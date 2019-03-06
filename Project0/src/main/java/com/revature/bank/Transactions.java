package com.revature.bank;

import java.util.ArrayList;
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
		List<Member> members = new ArrayList<>();
		members = md.getAllMembers();
		log.info("Login\n-----");
		log.info("Username: ");
		System.out.println();
		String username = sc.next();
		while(members.isEmpty() == false) {
			for(int i = 0; i < members.size(); i++) {
				//Member m1 = new Member(m.accountNumber, m.firstName,m.lastName, m.userName, m.password, m.email);	
				if(username.equals(members.get(i).getUserName())) {
					log.info("Password: ");
					String password = sc.next();
					if(password.equals(members.get(i).getPassword())) {
						transactions(members.get(i).getAccountNumber());	
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
	}

	public static void homeScreen() {
		log.info(" __________________________");
		log.info("|                        |");
		log.info("|       THE BANK         |");
		log.info("|________________________|");
		System.out.println();
		System.out.println();
		log.info("1: Login\n2: Create Account\n3: Exit");
		int option = sc.nextInt();
		if(option == 1) {
			System.out.println();
			logIn();	
		} else if (option == 2) {
			createNewMember();				
		} else if (option == 3) {
			exitBank();
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
				Member newUser = new Member(newUserFirst, newUserLast, newUsername, newUserPassword1, newUserEmail);
				int newMember = md.addNewMember(newUser);
				if(newMember == 1) {
					log.info("How much would you like to deposit to your new account?");
					log.info("Amount: ");;
					double depAmount = sc.nextDouble();
					Account newUserAccount = new Account(newUser.accountNumber, "Checkings", depAmount);
					int newChecking = ad.addNewAccount(newUserAccount);
					if(newChecking == 1) {
						log.info("Checking account successfully created!");
						log.info("Your new account number is: " + newUser.accountNumber);
						System.out.println();
						log.info("Would you like to additionally open a Savings account? (Y/N)");
						String response = sc.next();
						if(response.equalsIgnoreCase("Y")){
							log.info("How much would you like to deposit to your new account?");
							log.info("Amount");
							depAmount = sc.nextDouble();
							Account newUserSavings = new Account(newUser.accountNumber, "Savings", depAmount);
							int newSavings = ad.addNewAccount(newUserSavings);
							if(newSavings == 1) {
								log.info("Savings account successfully created!");
								transactions(newUser.accountNumber);
							}
						} else {
							transactions(newUser.accountNumber);			
						}
					}		
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
		System.out.println();
		log.info("\n1: View Balance\n2: Make Deposit\n3: Make Withdrawal\n4: Add New Account\n5: Log Out\n6: Exit");
		int option = sc.nextInt();
		while (option != 5) {
			if(option == 2) {
				System.out.println();
				// show the balance of each account
				log.info("Checkings: $" + checkings.accountBalance);
				log.info("Savings: $" + savings.accountBalance);	
				System.out.println();
				// get deposit amount
				log.info("Deposit Amount: ");
				double amount = sc.nextDouble();
				log.info("Deposit from 1: Checking or 2: Savings?");
				int accountChoice = sc.nextInt();
				if(accountChoice == 1) {	
					log.info("Are you sure you would like to deposit $" + amount +" from Checkings (Y/N)?");
					String confirm = sc.next();
					if(confirm.equalsIgnoreCase("Y")) {
						ad.makeDeposit(checkings.accountNumber, "Checkings", amount);
						log.info("You deposited $" + amount + " to Checkings");
					} else {
						transactions(checkings.accountNumber);
					}
					log.info("Would you like another transaction? (Y/N)");
					String answer = sc.next();
					if(answer.equalsIgnoreCase("Y")) {
						transactions(checkings.accountNumber);
					} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
						log.error("Invalid Input! Please select a valid option: (Y/N)");
						answer = sc.next();
					} else if (answer.equalsIgnoreCase("N")) {
						logOut();
					}
				} else if (accountChoice == 2) {
					log.info("Are you sure you would like to deposit $" + amount + " to Savings?");
					String confirm= sc.next();
					if(confirm.equalsIgnoreCase("Y")) {
						ad.makeWithdrawal(savings.accountNumber, "Savings", amount);
						log.info("You deposited $" + amount + " to Savings");
					} else {
						transactions(savings.accountNumber);
					}
					log.info("Would you like another transaction? (Y/N)");
					String answer = sc.next();
					if(answer.equalsIgnoreCase("Y")) {
						transactions(savings.accountNumber);
					} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
						log.error("Invalid Input! Please select a valid option: (Y/N)");
						answer = sc.next();
					} else if (answer.equalsIgnoreCase("N")) {
						logOut();
					}
				}
			} else if(option == 3) {
				System.out.println();
				log.info("Checkings: $" + checkings.accountBalance);
				log.info("Savings: $" + savings.accountBalance);
				System.out.println();
				log.info("Withdrawal Amount: ");
				double amount = sc.nextDouble();
				log.info("Wthdraw from 1: Checking or 2: Savings?");
				int accountChoice = sc.nextInt();
				if(accountChoice == 1) {	
					log.info("Are you sure you would like to withdraw $" + amount +" from Checkings (Y/N)?");
					String confirm = sc.next();
					if(confirm.equalsIgnoreCase("Y")) {
						ad.makeWithdrawal(checkings.accountNumber, "Checkings", amount);
						log.info("You withdrew $" + amount + " from Checkings");
					} else {
						transactions(checkings.accountNumber);
					}
					log.info("Would you like another transaction? (Y/N)");
					String answer = sc.next();
					if(answer.equalsIgnoreCase("Y")) {
						transactions(checkings.accountNumber);
					} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
						log.error("Invalid Input! Please select a valid option: (Y/N)");
						answer = sc.next();
					} else if (answer.equalsIgnoreCase("N")) {
						logOut();
					}
				} else if (accountChoice == 2) {
					log.info("Are you sure you would like to withdraw $" + amount +" from Savings?");
					String confirm= sc.next();
					if(confirm.equalsIgnoreCase("Y")) {
						ad.makeWithdrawal(savings.accountNumber, "Savings", amount);
						log.info("You withdrew $" + amount + "from Savings");
					} else {
						transactions(savings.accountNumber);
					}
					log.info("Would you like another transaction? (Y/N)");
					String answer = sc.next();
					if(answer.equalsIgnoreCase("Y")) {
						transactions(savings.accountNumber);
					} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
						log.error("Invalid Input! Please select a valid option: (Y/N)");
						answer = sc.next();
					} else if (answer.equalsIgnoreCase("N")) {
						logOut();
					}
				}
			} else if (option == 1){
				log.info("View balance from 1: Checking or 2: Savings?");
				int accountChoice = sc.nextInt();
				if(accountChoice == 1) {
					log.info("Checking: $" + checkings.accountBalance);
					log.info("Would you like another transaction? (Y/N)");
					String answer = sc.next();
					if(answer.equalsIgnoreCase("Y")) {
						transactions(checkings.accountNumber);
					} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
						log.error("Invalid Input! Please select a valid option: (Y/N)");
						answer = sc.next();
					} else if(answer.equalsIgnoreCase("N")) {
						logOut();
					}
				} else if (accountChoice == 2) {
					log.info("Savings: $" + savings.accountBalance);
					log.info("Would you like another transaction? (Y/N)");
					String answer = sc.next();
					if(answer.equalsIgnoreCase("Y")) {
						transactions(savings.accountNumber);
					} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
						log.error("Invalid Input! Please select a valid option: (Y/N)");
						answer = sc.next();
					} else if(answer.equalsIgnoreCase("N")) {
						logOut();
					}
				}
			} else if(option == 4) {
				log.info("1: Checkings or 2: Savings?");
				int answer = sc.nextInt();
				if(answer == 1) {
					log.info("Deposit amount: ");
					double amount = sc.nextDouble();
					Account newCheckings = new Account(m.accountNumber, "Checkings", amount);
					int addAccount = ad.addNewAccount(newCheckings);
					if(addAccount == 1) {
						log.info("New Checkings Account Created!");
						transactions(m.accountNumber);
					}
				} else if (answer == 2) {
					log.info("Deposit amount: ");
					double amount = sc.nextDouble();
					Account newSavings = new Account(m.accountNumber, "Savings", amount);
					int addAccount = ad.addNewAccount(newSavings);
					if(addAccount == 1) {
						log.info("New Savings Account Created!");
						transactions(m.accountNumber);
					}
				}
			} else if(option == 6) {
				log.info("Are you sure you want to exit? (Y/N");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("Y")) {
					exitBank();
				} else if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
					log.error("Invalid Input! Please select a valid option: (Y/N)");
					answer = sc.next();
				} else if(answer.equalsIgnoreCase("N")) {
					transactions(m.accountNumber);
				}	
			}else {
				log.error("Please select a valid option!");
				transactions(m.accountNumber);					
			}
		}
		if (option == 5) {
			logOut();
		}
	}

	private static void exitBank() {
		System.exit(0);	
	}

	// log out method
	public static void logOut() {
		System.out.println();
		homeScreen();		
	}
	
	
	
	
	public static double makeDeposit(double balance, double depositAmount) {
		double newBalance = balance + depositAmount;
		return newBalance;
	}
	
	public static double makeWithdrawal(double balance, double withdrawalAmount) {
		double newBalance = balance - withdrawalAmount;
		return newBalance;
	}
		
}
