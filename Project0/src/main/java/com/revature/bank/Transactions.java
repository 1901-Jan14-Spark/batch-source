package com.revature.bank;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImplementation;
import com.revature.dao.MemberDao;
import com.revature.dao.MemberDaoImplementation;

public class Transactions {
	
	public static Scanner sc = new Scanner(System.in);
	public final static Logger log = Logger.getRootLogger();

	static MemberDao md = new MemberDaoImplementation();	
	static AccountDao ad = new AccountDaoImplementation();

	// this file will contain all the methods that correspond to the user transactions

	// login in method
	public static void logIn() {
		List<Member> members = md.getAllMembers();
		log.info("Login\n-----");
		log.info("Username: ");
		String username = sc.next();
		for(Member m : members) {
			if(username.equals(m.userName)) {
				log.info("Password: ");
				String password = sc.next();
				if(password.equals(m.password)) {
					transactions(m.accountNumber);	
				} else {
					System.out.println();
					log.error("Invalid username or password!");
					System.out.println();
					logIn();
				}
			} else {
				System.out.println();
				log.error("Invalid username or password! Please re-enter: ");
				System.out.println();
				logIn();
			}
		}
	}

	public static void homeScreen() {
		log.info("__________________________");
		log.info("|                        |");
		log.info("|       THE BANK         |");
		log.info("|________________________|");
		System.out.println();
		System.out.println();
		log.info("1: Login\n2: Create Account");
		int option = sc.nextInt();
		if(option == 1) {
			System.out.println();
			logIn();	
		} else if (option == 2) {
			createNewMember();				
		}
	}

	public static void createNewMember() {
		List<Member> members = md.getAllMembers();

		System.out.println();
		log.info("New Member Info\n---------------");
		System.out.println();
		// create a new member object
		log.info("First Name: ");
		String newUserFirst = sc.next();
		log.info("Last Name: ");
		String newUserLast = sc.next();
		log.info("Email: ");
		String newUserEmail = sc.next();
		log.info("Username: ");
		String newUsername = sc.next();
		// check to see if the username is already taken
		if(members.contains(newUsername)) {
			// let the user know the name is already take, have them enter a new one
		} else {		
			log.info("Password: ");
			String newUserPassword1 = sc.next();
			log.info("Re-enter Password: ");
			String newUserPassword2 = sc.next();
			if(!newUserPassword1.equals(newUserPassword2)) {
				log.error("Passwords don't match!");
				log.info("Password: ");
				newUserPassword1 = sc.next();
				log.info("Re-enter Password: ");
				newUserPassword2 = sc.next();			
			} 
			if(newUserPassword1.equals(newUserPassword2)) {
				int newMember = md.addNewMember(new Member(newUserFirst, newUserLast, newUsername, newUserPassword1, newUserEmail));
				if(newMember == 1) {
					log.info("Account successfully created!");
				} 
			}
		}
	}

	public static void transactions(String accountNumber) {
		// the current member logged in
		Member m = md.getMemberByUsername(accountNumber);
		// their individual checking
		Account checkings = ad.getAccountByAccountType(accountNumber, "Checkings");
		// their individual savings
		Account savings = ad.getAccountByAccountType(accountNumber, "Savings");

		// once the user has been validated, enter the transactions menu
		log.info("1: View Balance\n2: Make Deposit\n3: Make Withdrawal\n4: Log Out");
		int option = sc.nextInt();
		while (option != 4) {
			if(option == 2) {
				System.out.println();
				// show the balance of each account
				log.info("Checkings: $" + checkings.accountBalance);
				log.info("Savings: $" + savings.accountBalance);	

				// get deposit amount
				log.info("Deposit Amount: ");
				double amount = sc.nextDouble();
				log.info("Deposit to (1)Checking or (2)Savings?");
				int accountChoice = sc.nextInt();
				if(accountChoice == 1) {
					ad.makeDeposit(accountNumber, "Checkings", amount);
				} else if (accountChoice == 2) {
					ad.makeDeposit(accountNumber, "Savings", amount);
				}
				log.info("Would you like another transaction? (Y/N)");
				String answer = sc.next();
				if(answer.equals("Y")) {
					transactions(accountNumber);
					option = sc.nextInt();
				} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
					System.out.println("Invalid Input! Please select a valid option: (Y/N)");
					answer = sc.next();
				} else if(answer.equalsIgnoreCase("N")) {
					option = 4;
				}
			} else if(option == 3) {
				System.out.println();
				log.info("Checkings: $" + checkings.accountBalance);
				log.info("Savings: $" + savings.accountBalance);	
				log.info("Withdrawal Amount: ");
				double amount = sc.nextDouble();
				log.info("Wthdraw from (1)Checking or (2)Savings?");
				int accountChoice = sc.nextInt();
				if(accountChoice == 1) {
					ad.makeWithdrawal(accountNumber, "Checkings", amount);
					log.info("You withdrew $" + amount + "for Checkings");
				} else if (accountChoice == 2) {
					ad.makeWithdrawal(accountNumber, "Savings", amount);
					log.info("You withdrew $" + amount + "for Savings");
				}
				log.info("Would you like another transaction? (Y/N)");
				String answer = sc.next();
				if(answer.equals("Y")) {
					transactions(accountNumber);
					option = sc.nextInt();
				} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
					log.error("Invalid Input! Please select a valid option: (Y/N)");
					answer = sc.next();
				} else if (answer.equalsIgnoreCase("N")) {
					option = 4;
				}
			} else if (option == 1){
				log.info("View balance from (1)Checking or (2)Savings?");
				int accountChoice = sc.nextInt();
				if(accountChoice == 1) {
					log.info("Checking: $" + checkings.accountBalance);
				} else if (accountChoice == 2) {
					log.info("Savings: $" + savings.accountBalance);
				}
				log.info("Would you like another transaction? (Y/N)");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("Y")) {
					transactions(accountNumber);
				} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
					log.error("Invalid Input! Please select a valid option: (Y/N)");
					answer = sc.next();
				} else if(answer.equalsIgnoreCase("N")) {
					option = 4;
				}
			}else {
				log.error("Please select a valid option!");
				log.info("1: View Balance\n2: Make Deposit\n3: Make Withdrawal\n4: Log Out");
				option = sc.nextInt();						
			}
		}
		if (option == 4) {
			logOut();
		}
	}

	// log out method
	public static void logOut() {
		System.out.println();
		homeScreen();		
	}
}
