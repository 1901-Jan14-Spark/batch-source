package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Employee;
import services.EmployeeService;
import services.LoginService;
import util.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public EmployeeDaoImpl() {
		super();
	}
	
	public EmployeeDaoImpl(LoginService loginServiceMock) {
	}

	@Override
	//getting all employees, excluding managers
	public List<Employee> getOnlyEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE";
		
		try(Connection con = DBConnection.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while (rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String fName = rs.getString("FNAME");
				String lName = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				int reportsTo = rs.getInt("REPORTSTO");
				employees.add(new Employee(empId, fName, lName, email, reportsTo));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeByUsername(String emailInp) {
		String sql = "Select * From Employee Where Email = ?";
		Employee tempEmp = null;
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, emailInp);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String fName = rs.getString("FNAME");
				String lName = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				int reportsTo = rs.getInt("REPORTSTO");
				tempEmp = new Employee(empId, fName, lName, email, password, reportsTo);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempEmp;
	}

	@Override
	public int updateEmployeeInfo(Employee e) {
		String sql = "Update Employee Set FNAME = ?, LNAME = ?, EMAIL = ?, PASSWORD = ? WHERE emp_id = ?";
		int employeesUpd = 0;
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
		
			ps.setString(1, e.getFirstName());
			ps.setString(2, e.getLastName());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPassword());
			ps.setInt(5, e.getId());
			employeesUpd = ps.executeUpdate();
		
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return employeesUpd;
	}
	
}
