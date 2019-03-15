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

	@Override//query only employees id, name, and email from table
	public List<EmpObj> getAllEmp() {
		List<EmpObj> employees = new ArrayList<>();
		
		//10000's -> employee id range
		String sql = "SELECT E_ID, E_NAME, EMAIL FROM EMPLOYEES WHERE E_ID < 20000";
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {				
				int id = rs.getInt("E_ID");
				String name = rs.getString("E_NAME");
				String email = rs.getString("EMAIL");
				
				employees.add(new EmpObj(id, name, email));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	@Override//query only managers id, name, and email
	public List<EmpObj> getAllMan() {
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
	
}
