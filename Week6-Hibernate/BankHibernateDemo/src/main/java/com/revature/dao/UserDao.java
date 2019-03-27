package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User createUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User getUserByUsername(String username);

}
