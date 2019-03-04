package com.revature.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.User;
import com.revature.bankapp.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public int createAccount(Account a, User u) {
		int accountsCreated = 0;
		String sql = "INSERT INTO ACCOUNTS (USER_ID, ACCOUNT_ID, BALANCE) VALUES (?, ?, ?)";
		
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1,  u.getAccountId());
			ps.setInt(2, a.getAccountId());
			ps.setBigDecimal(3, a.getBalance());
			accountsCreated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountsCreated;
	}

//	@Override
	public int updateAccount(Account a) {
//		int accountsUpdated = 0;
//		String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USER_ID = ?";
//		
//		try(Connection con = ConnectionUtil.getConnectionFromSystem();
//				PreparedStatement ps = con.prepareStatement(sql)){
//			
//			ps.setBigDecimal(parameterIndex, x);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return 0;
	}

}
