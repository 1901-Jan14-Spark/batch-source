package com.revature.dao;

import java.sql.CallableStatement;
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
	public int deleteBankAccount(int id) {
String sql = "DELETE FROM BANK_ACC WHERE BA_ID = ?";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String	sql2 = "{call UPDATE_BA_ID(?)}"; 
		try(Connection con = Connections.getConnection();
		CallableStatement cs = con.prepareCall(sql2)){

				cs.setInt(1, id); 
				cs.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void deposit(Account a, double increaseAmount) {
		double x=viewBalance(a);
		double y=increaseBalance(x, increaseAmount);
		log.info("Your balance is now " + y );
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
	
	public static double increaseBalance(Double balance, double deposit) {
		if (deposit<0.0) {
			log.info("Can only deposit positive, numeric amounts.");
			return balance;
		}
		double sum=balance+deposit;
		return sum;
	}

	

	@Override
	public void withdraw(Account a, double decreaseAmount) {
		double x=viewBalance(a);
	double y=decreaseBalance(x, decreaseAmount);
		log.info("your balance is now " + y);
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
	public static double decreaseBalance(Double balance, double withdrawal) {
		if (balance<withdrawal) {
			log.info("Balance is to low to withdraw that much");
			return balance;
		}
		if (withdrawal<0.0) {
			log.info("Can only withdraw positive, numeric amounts.");
			return balance;
		}
		double y=balance-withdrawal;
		return y;
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
