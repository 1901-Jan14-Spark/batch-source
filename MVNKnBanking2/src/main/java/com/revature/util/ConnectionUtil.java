package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection connection;
	
//	public static Connection getConnection() throws SQLException {
//		String url = System.getenv("DB_URL");
//		String username = System.getenv("username");
//		String password = System.getenv("passwoed");
//		
//		if(connection == null || connection.isClosed())
//			connection = DriverManager.getConnection(url, username, password);
//		
//		return connection;
//	}
	
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connections.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}

}
