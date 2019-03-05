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

public class UserDaoImpl implements UserDao {

	@Override
	public int createUser(User u) {
		int usersCreated = 0;
		String sql = "INSERT INTO USERS (NAME, USERNAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
		
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			usersCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersCreated;
	}

	@Override
	public User verifyUser(String username) {
		User returnVerif = new User();
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
		
		try (Connection con = ConnectionUtil.getConnectionFromSystem();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String name = rs.getString("NAME");
				String usersname = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");
				returnVerif = new User(userId, name, usersname, pass);
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnVerif;
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT ACCOUNTS.USER_ID, USERS.USERNAME, ACCOUNTS.BALANCE FROM USERS JOIN ACCOUNTS ON USERS.USER_ID = ACCOUNTS.USER_ID WHERE USERS.USER_ID = ?";
		User tempUser = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int userId = rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				BigDecimal balance = rs.getBigDecimal("BALANCE");
				Account tempAcc = new Account(userId, balance);
				tempUser = new User(username, tempAcc);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempUser;
	}

	public List fetchAccount() {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM USERS JOIN ACCOUNTS ON USERS.USER_ID = ACCOUNTS.USER_ID";
		Account tempAcc = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromSystem();
				Statement s = con.prepareStatement(sql)){
			
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				int accId = rs.getInt("USER_ID");
				String name = rs.getString("NAME");
				String username = rs.getString("USERNAME");
				BigDecimal balance = rs.getBigDecimal("BALANCE");
				User listUser = new User(accId, name, username, balance);
				users.add(listUser);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
}
