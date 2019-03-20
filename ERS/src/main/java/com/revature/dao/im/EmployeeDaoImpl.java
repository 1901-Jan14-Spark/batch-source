package com.revature.dao.im;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> employees = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while (rs.next()) {
				Employee e = new Employee(); 
				
				int employeeId = rs.getInt("EMP_ID");
				e.setId(employeeId);
				
				String email = rs.getString("EMAIL");
				e.setEmail(email);
				
				String fname = rs.getString("FIRST_NAME");
				e.setFname(fname);
				
				String lname = rs.getString("LAST_NAME");
				e.setLname(lname);
				
				int id = rs.getInt("REPORTSTO");
				e.setReportsto(id);
				
				employees.add(e);
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
		Employee e = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int employeeId = rs.getInt("EMP_ID");
				String name = rs.getString("EMAIL");
				String pass = rs.getString("PASS");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				int reportsto = rs.getInt("REPORTSTO");
				e = new Employee(employeeId, name, pass, fname, lname, reportsto);
			}
			
		} catch (SQLException x) {
			x.printStackTrace();
		}
		
		return e;
	}

	@Override
	public int createEmployee(Employee employee) {
		int usersCreated = 0;
		String sql = "INSERT INTO EMPLOYEE (EMAIL, PASSWORD, FIRSTNAME, LASTNAME, REPORTSTO) VALUES (?,?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, employee.getEmail());
			ps.setString(2, employee.getPass());
			ps.setString(3, employee.getFname());
			ps.setString(4, employee.getLname());
			ps.setInt(4, employee.getReportsto());
			usersCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersCreated;
	}


	@Override
	public int updateEmployee(Employee employee) {
		int employeeUpdated = 0;
		String sql = "UPDATE EMPLOYEE "
				+ "SET EMAIL = ?, "
				+ "PASS = ? "
				+ "WHERE EMP_ID = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){

			ps.setString(1, employee.getEmail());
			ps.setString(2, employee.getPass());
			ps.setInt(3, employee.getId());
			employeeUpdated = ps.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "UPDATE EXPENSE "
				+ "SET EMAIL = ? "
				+ "WHERE EXP_ID = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql2)){
			

			ps.setString(1, employee.getEmail());
			ps.setInt(2, employee.getId());
			employeeUpdated = ps.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeUpdated;
	}

	@Override
	public int deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMAIL = ?";
		Employee e = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int employeeId = rs.getInt("EMP_ID");
				String name = rs.getString("EMAIL");
				String pass = rs.getString("PASS");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				int reportsto = rs.getInt("REPORTSTO");
				e = new Employee(employeeId, name, pass, fname, lname, reportsto);
			}
			
		} catch (SQLException x) {
			x.printStackTrace();
		}
		
		return e;
	}

}
