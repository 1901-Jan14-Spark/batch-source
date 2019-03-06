package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import dao.AccountsDao;
import dao.AccountsDaoImpl;
import dao.BankClientsDao;
import dao.BankClientsDaoImpl;
import models.Accounts;
import models.BankClients;

public class Driver {
	public final static Logger log = Logger.getRootLogger();
	public static Scanner input = new Scanner(System.in);
	static BankClientsDao bcd = new BankClientsDaoImpl();
	static AccountsDao ad = new AccountsDaoImpl();
	static List<String> content = new ArrayList<>();
	public static void main(String[] args) {
//		menu();
//		newAccount();		
			makeNew();
//		withdraw();
	}
	public static void newAccount() {
log.info("WELCOME TO ACCOUNT CREATION");
		
		log.info("Please Enter Member Number: ");
		int memNum = input.nextInt();
		
		log.info("Please Enter Account Type: 'Checkings' or 'Savings ");
		input.nextLine().trim();
		String accType = input.nextLine().trim();
		 if(accType.matches("Checkings")) {
				accType="Checkings";
			}
		 else  if(accType.matches("Savings")) {
			accType="Savings";
		}else{
			log.error("Invalid Input Please Try Again");
			log.info("");
			log.info("Please Enter Account Type: 'Checkings' or 'Savings ");
			accType = input.nextLine();
		}
		
		log.info("Please Provide Opening Amount: ");
		double balance = input.nextDouble();
		
		ad.createAccount(new Accounts(memNum, accType, balance));
		
		log.info("Account Created");
		log.info("");
		menu();
	}
	public static void makeNew() {
		
		log.info("WELCOME NEW MEMBER");
		
		log.info("Please Enter First Name: ");
		String firstname = input.nextLine().trim();
		while(!firstname.matches("[a-zA-Z]*")||firstname.equals("")){
			log.error("Invalid Input Please Try Again");
			firstname = input.nextLine();
		}
		log.info("Please Enter Last Name: ");
		String lastname = input.nextLine().trim();
		while(!lastname.matches("[a-zA-Z]*")||lastname.equals("")){
			log.error("Invalid Input Please Try Again");
			lastname = input.nextLine();
		}
		log.info("Please Enter Email: ");
		String email = input.nextLine().trim();
		while(!email.matches("[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}")||email.equals("")){
			log.error("Invalid Input Please Try Again");
			email = input.nextLine();
		}
		log.info("Please Enter Username: ");
		String username = input.nextLine().trim();
		while(!username.matches("[a-zA-Z0-9_]*")||username.equals("")){
			log.error("Invalid Input Please Try Again");
			username = input.nextLine();
		}
		log.info("Please Enter Password: ");
		String password = input.nextLine().trim();
		while(!password.matches("[a-zA-Z0-9_]*")||password.equals("")){
			log.error("Invalid Input Please Try Again");
			password = input.nextLine();
		}
		bcd.createClient(new BankClients(firstname, lastname, email, username,password));
		
		log.info("USER CREATED");
		log.info("");
		newAccount();
		}
	
	
	public static void menu() {
		log.info("Welcome To Coders Bank");
		log.info("Please Select One of the Following Options: ");
		log.info("To Create a New User Please Type 'New'. To Login Into an Existing Account Please Type 'Login'.");
		String choice = input.nextLine().trim();
		if(choice.matches("New")) {
			makeNew();
		}
		else if(choice.matches("Login")) {
			login();
		}
			else {
			log.error("INVAID INPUT PLEASE TRY AGAIN");
			menu();
		}
		
	}
	
	public static void withdraw() {
		try {
			log.info("Please Enter Your MemberID");
			int memberId = input.nextInt();
			log.info("How Much Would You Like To Withdraw?");
			double withdraw = input.nextDouble();
			ad.withdraw(memberId, withdraw);
			log.info("Transaction Occured");
		}finally {
			loggedIn();
		}
	}
	public static void deposit() {
		log.info("Please Enter Your MemberID");
		int memberId = input.nextInt();
		log.info("How Much Would You Like To Deposit ?");
		double deposit = input.nextDouble();
		ad.deposit(memberId, deposit);
		log.info("Transaction Occured");
		loggedIn();
	}
	public static void loggedIn() {
		log.info("Welcome User");
		log.info("To Do A Withdrawal Please Type 'Withdraw', To Make a Deposit Please Type 'Deposit'.");
		log.info("To Log Out Please Type 'Logout'");
		String choice = input.nextLine().trim();
		if(choice.equals("Logout")) {
			logout();
		}
		else if(choice.equals("Withdraw")) {
			withdraw();
		}
		else if(choice.equals("Deposit")) {
			deposit();
		}
		else{
			loggedIn();
		}
	}
	
	public static void logout() {
		log.info("USER SIGNED OFF");
		menu();
	}
	
	public static void login() {
		log.info("Please Enter Username");
			String userName = input.nextLine().trim();
		log.info("Please Enter Password");
			String passWord = input.nextLine().trim();
			while(bcd.validation(userName, passWord)==false) {
				log.error("Username/Password Don't Match Please Try Again");
				login();
			}
			if(bcd.validation(userName, passWord)==true) {
				log.info("Login Success");
				loggedIn();
			}
	

	}
}
