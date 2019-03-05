package com.revature.dao;

import java.util.List;

import com.revature.bank.Account;
import com.revature.bank.Member;

public interface AccountDao {
	
	public List<Account> getBothAccounts(String accountNumber);
	public Account getAccountByAccountNumber(String accountNumber);
	public int addNewAccount(Account a);
	public int deleteAccount(String accountNumber, String AccountType);
	public void makeDeposit(String accountNumber, String accountType, double depositAmount);
	public void makeWithdrawal(Account a, double withdrawalAmount);
	public void viewBalance(String accountNumber);

}
