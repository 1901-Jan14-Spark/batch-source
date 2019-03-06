package com.revature.dao;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.User;

public interface AccountDao {
	public List<Account> getAccounts();
	public int createAccount(Account account, User u);
	public int updateAccount(Account account);
	public int deleteAccount(int account);
}
