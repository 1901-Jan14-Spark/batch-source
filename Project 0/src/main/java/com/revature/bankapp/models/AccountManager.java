package com.revature.bankapp.models;

import java.math.BigDecimal;

public class AccountManager {
	
	private static User user;
	private int accountNumber;
	private double balance;
	private Account account;
		
	public AccountManager(User user, Account account) {
		this.user = user;
		this.account = account;
	}

//	public static double addDeposit(BigDecimal entry) {
//		String[] activeUserArr = user.readUser();
//		BigDecimal userCurrentBal = Double.parseDouble(activeUserArr[4]);
//		return userCurrentBal+entry;
//	}
	
	public static double processWithdrawal(double withdrawalAmount) {
		String[] activeUserArr = user.readUser();
		double userCurrentBal = Double.parseDouble(activeUserArr[4]);
		double newBalance = userCurrentBal - withdrawalAmount;
			if (newBalance < 0) {
					System.out.println("You cannot withdraw an amount that will cause your account to overdraft. Please  try again.");
					return newBalance;
				} 
		return newBalance;
	}

}
