package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Account;
import com.revature.util.Connections;

public class AccountDAO_Impl implements AccountDAO{

	@Override
	public  int createAccount(Account a) {
		int departmentsCreated = 0;
		String sql = "INSERT INTO ACCOUNTS (ACC_ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, PHONE_NUMBER, BANK_ACC_ID) VALUES (?,?,?,?,?,?,?,?)";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, a.getId());
			ps.setString(2, a.getUsername());
			ps.setString(3, a.getPassword());
			ps.setString(4, a.getFirstname());
			ps.setString(5, a.getLastname());
			ps.setString(6, a.getEmail());
			ps.setString(7, a.getPhoneNumber());
			ps.setInt(8, a.getBA_ID());
			
			departmentsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departmentsCreated;
	}

	

	public Account varifyAccount(String username, String password) {
		String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME = ? AND PASSWORD= ?";
		Account acc = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("ACC_ID");
				String name = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");
				String firstname= rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE_NUMBER");
				int bankId = rs.getInt("BANK_ACC_ID");
				
				
				acc = new Account(Id, name, pass, firstname, lastname, email, phone, bankId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acc;
		}

	

	public void updateAccount(Account a) {
String sql = "UPDATE ACCOUNTS SET BANK_ACC_ID = ? WHERE ACC_ID = ?";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, a.getId());
			ps.setInt(2, a.getId());
		
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int deleteAccount(int id) {
		int rowsDeleted = 0;
		
		String sql = "DELETE FROM ACCOUNTS WHERE ACC_ID = ?";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
String sql2 = "DELETE FROM BANK_ACC WHERE BA_ID = ?";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql2)){
			
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
		
	}

	public void Deposit(Account a, double increaseAmount) {
		// TODO Auto-generated method stub
		
	}
}
