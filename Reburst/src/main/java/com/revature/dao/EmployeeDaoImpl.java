package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private static Logger log = Logger.getRootLogger();


	@Override
	public Employee getUserByEmail(String Email) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_EMAIL = ?";
		Employee emp = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)){
			System.out.println("Find email: " + Email);
			ps.setString(1, Email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int eId = rs.getInt("EMPLOYEE_ID");
				String fName = rs.getString("FIRST_NAME");
				String lName = rs.getString("LAST_NAME");
				String email = rs.getString("EMPLOYEE_EMAIL");
				String password = rs.getString("EMPLOYEE_PASSWORD");
				String title = rs.getString("TITLE");			
				int isManager = rs.getInt("IS_MANAGER");
				int  manager = rs.getInt("MANAGERS_ID");
				emp = new Employee(eId, fName, lName, email, password, title, isManager, manager);
				System.out.println(emp.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return emp;
	}
	

	@Override
	public int validate(String email, String Pass) {
		String sql = "SELECT EMPLOYEE_EMAIL, EMPLOYEE_PASSWORD FROM EMPLOYEE WHERE EMPLOYEE_EMAIL=? AND EMPLOYEE_PASSWORD =?";
		
		Employee emp = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement statement = con.prepareStatement(sql)	) {
		    
				statement.setString(1, email);
				statement.setString(2, Pass);
				
				ResultSet rs = statement.executeQuery();
				
				rs.next();
				
				String emailV = rs.getString("EMPLOYEE_EMAIL");
				String passV = rs.getString("EMPLOYEE_PASSWORD");
				
				emp = new Employee(email, Pass);
				emp.setEmail(emailV);
				emp.setPassword(passV);
		
				log.info(emp);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Employee> getEmpsReportingTo(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmps() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while (rs.next()) {
				int empId = rs.getInt("EMPLOYEE_ID");
				String fName = rs.getString("FIRST_NAME");
				String lName = rs.getString("LAST_NAME");
				String email = rs.getString("EMPLOYEE_EMAIL");
				int reportsTo = rs.getInt("MANAGERS_ID");
				employees.add(new Employee(empId, fName, lName, email, reportsTo));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return employees;
	}
	@Override
	public int createEmp(String fname, String lName, String email, String pass, String title, int mId) {
		
		String sql ="INSERT INTO EMPLOYEE(FIRST_NAME, LAST_NAME, EMPLOYEE_EMAIL, EMPLOYEE_PASS, TITLE, MANAGERS_ID) VALUES(?, ?, ?, ?, ?, ?)";
		 int eBoolean = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, fname);
			ps.setString(2, lName);
			ps.setString(3, email);
			ps.setString(4, pass);
			ps.setString(5, title);
			ps.setInt(6, mId);
			eBoolean = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return eBoolean;
	}

	@Override
	public int updateEmp(String fname, String lName, String email, String pass, int id) {
		String sql ="UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, EMPLOYEE_EMAIL = ?, EMPLOYEE_PASSWORD = ? WHERE EMPLOYEE_ID = ?";
		 int eBoolean = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, fname);
			ps.setString(2, lName);
			ps.setString(3, email);
			ps.setString(4, pass);
			eBoolean = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return eBoolean;
	}

	@Override
	public boolean LoggedIn(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Employee getEmps(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
