package com.revature.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	

	
	
	public static Connection getConnection() throws SQLException {
		String url ="jdbc:oracle:thin:@revature.ctdbzzqeogfq.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		System.out.println("printing use and pasword" + user + password);
		if(connection==null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}