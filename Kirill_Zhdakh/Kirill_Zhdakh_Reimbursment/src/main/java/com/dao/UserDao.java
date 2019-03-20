package com.dao;

import java.util.List;
import com.model.User;

public interface UserDao {
	public List<User> getUsers();
	public User getUserById(int id);
	public boolean createUser(User user);
	public boolean updateUserPassword(String password, int id);
	public boolean deleteUser(int id);
}
