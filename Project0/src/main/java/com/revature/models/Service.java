package com.revature.models;
import com.revature.models.Account;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAO_Impl;
import com.revature.dao.Bank_AccountDAO;
import com.revature.dao.Bank_AccountDAO_Impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.revature.util.Connections;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Service {
	static Scanner s =new Scanner(System.in);
	private static Logger log = Logger.getRootLogger();
	// main class--------------------------------------------------------------------------------------------------------------
	public static void main(String ...args) {
		
		
		log.info("Welcome to Revature Banks.");
		log.info("Do you have an account with us. Y/N");
		boolean YN=false;
		while(YN==false) {
		String x = s.nextLine();
		if (x.equals("N")) {
			YN=true;
			newUser();
			
			
		}else if (x.equals("Y")) {
			YN=true;
			logIn();
		
		}else {
			log.info("Please only enter Y for yes or N for no.");
		}
		
	}
	
		

	}
	// making a user account--------------------------------------------------------------------------------------------------------------
	public static void newUser() {
		String a="";
		String b="";
		String b2="";
		String c="";
		String d="";
		String e="";
		String f="";
		int id=7;
		boolean correctPass=false;
		
		log.info("Please provide a Username");
		a=s.nextLine();
		if(ReadWrite.checkUsername(a)) {
			log.info("Username already taken, please choose another.");
			newUser();
		}
		if (a.length()>20) {
			log.info("Username is too long. please choose another");
			newUser();
		}
		while(correctPass==false) {
			
		System.out.println("Please enter PassWord.");
		b=s.nextLine();
		
		String patt="((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
		Pattern p=Pattern.compile(patt);
		Matcher m=p.matcher(b);
		if (m.matches()==false){
			log.info("Password does not meet criteria. Must be between 8 and 40 characters, have a lowercase and uppercase letter,\n have a number, and include a special character (@#$%!).");
			continue;
		}
		
		
		System.out.println("Please re-enter PassWord");
		b2=s.nextLine();
		if (b.equals(b2)) {
			correctPass=true;
		}else {
			log.info("Passwords did not match, please try again.");
		}
		}
		
		boolean validFN=false;
		while(validFN==false) {
			log.info("Please enter your first name");
			c=s.nextLine();
		String patt2="[A-Z][a-z]{1,20}";
		Pattern email=Pattern.compile(patt2);
		Matcher m1=email.matcher(c);
		
		if(m1.matches()) {
			validFN=true;
		}else {log.info("First name must be capital, consist of only letters, and be between 1 and 20 characters");
		}
		}
		
		boolean validLN=false;
		while(validLN==false) {
			log.info("Please enter your last name");
			d=s.nextLine();
		String patt2="[A-Z][a-z]{1,20}";
		Pattern email=Pattern.compile(patt2);
		Matcher m1=email.matcher(d);
		
		if(m1.matches()) {
			validLN=true;
		}else {log.info("Last name must be capital, consist of only letters, and be between 1 and 20 characters");
		}
		}
		
		
		boolean validemail=false;
		while(validemail==false) {
		log.info("Please enter email address");
		e=s.nextLine();
		String patt2="^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern email=Pattern.compile(patt2);
		Matcher m1=email.matcher(e);
		
		if(m1.matches()) {
			validemail=true;
		}else {log.info("Invalid Email, please try again.");
		}
		}
		
		boolean validphone=false;
		while(validphone==false) {
			log.info("Please enter a phone number with 10 digits and no other characters in between.");
		f=s.nextLine();
		String patt2="\\d{10}";
		Pattern email=Pattern.compile(patt2);
		Matcher m1=email.matcher(f);
		
		if(m1.matches()) {
			validphone=true;
		}else {log.info("Invalid Phone Number.");
		}
		}
		
		
		id=ReadWrite.getCount();
		Account acc = new Account(id, a, b, c, d, e, f, 0); 
		AccountDAO aa=new AccountDAO_Impl();
		log.info("Your user account is as follows: Username: " + a + " | Password: " + b + " | First Name: " + c + " | Last Name: " + d + " | Email: " + e+ " | Phone# " + f +".");
		log.info("Is this all correct, Y/N?");
		boolean YN=false;
		while(YN==false) {
		String x = s.nextLine();
		if (x.equals("N")) {
			YN=true;
			newUser();
			
			
		}else if (x.equals("Y")) {
			YN=true;
			aa.createAccount(acc);
			ReadWrite.addUsername(acc.getUsername());
			id++;
			ReadWrite.writeCount(id);
			log.info("Thank you for making an account. Press enter to continue");
		s.hasNextLine();
		logIn();
		}else {
			log.info("Please only enter Y for yes or N for no.");
		}
		}
	}
	
	// checking user credentials--------------------------------------------------------------------------------------------------------------	
public static void logIn() {
	String reply="";
	String name="";
	String pass1="";
	log.info("Please enter username.");
	name=s.nextLine();
	log.info("Please enter password.");
	pass1=s.nextLine();
	AccountDAO aa=new AccountDAO_Impl();
	
	try{Account test=aa.varifyAccount(name, pass1);
		if (test.getUsername().equals(name) && test.getPassword().contentEquals(pass1)) {
			log.info("Welcome " + test.getFirstname() + ".") ;
			enterAccount(test);
		}else {
			log.info(" Incorrect Username or Password. Enter 1 to try again or any other button to quit.");
			reply=s.nextLine();
			if (reply.equals("1")) {
			logIn();
			}else {
				main();
			}
		}
	}catch(NullPointerException e) {
		log.info(" Incorrect Username or Password. Enter 1 to try again or any other button to quit.");
		reply=s.nextLine();
		if (reply.equals("1")) {
		logIn();
		}else {
			main();
		}
	}
	}
// logging into account--------------------------------------------------------------------------------------------------------------
public static void enterAccount(Account user) {
	String reply="";
	
	if (user.getBA_ID()==0) {
		log.info("Would you like to 1:make a bank account or 2: Delete user account?  Any other button will exit.");
		reply=s.nextLine();
		if (reply.equals("1")) {
			Bank_Account bank= new Bank_Account();
			Bank_AccountDAO aa=new Bank_AccountDAO_Impl();
			aa.createBankAccount(user, bank);
			log.info("Thank you for making a bank account. Would you like to log in now? Y/N");
			boolean YN=false;
			while(YN==false) {
				String x = s.nextLine();
				if (x.equals("Y")) {
					YN=true;
					logIn();
					
					
				}else if (x.equals("N")) {
					YN=true;
					main();
				
				}else {
					log.info("Please only enter Y for yes or N for no.");
				}
			}
			}
		if (reply.equals("2")) {
			log.info("Are you sure you want to delete your account?Y/N");
			boolean YN=false;
			do {
				String sure =s.nextLine();
				if (sure.equals("Y")){
					YN=true;
					}
				if(sure.contentEquals("N")) {
					YN=true;
					enterAccount(user);
				}
				
			}while (YN==false);
			log.info("Please enter username to validate deletion");
			String confirmU=s.nextLine();
			log.info("Please enter password to validate deletion");
			String confirmP=s.nextLine();
			if(confirmU.contentEquals(user.getUsername()) && confirmP.equals(user.getPassword())) {
				log.info("Confirmed. Deleting account.");
			}else {
				enterAccount(user);
			}
			AccountDAO aa=new AccountDAO_Impl();
			aa.deleteAccount(user.getId());
			log.info("Account deleted. Returning to home screen.");
			main();
		}
		
		else {
				main();
			}
		
	}else {
		log.info("What would you like to do? Enter 1 to Make a Transaction, 2 to view Account Info, 3 to delete Account, 4 to log out, 5 to home screen ");
		reply=s.nextLine();
		switch(reply) {
		case "1":
			transaction(user);
			break;
		case "2":
			log.info("Your user acount is as follows: Username " + user.getUsername() +"| First Name: "+ user.getFirstname() + "| Last Name: " + user.getLastname() + "| Email: " + user.getEmail()+  "| Phone Number: " + user.getPhoneNumber());
			break;
		case "3":
			log.info("Are you sure you want to delete your account?Y/N");
			boolean YN=false;
			do {
				String sure =s.nextLine();
				if (sure.equals("Y")){
					YN=true;
					}
				if(sure.contentEquals("N")) {
					YN=true;
					enterAccount(user);
				}
				
			}while (YN==false);
			log.info("Please enter username to validate deletion");
			String confirmU=s.nextLine();
			log.info("Please enter password to validate deletion");
			String confirmP=s.nextLine();
			if(confirmU.contentEquals(user.getUsername()) && confirmP.equals(user.getPassword())) {
				log.info("Confirmed. Deleting account.");
			}else {
				enterAccount(user);
			}
			AccountDAO aa=new AccountDAO_Impl();
			aa.deleteAccount(user.getId());
			log.info("Your account has been deleted. Returning to home screen.");
			main();
			break;
		case "4":
			logIn();
			break;
		case "5":
			main();
			break;
		default:
			enterAccount(user);
		}
		enterAccount(user);
	}
}
// transactions--------------------------------------------------------------------------------------------------------------
	public static void transaction(Account a) {
		String reply=" ";
		double withdrawal = 0.0;
		double deposit = 0.0;
		log.info("Would you like to do? Enter 1 to view balance, 2 to withdraw, 3 to deposit, 4 to delete bank account, 5 to log out, or 6 to return to home screen.");
		reply=s.nextLine();
		Bank_AccountDAO aa=new Bank_AccountDAO_Impl();
		switch(reply) {
		case "1":
			
			log.info(aa.viewBalance(a));
			
			break;
		case "2":
			log.info("Your balance is " + aa.viewBalance(a) + ".");
			log.info("How much would you like to withdraw?");
			
			try{withdrawal=Double.parseDouble(s.nextLine());
		aa.withdraw(a, withdrawal);
			}catch(NumberFormatException e) {
				log.info("Please only enter a positive numceric value.");
				transaction(a);
			}
			break;
		case "3":
			log.info("Your balance is " + aa.viewBalance(a) + ".");
			log.info("How much would you like to deposit");
			try {
			deposit=Double.parseDouble(s.nextLine());
			aa.deposit(a, deposit);
			}catch(NumberFormatException e) {
				log.info("Please only enter a positive numceric value.");
				transaction(a);
			}
			
			break;
		case "4":
			log.info("Are you sure you want to delete your account?Y/N");
			boolean YN=false;
			do {
				String sure =s.nextLine();
				if (sure.equals("Y")){
					YN=true;
					}
				if(sure.contentEquals("N")) {
					YN=true;
					enterAccount(a);
				}
				
			}while (YN==false);
			log.info("Please enter username to validate deletion");
			String confirmU=s.nextLine();
			log.info("Please enter password to validate deletion");
			String confirmP=s.nextLine();
			if(confirmU.contentEquals(a.getUsername()) && confirmP.equals(a.getPassword())) {
				log.info("Confirmed. Deleting account.");
			}else {
				transaction(a);
			}
			aa.deleteBankAccount(a.getBA_ID());
			main();
			break;
			
		case "5":
			logIn();
			break;
		case "6":
			main();
			break;
		default:
			enterAccount(a);
		}
	}
}
