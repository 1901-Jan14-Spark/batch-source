package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class BankLogic {
	static Logger log = Logger.getRootLogger();
	
	static String path = "src/com/revature/bank/users.txt";
	
	static Scanner input = new Scanner(System.in); 

	public static void bank() {
		
		String choice;
		
		log.info("~~~~Welcome to Hassan's Bank~~~~");
		log.info("| 1. Login");
		log.info("| 2. Register");
		log.info("| 3. Quit");
		
		
			choice = input.next();
			try {
				while(!(choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
					log.info("Try again...");
					choice = input.next();
				}
			} catch(InputMismatchException e) {
				e.printStackTrace();
			}
		
			if(choice.equals("1")) {
				login();
			} else if (choice.equals("2")) {
				register();
			} else {
				System.exit(0);
			}
		
	}
	
	public static void login() {
		
		System.out.print("E-mail: ");
		String email = input.next();
		System.out.print("Password: ");
		String password  = input.next();
		
		if(Handler.userExists(email) && Handler.isPass(password)) {
				userAccount(email);
		} else {
			log.info("User does not exist");
			bank();
			
		}
						
	}
	
	public static void userAccount(String email) {
		log.info("~~~~~~~~~~~~~~~~~");
		log.info("Select an Action:\n1. Deposit\n2. Withdraw \n3. Balance \n4. Logout");
		String choice;
		
		choice = input.next();
		
		try {
			while(!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4"))) {
				log.info("Try again...");
				choice = input.next();
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		
		switch (choice) {
			case "1":
				deposit(email);
				break;
			case "2":
				withdraw(email);
				break;
			case "3":
				showBal(email);
				break;
			case "4":
				log.info("Logging off...");
				bank();
			default:
				log.info("Invalid Input, try again.");
				userAccount(email);
		}	
				
	}
	
	public static void deposit(String email) {
		log.info("~~~~~DEPOSIT~~~~~");
		AccountDao ad = new AccountDaoImpl();
		String amount;
		double damount;
		String choice;
		
		log.info("Where would you like to deposit?");
		log.info("Checkings Balance: $"+ Handler.getCheckingsBal(email));
		log.info("Savings Balance: $"+ Handler.getSavingsBal(email));
		
		log.info("1. Checkings\n2. Savings");
		choice = input.next();
		
		if(choice.equals("1")) {
			log.info("How much would you like to deposit?");
			amount = input.next();
			while(!(amount.matches("^[0-9]+$"))) {
				log.info("Must be numbers");
				amount = input.next();
			}
			damount = Double.parseDouble(amount);
			double accBal = Handler.getCheckingsBal(email);
			accBal += damount;
			ad.updateAccountCheckings(email, accBal);
		} else if (choice.equals("2")) {
			log.info("How much would you like to deposit?");
			amount = input.next();
			while(!(amount.matches("^[0-9]+$"))) {
				log.info("Must be numbers");
				amount = input.next();
			}
			damount = Double.parseDouble(amount);
			ad.incAccountSavings(email, damount);
		}
		
		userAccount(email);
	}
	
	public static void withdraw(String email) {
		log.info("~~~~~WITHDRAW~~~~");
		AccountDao ad = new AccountDaoImpl();
		String amount;
		double damount;
		String choice;
		double check;
		
		log.info("Where would you like to withdraw?");
		log.info("Checkings Balance: $"+ Handler.getCheckingsBal(email));
		log.info("Savings Balance: $"+ Handler.getSavingsBal(email));
		
		log.info("1. Checkings\n2. Savings");
		choice = input.next();
		
		if(choice.equals("1")) {
			log.info("How much would you like to withdraw?");
			amount = input.next();
			while(!(amount.matches("^[0-9]+$"))) {
				log.info("Must be numbers");
				amount = input.next();
			}
			damount = Double.parseDouble(amount);
			double accBal = Handler.getCheckingsBal(email);
			check = accBal - damount;
			if(check <= 0) {
				log.info("Insufficient funds.");
			} else {
				ad.updateAccountCheckings(email, check);
			}	
		} else if (choice.equals("2")) {
			log.info("How much would you like to withdraw?");
			amount = input.next();
			while(!(amount.matches("^[0-9]+$"))) {
				log.info("Must be positive numbers");
				amount = input.next();
			}
			damount = Double.parseDouble(amount);
			double accBal = Handler.getSavingsBal(email);
			check = accBal - damount;
			if(check <= 0 ) {
				log.info("Insufficient funds.");
			} else {
				ad.decAccountSavings(email, damount);
			}
			
		}
		
		userAccount(email);
	}
	
	public static void showBal(String email) {
		log.info("~~~~~BALANCE~~~~~");
		log.info("Checkings:\n $"+ Handler.getCheckingsBal(email));
		log.info("Savings:\n $"+ Handler.getSavingsBal(email));
		userAccount(email);
	}
	
	public static void register() {
		log.info("~~~~~REGISTER~~~~");
		
		AccountDao ad = new AccountDaoImpl();
		UserDao ud = new UserDaoImpl();
		String password = "1";
		String password2= "2";
		String choice;
		int outcome = 0;
		int outcome2 = 0;
		
			log.info("Input First Name: ");
			String fname = input.next();
			log.info("Input Last Name: ");
			String lname = input.next();
			log.info("Input E-mail: ");
			String email = input.next();
			while(!password.equals(password2)) {
				log.info("Input Password");
				password = input.next();
				log.info("Confirm Password");
				password2 = input.next();
				if(!password.equals(password2)) {
					log.info("Passwords don't match, try again.");
				}
			}
			User newUser = new User(fname, lname, email, password);
			
			log.info("Input starting balance: ");
			double userBal = input.nextDouble();
			log.info("Checkings or Savings?\n1. Checkings\n2. Savings");
			choice = input.next();
			while(!(choice.equals("1") || choice.equals("2"))) {
				log.info("Invalid input, try again");
				choice = input.next();
			}
			if(choice.equals("1")) {
				outcome = ad.createAccount(newUser, new Account(newUser, userBal, 0));
				outcome2 = ud.createUser(newUser);
				
			} else if(choice.equals("2")){
				outcome = ad.createAccount(newUser, new Account(newUser, userBal, 0));
				outcome2 = ud.createUser(newUser);
			}
			
			if(outcome == 1 && outcome2 == 2) {
			log.info("User has been added. Please login");
			}
			bank();
	}
}
