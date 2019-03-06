package com.revature.bankapp.dao;

import java.util.List;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.User;

public interface UserDao {

	public int createUser(User u);
	public int updateUser(User u);
	public User getUserById(int id);
	public User verifyUser(String user);
	public List fetchAccount();
	public int returnId(String input);
	
}
