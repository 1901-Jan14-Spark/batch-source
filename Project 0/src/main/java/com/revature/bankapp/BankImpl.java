package com.revature.bankapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.bankapp.models.User;
import com.revature.exceptions.OverdraftException;
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

	public static void appStart()
	{
		System.out.println("Welcome to the revBanking app! Please input a number 1-3 to begin.");
		System.out.println("[1] -- Login");
		System.out.println("[2] -- Create an account");
		System.out.println("[3] -- Quit");
		String menuSelect = userInput.next();
		try {
			if(Integer.parseInt(menuSelect) <= 0 || Integer.parseInt(menuSelect) > 3) {
				appStart();
			}
			if(Integer.parseInt(menuSelect) == 1) {
				userLogin();
			}
			if(Integer.parseInt(menuSelect) == 2) {
				createAccount();
			}
			if(Integer.parseInt(menuSelect) == 3) {
				System.out.println("Goodbye. Thank you for using revBanking.");
				System.exit(0);
			}
			if (menuSelect.matches("[^1-3]") ){
				throw new NumberFormatException();
			}
		}  catch (NumberFormatException e) {
			appStart();
		}
	}
	
	private static void userLogin() {
		System.out.println("Welcome to the login page! Please input your username.");
		String enteredUsername = userInput.next();
		String[] userArr = bank.readUser();
		if(enteredUsername.equals(userArr[1])) {
			System.out.println("Hello, "+enteredUsername+" -- Please enter your password.");
			String enteredPassword = userInput.next();
			if(enteredPassword.equals(userArr[3])) {
				bankRun();
			} else {
				System.out.println("You have entered an incorrect password. Please try again.");
				userLogin();
			}
		} else {
			System.out.println("This username does not match any existing username in our database. Please try again.");
			userLogin();
		}
		
		
	}

	public static void createAccount() 
	{
		try 
		{
			User newUser = new User();
			System.out.println("Since this is the first time using our app, you will have to create your account. We'll have you set up in a few quick steps."); 
			System.out.println("Please enter your name below.");
			newUser.setName(userInput.next());
			if(newUser.getName() == null) {
				System.out.println("You have input an invalid entry for name. Please try again.");
				createAccount();
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
					newUser.writeUser(newUser.getName(), newUser.getUsername(), newUser.getEmail(), newUser.getPassword(), newAcc);
					int test = userDao.createUser(newUser);
					System.out.println(test);
//					System.out.println(newUser.getAccountId());
//					System.out.println(newAcc.getAccountId());
					appStart();
			}	
		} catch (Exception e)
		{
			
		}
	}
	
	public static void returnHome() {
		System.out.println(">>>>>>> RETURNING TO ACCOUNT HOME <<<<<<<<");
	}
	
	public static void bankRun() {
		String[] loggedInArr = bank.readUser();
		String currentUser = loggedInArr[1];
		System.out.println("Welcome back "+currentUser+"! How can revBanking serve you today?");
		System.out.println("[1] -- View account balance.");
		System.out.println("[2] -- Make a deposit.");
		System.out.println("[3] -- Make a withdrawal.");
		System.out.println("[4] -- Change my account information.");
		System.out.println("[5] -- Logout.");
		String theirChoice = userInput.next();
		if(!theirChoice.matches("[1-5]")) {
			System.out.println("Did you input the correct command? We can't process that request.");
			bankRun();
		}
		if(Integer.parseInt(theirChoice) == 1) {
			System.out.println("Your current account balance is $"+loggedInArr[4]);
			returnHome();
			bankRun();
		}
		if(Integer.parseInt(theirChoice) == 2) {
//			depositUI();
		}
		if(Integer.parseInt(theirChoice) == 3) {
//			withdrawUI();
		}
		if(Integer.parseInt(theirChoice) == 4) {
			System.out.println("This feature is currently still being implemented.");
			returnHome();
			bankRun();
		}
		if(Integer.parseInt(theirChoice) == 5) {
			System.out.println("Are you sure you wish to log-out? You will have to log-back in if you wish you do. Enter 'Yes' to confirm logout. Press any other button and enter to keep working.");
			String logoutChoice = userInput.next();
			if (!logoutChoice.toLowerCase().equals("yes")) {
				System.out.println("You did not enter the correct command to logout.");
				returnHome();
				bankRun();
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

//	private static void depositUI() 
//	{{
//		String[] loggedInArr = bank.readUser();
//		System.out.println("Please enter how much you would like to deposit. Must be in $xx.xx format. You do not need to add the $ to your entry. To return to the menu at anytime, enter 'Menu'!");
//		BigDecimal entry = userInput.nextBigDecimal();
//		 add validation here
//		if (entry.toLowerCase().equals("menu"))
//		{
//			returnHome();
//			bankRun();
//		} 
//		else 
//		{
//			try 
//			{ 
//				BigDecimal newBalance = AccountManager.addDeposit(entry);
//				bank.saveUserChanges(loggedInArr[0], loggedInArr[1], loggedInArr[2], loggedInArr[3], newBalance);
//				System.out.println("Your deposit of $"+depositAmount+" has been added. Your updated bank balance is: $"+newBalance);
//				if (entry.matches("A-Za-z") && !entry.toLowerCase().equals("menu")){
//					throw new NumberFormatException();
//				}
//			} catch (NumberFormatException e) 
//				{
//					System.out.println("Did you input the correct command? We can't process that request.");
//					depositUI();
//				}
//		}
//		returnHome();
//		bankRun();
//	}
//		
//	private static void withdrawUI() {
//		String[] loggedInArr = bank.readUser();
//		System.out.println("Please enter how much you would like to withdraw. Must be in $xx.xx, you do not need to include the $ in your entry. To return to the menu at anytime, enter 'Menu'!");
//		String entry = userInput.next();
//		if (entry.toLowerCase().equals("menu"))
//		{
//			returnHome();
//			bankRun();
//		} 
//		else 
//		{
//			try 
//			{ 
//				BigDecimal withdrawalAmount = BigDecimal.parseDouble(entry);
//				if (entry.matches("A-Za-z") && !entry.toLowerCase().equals("menu")) {
//					throw new NumberFormatException();
//				}
//				BigDecimal newBalance = AccountManager.processWithdrawal(withdrawalAmount);
//				if (newBalance < 0) {
//					throw new OverdraftException();
//				}
//				bank.saveUserChanges(loggedInArr[0], loggedInArr[1], loggedInArr[2], loggedInArr[3], newBalance);
//				System.out.println("Your withdrawal of $"+withdrawalAmount+" has been added. Your updated bank balance is: $"+newBalance);
//			} catch (NumberFormatException e) 
//				{
//					System.out.println("Did you input the correct command? We can't process that request.");
//					withdrawUI();
//				}
//				catch (OverdraftException e) {
//			}
//		}
//		returnHome();
//		bankRun();
//	}

}

