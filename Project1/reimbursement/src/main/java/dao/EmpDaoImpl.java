package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.EmpObj;
import util.ConnectionUtil;

public class EmpDaoImpl implements EmpDao{

	@Override
	public List<EmpObj> getAllEmp() {
		List<EmpObj> employees = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEES";
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {				
				int id = rs.getInt("E_ID");
				String name = rs.getString("E_NAME");
				String pass = rs.getString("E_PASS");
				String email = rs.getString("EMAIL");
				
				employees.add(new EmpObj(id, name, pass, email));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	@Override//query only employees id, name, and email from table
	public List<EmpObj> getOnlyEmp() {
		List<EmpObj> employees = new ArrayList<>();
		
		//10000's -> employee id range
		String sql = "SELECT * FROM EMPLOYEES WHERE E_ID < 20000";
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {				
				int id = rs.getInt("E_ID");
				String name = rs.getString("E_NAME");
				String pass = rs.getString("E_PASS");
				String email = rs.getString("EMAIL");
				
				employees.add(new EmpObj(id, name, pass, email));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	@Override//query only managers id, name, and email
	public List<EmpObj> getOnlyMan() {
		List<EmpObj> managers = new ArrayList<>();
		
		//20000's -> managers id range
		String sql = "SELECT E_ID, E_NAME, EMAIL FROM EMPLOYEES WHERE E_ID > 19999";
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {				
				int id = rs.getInt("E_ID");
				String name = rs.getString("E_NAME");
				String email = rs.getString("EMAIL");
				
				managers.add(new EmpObj(id, name, email));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return managers;
	}
	
	@Override
	public EmpObj getEmpById(int userId) {
		String sql = "SELECT * FROM EMPLOYEES WHERE E_ID = ?";
		EmpObj eo = new EmpObj();
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				eo.seteId(rs.getInt("E_ID"));
				eo.seteName(rs.getString("E_NAME"));
				eo.setePass(rs.getString("E_PASS"));
				eo.setEmail(rs.getString("EMAIL"));
			}
			else {
				eo.seteId(0);
				eo.setePass("");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eo;
	}
	
	@Override
	public EmpObj getIdAndPass(int userId) {
		String sql = "SELECT E_ID, E_PASS FROM EMPLOYEES WHERE E_ID = ?";
		EmpObj eo = new EmpObj();
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("E_ID");
				eo.seteId(id);
				String pass = rs.getString("E_PASS");
				eo.setePass(pass);
			}
			else {
				eo.seteId(0);
				eo.setePass("");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eo;
	}

	@Override
	public boolean updateEmp(int empId, EmpObj employee) {
		int empAdded = 0;
		String sql = "UPDATE EMPLOYEES SET E_NAME = ?, E_PASS = ?, EMAIL = ? WHERE E_ID = ?";
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, employee.geteName());
			ps.setString(2, employee.getePass());
			ps.setString(3, employee.getEmail());
			ps.setInt(4, empId);
			empAdded = ps.executeUpdate();
			
			if(empAdded > 0)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
}
