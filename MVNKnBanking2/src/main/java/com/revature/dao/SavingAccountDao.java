package com.revature.dao;

import java.util.List;

import com.revature.model.SavingAccount;

public interface SavingAccountDao {
	
	public List<SavingAccount> getCAccount();
	public SavingAccount getSAccountById(long id);
	public int createSAccount(SavingAccount sobj);
	public int updateSAccountDeposit(SavingAccount sa, double transAmount);
	public int updateCAccount(SavingAccount sa);
	public int deleteCAccount(SavingAccount sa);

}
