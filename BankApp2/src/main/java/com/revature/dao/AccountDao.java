package com.revature.dao;

import com.revature.models.Account;
import com.revature.models.User;

public interface AccountDao {

	public Account getAccountById(int id);
	public int createAccount(User u, Account a);
	public boolean decAccountSavings(String email, double amount);
	public boolean incAccountSavings(String email, double amount);
	public int updateAccountCheckings(String email, double amount);
	public int deleteAccount(int id);
}
