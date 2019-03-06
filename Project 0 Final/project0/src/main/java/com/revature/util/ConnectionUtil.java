package com.revature.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//the Class that provides the connection to the sql database
public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		String url = System.getenv("DB_URL");
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		if(connection == null|| connection.isClosed()){
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
}
