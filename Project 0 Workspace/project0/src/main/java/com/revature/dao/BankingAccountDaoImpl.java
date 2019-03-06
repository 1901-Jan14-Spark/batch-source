package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.BankingAccount;
import com.revature.util.ConnectionUtil;

public class BankingAccountDaoImpl implements BankingAccountDao{

	@Override
	public List<BankingAccount> getBankingAccount() {
		List<BankingAccount> accounts = new ArrayList<>();
		
		String sql = "SELECT * FROM ACCOUNTS";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				int accountId = rs.getInt("ACCOUNT_ID");
				String accountType = rs.getString("ACCOUNT_TYPE");
				double accountBalance = rs.getDouble("ACCOUNT_BALANCE");
				accounts.add(new BankingAccount(accountId, accountType, accountBalance));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public BankingAccount getBankingAccountById(int id) {
		String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
		BankingAccount b = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accountId = rs.getInt("ACCOUNT_ID");
				String accountType = rs.getString("ACCOUNT_TYPE");
				double accountBalance = rs.getDouble("ACCOUNT_BALANCE");
				b = new BankingAccount(accountId, accountType, accountBalance);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public int createAccount(BankingAccount b) {
		int accountCreated = 0;
		String sql = "INSERT INTO ACCOUNTS (ACCOUNT_ID, ACCOUNT_TYPE, ACCOUNT_BALANCE) VALUES (?,?,?)";
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, b.getAccountId());
			ps.setString(2, b.getAccountType());
			ps.setDouble(3, b.getBalance());
			accountCreated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountCreated;
	}

	@Override
	public int updateAccount(BankingAccount b) {
		int accountUpdate = 0;
		String sql = "UPDATE ACCOUNTS"
				+ "SET ACCOUNT_BALANCE = ?,"
				+ "WHERE ACCOUNT_ID = ?";
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setDouble(1, b.getBalance());
			ps.setInt(2, b.getAccountId());
			accountUpdate = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountUpdate;
	}

	@Override
	public int deleteAccount(int id) {
		int rowsDeleted = 0;
		
		String sql = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
	}

	@Override
	public int changeAccountBalance(int id, double changeAmount) {
		
		String sql = "{call CHANGE_BALANCE(?,?)}";
		
		try(Connection con = ConnectionUtil.getConnection();
				CallableStatement cs = con.prepareCall(sql)){
			cs.setInt(1,id);
			cs.setDouble(2, changeAmount);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
}
