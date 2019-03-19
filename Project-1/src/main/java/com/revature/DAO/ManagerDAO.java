package com.revature.DAO;


import com.revature.models.Manager;

public interface ManagerDAO {
	public Manager varifyAccount(String username, String password);
}
