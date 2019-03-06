package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;
import com.revature.dao.AccountDao;

public class AccountDaoImpl  implements AccountDao {

	public List<Account> getAccounts() {
		List<Account> accountList = new ArrayList<>();
		String sql = "SELECT * FROM BANK_ACCOUNT";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			while (rs.next()) {
				int id = rs.getInt("ACCOUNTID");
				double balance = rs.getDouble("ACCOUNTBALANCE"); 
				String typeOfAccount = rs.getString("CHECKING_OR_SAVINGS");
				accountList.add(new Account(id,balance,typeOfAccount));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return accountList;
	}

	public int createAccount(Account account, User user) {
		int openAccount = 0;
		String sql = "INSERT INTO BANK_ACCOUNT (ACCOUNTID, ACCOUNTBALANCE, CHECKING_OR_SAVINGS ) VALUES (?, ?, ?)";
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql); ) {
			
			ps.setInt(1, account.getAccountId());
			ps.setDouble(2, account.getAccountBalance());
			ps.setString(3, account.getTypeOfAccount());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String sql2 = "INSERT INTO USER_ACCOUNT (USERNAME, ACCOUNTID) VALUES (?, ?)";
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql2); ) {
			ps.setString(1, user.getUserName());
			ps.setInt(2, account.getAccountId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return openAccount;
	}
	

	public int updateAccount(Account account) {
		int accountUpdated = 0;
		String sql = "UPDATE BANK_ACCOUNT SET  ACCOUNTBALANCE = ? where ACCOUNTID = ?";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {
			con.setAutoCommit(false);
			
			ps.setDouble(1, account.getAccountBalance());
			ps.setInt(2, account.getAccountId());			
			accountUpdated = ps.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accountUpdated;
	}

	public int deleteAccount(int account) {
		return 0;
	}

}
