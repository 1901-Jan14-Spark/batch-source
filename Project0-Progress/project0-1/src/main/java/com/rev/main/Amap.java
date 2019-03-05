package com.rev.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.rev.util.ConnectionSrc;

public class Amap {
	
	static HashMap<String, String> custCreds = new HashMap<String,String>();
	
	public static HashMap<String,String> getCustomerCredentials() {

		String sql = "SELECT USERNAME, PASSWORD FROM C_USERS";
		try(Connection con = ConnectionSrc.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			 	while(rs.next()) {
			 		String pass = rs.getString("USERNAME");
			 		String user = rs.getString("PASSWORD");
			 		custCreds.put(pass, user);
			 	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		// TODO Auto-generated method stub
		return custCreds;
	}
	
	
	
	
}
