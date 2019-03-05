package com.revature.bankapp.models;

import java.math.BigDecimal;

public class Account{

	private int accountId;
	static private int accountNumber = 1;
	private BigDecimal balance;
	
	public Account() {
		super();		
	}
	
	public Account(BigDecimal balance) {
		super();
		this.accountId = accountNumber++;
		this.balance = balance;
	}

	public Account(int accId, BigDecimal balance2) {
		this.accountId = accId;
		this.balance = balance2;
	}

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + "]";
	}
	
	
	
	
	
	
}