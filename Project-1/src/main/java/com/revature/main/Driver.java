
package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.Connections;

public class Driver {

	public static void main(String[] args) {
		try {
			Connection c = Connections.getConnection();
			System.out.println(c.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
