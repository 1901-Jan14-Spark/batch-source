package com.revature.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.BankingAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.model.BankingAccount;
import com.revature.model.User;

public class BankingDriver {
	static Scanner scanner = new Scanner(System.in);
	public final static Logger log = Logger.getRootLogger();
	
	
	public static  void main(String[] args) {
		log.info("Welcome to Daniel Bogar's Banking Application.");
		log.info("----------------------------------------------------");
		log.info("You May Logout at Anytime by Entering (X)");
		Start();
	}
	
	public static void Start() {
		log.info("----------------------------------------------------");
		log.info("Enter (C) to Create a New Account, or (L) to Login");
		log.info("----------------------------------------------------");
		String input = scanner.nextLine().toLowerCase();
		if(input.equals("l")) {
			Login();
		}
		else if(input.equals("c")) {
			Create();
		}
		else if(input.equals("x")) {
			log.info("Cannot Logout as No User is Currently Logged In");
			Start();
		}
		else {
			log.error("Incorrect Input, Please Enter in One of the Given Characters");
			Start();
		}
	}
	
	public static void Create() {
		log.info("Create a New UserName!");
		log.info("----------------------------------------------------");
		log.info("Username should be between 8 to 16 characters and include alphanumeric values (a-z, 0-9)");
		log.info("Should Not Include Spaces, or Special Characters besides - ");
		log.info("----------------------------------------------------");
		log.info("Username: ");
		String userName = scanner.nextLine().toLowerCase();
		if(userName.contentEquals("x")) {
			Logout();
		}
		else if(userName.length()< 8 || userName.length() > 16) {
			
		}
		log.info("Create a New Password!");
		log.info("----------------------------------------------------");
		log.info("Password should be between 8 to 16 characters and include alphanumeric values (a-z, 0-9)");
		log.info("Should Not Include Spaces, or Special Characters besides - ");
		log.info("----------------------------------------------------");
		log.info("Password: ");
		log.info("----------------------------------------------------");
		
		String password = scanner.nextLine().toLowerCase();
		if(password.contentEquals("x")) {
			Logout();
		}
		else if(password.length()< 8 || password.length() > 16) {
			log.error("Password Length Not Within Constraints");
			log.info("----------------------------------------------------");
		};
		
		//Will Validate that a account with the name does not exist
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> userList = userDao.getUsers();
		boolean matches = false;
		int listSize = 0;
		for(User u:userList) {
			listSize ++;
			if(u.getUserName().equals(userName)) {
				matches = true;
			}
		}
		if(matches == false) {
			log.info("Credentials have been approved!");
			double balance = EnterBalance();
			BankingAccount newbankAccount = new BankingAccount(listSize+1, "Checking" , balance);
			User u = new User(listSize + 1, userName, password, newbankAccount);
			userDao.createUser(u);
			log.info("----------------------------------------------------");
			log.info("Account Created!");
			Start();
		}
		else {
			log.error("There is Already a User with that Account, Please enter a different Account");
			log.info("----------------------------------------------------");
			Create();
		}
	}
	
	public static void Login() {
		log.info("Enter in Your Account Username: ");
		log.info("----------------------------------------------------");
		String userName = scanner.nextLine().toLowerCase();
		if(userName.contentEquals("x")) {
			Logout();
		}
		log.info("Enter in Your Account Password");
		log.info("----------------------------------------------------");
		String password = scanner.nextLine().toLowerCase();
		if(password.contentEquals("x")) {
			Logout();
		}
		//Account Verification Step - will check to see if a user with account and password exist
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> userList = userDao.getUsers();
		User currentUser = null;
		boolean matches = false;
		for(User u:userList) {
			if(u.getUserName().equals(userName) && u.getPassword().equals(password)) {
				matches = true;
				currentUser = u;
			}
		}
		if(matches == false) {
			log.error("Invalid Username or Password");
			log.info("----------------------------------------------------");
			Login();
		}
		//
		Navigation(currentUser);
	}
	
	public static void Logout() {
		log.info("You Have Successfully Logged Out");
		Start();
	}
	
	public static void Navigation(User currentUser) {
		log.info("Account Navigation:");
		log.info("----------------------------------------------------");
		log.info("Enter (D) to Deposit, (W) to Withdraw, (B) to View Balance, and (X) to Logout.");
		log.info("----------------------------------------------------");
		

		String navInput = scanner.nextLine().toLowerCase();
		if(navInput.equals("d")) {
			Deposit(currentUser);
			Navigation(currentUser);
		}
		else if(navInput.equals("w")) {
			Withdraw(currentUser);
			Navigation(currentUser);
		}
		else if(navInput.equals("b")) {
			Balance(currentUser);
			Navigation(currentUser);
		}
		else if(navInput.equals("x")) {
			Logout();
		}
		else {
			log.error("Invalid Input Please Enter a Character Given Below.");
			log.info("----------------------------------------------------");
			Navigation(currentUser);
		}
	}
	
	public static void Deposit(User currentUser) {
		log.info("Enter in a Value to Deposit: ");
		log.info("----------------------------------------------------");
		double amount = EnterAmount();
		BankingAccountDaoImpl bad = new BankingAccountDaoImpl();
		bad.changeAccountBalance(currentUser.getAccount(), amount);
	}
	
	public static void Withdraw(User currentUser){
		log.info("Enter in a Value to Withdraw: ");
		log.info("----------------------------------------------------");
		double amount = EnterAmount();
		BankingAccountDaoImpl bad = new BankingAccountDaoImpl();
		double balance = currentUser.getAccount().getBalance();
		if(amount - balance < 0) {
			log.error("Withdraw Error, Cannot Withdraw More than the Balance of the Account");
			log.info("----------------------------------------------------");
			Withdraw(currentUser);
		}
		else {
			bad.changeAccountBalance(currentUser.getAccount(), amount);
		}
		
		
	}
	
	public static void Balance(User currentUser) {
		log.info("Current Balance Is: ");
		log.info("----------------------------------------------------");
	}
	
	public static double EnterBalance() {
		log.info("----------------------------------------------------");
		log.info("Enter in the New Account Balance to Finalize Account: ");
		log.info("----------------------------------------------------");
		String input = scanner.nextLine().toLowerCase();
		if(input.equals("x")) {
			Logout();
		}
		double balance = (double) Integer.parseInt(input);
		if(balance >= 0) {
			log.info("New Balance for the Account is: " + balance);
			log.info("----------------------------------------------------");
		}
		else if(balance < 0) {
			log.error("Please Enter a Non-Negative Number.");
			EnterBalance();
		}
		return balance;
		
	}
	
	public static double EnterAmount() {
		String input = scanner.nextLine().toLowerCase();
		if(input.equals("x")) {
			Logout();
		}
		double amount = (double) Integer.parseInt(input);
		if(amount < 0) {
			log.error("Please Enter a Non-Negative Number.");
			log.info("----------------------------------------------------");
			EnterBalance();
		}
		return amount;
		
	}
}
