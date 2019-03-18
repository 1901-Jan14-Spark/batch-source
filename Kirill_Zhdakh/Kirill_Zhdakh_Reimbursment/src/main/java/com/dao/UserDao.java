package com.dao;

import java.util.List;
import com.model.User;

public interface UserDao {
	public List<User> getUsers();
	public List<User> getUsersById(int id);
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
}
