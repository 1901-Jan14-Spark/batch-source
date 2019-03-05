package com.revature.bankapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.models.User;
import com.revature.exceptions.OverdraftException;
import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.AccountDaoImpl;
import com.revature.bankapp.dao.UserDao;
import com.revature.bankapp.dao.UserDaoImpl;
import com.revature.bankapp.models.Account;
import com.revature.bankapp.models.AccountManager;
import org.apache.log4j.Logger;

public class BankImpl implements ReadWriteManager{
	
	static BankImpl bank = new BankImpl();
	static Scanner userInput = new Scanner(System.in);
	static String userFilePath = "src/main/java/com/revature/bankapp/users.txt";
	static UserDao userDao = new UserDaoImpl();
	static AccountDao accDao = new AccountDaoImpl();
	static User newUser = new User();
	
	public static void appStart()
	{
		System.out.println("Welcome to the revBanking app! Please input a number 1-3 to begin.");
		System.out.println("[1] -- Login");
		System.out.println("[2] -- Create an account");
		System.out.println("[3] -- Admin access");
		System.out.println("[4] -- Quit");
		String menuSelect = userInput.next();
		try {
			if(Integer.parseInt(menuSelect) <= 0 || Integer.parseInt(menuSelect) > 3) {
				appStart();
			}
			if(Integer.parseInt(menuSelect) == 1) {
				userLogin();
			}
			if(Integer.parseInt(menuSelect) == 2) {
				createAccount(newUser);
			}
			if(Integer.parseInt(menuSelect) == 3) {
				adminAccess();
			}
			if(Integer.parseInt(menuSelect) == 4) {
				System.out.println("Goodbye. Thank you for using revBanking.");
				System.exit(0);
			}
			if (menuSelect.matches("[^1-4]") ){
				throw new NumberFormatException();
			}
		}  catch (NumberFormatException e) {
			appStart();
		}
	}
	
	private static void userLogin() {
		User testLogin = new User();
		System.out.println("Welcome to the login page! Please input your username.");
		String enteredUsername = userInput.next();
		System.out.println("Please input your password:");
		String enteredPassword = userInput.next();
		testLogin = userDao.verifyUser(enteredUsername);
		System.out.println(testLogin);
		try {
			if(testLogin.getUsername().matches(enteredUsername) && testLogin.getPassword().matches(enteredPassword)){
				int loggedInAccId = testLogin.getUserId();
				bankRun(loggedInAccId);
			} else {
				System.out.println("You have entered an incorrect username or password. Please try again.");
				userLogin();
			}
		} catch(NullPointerException e) {
			System.out.println("You have entered an incorrect username or password. Please try again.");
			userLogin();
		}	
	}
	
	public static void adminAccess() {
		System.out.println("Welcome back admin! If you wish to view all the current accounts press 1. If you wish to return to the menu enter 'Menu'.");
		String option = userInput.next();
		if(option.toLowerCase().matches("menu")) {
			appStart();
		}
		if(Integer.parseInt(option) == 1) {
			List<User> ourList = new ArrayList<User>();
			UserDao userDao = new UserDaoImpl();
			ourList = userDao.fetchAccount();
			for(User user : ourList) {
				System.out.println(user);
			}
			System.out.println();
			System.out.println();
			adminAccess();
		}
	}

	public static void createAccount(User newUser) 
	{
		try 
		{
			System.out.println("Since this is the first time using our app, you will have to create your account. We'll have you set up in a few quick steps."); 
			System.out.println("Please enter your name below.");
			newUser.setName(userInput.next());
			if(newUser.getName() == null) {
				System.out.println("You have input an invalid entry for name. Please try again.");
				createAccount(newUser);
			} else {
				do 	{
					System.out.println("Hi "+newUser.getName()+"! Please choose your username.");
					System.out.println("Your username must contain a letter and must contain 4-12 characters. No symbols are allowed.");
					newUser.setUsername(userInput.next());
				} while (newUser.getUsername() == null);
					do {
						System.out.println("Awesome choice, "+newUser.getUsername()+"! Please also provide your e-mail and password!");
						System.out.println("Remember, your e-mail must contain an @ symbol and must end with a .com!");
						System.out.println("E-Mail: ");
						newUser.setEmail(userInput.next());
					} while (newUser.getEmail() == null);
					do {
						System.out.println("E-mail input accepted. Please provide a password that is between 4-10 characters long and contains at least one numeric digit.");
						System.out.println("Password: ");
						newUser.setPassword(userInput.next());
					}	while (newUser.getPassword() == null);
					System.out.println("Please input your starting balance. You must start with a balance greater than 0.");
					newUser.setBalance(userInput.nextBigDecimal());
					Account newAcc = new Account(newUser.getBalance());
					System.out.println("Your account was created! You are being returned to the homescreen. You may choose to log-in there.");
					System.out.println(newUser);
					int test2 = accDao.createAccount(newAcc);
					int test = userDao.createUser(newUser);
					System.out.println(test);
					System.out.println("Accounts created: "+test2);
					appStart();
			}	
		} catch (Exception e)
		{
			
		}
	}
	
	public static void returnHome() {
		System.out.println(">>>>>>> RETURNING TO ACCOUNT HOME <<<<<<<<");
	}
	
	public static void bankRun(int accountId) {
		User temp = userDao.getUserById(accountId);
		System.out.println(temp.getAccount().getAccountId());
		
		System.out.println("Welcome back "+temp.getUsername()+"! Your current balance is: $"+temp.getAccount().getBalance()+". How can revBanking serve you today?");
		System.out.println("[1] -- View account balance.");
		System.out.println("[2] -- Make a deposit.");
		System.out.println("[3] -- Make a withdrawal.");
		System.out.println("[4] -- Change my account information.");
		System.out.println("[5] -- Logout.");
		String theirChoice = userInput.next();
		if(!theirChoice.matches("[1-5]")) {
			System.out.println("Did you input the correct command? We can't process that request.");
			bankRun(temp.getAccount().getAccountId());
		}
		if(Integer.parseInt(theirChoice) == 1) {
			System.out.println("Your current account balance is $"+temp.getAccount().getBalance());
			returnHome();
			bankRun(temp.getAccount().getAccountId());
		}
		if(Integer.parseInt(theirChoice) == 2) {
			depositUI(temp.getAccount().getAccountId());
		}
		if(Integer.parseInt(theirChoice) == 3) {
			withdrawUI(temp.getAccount().getAccountId());
		}
		if(Integer.parseInt(theirChoice) == 4) {
			System.out.println("This feature is currently still being implemented.");
			returnHome();
			bankRun(temp.getAccount().getAccountId());
		}
		if(Integer.parseInt(theirChoice) == 5) {
			System.out.println("Are you sure you wish to log-out? You will have to log-back in if you wish you do. Enter 'Yes' to confirm logout. Press any other button and enter to keep working.");
			String logoutChoice = userInput.next();
			if (!logoutChoice.toLowerCase().equals("yes")) {
				System.out.println("You did not enter the correct command to logout.");
				returnHome();
				bankRun(temp.getAccount().getAccountId());
			}
			if (logoutChoice.toLowerCase().equals("yes")) {
				System.out.println("You are being logged out...... Thank you for choosing revBanking.");
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				appStart();
			}
		}
	}

	private static void depositUI(int accountId) {
		User temp = userDao.getUserById(accountId);
		System.out.println("Please enter how much you would like to deposit. Must be in $xx.xx format. You do not need to add the $ to your entry. To return to the menu at anytime, enter 'Menu'!");
		String entry = userInput.next();
		if (entry.toLowerCase().equals("menu"))
		{
			returnHome();
			bankRun(temp.getAccount().getAccountId());
		} 
		else 
		{
			try 
			{ 
				BigDecimal depositBD = new BigDecimal(entry);
				BigDecimal newBalance = AccountManager.addDeposit(temp.getAccount().getAccountId(), depositBD);
				int updateCount = accDao.updateAccount(newBalance, temp.getAccount().getAccountId());
				System.out.println(updateCount);
				System.out.println("Your deposit of $"+depositBD+" has been added. Your updated bank balance is: $"+newBalance);
				if (entry.matches("A-Za-z") && !entry.toLowerCase().equals("menu")){
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) 
				{
					System.out.println("Did you input the correct command? We can't process that request.");
					depositUI(accountId);
				}
		}
		returnHome();
		bankRun(temp.getAccount().getAccountId());
	}

		
	private static void withdrawUI(int accountId) {
		User temp = userDao.getUserById(accountId);
		System.out.println("Please enter how much you would like to withdraw. Must be in $xx.xx, you do not need to include the $ in your entry. To return to the menu at anytime, enter 'Menu'!");
		String entry = userInput.next();
		if (entry.toLowerCase().equals("menu"))
		{
			returnHome();
			bankRun(temp.getAccount().getAccountId());
		} 
		else 
		{
			try 
			{ 
				BigDecimal withdrawalAmount = new BigDecimal(entry);
				if (entry.matches("A-Za-z") && !entry.toLowerCase().equals("menu")) {
					throw new NumberFormatException();
				}
				BigDecimal newBalance = AccountManager.processWithdrawal(temp.getAccount().getAccountId(), withdrawalAmount);
				if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
					throw new OverdraftException();
				}
				int updateCount = accDao.updateAccount(newBalance, temp.getAccount().getAccountId());
				System.out.println(updateCount);
				System.out.println("Your withdrawal of $"+withdrawalAmount+" has been processed. Your updated bank balance is: $"+newBalance);
			} catch (NumberFormatException e) 
				{
					System.out.println("Did you input the correct command? We can't process that request.");
					withdrawUI(temp.getAccount().getAccountId());
				}
				catch (OverdraftException e) {
			}
		}
		returnHome();
		bankRun(temp.getAccount().getAccountId());
	}

}

