package com.revature.bank;

import java.util.Scanner;

public class Service extends Persistence {
	
	public static Scanner sc = new Scanner(System.in);
	
	// this file will contain all the methods that correspond to the user transactions
	
	// login in method
	public static void logIn() {
		System.out.println("Login\n-----");
		System.out.print("Username: ");
		String username = sc.next();
		if(username.equals(getAccountUsername())) {
			System.out.print("Password: ");
			String password = sc.next();
			if(password.equals(getAccountPassword())) {
				// validate the user
				while(true) {
					// once the user has been validated, enter the transactions menu
					System.out.println("My Account\n----------");
					System.out.println("Account: " + getAccountNumber());
					System.out.println();
					System.out.println();
					System.out.println("1: View Balance\n2: Make Deposit\n3: Make Withdrawal\n4: Log Out");
					int option = sc.nextInt();
					while (option != 4) {
						if(option == 2) {
							System.out.println("Deposit Amount: ");
							double amount = sc.nextDouble();
							makeDeposit(amount);
							System.out.println("Would you like another transaction? (Y/N)");
							String answer = sc.next();
							if(answer.equals("Y")) {
								System.out.println("1: View Balance\n2: Make Deposit\n3: Make Withdrawal\n4: Log Out");
								option = sc.nextInt();
							} else {
								logOut();
							}
						} else if(option == 3) {
							System.out.println("Withdrawal Amount: ");
							double amount = sc.nextDouble();
							makeWithdrawal(amount);
							System.out.println("Would you like another transaction? (Y/N)");
							String answer = sc.next();
							if(answer.equals("Y")) {
								System.out.println("1: View Balance\n2: Make Deposit\n3: Make Withdrawal\n4: Log Out");
								option = sc.nextInt();
							} else {
								logOut();
							}
						} else if (option == 1){
							viewBalance();
							System.out.println("Would you like another transaction? (Y/N)");
							String answer = sc.next();
							if(answer.equals("Y")) {
								System.out.println("1: View Balance\n2: Make Deposit\n3: Make Withdrawal\n4: Log Out");
								option = sc.nextInt();
							} else {
								logOut();
							}
						}else {
							System.out.println("Please select a valid option!");
						}
					}
					if (option == 4) {
						logOut();
					}
				}
			}		
		}		
	}
	
	// log out method
	public static void logOut() {
		System.out.println("Have a great day!");		
	}
	
	// add money to a user's account
	public static void makeDeposit(double amount) {
		// here we want to make changes to add money to the user's account
		// get the current balance from the text file
		double currentBalance = retrieveAccountBalance();
		// variable for what the balance will be after the deposit
		double newBalance;
		// add the deposit amount to the current balance to create the new balance
		newBalance = currentBalance + amount;
		// let the user know what how much they deposited
		System.out.println("Deposit Amount: $" + amount);
		System.out.println();
		// display the new account balance
		System.out.println("Account Balance: $" + newBalance);
		// adjust the nbalance int the text file to reflect the new balance
		adjustAccountBalance(newBalance);
		
	}
	
	
	// take money out of a user's account
	public static void makeWithdrawal(double amount) {
		double currentBalance = retrieveAccountBalance();
		double newBalance = 0.0;
		// we don't want the user to be able to take out money if there's nothing in their account
		if(currentBalance > 0) {
			if(currentBalance >= amount) {
				// change the balance to reflect the withdrawal, and let the user know
				newBalance = (currentBalance - amount);
				System.out.println("Withdrawal Amount: $" + amount + "\nAccount Balance: $" + newBalance);
				// adjust the balance amount within the text file
				adjustAccountBalance(newBalance);
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
	public static void viewBalance() {
		// get the user's balance and print it to the console
		double currentBalance = retrieveAccountBalance();
		System.out.println("Account Balance: $" + currentBalance);
	}

}
