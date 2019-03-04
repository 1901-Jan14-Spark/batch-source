package com.revature.bankapp.dao;

import com.revature.bankapp.models.User;

public interface UserDao {

	public int createUser(User u);
	public int updateUser(User u);
	public User getUserById(int id);
	
}
