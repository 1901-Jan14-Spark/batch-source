package com.revature.bank;

import java.util.Scanner;

public class Service extends User {
	
	public static Scanner sc = new Scanner(System.in);
	
	// this file will contain all the methods that correspond to the user transactions
	
	// login in method
	public static void logIn(User u) {
		System.out.println("Login\n-----");
		System.out.println();
		System.out.println();
		System.out.print("Username: ");
		String username = sc.next();
		if(username.equals(u.getUserName())) {
			System.out.print("Password: ");
			String password = sc.next();
			if(password.equals(u.getPassword())) {
				// validate the user
				while(true) {
					// once the user has been validated, enter the transactions menu
					System.out.println("My Account\n----------");
					System.out.println();
					System.out.println("Account: " + u.getAccountNumber());
					System.out.println("Balance: " + u.getAccountBalance());
					System.out.println();
					System.out.println();
					System.out.println("1: Make Deposit\n2: Make Withdrawal\n3: Log Out");
					int option = sc.nextInt();
					while (option != 3) {
						if(option == 1) {
							System.out.println("Deposit Amount: ");
							double amount = sc.nextDouble();
							makeDeposit(u, amount);
						} else if(option == 2) {
							System.out.println("Withdrawal Amount: ");
							double amount = sc.nextDouble();
							makeWithdrawal(u, amount);					
						} else {
							System.out.println("Please select a valid option");
						}
					}
					if (option == 3) {

					}
				}
			}
			
		}
		
		
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
		System.out.println("Deposit Amount: $" + amount);
		System.out.println();
		// here, i'm checking to make sure the account balance and the new balance are the same
		System.out.println("Account Balance: " + newBalance);
		System.out.println(u.getAccountBalance());
		
	}
	
	// take money out of a user's account
	public static void makeWithdrawal(User u, double amount) {
		double currentBalance = u.getAccountBalance();
		// we don't want the user to be able to take out money if there's nothing in their account
		while(currentBalance > 0) {
			if(currentBalance >= amount) {
				// change the balance to reflect the withdrawal, and let the user know
				u.setAccountBalance(currentBalance - amount);
				System.out.println("Withdrawal Amount: $" + amount + "\nAccount Balance: $" + u.getAccountBalance());
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
