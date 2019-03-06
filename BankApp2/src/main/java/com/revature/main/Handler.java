package com.revature.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class Handler {

	public static boolean userExists(String email){
		
		String sql = "SELECT * FROM ACCOUNT WHERE EMAIL = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static boolean isPass(String password) {
		
		String sql = "SELECT * FROM PERSON WHERE PASSWORD = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			
			ps.setString(1, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public static double getCheckingsBal(String email) {
		
		String sql = "SELECT * FROM ACCOUNT WHERE EMAIL = ?";
		double bal = 0;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			bal = rs.getDouble("CHECKINGS_BALANCE");
			}
			return bal;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bal;
	}
	
	public static double getSavingsBal(String email) {
		
		String sql = "SELECT * FROM ACCOUNT WHERE EMAIL = ?";
		double bal = 0;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			bal = rs.getDouble("SAVINGS_BALANCE");
			}
			return bal;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bal;
	}
}
