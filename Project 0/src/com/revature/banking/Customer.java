package com.revature.banking;

public class Customer {

	private String userName;
	private String password;
	private Account account;

	Customer(String userName, String password, Account account) {
		this.userName = userName;
		this.password = password;
		this.account = account;
	}
	
	public String basicInfo() {
		return "User Name: " + userName + "\n" +
				"   Account Number: " + account.getAccountNumber();
	}

	Account getAccount() {
		return account;
	}
	
}
