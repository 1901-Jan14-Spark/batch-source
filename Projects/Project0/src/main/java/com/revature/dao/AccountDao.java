package com.revature.dao;

import java.util.List;

import com.revature.bank.Account;
import com.revature.bank.Member;

public interface AccountDao {
	
	public List<Account> getMemberAccounts(String accountNumber);
	public Account getAccountByAccountType(String accountNumber, String accountType);
	public int addNewAccount(Account a);
	public int deleteAccount(String accountNumber, String AccountType);
	public void makeDeposit(String accountNumber, String accountType, double depositAmount);
	public void makeWithdrawal(String accountNumber, String accountType, double withdrawalAmount);
	public double viewBalance(String accountNumber, String accountType);

}
