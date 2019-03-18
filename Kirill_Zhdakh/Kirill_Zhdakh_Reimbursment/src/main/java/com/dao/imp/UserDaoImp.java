package com.dao.imp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.model.User;

import com.util.ConnectionUtil;

import com.util.PasswordEncryption;

public class UserDaoImp implements UserDao {

	@Override
	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM USER_TABLE";
		try(Connection c = ConnectionUtil.getConnectionFromFile();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql))
		{
			while(rs.next())
			{
				userList.add(new User(rs.getString("USER_FIRSTNAME"), rs.getString("USER_LASTNAME"), rs.getString("USER_USERNAME"), rs.getString("USER_PASSWORD"), rs.getString("USER_EMAIL"), rs.getString("USER_TITLE"), rs.getInt("USER_REPORTSTO")));			
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public List<User> getUsersById(int id) {
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM USER_TABLE WHERE USER_REPORTSTO = " + id;
		try(Connection c = ConnectionUtil.getConnectionFromFile();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql))
		{
			while(rs.next())
			{
				userList.add(new User(rs.getString("USER_FIRSTNAME"), rs.getString("USER_LASTNAME"), rs.getString("USER_USERNAME"), rs.getString("USER_PASSWORD"), rs.getString("USER_EMAIL"), rs.getString("USER_TITLE"), rs.getInt("USER_REPORTSTO")));			
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public boolean createUser(User user) {
		String sql = "INSERT INTO USER_TABLE (USER_FIRSTNAME,"
				+"USER_LASTNAME,USER_USERNAME,USER_PASSWORD,"
				+ "USER_EMAIL,USER_TITLE,USER_REPORTSTO)"
				+" VALUES (?,?,?,?,?,?,?)";
	
		try(Connection c = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = c.prepareStatement(sql))
		{		
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, PasswordEncryption.encodePassword(user.getPassword()));
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getTitle());
			ps.setInt(7, user.getReportsTo());
			ps.executeUpdate();
			return true;
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		String sql;
		if (user.getReportsTo() == -1)
		{
		  sql = "UPDATE USER_TABLE"
				+" SET USER_FIRSTNAME = ?,"
				+" USER_LASTNAME = ?,"
				+" USER_USERNAME = ?,"
				+" USER_PASSWORD = ?,"
				+" USER_EMAIL = ?"
				+" WHERE USER_USERNAME = ?";
		}
		else
		{
			sql = "UPDATE USER_TABLE"
					+" SET USER_FIRSTNAME = ?,"
					+" USER_LASTNAME = ?,"
					+" USER_PASSWORD = ?,"
					+" USER_EMAIL = ?"
					+" WHERE USER_USERNAME = ?";
		}
		try(Connection c = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = c.prepareStatement(sql))
		{
			ps.setFloat(1, user.getCheckingBalance());
			ps.setFloat(2, user.getSavingBalance());
			ps.setString(3, user.getUsername());
			ps.executeUpdate();
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
