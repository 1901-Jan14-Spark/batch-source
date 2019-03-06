package main;

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
	
	public static void main(String[] args) {
		menu();
		//newAccount();		
			
	}
	public static void newAccount() {
log.info("WELCOME TO ACCOUNT CREATION");
		
		log.info("Please Enter Member Number: ");
		int memNum = input.nextInt() ;
		
		log.info("Please Enter Account Type: 'Checkings' or 'Savings ");
		input.nextLine();
		String accType = input.nextLine();
		
		log.info("Please Opening Ammount: ");
		double balance = input.nextDouble();
		
		ad.createAccount(new Accounts(memNum, accType, balance));
		
		log.info("Account Created");
		log.info("");
	}
	public static void makeNew() {
		
		log.info("WELCOME NEW MEMBER");
		
		log.info("Please Enter First Name: ");
		String firstname = input.nextLine() ;
		
		log.info("Please Enter Last Name: ");
		String lastname = input.nextLine();
		
		log.info("Please Enter Email: ");
		String email = input.nextLine();
		
		log.info("Please Enter Username: ");
		String username = input.nextLine();
		
		log.info("Please Enter Password: ");
		String password = input.nextLine();
		
		bcd.createClient(new BankClients(firstname, lastname, email, username,password));
		
		log.info("USER CREATED");
		log.info("");
		menu();
		}
	
	
	public static void menu() {
		log.info("Welcome To Coders Bank");
		log.info("Please Select One of the Following Options: ");
		log.info("To Create a New User Please Type 'New'. To Login Into an Existing Account Please Type 'Login'.");
		String choice = input.nextLine();
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
		log.info("Please Enter Your MemberID");
		int memberId = input.nextInt();
		log.info("How Much Would You Like To Withdraw?");
		double withdraw = input.nextDouble();
		ad.withdraw(memberId, withdraw);
		log.info("Withdrawal Successful");
		loggedIn();
	}
	public static void deposit() {
		log.info("Please Enter Your MemberID");
		int memberId = input.nextInt();
		log.info("How Much Would You Like To Deposit ?");
		double deposit = input.nextDouble();
		ad.deposit(memberId, deposit);
		log.info("Deposit Success");
		loggedIn();
	}
	public static void loggedIn() {
		log.info("Welcome User");
		log.info("To Do A Withdrawal Please Type 'Withdraw', To Make a Depsit Please Type 'Deposit'.");
		log.info("To Log Out Please Type 'Logout'");
		String choice = input.nextLine();
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
			log.error("Invalid Choice Please Try Again");
			loggedIn();
		}
//		String sql = "SELECT (FIRSTNAME|| ' ' || LASTNAME) FROM BANK_CLIENTS";
//		try(Connection con = ConnectionUtil.sysVar();
//				PreparedStatement ps = con.prepareStatement(sql);){
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	public static void logout() {
		log.info("USER SIGNED OFF");
		menu();
	}
	
	public static void login() {
		log.info("Please Enter Username");
			String userName = input.nextLine();
		log.info("Please Enter Password");
			String passWord = input.nextLine();
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
