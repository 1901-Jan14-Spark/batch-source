package com.revature.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.Connections;


public class EmployeeDAO_Impl implements EmployeeDAO{
	

	@Override
	public Employee varifyAccount(String username, String password) {
		
		
		
		
		System.out.println("username is "+ username+ " and password is" + password);
		String sql = "SELECT * FROM EMPLOYEES WHERE USERNAME = ? AND PASSWORD= ?";
		Employee emp = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("EMP_ID");
				System.out.println(Id);
				String wholeName= rs.getString("EMP_NAME");
//				Date birthday = rs.getDate("BIRTHDAY");
				int salary = rs.getInt("MONTHLY_SALARY");

				String position=rs.getString("POSITION");
				int reportsto = rs.getInt("MANAGER_ID");
//				Date hireDate = rs.getDate("HIRE_DATE");
				String name = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");
				System.out.println("username"+ name);
				
				
				emp = new Employee(Id, wholeName, "1998-02-12", salary, position, reportsto, "1996-02-02", name, pass);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("threw exception");
		}catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IO exception");
		}
		
		return emp;

		
		
		
	}

	@Override
	public int createEmployee(Employee a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLOYEES";
		Employee emp = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("EMP_ID");
				System.out.println(Id);
				String wholeName= rs.getString("EMP_NAME");
//				Date birthday = rs.getDate("BIRTHDAY");
				int salary = rs.getInt("MONTHLY_SALARY");

				String position=rs.getString("POSITION");
				int reportsto = rs.getInt("MANAGER_ID");
//				Date hireDate = rs.getDate("HIRE_DATE");
				String name = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");
				System.out.println("username"+ name);
				
				
				emp = new Employee(Id, wholeName, "1998-02-12", salary, position, reportsto, "1996-02-02", name, pass);
				employees.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("threw exception");
		}catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IO exception");
		}
		
		return employees;

		
	}

	@Override
	public Employee getEmpByUsername(String username) {
		
		
		String sql = "SELECT * FROM EMPLOYEES WHERE USERNAME = ?";
		Employee emp = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, username);
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("EMP_ID");
				System.out.println(Id);
				String wholeName= rs.getString("EMP_NAME");
//				Date birthday = rs.getDate("BIRTHDAY");
				int salary = rs.getInt("MONTHLY_SALARY");

				String position=rs.getString("POSITION");
				int reportsto = rs.getInt("MANAGER_ID");
//				Date hireDate = rs.getDate("HIRE_DATE");
				String name = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");
				System.out.println("username"+ name);
				
				
				emp = new Employee(Id, wholeName, "1998-02-12", salary, position, reportsto, "1996-02-02", name, pass);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("threw exception");
		}catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IO exception");
		}
		
		return emp;

		
		
	
	}
	

}
