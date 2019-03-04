package com.revature.bankapp.dao;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.User;

public interface AccountDao {
	
	public int createAccount(Account a, User u);
	public int updateAccount(Account a);

}
