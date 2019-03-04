package com.revature.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.bankapp.models.User;
import com.revature.bankapp.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int createUser(User u) {
		int usersCreated = 0;
		String sql = "INSERT INTO USERS (USER_ID, NAME, USERNAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, u.getAccountId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPassword());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersCreated;
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
