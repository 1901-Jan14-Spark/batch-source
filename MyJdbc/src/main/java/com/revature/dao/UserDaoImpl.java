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



public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getUsers() 
	{
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM ACCOUNT_HOLDER";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while (rs.next()) {
				
				String username = rs.getString("USERNAME");
				String password = rs.getString("USER_PASSWORD");
				String fname = rs.getString("FIRSTNAME");
				String lname = rs.getString("LASTNAME");
	
				userList.add(new User(username,password,fname,lname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userList;	
	}

	@Override
	public User getUserByUsername(String username) {
		User u = null;
		String sql = "SELECT * FROM ACCOUNT_HOLDER WHERE USERNAME = ?";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String userName = rs.getString("USERNAME");
				String passWord = rs.getString("USER_PASSWORD");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				
				u = new User(firstName,lastName,userName,passWord);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return u;
	}

	@Override
	public int createUser(User user) {
		int usersCreated = 0;
		String sql = "INSERT INTO ACCOUNT_HOLDER (USERNAME, USER_PASSWORD, FIRSTNAME, LASTNAME) VALUES (?, ?, ?, ?)";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			usersCreated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usersCreated;
	}

	@Override
	public int updateUser(User user) {
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		return 0;
	}

	public List<Account> getUserAcounts(String username)
	{
	   List<Account> userAccounts = new ArrayList<>();
       String sql ="select BANK_ACCOUNT.ACCOUNTID,BANK_ACCOUNT.ACCOUNTBALANCE,BANK_ACCOUNT.CHECKING_OR_SAVINGS from BANK_ACCOUNT join USER_ACCOUNT on BANK_ACCOUNT.ACCOUNTID = USER_ACCOUNT.ACCOUNTID where USER_ACCOUNT.USERNAME = ? ";
			
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();
		PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			       while(rs.next()) {
                       Account a = new Account();
				       int id = rs.getInt("ACCOUNTID");
				       double balance = rs.getDouble("ACCOUNTBALANCE");
				       String type = rs.getString("CHECKING_OR_SAVINGS");

				      a.setAccountId(id);
				      a.setAccountBalance(balance);
				      a.setTypeOfAccount(type);
			
				       userAccounts.add(a);
			      }
			       } catch (SQLException e) {
			} catch (IOException e) {
				e.printStackTrace();
             }
		return userAccounts;
}}