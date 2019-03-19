package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import utilities.ConnetionSrc;

public class EmployeeDaoImp implements EmployeeDao, Runnable{
			List<Employee> employees = new ArrayList<>();
		
			
	static HashMap<String, String> creds = new HashMap<String, String>();
	
	public HashMap<String, String> getEmployeeCredentials() {
		String sql = "SELECT USERNAME, EMP_PASSWORD FROM EMPLOYEE_INFO";
		try(Connection con = ConnetionSrc.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
				while(rs.next()) {
					String pass = rs.getString("USERNAME");
					String user = rs.getString("EMP_PASSWORD");
					creds.put(pass, user);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(creds);
		return creds;
		
	}
	
	

	public int getManager(String username) {
		int managerId = 0;
		
		String sql = "SELECT REPORSTO FROM EMPLOYEE_INFO WHERE USERNAME = ?";
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			 	ps.setString(1, username);
			 	ResultSet rs = ps.executeQuery();
			 	while(rs.next()) {
			 		managerId = rs.getInt("REPORSTO");
			 	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return managerId;
	}
	@Override
	public String getManagerName(String username) {
		String managerName = "";
		String sql = "SELECT FIRST_NAME FROM EMPLOYEE_INFO WHERE EMPLOYEE_ID = ?";
		int empUser = getManager(username);
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, empUser);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					managerName = rs.getString("FIRST_NAME");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return managerName;
	}

	@Override
	public HashMap<String, String> checkManager() {
		HashMap<String,String> mngCred = new HashMap<>();
		String sql = "SELECT USERNAME, EMP_PASSWORD FROM EMPLOYEE_INFO WHERE REPORSTO IS NULL";
		try(Connection con = ConnetionSrc.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
				while(rs.next()) {
					String pass = rs.getString("USERNAME");
					String user = rs.getString("EMP_PASSWORD");
					mngCred.put(pass, user);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mngCred;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Request> getRequests(String username) {
		List<Request> request = new ArrayList<>();
		int id = getEmployeeId(username);
		String sql = "SELECT * FROM REIMBURSEMENT_REQUEST WHERE EMPLOYEE_ID = ?";
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int empId = rs.getInt("EMPLOYEE_ID");
					boolean aproved = rs.getBoolean("APPROVED");
					String date = rs.getString("DATE_SUBMITTED");
					String reason = rs.getString("REASON");
					double amount = rs.getDouble("AMOUNT");
					request.add(new Request(empId, aproved, date, reason, amount));
					
				}
				
			    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return request;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getEmployees() {
		String sql = "SELECT * FROM EMPLOYEE_INFO";
		try(Connection con = ConnetionSrc.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			 	while(rs.next()) {
			 		int empId = rs.getInt("EMPLOYEE_ID");
			 		String first = rs.getString("FIRST_NAME");
			 		String last = rs.getString("LAST_NAME");
			 		int mngId = rs.getInt("REPORSTO");
			 		String pass = rs.getString("EMP_PASSWORD");
			 		String user = rs.getString("USERNAME");
			 		employees.add(new Employee(empId, first, last, mngId, pass, user));
			 	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmpByUser(String username) {
		Employee employee = new Employee();
		String sql = "SELECT * FROM EMPLOYEE_INFO WHERE USERNAME = ?";
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int empId = rs.getInt("EMPLOYEE_ID");
			 		String first = rs.getString("FIRST_NAME");
			 		String last = rs.getString("LAST_NAME");
			 		int mngId = rs.getInt("REPORSTO");
			 		String pass = rs.getString("EMP_PASSWORD");
			 		String user = rs.getString("USERNAME");
			 		employee= new Employee(empId, first, last, mngId,pass,user);
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return employee;
	}



	@Override
	public List<Employee> getManagersEmployee(String username) {
		List<Employee> MngEmployees = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE_INFO WHERE REPORSTO = ?";
		int id = getEmployeeId(username);
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int empId = rs.getInt("EMPLOYEE_ID");
			 		String first = rs.getString("FIRST_NAME");
			 		String last = rs.getString("LAST_NAME");
			 		int mngId = rs.getInt("REPORSTO");
			 		String pass = rs.getString("EMP_PASSWORD");
			 		String user = rs.getString("USERNAME");
			 		MngEmployees.add(new Employee(empId,first,last,mngId,pass,user));
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return MngEmployees;
	}



	@Override
	public int getEmployeeId(String username) {
		int id = 0;
		String sql = "SELECT EMPLOYEE_ID FROM EMPLOYEE_INFO WHERE USERNAME = ?";
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					id = rs.getInt("EMPLOYEE_ID");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}



	@Override
	public void postRequest(String username, int id, double cost, String reason) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date =  dtf.format(now);

		String sql = "INSERT INTO REIMBURSEMENT_REQUEST (EMPLOYEE_ID, REASON, AMOUNT, DATE_SUBMITTED) VALUES (?,?,?,?)";
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, id);
				ps.setString(2, reason);
				ps.setDouble(3, cost);
				ps.setString(4, date);
				ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public List<Request> apiRequest() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void updatePassword(String username, String password) {
		
		String sql = "UPDATE EMPLOYEE_INFO SET EMP_PASSWORD = ? WHERE USERNAME = ? ";
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, password);
			 	ps.setString(2, username);
			 	ps.executeUpdate();
			 	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	@Override
	public List<Request> yourEmployeesRequests(String username) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Integer> getIdbyMngUser(String username) {
		List<Integer> IdList = new ArrayList<Integer>();
		int repo = getEmployeeId(username);
		String sql= "SELECT EMPLOYEE_ID FROM EMPLOYEE_INFO WHERE REPORSTO = ? ";
		
		
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, repo);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
				int	id = rs.getInt("EMPLOYEE_ID");
				IdList.add(id);
				}
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return IdList;
	}



	@Override
	public List<Request> getRequestById(String username) {
		List<Integer> ids = getIdbyMngUser(username);
		List<Request> requests = new ArrayList<Request>();
		String sql = "SELECT * FROM REIMBURSEMENT_REQUEST WHERE EMPLOYEE_ID = ? ";
		for(int eid :ids) {
			try(Connection con = ConnetionSrc.getConnection();
					PreparedStatement ps = con.prepareStatement(sql)){
					ps.setInt(1, eid);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
					int empId = rs.getInt("EMPLOYEE_ID");	
					boolean	approval = rs.getBoolean("APPROVED");
					String date = rs.getString("DATE_SUBMITTED");
					String reason = rs.getString("REASON");
					double amount = rs.getDouble("AMOUNT");
					requests.add(new Request(empId, approval, date, reason, amount));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return requests;
	}
	



	
	
	
	
}
