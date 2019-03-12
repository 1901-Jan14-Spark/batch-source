package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import utilities.ConnetionSrc;

public class EmployeeDaoImp implements EmployeeDao{

	static HashMap<String, String> creds = new HashMap<String, String>();
	
	public HashMap<String, String> getEmployeeCredentials() {
		String sql = "SELECT USERNAME, EMP_PASSWORD FROM EMPLOYEE_INFO";
		try(Connection con = ConnetionSrc.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
				while(rs.next()) {
					String pass = rs.getString("USERNAME");
					String user = rs.getString("EMP_PASSWORD");
					creds.put(pass, user);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creds;
	}

	public int getManager(String username) {
		int managerId = 0;
		String sql = "SELECT REPOSTO FROM EMPLOYEE_INFO WHERE USERNAME = ?";
		try(Connection con = ConnetionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			 	ps.setString(1, username);
			 	ResultSet rs = ps.executeQuery();
			 	while(rs.next()) {
			 		managerId = rs.getInt("REPOSTO");
			 	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return managerId;
	}

	@Override
	public boolean checkManager(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
