package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnetionSrc {

	private static Connection connection;
	public static Connection getConnection() throws SQLException {
		String url = System.getenv("DB_URL");
		String user = System.getenv("DB_USERS");
		String password = System.getenv("BD_PASS");
		if(connection == null|| connection.isClosed()) {
			connection = DriverManager.getConnection(url,user,password);
		}
		return connection;
	}		
	
}
