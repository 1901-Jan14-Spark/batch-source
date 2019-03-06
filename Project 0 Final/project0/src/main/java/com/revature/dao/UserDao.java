package com.revature.dao;

import java.util.List;

import com.revature.model.User;
//framework for the UserDaoImpl and what parameters are needed for those methods
public interface UserDao {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public int createUser(User u);
	public int updateUser(User u);
	public int deleteUser(int id);
}
