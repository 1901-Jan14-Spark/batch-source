package com.revature.dao;

import java.sql.CallableStatement;
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
	public Account getAccountByAccountNumber(String accountNumber) {
	
		String sql = "SELECT * FROM ACCOUNT_TABLE"
				+ "WHERE ACCOUNT_NUMBER = ?";
		Account a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String memAccountNumber = rs.getString("ACCOUNT_NUMBER");
				System.out.println(memAccountNumber);
				String memAccountType = rs.getString("ACCOUNT_TYPE");
				System.out.println(memAccountType);
				double memAccountBalance = rs.getDouble("ACCOUNT_BALANCE");
				System.out.println(memAccountBalance);
				a = new Account(memAccountType, memAccountBalance);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return a;
	}

	@Override
	public void makeDeposit(String accountNumber, String accountType, double depositAmount) {
		
		String sql = "{CALL MAKE_DEPOSIT(?,?,?)}";
		
		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){
			
			cs.setString(1, accountNumber);
			cs.setString(2, accountType);
			cs.setDouble(3, depositAmount);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void makeWithdrawal(Account a, double withdrawalAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewBalance(String accountNumber) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int addNewAccount(Account a) {
		int accountsCreated = 0;
		String sql = "INSERT INTO ACCOUNT_TABLE ("
				+ "ACCOUNT_NUMBER, "
				+ "ACCOUNT_TYPE, ACCOUNT_BALANCE) VALUES (?, ?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, a.getAccountNumber());
			ps.setString(2, a.getAccountType());
			ps.setDouble(3, a.getAccountBalance());
			accountsCreated = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return accountsCreated;
	}

	@Override
	public int deleteAccount(String accountNumber, String accountType) {
		int accountsDeleted = 0;
		
		
		return accountsDeleted;	
	}


}
