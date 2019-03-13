package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private static Logger log = Logger.getRootLogger();
	@Override
	public List<Employee> getEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public Employee getEmps(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createEmp(String email, String password, int managerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean LoggedIn(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

}
