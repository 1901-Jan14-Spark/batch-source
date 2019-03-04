package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
	
		String url = System.getenv("DB_URL");
		System.out.println(url);
		String user = System.getenv("DB_USER");
		System.out.println(user);
		String password = System.getenv("DB_PASS");
		System.out.println(password);
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url,  user,  password);
		}
		return connection;
	}

}
