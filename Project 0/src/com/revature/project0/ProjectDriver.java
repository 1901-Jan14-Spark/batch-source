package com.revature.project0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProjectDriver {
	static Scanner scanner = new Scanner(System.in);
	static String userName;
	static String accountPassword;
	static String accountsPath = "src/com/revature/project0/accountInfo.txt";
	//Used to call key methods to activate the program and prompt user for either Login or Account Creation.
	public static void main(String[] args) {
		System.out.println("Welcome to the Account Managment Portal!");
		System.out.println();
		System.out.println("Please Enter One of the Following to Proceed");
		System.out.println();
		Start();
	}
	//Starts the Program and prompts for Login or Creation.
	public static void Start() {
		
		System.out.println("Login or Create (to Logout at anytime type: logout)");
		String input = scanner.nextLine().toLowerCase();
		if(input.equals("login")) {
			Login();
		}
		else if(input.equals("create")) {
			Create();
		}
		else {
			System.out.println("Invalid Input, Please Enter One of the Following");
			System.out.println();
			Start();
		}
	}
	//Will be called if the response from the user is to login into account previously created.
	public static void Login() {
		System.out.println("Please enter Username: ");
		userName = scanner.nextLine();
		LogOut(userName);
		System.out.println();
		System.out.println("Enter your password:");
		accountPassword = scanner.nextLine();
		LogOut(accountPassword);
		if(getAccountLine(userName, accountPassword) == -1) {
			System.out.println("Username or Password is Incorrect, Please enter in the correct information:");
			Login();
		}
		else {
			
			runAccountOptions(getAccount(userName, accountPassword));
		}
	}
	
	//Used to Create an account based on the information provided by the user.
	//Then will prompt Login
	public static void Create() {
		String output = "";
		String consoleOutput ="";
		System.out.println("Please enter a username between 8 and 16 characters");
		String user = scanner.nextLine();
		LogOut(user);
		if(user.length()<8 || user.length() > 16) {
			System.out.println();
			System.out.println("Invalid Username Length");
			Create();
		}
		else {
			output += "" + returnAccountId() + "," + user + ",";
			consoleOutput += "Account ID: " + returnAccountId() + ", User ID: " + user + ", ";
		}
		System.out.println();
		System.out.println("Create your Password (must be between 8 and 16 characters): ");
		String password = scanner.nextLine();
		LogOut(password);
		if(user.length()<8 || user.length() > 16) {
			System.out.println("Invalid Password Length");
			Create();
		}
		else {
			output += password + ",";
			consoleOutput += "Password: " + password + ", ";
		}
		System.out.println();
		System.out.println("Add an Amount to your newly created account");
		String balance = scanner.nextLine();
		LogOut(balance);
		if(Integer.parseInt(balance) < 0) {
			System.out.println();
			System.out.println("Negative Account Balance is not Allowed");
		}
		else {
			output += balance;
			consoleOutput += "Balance: " + balance;
		}
		System.out.println();
		System.out.println("Current Metrics of your new Account!");
		System.out.println();
		addAccount(output);
		System.out.println(consoleOutput);
		Start();
	}
	//Used to Log Out and Restart the application.
	public static void LogOut(String logout) {
		if(logout.toLowerCase() == "logout") {
			Start();
		}

	}
	//Used to get the account line given userName and password on login
	public static int getAccountLine(String userName, String password) {
		int accountLine = -1;
		ArrayList<String> accounts = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(accountsPath))){
			String account = br.readLine();
			while(account!=null) {
				accounts.add(account);
				account = br.readLine();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i< accounts.size(); i++){
			String[] accountMetrics = accounts.get(i).split(",");
			if(accountMetrics[1].equals(userName) && accountMetrics[2].equals(password) ){
				accountLine = i;

			}
			
		}
		return accountLine;
	}
	//Used to add new account line in the textfile
	public static void addAccount(String newAccount) {
		try(FileWriter fw = new FileWriter(accountsPath, true); BufferedWriter bw = new BufferedWriter(fw)){
			bw.newLine();
			bw.append(newAccount);
			System.out.println("Account has been added to the Server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Check if Username is used and will return -1 if not
	public static int checkUserName(String createdName) {
		int accountLine = -1;
		ArrayList<String> accounts = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(accountsPath))){
			String account = br.readLine();
			while(account!=null) {
				accounts.add(account);
				account = br.readLine();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i< accounts.size(); i++){
			String[] accountMetrics = accounts.get(i).split(",");
			if(accountMetrics[1].equals(userName)){
				accountLine = i;

			}
			
		}
		return accountLine;	
	}
	//will give the amount of line/ids in use
	public static int returnAccountId() {
		int count = 0;
		ArrayList<String> accounts = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(accountsPath))){
			String account = br.readLine();
			while(account!=null) {
				accounts.add(account);
				account = br.readLine();
				count++;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;	
	}
	//Will use the given accountLine to construct a String Array of the metrics for that line
	public static String getAccount(String userName, String password) {
		String[] accountInfo = new String[3];
		String output = "";
		ArrayList<String> accounts = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(accountsPath))){
			String account = br.readLine();
			while(account!=null) {
				accounts.add(account);
				account = br.readLine();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i< accounts.size(); i++){
			String[] accountMetrics = accounts.get(i).split(",");
			if(accountMetrics[1].equals(userName) && accountMetrics[2].equals(password)){
				accountInfo = accountMetrics;
			}
			
		}
		for(int i = 0; i< accountInfo.length - 1; i++) {
			output += accountInfo[i] + ",";
		}
		output+=accountInfo[accountInfo.length-1];
		return output;
	}
	//will be used to display account information on to the console
	public static void runAccountOptions(String accountInfo) {
		String info = accountInfo;
		String input = "";
		System.out.println("To Deposit or Withdraw from an account please type Deposit or Withdraw");
		System.out.println();
		System.out.println("To View Balance: enter Balance");
		System.out.println();
		System.out.println("To Logout at any time please enter logout");
		input = scanner.nextLine().toLowerCase();
		LogOut(input);
		if(input.equals("deposit")){
			info = Deposit(accountInfo);
		}
		else if(input.equals("withdraw")) {
			info  = Withdraw(accountInfo);
		}
		else if(input.equals("balance")) {
			info = DisplayBalance(accountInfo);
		}
		runAccountOptions(info);
	}
	//Displays the Balance of an Account
	public static String DisplayBalance(String accountInfo) {
		String[] accountsplit = AccountSpliter(accountInfo);
		System.out.println("Current Balance: " + accountsplit[accountsplit.length-1]);
		String output = "";
		for(int i = 0; i< accountsplit.length - 1; i++) {
			output += accountsplit[i] + ",";
		}
		output+=accountsplit[accountsplit.length-1];
		return output;
	}
	//Will update an existing account by depositing a valid non negative number/
	public static String Deposit(String accountInfo) {
		String[] accountsplit = AccountSpliter(accountInfo);
		int currentBalance = Integer.parseInt(accountsplit[accountsplit.length-1]);
		System.out.println("Enter in a Valid Currency Amount: ");
		int depositValue = scanner.nextInt();
		if(depositValue < 0) {
			System.out.println("Please enter in a non negative amount");
			Deposit(accountInfo);
		}
		else {
			accountsplit[accountsplit.length-1] = "" + (currentBalance + depositValue);
		}
		String output = "";
		for(int i = 0; i< accountsplit.length - 1; i++) {
			output += accountsplit[i] + ",";
		}
		output+=accountsplit[accountsplit.length-1];
		ModifyAccount(output);
		return output;
	}
	//Will reduce the account by the amount of given if the number is a valid non negative number not greater than the account balance.
	public static String Withdraw(String accountInfo) {
		String[] accountsplit = AccountSpliter(accountInfo);
		int currentBalance = Integer.parseInt(accountsplit[accountsplit.length-1]);
		System.out.println("Enter in a Valid Currency Amount: ");
		int withdrawValue = scanner.nextInt();
		if(withdrawValue < 0 || currentBalance <= withdrawValue) {
			System.out.println("Please enter in a non negative amount");
			Withdraw(accountInfo);
		}
		else {
			accountsplit[accountsplit.length-1] = "" + (currentBalance - withdrawValue);
		}
		String output = "";
		for(int i = 0; i< accountsplit.length - 1; i++) {
			output += accountsplit[i] + ",";
		}
		output+=accountsplit[accountsplit.length-1];
		ModifyAccount(output);
		return output;
		
	}
	//Puts Account into an StringArray
	public static String[] AccountSpliter(String accountText) {
		String[] accountArray = accountText.split(",");
		return accountArray;
	}
	//Replaces existing Account
	public static void ModifyAccount(String output) {
		try(FileWriter fw = new FileWriter(accountsPath); BufferedWriter bw = new BufferedWriter(fw)){
			bw.write(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
}
