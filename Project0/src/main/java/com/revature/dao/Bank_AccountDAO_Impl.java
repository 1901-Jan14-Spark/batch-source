package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Bank_Account;
import com.revature.models.Service;
import com.revature.util.Connections;

public class Bank_AccountDAO_Impl implements Bank_AccountDAO {
	private static Logger log = Logger.getRootLogger();
	@Override
	public List<Bank_Account> getBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createBankAccount(Account a, Bank_Account b) {
		int BankAccountsCreated = 0;
		String sql = "INSERT INTO BANK_ACC (BA_ID, BALANCE) VALUES (?,?)";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			b.setId(a.getId());
			ps.setInt(1, b.getId());
			ps.setDouble(2, b.getBalance());
			
			
			BankAccountsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		AccountDAO aa=new AccountDAO_Impl();
		aa.updateAccount(a);
		
		return BankAccountsCreated;
	}
		
	

	@Override
	public int updateBankAccount(Bank_Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBankAccount(int id) {
String sql = "DELETE FROM BANK_ACC WHERE BA_ID = ?";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
String sql2 = "UPDATE ACCOUNTS SET BANK_ACC_ID = ? WHERE ACC_ID = ?";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql2)){
			
			ps.setInt(1, 0);
			ps.setInt(2, id);
		
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void deposit(Account a, double increaseAmount) {
		double x=viewBalance(a);
		if (increaseAmount<0.0) {
			log.info("Can only deposit positive, numeric amounts.");
			return;
		}
		double y=x+increaseAmount;
String sql = "UPDATE BANK_ACC SET BALANCE = ? WHERE BA_ID = ?";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setDouble(1, y);
			ps.setInt(2, a.getId());
		
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	

	@Override
	public void withdraw(Account a, double decreaseAmount) {
		double x=viewBalance(a);
		if (x<decreaseAmount) {
			log.info("Balance is to low to withdraw that much");
			Service.transaction(a);
		}
		if (decreaseAmount<0.0) {
			log.info("Can only withdraw positive, numeric amounts.");
			return;
		}
		double y=x-decreaseAmount;
String sql = "UPDATE BANK_ACC SET BALANCE = ? WHERE BA_ID = ?";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setDouble(1, y);
			ps.setInt(2, a.getId());
		
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public double viewBalance(Account a) {
		String bankId= Integer.toString(a.getBA_ID()); 
String sql = "SELECT BALANCE FROM BANK_ACC WHERE BA_ID =" + bankId;
	double	balance= 0.0;
		try(Connection con = Connections.getConnection();
				
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
			 balance=rs.getDouble("Balance");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}

	
	
	
	
	
	
}
