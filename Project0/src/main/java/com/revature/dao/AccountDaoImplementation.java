package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.Account;
import com.revature.bank.Member;
import com.revature.util.ConnectionUtil;

public class AccountDaoImplementation implements AccountDao {

	@Override
	public List<Account> getBothAccounts(String accountNumber) {
		List<Account> accounts = new ArrayList<>();
		
		String sql = "SELECT * FROM ACCOUNTS"
				+ "WHERE USER_ACCOUNT = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String memAccountNumber = rs.getString("USER_ACCOUNT");
				double memAccountBalance = rs.getDouble("ACCOUNT_BALANCE");
				String memAccountType = rs.getString("ACCOUNT_TYPE");
				accounts.add(new Account(memAccountNumber, memAccountType, memAccountBalance));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return accounts;
	}

	
	@Override
	public Account getAccountByType(String accountNumber, String accountType) {
	
		String sql = "SELECT * FROM ACCOUNTS"
				+ "WHERE USER_ACCOUNT = ?, ACCOUNT_TYPE = ?";
		Account a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, accountNumber);
			ps.setString(2,  accountType);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String memAccountNumber = rs.getString("USER_ACCOUNT");
				double memAccountBalance = rs.getDouble("ACCOUNT_BALANCE");
				String memAccountType = rs.getString("ACCOUNT_TYPE");
				a =new Account(memAccountNumber, memAccountType, memAccountBalance);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return a;
	}

	@Override
	public void makeDeposit(String accountNumber, String accountType, double depositAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeWithdrawal(String accountNumber, String accountType, double withdrawalAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewBalance(String accountNumber, String accountType) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addNewAccount(Member m, String accountType, double newBalance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(Member m, String AccountType) {
		// TODO Auto-generated method stub
		
	}


}
