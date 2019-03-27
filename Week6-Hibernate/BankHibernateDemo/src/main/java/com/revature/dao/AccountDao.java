package com.revature.dao;

import java.util.List;

import com.revature.model.Account;

public interface AccountDao {
	
	public List<Account> getAllAccounts();
	public Account getAccountById(int id);
	public Account createAccount(Account account);
	public Account updateAccount(Account account);
	public void deleteAccount(Account account);

}
