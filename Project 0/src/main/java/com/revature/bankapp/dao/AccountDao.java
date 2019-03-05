package com.revature.bankapp.dao;

import java.math.BigDecimal;

import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.User;

public interface AccountDao {
	
	public int createAccount(Account acc);
	public int updateAccount(BigDecimal bal, int id);

}
