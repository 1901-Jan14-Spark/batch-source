package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				Employee e = new Employee();
				
				int employeeId = rs.getInt("EMPLOYEE_ID");
				e.setId(employeeId);
				
				String username = rs.getString("USERNAME");
				e.setUsername(username);
				
				String password = rs.getString("USER_PW");
				e.setPassword(password);
				
				String email = rs.getString("EMAIL");
				e.setEmail(email);
				
				String address = rs.getString("ADDRESS");
				e.setAddress(address);
				
				String phone = rs.getString("PHONE");
				e.setPhone(phone);
				
				int isManager = rs.getInt("IS_MANAGER");
				e.setIsManager(isManager);
				
				employees.add(e);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeId(int id) {
		
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
		Employee e = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("USER_PW");
				String email = rs.getString("EMAIL");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				int isManager = rs.getInt("IS_MANAGER");
				e = new Employee(employeeId, username, password, email, address, phone, isManager);
			}
		}catch(SQLException x) {
			x.printStackTrace();
		}
		return e;
	}

	@Override
	public int createEmployee(Employee e) {
		int employeeCreated = 0;
		String sql = "INSERT INTO EMPLOYEE (EMPLOYEE_ID, USERNAME, USER_PW, EMAIL, ADDRESS, PHONE, IS_MANAGER) VALUES(?,?,?,?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, e.getId());
			ps.setString(1, e.getUsername());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getAddress());
			ps.setString(6, e.getPhone());
			ps.setInt(7, e.getIsManager());
			employeeCreated = ps.executeUpdate();
			
		}catch(SQLException x) {
			x.printStackTrace();
		}
		return employeeCreated;
	}

	@Override
	public int updateEmployee(Employee e) {
		int employeeUpdate = 0;
		String sql = "UPDATE EMPLOYEE "
				+ "SET EMPLOYEE_ID = ?,"
				+ "USERNAME = ?,"
				+ "USER_PW = ?,"
				+ "EMAIL = ?,"
				+ "ADDRESS = ?,"
				+ "PHONE = ?,"
				+ "IS_MANAGER = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, e.getId());
			ps.setString(1, e.getUsername());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getAddress());
			ps.setString(6, e.getPhone());
			ps.setInt(7, e.getIsManager());
			employeeUpdate = ps.executeUpdate();
			
		}catch(SQLException x) {
			x.printStackTrace();
		}
		return employeeUpdate;
	}

	@Override
	public int deleteEmployee(int id) {
		int rowsDeleted = 0;
		String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, id);
		}catch(SQLException x) {
			x.printStackTrace();
		}
		return rowsDeleted;
	}

	@Override
	public Employee getEmployeeBySignIn(String user, String pass) {
		String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? AND USER_PW = ?";
		Employee e = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("USER_PW");
				String email = rs.getString("EMAIL");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				int isManager = rs.getInt("IS_MANAGER");
				e = new Employee(employeeId, username, password, email, address, phone, isManager);
			}
		}catch(SQLException x) {
			x.printStackTrace();
		}
		return e;
	}
	
}
