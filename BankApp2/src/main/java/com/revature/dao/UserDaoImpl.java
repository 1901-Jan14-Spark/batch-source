package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createUser(User u) {
		int usersCreated = 0;
		String sql = "INSERT INTO PERSON (FIRSTNAME, LASTNAME, EMAIL, PASSWORD) VALUES (?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			usersCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersCreated;
	}

	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
