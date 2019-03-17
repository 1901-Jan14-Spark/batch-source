package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Employees;
import util.ConnectionUtil;

public class EmployeesDaoImpl implements EmployeesDao{

	@Override
	public List<Employees> getEmployees() {
		String sql = "SELECT * FROM EMPLOYEES WHERE IS_MANA =0";
		List<Employees> emp = new ArrayList<>();
		try(Connection con = ConnectionUtil.systemVar();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int id = rs.getInt("EMP_ID");
				String first = rs.getString("EMP_FIRST");
				String last = rs.getString("EMP_LAST");
				String username =rs.getString("EMP_USER");
				String password = rs.getString("EMP_PASS");
				String isMana = rs.getString("IS_MANA");
				emp.add(new Employees(id,first,last,username, password, isMana));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	

	@Override
	public List<Employees> getManagers() {
		String sql = "SELECT * FROM EMPLOYEES WHERE IS_MANA =1";
		List<Employees> emp = new ArrayList<>();
		try(Connection con = ConnectionUtil.systemVar();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int id = rs.getInt("EMP_ID");
				String first = rs.getString("EMP_FIRST");
				String last = rs.getString("EMP_LAST");
				String username =rs.getString("EMP_USER");
				String password = rs.getString("EMP_PASS");
				String isMana = rs.getString("IS_MANA");
				emp.add(new Employees(id,first,last,username, password, isMana));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;

	}


	@Override
	public List<Employees> getAll() {
		String sql = "SELECT * FROM EMPLOYEES";
		List<Employees> emp = new ArrayList<>();
		try(Connection con = ConnectionUtil.systemVar();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int id = rs.getInt("EMP_ID");
				String first = rs.getString("EMP_FIRST");
				String last = rs.getString("EMP_LAST");
				String username =rs.getString("EMP_USER");
				String password = rs.getString("EMP_PASS");
				String isMana = rs.getString("IS_MANA");
				emp.add(new Employees(id,first,last,username, password, isMana));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;

	}


	@Override
	public int updateEmployee(Employees e) {
		String sql = "UPDATE EMPLOYEES SET EMP_FIRST= ?, EMP_LAST= ?,EMP_USER=?, EMP_PASS WHERE EMP_ID = ?";
		int clientsUpdated = 0;
		try(Connection con = ConnectionUtil.systemVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, e.getFirst());
			ps.setString(2, e.getLast());
			ps.setString(3, e.getUsername());
			ps.setString(4, e.getPassword());
			clientsUpdated = ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return clientsUpdated;
	}


	@Override
	public Employees getEmployeesById(int id) {
		Employees employees = null;
		String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ?";
		try(Connection con = ConnectionUtil.systemVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String first = rs.getString("EMP_FIRST");
				String last = rs.getString("EMP_LAST");
				String user = rs.getString("EMP_USER");
				String pass = rs.getString("EMP_PASS");
				employees= new Employees(empId,first,last,user,pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	@Override
	public Employees getEmployeesByIsMana(int stat) {
		Employees employees = null;
		String sql = "SELECT * FROM EMPLOYEES WHERE IS_MANA = ?";
		try(Connection con = ConnectionUtil.systemVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1,stat);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String first = rs.getString("EMP_FIRST");
				String last = rs.getString("EMP_LAST");
				String user = rs.getString("EMP_USER");
				String pass = rs.getString("EMP_PASS");
				employees= new Employees(empId,first,last,user,pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}


	@Override
	public int createEmployee(Employees emp) {
			String sql = "INSERT INTO EMPLOYEES VALUES(null,?,?,?,?,?)";
			int employeesMade = 0;
			try(Connection con = ConnectionUtil.systemVar();
					PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, emp.getFirst());
				ps.setString(2, emp.getLast());
				ps.setString(3, emp.getUsername());
				ps.setString(4, emp.getPassword());
				ps.setString(5, emp.IsMana());
			employeesMade = ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return employeesMade;
		}



	@Override
	public int deleteEmployeesById(int id) {
		String sql = "DELETE FROM EMPLOYEES WHERE EMP_ID =?";
		int rowsDeleted = 0;
		try(Connection con = ConnectionUtil.systemVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

}
