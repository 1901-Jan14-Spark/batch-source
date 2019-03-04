package com.revature.bank;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class BankPresentation {

	public static void main(String[] args) {
		
			Connection c;
			try {
				c = ConnectionUtil.getConnection();
				//System.out.println(c.getMetaData().getDriverName());

			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}
