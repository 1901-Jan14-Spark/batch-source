package com.revature.dao;
import com.revature.model.Account;
public interface AccountDao {
	public Account getAccountById(int accnum);
	public int createAccount();
	public void updateAccount(Account acc);
	
	

}
