package com.revature.dao;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.Bank_Account;

public interface Bank_AccountDAO {
	public List<Bank_Account> getBankAccounts();
	public int createBankAccount(Account a, Bank_Account b);
	public int updateBankAccount(Bank_Account a);
	public int deleteBankAccount(int id);
	public void deposit(Account a, double increaseAmount);
	public void withdraw(Account a, double decreaseAmount);
	public double viewBalance(Account a);
	
}
