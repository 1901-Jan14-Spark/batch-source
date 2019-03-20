package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.utility.ConnectionUtil;

public class RequestDaoImpl implements RequestDao {
	private List<Request> getRequests(String sql) {
		List<Request> requestList = new ArrayList<>();
		ResultSet rs = null;
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();) {
			rs = s.executeQuery(sql);
			while(rs.next()) {
				Request r = populateRequest(rs, con);
				requestList.add(r);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return requestList;
	}

	@Override
	public Request getRequestById(int id) {
		Request req = null;
		String sql = "SELECT * FROM REQUEST WHERE REQUEST_ID = ?";
		ResultSet rs = null;
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				req = populateRequest(rs, con);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return req;
	}

	@Override
	public Request getRequestById(int id, Connection con) {
		Request req = null;
		String sql = "SELECT * FROM REQUEST WHERE REQUEST_ID = ?";
		ResultSet rs = null;
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String status = rs.getString("STATUS");
				double amount = rs.getDouble("AMOUNT");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				int managerId = rs.getInt("MANAGER_ID");
				EmployeeDao ed = new EmployeeDaoImpl();
				Employee e = ed.getEmployeeById(employeeId, con);
				ManagerDao md = new ManagerDaoImpl();
				Manager m = md.getManagerById(managerId, con);
				
				req = new Request();
				req.setId(id);
				req.setStatus(status);
				req.setAmount(amount);;
				req.setEmployee(e);
				req.setManager(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return req;
	}
	
	private List<Request> getRequestsByEmployeeId(int employeeId, String sql) {
		List<Request> requests = new ArrayList<>();
		ResultSet rs = null;
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, employeeId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Request req = populateRequest(rs, con);
				requests.add(req);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return requests;
	}
	


	@Override
	public void addRequest(Request r) {
		r.setId(getNextId());
		String sql = "INSERT INTO REQUEST (REQUEST_ID, STATUS, AMOUNT, EMPLOYEE_ID) VALUES (?, ?, ?, ?)";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, r.getId());
			ps.setString(2, r.getStatus());
			ps.setDouble(3, r.getAmount());
			ps.setInt(4, r.getEmployee().getId());
			ps.executeQuery();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private int getNextId() {
		int nextId = -1;
		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();) {
			rs = s.executeQuery("SELECT MAX(REQUEST_ID) FROM REQUEST");
			if (rs.next()) {
				if (nextId == 0) {
					nextId = 1;
				} else {
					nextId = rs.getInt(1) + 1;
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return nextId;
	}
	
	@Override
	public void updateRequest(Request r) {
		String sql = "UPDATE REQUEST SET REQUEST_ID = ?, STATUS = ?, AMOUNT = ?, EMPLOYEE_ID = ?, MANAGER_ID = ? WHERE REQUEST_ID = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, r.getId());
			ps.setString(2, r.getStatus());
			ps.setDouble(3, r.getAmount());
			ps.setInt(4, r.getEmployee().getId());
			ps.setInt(5, r.getManager().getId());
			ps.setInt(6, r.getId());
			ps.executeQuery();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private Request populateRequest(ResultSet rs, Connection con) throws SQLException {
		int requestId = rs.getInt("REQUEST_ID");
		String status = rs.getString("STATUS");
		double amount = rs.getDouble("AMOUNT");
		int employeeId = rs.getInt("EMPLOYEE_ID");
		int managerId = rs.getInt("MANAGER_ID");
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee e = ed.getEmployeeById(employeeId, con);
		ManagerDao ad = new ManagerDaoImpl();
		Manager m = ad.getManagerById(managerId, con);
		
		Request r = new Request();
		r.setId(requestId);
		r.setStatus(status);
		r.setAmount(amount);
		r.setEmployee(e);
		r.setManager(m);
		return r;
	}
	
	@Override
	public List<Request> getRequests() {
		return getRequests("SELECT * FROM REQUEST");
	}
	@Override
	public List<Request> getRequestsByEmployeeId(int employeeId) {
		return getRequestsByEmployeeId(employeeId, "SELECT * FROM REQUEST WHERE EMPLOYEE_ID = ?");
	}
	@Override
	public List<Request> getPendingRequestsByEmployeeId(int employeeId) {
		String sql = "SELECT * FROM REQUEST WHERE EMPLOYEE_ID = ? AND STATUS = 'Pending' ";
		return getRequestsByEmployeeId(employeeId, sql);
	}
	@Override
	public List<Request> getResolvedRequestsByEmployeeId(int employeeId) {
		String sql = "SELECT * FROM REQUEST WHERE EMPLOYEE_ID = ? AND STATUS = 'Approved' ";
		return getRequestsByEmployeeId(employeeId, sql);
	}
	
	@Override
	public List<Request> getDeniedRequestsByEmployeeId(int employeeId) {
		System.out.println("denied Dao");
		String sql = "SELECT * FROM REQUEST WHERE EMPLOYEE_ID = ? AND STATUS = 'Denied' ";
		return getRequestsByEmployeeId(employeeId, sql);
	}
	
	@Override
	public List<Request> getPendingRequest() {
		return getRequests("SELECT * FROM REQUEST WHERE STATUS = 'Pending'");
	}

	@Override
	public List<Request> getApprovedRequest() {
		return getRequests("SELECT * FROM REQUEST WHERE STATUS = 'Approved'");
	}

	@Override
	public List<Request> getDeniedRequest() {
		return getRequests("SELECT * FROM REQUEST WHERE STATUS = 'Denied'");

	}

}
