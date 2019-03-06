package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	//implementing CRUD/Create/Update/Delete
	public List<User> getUsers();
	public User getUserByUsername(String username);
	public int createUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id);
}
