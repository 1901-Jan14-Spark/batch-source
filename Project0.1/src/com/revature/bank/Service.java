package com.revature.bank;

public class Service extends User {
	
	// this file will contain all the methods that correspond to the user transactions
	
	// login in method
	public static void logIn(User u) {
		System.out.println("Username: ");
		
	}
	
	// log out method
	public static void logOut() {
		
	}
	
	// add money to a user's account
	public static void makeDeposit(User u, double amount) {
		// here we want to make changes to add money to the user's account
		double currentBalance = u.getAccountBalance();
		double newBalance;
		newBalance = currentBalance + amount;
		u.setAccountBalance(newBalance);
		// here, i'm checking to make sure the account balance and the new balance are the same
		System.out.println(newBalance);
		System.out.println(u.getAccountBalance());
		
	}
	
	// take money out of a user's account
	public static void makeWithdrawl(User u, double amount) {
		double currentBalance = u.getAccountBalance();
		// we don't want the user to be able to take out money if there's nothing in their account
		while(currentBalance > 0) {
			if(currentBalance >= amount) {
				// change the balance to reflect the withdrawl, and let the user know
				u.setAccountBalance(currentBalance - amount);
				System.out.println("Withdrawal Amount: $" + amount + ".\nAccount Balance: $" + u.getAccountBalance());
			} else {
				// the user is trying to take out more money than they have
				System.out.println("Insufficient Funds");
			}
		}
		if(currentBalance == 0.0){
			// notify the user if they don't have any money in their account
			System.out.println("There are no funds in this account");
		}
		
	}
	
	// show the user their balance
	public static void viewBalance(User u) {
		// get the user's balance and print it to the console
		double currentBalance = u.getAccountBalance();
		System.out.println("Account Balance: $" + currentBalance);
	}

}
