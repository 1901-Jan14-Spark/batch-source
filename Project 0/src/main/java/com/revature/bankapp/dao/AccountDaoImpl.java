package com.revature.bankapp.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.User;
import com.revature.bankapp.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public int createAccount(Account acc) {
		int accountsCreated = 0;
		String sql = "INSERT INTO ACCOUNTS (BALANCE) VALUES (?)";
		
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setBigDecimal(1, acc.getBalance());
			accountsCreated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountsCreated;
	}

//	@Override
	public int updateAccount(BigDecimal balance, int id) {
		int accountsUpdated = 0;
		String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USER_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setBigDecimal(1, balance);
			ps.setInt(2, id);
			accountsUpdated = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountsUpdated;
	}


}
