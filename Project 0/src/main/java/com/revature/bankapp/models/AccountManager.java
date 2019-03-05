package com.revature.bankapp.models;

import java.math.BigDecimal;

import com.revature.bankapp.dao.UserDao;
import com.revature.bankapp.dao.UserDaoImpl;

public class AccountManager {
	
	private static User user;
	private int accountNumber;
	private double balance;
	private Account account;
	static UserDao userDao = new UserDaoImpl();
		
	public AccountManager(User user, Account account) {
		this.user = user;
		this.account = account;
	}

	public static BigDecimal addDeposit(int accountId, BigDecimal entry) {
		User temp = userDao.getUserById(accountId);
		BigDecimal userCurrentBal = temp.getAccount().getBalance();
		BigDecimal newBalance = userCurrentBal.add(entry);
		return newBalance;
	}
	
	public static BigDecimal processWithdrawal(int accountId, BigDecimal withdrawalAmount) {
		User temp = userDao.getUserById(accountId);
		BigDecimal userCurrentBal = temp.getAccount().getBalance();
		BigDecimal newBalance = userCurrentBal.subtract(withdrawalAmount);
			if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
					System.out.println("You cannot withdraw an amount that will cause your account to overdraft. Please try again.");
					return newBalance;
				} 
		return newBalance;
	}
}
