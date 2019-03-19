package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// gets connection credentials and establishes the connection
public class ConnectionUtil {
	
	private static Connection connection;
	public static Connection getConnection() throws SQLException{
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
		String url = System.getenv("DB_URL");
		String user= System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");
		if(connection== null ||connection.isClosed()) {
			connection= DriverManager.getConnection(url,user,password);
		}
		return connection;
	}
}