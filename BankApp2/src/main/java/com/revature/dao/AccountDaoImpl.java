package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createAccount(User u, Account a) {
		int AccountsCreated = 0;
		String sql = "INSERT INTO ACCOUNT (EMAIL, CHECKINGS_BALANCE, SAVINGS_BALANCE) VALUES (?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, u.getEmail());
			ps.setDouble(2, a.getCheckings());
			ps.setDouble(3, a.getSavings());
			AccountsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AccountsCreated;
	}

	@Override
	public int updateAccountCheckings(String email, double amount) {
		int AccountsUpdated = 0;
		String sql = "UPDATE ACCOUNT "
				   + "SET CHECKINGS_BALANCE = ? "
				   + "WHERE EMAIL = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			
			ps.setDouble(1, amount);
			ps.setString(2, email);
			AccountsUpdated = ps.executeUpdate();
			//con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return AccountsUpdated;
	}
	

	@Override
	public int updateAccountSavings(String email, double amount) {
		int AccountsUpdated = 0;
		String sql = "UPDATE ACCOUNT "
				   + "SET SAVINGS_BALANCE = ? "
				   + "WHERE EMAIL = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			
			ps.setDouble(1, amount);
			ps.setString(2, email);
			AccountsUpdated = ps.executeUpdate();
			//con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return AccountsUpdated;
	}
	

	@Override
	public int deleteAccount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
