package com.revature.dao;

import java.util.List;

import com.revature.model.BankingAccount;

public interface BankingAccountDao {
	
	public List<BankingAccount> getBankingAccount();
	public BankingAccount getBankingAccountById(int id);
	public int createAccount(BankingAccount b);
	public int updateAccount(BankingAccount b);
	public int deleteAccount(int id);
	public void changeAccountBalance(BankingAccount b, double changeAmount);
}
