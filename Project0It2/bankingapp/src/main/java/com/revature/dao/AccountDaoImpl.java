package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	public Account getAccountById(int accnum) {
		String sql = "SELECT * FROM B_ACCOUNT WHERE A_ID = ?";
		Account a = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, accnum);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int aId = rs.getInt("A_ID");
				double cAmount = rs.getDouble("C_AMOUNT");
				double sAmount = rs.getDouble("S_AMOUNT");
				a = new Account(aId, cAmount, sAmount);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	public int createAccount() {
		int naccNum = 0;
		String sql = "{call CREATEACC(?)}";
		
		try(Connection con = ConnectionUtil.getConnection();
				CallableStatement cs = con.prepareCall(sql)){
			
			cs.registerOutParameter(1, java.sql.Types.INTEGER);
			cs.executeUpdate();
			naccNum = cs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return naccNum;
	}
	
	public void updateAccount(Account acc) {
		String sql = "UPDATE B_ACCOUNT SET C_AMOUNT = ?, S_AMOUNT=? WHERE A_ID = ? ";
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setDouble(1, acc.getCheckingBalance());
			ps.setDouble(2, acc.getSavingsBalance());
			ps.setInt(3, acc.getAccId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
