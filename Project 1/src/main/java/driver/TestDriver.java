package driver;

import java.sql.Connection;
import java.sql.SQLException;

import util.DBConnection;

public class TestDriver {

	public static void main(String[] args) {
		try {
			Connection c = DBConnection.getConnection();
			System.out.println(c.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		System.out.println();
	}
}

