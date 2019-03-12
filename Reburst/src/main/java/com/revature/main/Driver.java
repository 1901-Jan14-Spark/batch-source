package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		try {
			Connection c = ConnectionUtil.getConnectionFromFile();
			System.out.println(c.getMetaData().getDriverName());
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
	}

}
