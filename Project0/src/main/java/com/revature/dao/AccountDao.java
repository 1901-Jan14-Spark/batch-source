package com.revature.dao;

import java.util.List;

import com.revature.bank.Account;
import com.revature.bank.Member;

public interface AccountDao {
	
	public List<Account> getBothAccounts(String accountNumber);
	public Account getAccountByType(String accountNumber, String accountType);
	public void addNewAccount(Member m, String accountType, double newBalance);
	public void deleteAccount(Member m, String AccountType);
	public void makeDeposit(String accountNumber, String accountType, double depositAmount);
	public void makeWithdrawal(String accountNumber, String accountType, double withdrawalAmount);
	public void viewBalance(String accountNumber, String accountType);

}
