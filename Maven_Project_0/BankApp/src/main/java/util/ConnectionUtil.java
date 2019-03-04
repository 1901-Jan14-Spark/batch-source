package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection connect;	

public static Connection sysVar() throws SQLException {
	
	String url = System.getenv("DB_URL");
	String username = System.getenv("DB_USER");
	String password = System.getenv("DB_PASS");
	if(connect == null || connect.isClosed()) {
		connect = DriverManager.getConnection(url,username,password);
	}
	return connect;
}


	
}
