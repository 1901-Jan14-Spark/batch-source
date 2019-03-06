package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface AccountDAO {

	public Account varifyAccount(String username, String password);
	public int createAccount(Account a);
	public void updateAccount(Account a);
	public int deleteAccount(int id);
	public void Deposit(Account a, double increaseAmount);
}
