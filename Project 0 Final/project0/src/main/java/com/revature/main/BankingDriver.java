package com.revature.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.BankingAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.model.BankingAccount;
import com.revature.model.User;


//The Main Driver of the Banking Appilcation
public class BankingDriver {
	static Scanner scanner = new Scanner(System.in);
	public final static Logger log = Logger.getRootLogger();
	
	
	public static  void main(String[] args) {
		log.info("Welcome to Daniel Bogar's Banking Application.");
		log.info("----------------------------------------------------");
		log.info("You May Logout at Anytime by Entering (X)");
		Start();
	}
	//The Start method will ask for user input and redirect them to either account creation or user login
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
	//Create will access the user dao and bankaccount dao to create a new user with the given username and password
	public static void Create() {
		log.info("Create a New UserName!");
		log.info("----------------------------------------------------");
		log.info("Username should be between 8 to 16 characters and include alphanumeric values (a-z, 0-9)");
		log.info("Should Not Include Spaces as Well (Enter X to logout)");
		log.info("----------------------------------------------------");
		log.info("Username: ");
		//Scan in for username and check validation in the given constraints
		String userName = scanner.nextLine();
		if(userName.toLowerCase().equals("x")) {
			Logout();
		}
		else if(userName.length()< 8 || userName.length() > 16 || userName.matches("^[a-zA-Z0-9]*$") == false){
			log.error("Invalid Username Input Please Read the Criteria Below to Input a Correct Username and Password");
			log.info("----------------------------------------------------");
			Create();
		}
		log.info("Create a New Password!");
		log.info("----------------------------------------------------");
		log.info("Password should be between 8 to 16 characters and include alphanumeric values (a-z, 0-9)");
		log.info("Should Not Include Spaces as Well (Enter X to logout)");
		log.info("----------------------------------------------------");
		log.info("Password: ");
		log.info("----------------------------------------------------");
		//Scans the user for a password input and checks validation in the given constraints
		String password = scanner.nextLine();
		if(password.toLowerCase().equals("x")) {
			Logout();
		}
		else if(password.length()< 8 || password.length() > 16 || userName.matches("^[a-zA-Z0-9]*$") == false) {
			log.error("Invalid Password Input Please Read the Criteria Below to Input a Correct Username and Password");
			log.info("----------------------------------------------------");
			Create();
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
		//if there are no currrent matches in the list of accounts then using the provided inputs the new account will be created
		if(matches == false) {
			log.info("Credentials have been approved!");
			double balance = EnterBalance();
			BankingAccount newbankAccount = new BankingAccount(listSize+1, "Checking" , balance);
			User u = new User(listSize + 1 , userName, password, newbankAccount);
			log.info(u.getAccount().getAccountId());
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
	//When an account has already been created a user will log in here with there username and password
	//if an account does not exist the user will not be allowed to login
	public static void Login() {
		log.info("Enter in Your Account Username: ");
		log.info("----------------------------------------------------");
		String userName = scanner.nextLine();
		if(userName.toLowerCase().equals("x")) {
			Logout();
		}
		log.info("Enter in Your Account Password");
		log.info("----------------------------------------------------");
		String password = scanner.nextLine();
		if(password.toLowerCase().equals("x")) {
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
		else {
			log.info("");
		}
		//
		Navigation(currentUser);
	}
	//the method that will activate when entering X or -1 at scanner inputs and will log the user out to the create/login prompt
	public static void Logout() {
		log.info("You Have Successfully Logged Out");
		Start();
	}
	//Navigation method to allow for easier traversal through the application
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
	//Will ask for a positive number to change the bank account balance associated to the user account
	public static void Deposit(User currentUser) {
		log.info("Enter in a Value to Deposit: ");
		log.info("----------------------------------------------------");
		double amount = EnterAmount();
		BankingAccountDaoImpl bad = new BankingAccountDaoImpl();
		bad.changeAccountBalance(currentUser.getAccount().getAccountId(), amount);
		double balance = currentUser.getAccount().getBalance();
		currentUser.getAccount().setBalance(balance + amount);
		Navigation(currentUser);
	}
	//Will ask for a positive number that is not greater than the current balance, and change the bank account accordingly
	public static void Withdraw(User currentUser){
		log.info("Enter in a Value to Withdraw: ");
		log.info("----------------------------------------------------");
		double amount = EnterAmount();
		BankingAccountDaoImpl bad = new BankingAccountDaoImpl();
		double balance = currentUser.getAccount().getBalance();
		if(balance - amount < 0) {
			log.error("Withdraw Error, Cannot Withdraw More than the Balance of the Account");
			log.info("----------------------------------------------------");
			Withdraw(currentUser);
		}
		else {
			amount *= -1;
			bad.changeAccountBalance(currentUser.getAccount().getAccountId(), amount);
			currentUser.getAccount().setBalance(balance + amount);
			Navigation(currentUser);
		}
		
		
	}
	//Return the balance of the currently logged in user
	public static void Balance(User currentUser) {
		double balance = currentUser.getAccount().getBalance();
		log.info("Current Balance Is: $" + balance);
		log.info("----------------------------------------------------");
		
	}
	//method called when creating a new account to enter in the starting balance of the account
	public static double EnterBalance() {
		log.info("----------------------------------------------------");
		log.info("Enter in the New Account Balance to Finalize Account: (or (-1) to Logout)");
		log.info("----------------------------------------------------");
		double balance = 0;
		try{double input = scanner.nextDouble();
			scanner.nextLine();
			if(input == -1) {
				Logout();
			}
			balance = input;
			if(balance >= 0) {
				log.info("New Balance for the Account is: " + balance);
				log.info("----------------------------------------------------");
			}
			else if(balance < 0) {
				log.error("Please Enter a Non-Negative Number.");
				EnterBalance();
			}
		
		}catch(InputMismatchException e){
			log.error("There was not a Valid input, please enter a Number");
			scanner.nextLine();
			log.info("----------------------------------------------------");
			EnterBalance();
		}
		return balance;
		
	}
	//Method used by the Deposit and Withdraw methods to scan in user input and check if the input is valid
	public static double EnterAmount() {
		double input = 0;
		try{input = scanner.nextDouble();
			scanner.nextLine();
			if(input < 0) {
				log.error("Please Enter a Non-Negative Number.");
				log.info("----------------------------------------------------");
				EnterAmount();
			}
		}catch(InputMismatchException e) {
			log.error("There was not a Valid input, please enter a Number");
			scanner.nextLine();
			log.info("----------------------------------------------------");
			
			EnterAmount();
		}
		return input;
		
	}
}
