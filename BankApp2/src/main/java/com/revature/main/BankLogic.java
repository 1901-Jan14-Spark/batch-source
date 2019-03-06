package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Account;
import com.revature.models.User;

public class BankLogic {
	
	static String path = "src/com/revature/bank/users.txt";
	
	static Scanner input = new Scanner(System.in); 

	public static void bank() {
		
		int choice = 0;
		
		System.out.println("~~~~Welcome to Hassan's Bank~~~~");
		System.out.println("| 1. Login");
		System.out.println("| 2. Register");
		System.out.println("| 3. Quit");
		
		
			choice = input.nextInt();
			try {
				while(choice != 1 && choice != 2 && choice != 3 ) {
					System.out.println("Try again...");
					choice = input.nextInt();
				}
			} catch(InputMismatchException e) {
				e.printStackTrace();
			}
		
			if(choice == 1) {
				login();
			} else if (choice == 2) {
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
			System.out.println("User does not exist");
			bank();
			
		}
						
	}
	
	public static void userAccount(String email) {
		System.out.println("~~~~~~~~~~~~~~~~~");
		System.out.println("Select an Action:\n1. Deposit\n2. Withdraw \n3. Balance \n4. Logout");
		int choice = 0;
		try {
			choice = input.nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		switch (choice) {
			case 1:
				deposit(email);
				break;
			case 2:
				withdraw(email);
				break;
			case 3:
				showBal(email);
				break;
			case 4:
				System.out.println("Logging off...");
				bank();
			default:
				System.out.println("Invalid Input, try again.");
				userAccount(email);
		}
			
				
	}
	
	public static void deposit(String email) {
		System.out.println("~~~~~DEPOSIT~~~~~");
		AccountDao ad = new AccountDaoImpl();
		String amount;
		double damount;
		String choice;
		
		System.out.println("Where would you like to deposit?");
		System.out.println("Checkings Balance: $"+ Handler.getCheckingsBal(email));
		System.out.println("Savings Balance: $"+ Handler.getSavingsBal(email));
		
		System.out.println("1. Checkings\n2. Savings");
		choice = input.next();
		
		if(choice.equals("1")) {
			System.out.println("How much would you like to deposit?");
			amount = input.next();
			while(!(amount.matches("^[0-9]+$"))) {
				System.out.println("Must be numbers");
				amount = input.next();
			}
			damount = Double.parseDouble(amount);
			double accBal = Handler.getCheckingsBal(email);
			accBal += damount;
			ad.updateAccountCheckings(email, accBal);
		} else if (choice.equals("2")) {
			System.out.println("How much would you like to deposit?");
			amount = input.next();
			while(!(amount.matches("^[0-9]+$"))) {
				System.out.println("Must be numbers");
				amount = input.next();
			}
			damount = Double.parseDouble(amount);
			ad.incAccountSavings(email, damount);
		}
		
		userAccount(email);
	}
	
	public static void withdraw(String email) {
		System.out.println("~~~~~WITHDRAW~~~~");
		AccountDao ad = new AccountDaoImpl();
		String amount;
		double damount;
		String choice;
		double check;
		
		System.out.println("Where would you like to withdraw?");
		System.out.println("Checkings Balance: $"+ Handler.getCheckingsBal(email));
		System.out.println("Savings Balance: $"+ Handler.getSavingsBal(email));
		
		System.out.println("1. Checkings\n2. Savings");
		choice = input.next();
		
		if(choice.equals("1")) {
			System.out.println("How much would you like to withdraw?");
			amount = input.next();
			while(!(amount.matches("^[0-9]+$"))) {
				System.out.println("Must be numbers");
				amount = input.next();
			}
			damount = Double.parseDouble(amount);
			double accBal = Handler.getCheckingsBal(email);
			check = accBal - damount;
			if(check <= 0) {
				System.out.println("Insufficient funds.");
			} else {
				ad.updateAccountCheckings(email, check);
			}	
		} else if (choice.equals("2")) {
			System.out.println("How much would you like to withdraw?");
			amount = input.next();
			while(!(amount.matches("^[0-9]+$"))) {
				System.out.println("Must be numbers");
				amount = input.next();
			}
			damount = Double.parseDouble(amount);
			double accBal = Handler.getSavingsBal(email);
			check = accBal - damount;
			if(check <= 0 ) {
				System.out.println("Insufficient funds.");
			} else {
				ad.decAccountSavings(email, damount);
			}
			
		}
		
		userAccount(email);
	}
	
	public static void showBal(String email) {
		System.out.println("~~~~~BALANCE~~~~~");
		System.out.println("Checkings:\n $"+ Handler.getCheckingsBal(email));
		System.out.println("Savings:\n $"+ Handler.getSavingsBal(email));
		userAccount(email);
	}
	
	public static void register() {
		System.out.println("~~~~~REGISTER~~~~");
		
		AccountDao ad = new AccountDaoImpl();
		UserDao ud = new UserDaoImpl();
		String password = "1";
		String password2= "2";
		String choice;
		int outcome = 0;
		int outcome2 = 0;
		
			System.out.println("Input First Name: ");
			String fname = input.next();
			System.out.println("Input Last Name: ");
			String lname = input.next();
			System.out.println("Input E-mail: ");
			String email = input.next();
			while(!password.equals(password2)) {
				System.out.println("Input Password");
				password = input.next();
				System.out.println("Confirm Password");
				password2 = input.next();
				if(!password.equals(password2)) {
					System.out.println("Passwords don't match, try again.");
				}
			}
			User newUser = new User(fname, lname, email, password);
			
			System.out.println("Input starting balance: ");
			double userBal = input.nextDouble();
			System.out.println("Checkings or Savings?\n1. Checkins\n2. Savings");
			choice = input.next();
			while(!(choice.equals("1") || choice.equals("2"))) {
				System.out.println("Invalid input, try again");
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
			System.out.println("User has been added. Please login");
			}
			bank();
	}
}
