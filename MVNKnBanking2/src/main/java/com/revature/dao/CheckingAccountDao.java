package com.revature.dao;

import java.util.List;

import com.revature.model.CheckingAccount;

public interface CheckingAccountDao {

	public List<CheckingAccount> getCAccount();
	public CheckingAccount getCAccountById(long id);
	public int createCAccount(CheckingAccount cobj);
	public int updateCAccountDeposit(CheckingAccount ca, double transAmount);
	public int updateCAccountWithdraw(CheckingAccount ca);
	public int deleteCAccount(CheckingAccount ca);
	
	
}
