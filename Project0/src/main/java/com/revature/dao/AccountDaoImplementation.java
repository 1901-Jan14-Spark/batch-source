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
	public List<Account> getMemberAccounts(String accountNumber) {
		List<Account> accounts = new ArrayList<>();
		
		String sql = "SELECT * FROM ACCOUNT_TABLE "
				+ "WHERE ACCOUNT_NUMBER = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
				ps.setString(1, accountNumber);
				ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				String memAccountNumber = rs.getString("ACCOUNT_NUMBER");
				String memAccountType = rs.getString("ACCOUNT_TYPE");
				double memAccountBalance = rs.getDouble("ACCOUNT_BALANCE");
				accounts.add(new Account(memAccountNumber, memAccountType, memAccountBalance));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return accounts;
	}

	
	@Override
	public Account getAccountByAccountType(String accountNumber, String accountType) {
		String sql = "SELECT * FROM ACCOUNT_TABLE "
				+ "WHERE ACCOUNT_NUMBER = ? AND ACCOUNT_TYPE = ?";
		Account a = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, accountNumber);
			ps.setString(2, accountType);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String memAccountNumber = rs.getString("ACCOUNT_NUMBER");
				String memAccountType = rs.getString("ACCOUNT_TYPE");
				double memAccountBalance = rs.getDouble("ACCOUNT_BALANCE");
				a = new Account(memAccountNumber, memAccountType, memAccountBalance);
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
	public void makeWithdrawal(String accountNumber, String accountType, double withdrawalAmount) {
		String sql = "{CALL MAKE_WITHDRAWAL(?,?,?)}";

		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){

			cs.setString(1, accountNumber);
			cs.setString(2, accountType);
			cs.setDouble(3, withdrawalAmount);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public double viewBalance(String accountNumber, String accountType) {	
		double accountBalance = 0.0;
		
		String sql = "{CALL VIEW_BALANCE(?,?,?)}";

		try(Connection c = ConnectionUtil.getConnection();
				CallableStatement cs = c.prepareCall(sql)){

			cs.setString(1, accountNumber);
			cs.setString(2, accountType);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountBalance;
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
