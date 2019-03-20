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
		
//		String url = System.getenv("DB_URL");
//		String user = System.getenv("DB_USER");
//		String password = System.getenv("DB_PASS");
		
		String url = "jdbc:oracle:thin:@project1db.cxtzccza3la8.us-east-1.rds.amazonaws.com:1521:ORCL";
		String user = "vanalstined";
		String password = "Foo1ball4L!fe";
		
		
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
		}
		return connection;
	}
}
