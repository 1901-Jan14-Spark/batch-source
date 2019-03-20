package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = System.getenv("P1_URL");
		String user = System.getenv("P1_USER");
		String password = System.getenv("P1_PASS");
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url,  user,  password);
		}
		return connection;
	}
}
