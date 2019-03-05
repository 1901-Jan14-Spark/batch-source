package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.BankingAccount;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{
	
	BankingAccountDaoImpl bad = new BankingAccountDaoImpl();
	
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		
		String sql = "SELECT * FROM USERS_TABLE";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				User u = new User();
				
				int userId = rs.getInt("USER_ID");
				u.setId(userId);
				
				String userName = rs.getString("USER_NAME");
				u.setUserName(userName);
				
				String password = rs.getString("USER_PW");
				u.setPassword(password);
				
				int accountId = rs.getInt("ACCOUNT_ID");
				u.setAccount(new BankingAccount(accountId));
				
				users.add(u);
			}
			
			List<BankingAccount> accounts = bad.getBankingAccount();
			
			for(User u: users) {
				int accountId = u.getAccount().getAccountId();
				if(accountId!=0) {
					for(BankingAccount a: accounts) {
						if(accountId == a.getAccountId()) {
							u.setAccount(a);
						}
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT * FROM USERS_TABLE WHERE USER_ID = ?";
		User u = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USERNAME");
				String password = rs.getString("USER_PW");
				int accountId = rs.getInt("ACCOUNT_ID");
				u = new User(userId, userName, password, bad.getBankingAccountById(accountId));
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int createUser(User u) {
		int userCreated = 0;
		String sql = "INSERT INTO USER (USER_ID, USERNAME, PASSWORD, ACCOUNT_ID) VALUES (?,?,?,?)";
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, u.getId());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getPassword());
			ps.setInt(3, u.getAccount().getAccountId());
			userCreated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bad.createAccount(u.getAccount());
		return userCreated;
	}

	@Override
	public int updateUser(User u) {
		int userUpdated = 0;
		return userUpdated;
	}

	@Override
	public int deleteUser(int id) {
		return 0;
	}

}
