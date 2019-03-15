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
import com.revature.utility.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao  {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE";
		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();) {
			rs = s.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("EMPLOYEE_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String username = rs.getString("EMPLOYEE_USERNAME");
				String password = rs.getString("EMPLOYEE_PASSWORD");
				
				
				Employee e = new Employee();
				e.setId(id);
				e.setFirstname(firstname);
				e.setLastname(lastname);
				e.setUsername(username);
				e.setPassword(password);
				employeeList.add(e);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} 
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp = null;
		try (Connection con = ConnectionUtil.getConnection();) {
			emp = getEmployeeById(id, con);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee getEmployeeById(int id, Connection con) {
		Employee emp = null;
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
		ResultSet rs = null;
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String username = rs.getString("EMPLOYEE_USERNAME");
				String password = rs.getString("EMPLOYEE_PASSWORD");
				
				emp = new Employee();
				emp.setId(id);
				emp.setFirstname(firstname);
				emp.setLastname(lastname);
				emp.setUsername(username);
				emp.setPassword(password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql grr");
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee emp = null;
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_USERNAME = ?";
		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("EMPLOYEE_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String password = rs.getString("EMPLOYEE_PASSWORD");
				
				emp = new Employee();
				emp.setId(id);
				emp.setFirstname(firstname);
				emp.setLastname(lastname);
				emp.setUsername(username);
				emp.setPassword(password);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	@Override
	public void updateEmployee(Employee e) {
		String sql = "UPDATE EMPLOYEE SET EMPLOYEE_ID = ?, FIRSTNAME = ?, LASTNAME = ?, EMPLOYEE_USERNAME = ?, EMPLOYEE_PASSWORD = ? WHERE EMPLOYEE_ID = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, e.getId());
			ps.setString(2, e.getFirstname());
			ps.setString(3, e.getLastname());
			ps.setString(4, e.getUsername());
			ps.setString(5, e.getPassword());
			ps.setInt(6, e.getId());
			ps.executeQuery();
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
	

}
