package com.revature.bankapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
//import java.nio.file.Paths;
import java.util.Scanner;

import com.revature.bankapp.exceptions.OverdraftException;

//import org.apache.log4j.Logger;

final class BankDriver extends User implements ReadWriteManager {

	/*
	 * Using this class as the main driver for the application. The BankDriver will hold the main method and will just have the one method passed in which
	 * starts the application itself. All other methods related to console input / console output will be listed in BankDriver.
	 * 
	 */
	
	static Scanner userInput = new Scanner(System.in);
//	private static Logger log = Logger.getRootLogger();
	
	static BankDriver bankDr = new BankDriver();
	
	public static void main(String[] args) {
		appStart();
	}
	
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
		String[] userArr = bankDr.readUser();
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
					newUser.setBalance(userInput.nextDouble());

					System.out.println("Your account was created! You are being returned to the homescreen. You may choose to log-in there.");
					bankDr.writeUser(newUser.getName(), newUser.getUsername(), newUser.getEmail(), newUser.getPassword(), newUser.getBalance());
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
		String[] loggedInArr = bankDr.readUser();
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
			depositUI();
		}
		if(Integer.parseInt(theirChoice) == 3) {
			withdrawUI();
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

	private static void depositUI() 
	{
		String[] loggedInArr = bankDr.readUser();
		System.out.println("Please enter how much you would like to deposit. Must be in $xx.xx format. You do not need to add the $ to your entry. To return to the menu at anytime, enter 'Menu'!");
		String entry = userInput.next();
		if (entry.toLowerCase().equals("menu"))
		{
			returnHome();
			bankRun();
		} 
		else 
		{
			try 
			{ 
				double depositAmount = Double.parseDouble(entry);
				double newBalance = bankDr.addDeposit(depositAmount);
				bankDr.saveUserChanges(loggedInArr[0], loggedInArr[1], loggedInArr[2], loggedInArr[3], newBalance);
				System.out.println("Your deposit of $"+depositAmount+" has been added. Your updated bank balance is: $"+newBalance);
				if (entry.matches("A-Za-z") && !entry.toLowerCase().equals("menu")){
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) 
				{
					System.out.println("Did you input the correct command? We can't process that request.");
					depositUI();
				}
		}
		returnHome();
		bankRun();
	}
		
	private static void withdrawUI() {
		String[] loggedInArr = bankDr.readUser();
		System.out.println("Please enter how much you would like to withdraw. Must be in $xx.xx, you do not need to include the $ in your entry. To return to the menu at anytime, enter 'Menu'!");
		String entry = userInput.next();
		if (entry.toLowerCase().equals("menu"))
		{
			returnHome();
			bankRun();
		} 
		else 
		{
			try 
			{ 
				double withdrawalAmount = Double.parseDouble(entry);
				if (entry.matches("A-Za-z") && !entry.toLowerCase().equals("menu")) {
					throw new NumberFormatException();
				}
				double newBalance = bankDr.processWithdrawal(withdrawalAmount);
				if (newBalance < 0) {
					throw new OverdraftException();
				}
				bankDr.saveUserChanges(loggedInArr[0], loggedInArr[1], loggedInArr[2], loggedInArr[3], newBalance);
				System.out.println("Your withdrawal of $"+withdrawalAmount+" has been added. Your updated bank balance is: $"+newBalance);
			} catch (NumberFormatException e) 
				{
					System.out.println("Did you input the correct command? We can't process that request.");
					withdrawUI();
				}
				catch (OverdraftException e) {
			}
		}
		returnHome();
		bankRun();
	}

	public void writeUser(String nameInput, String usernameInput, String emailInput, String passwordInput,
			double startingBalance) {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(userFilePath, true)))) {
			pw.println(nameInput+","+usernameInput+","+emailInput+","+passwordInput+","+startingBalance);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveUserChanges(String nameInput, String usernameInput, String emailInput, String passwordInput,
			double newBalance) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFilePath))) {
			bw.write(nameInput+","+usernameInput+","+emailInput+","+passwordInput+","+newBalance);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String[] readUser() {
		try (BufferedReader br = new BufferedReader(new FileReader(userFilePath))) {
			String line;
			while ((line = br.readLine()) != null) {
			String[] userInfoArr = line.split(",");
			return userInfoArr;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

	
//	public Stream<String> readUnproccessed() {
//		try(Stream<String> stream = Files.lines(Paths.get(userFilePath))) {
//			stream.forEach(System.out::println);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Stream<String> stream = 
//		return ;
//	}
	
