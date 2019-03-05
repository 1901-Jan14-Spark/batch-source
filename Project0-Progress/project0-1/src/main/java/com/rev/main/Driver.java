package com.rev.main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import log4j.properties;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.rev.util.Customer;
import com.rev.util.CustomerDao;
import com.rev.util.CustomerDaoImpl;

public class Driver {
	private static Logger log = Logger.getRootLogger();
	static Scanner scan1 = new Scanner(System.in);
	static int userId = 0;
	
	
	public static void main(String[] args) {
		
		//CustomerDao cus1 = new CustomerDaoImpl();
		
//		int creat = cus1.addCustomer(new Customer(1,"George",200.01,"GG","fancypants1"));
//		log.info(creat);
		Login();
		
		
		
//		List<Customer> customers = cus1.getCustomers();
//		for(Customer c: customers) {
//			log.info(c);
//		}
		
	}
	
	
	public static  void Login() {
		log.info("\t\t\t\t\t\t\tAre you logining in or signing up?");
		log.info("Type: Login or Sign");
		String ans = scan1.nextLine();
		
		if(ans.equals("Login")||ans.equals("login")||ans.equals("l")){
			log.info("Please enter your credentials");
		}
		else if(ans.equals("Sign")||ans.equals("sign")||ans.equals("s")) {
			CreateAccount();
		}
		else {
			log.info("Sorry, didn't quite get that.");
			Login();
		}
		CustomerDao cus1 = new CustomerDaoImpl();
		
		log.info("Username: ");
		String ans2 = scan1.nextLine();
		if(cus1.getCustomerCredentials().containsKey(ans2)) {
			log.info("Password: ");
			String ans3 = scan1.nextLine();
			if(cus1.getCustomerCredentials().get(ans2).equals(ans3)) {
				log.info("You're Login Has Been Succesful");
				userId=cus1.getIdByUser(ans2);
				 
				operations(userId);
				return;
			}
		}
		
	}
	
	public static void CreateAccount() {
		CustomerDao cus1 = new CustomerDaoImpl();
	
		log.info("\t\t\t\t\t\t\tCreate an account");
		log.info("\t\t\t\tPlease Create a username");
		log.info("");
		String name = "";
		String username = scan1.nextLine();
		if(cus1.getCustomerCredentials().containsKey(username)) {
			log.info("Sorry but the username "+username+" already exists");
			log.info("Please choose another username");
			CreateAccount();
			return;
		}
		log.info(username+"?"+" Are you sure?");
		log.info("");
		String ans = scan1.nextLine();
		if(ans.equals("yes")||ans.equals("Yes")||ans.equals("y")||ans.equals("Y")||ans.equals("yea")||ans.equals("yep")) {
			log.info("Alright "+username+". Your username is set. Please Enter your password.");
			
		}else{log.info("Well, what would you like your username to be?");
				username = scan1.nextLine();
				log.info("You're right. That is better");
				log.info("Alright "+username+". Your username is set. Please Enter your password.");
				userId = cus1.getIdByname(username);
		}
		String password = scan1.nextLine();
		
		//log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();
		log.info("");
		log.info("");
		log.info("");
		log.info("");
		log.info("");
		log.info("");
		log.info("");
		log.info("");
		System.out.print("Ok "+username+" your password: ");
		for(int i = 0; i<password.length(); i++) {
			System.out.print("x");
		}
		log.info(" and username are both set and will be saved.");
		int creat = cus1.addCustomer(new Customer("George",0,username,password));
		//log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();
		operations(userId);
	}
	
	
	
	public static void operations(int id) {
		CustomerDao cus1 = new CustomerDaoImpl();
		log.info("What Operation would you Like to Preform?");
		log.info("Deposit\t\t\t\tWithdraw\t\t\t\tView Balance\t\t\t\t\t\tLogout");
		String op = scan1.nextLine();
		if(op.equals("d")||op.equals("D")||op.equals("deposit")||op.equals("Deposit")){
			log.info("How much would you like to deposit?");
			String dep = scan1.nextLine();
			if(dep.matches(".*[a-z].*")) {
				log.info("The depoite cannot contain letters");
				operations(id);
			}
			double deposit = Double.parseDouble(dep);
			if(deposit>0) {
			double balance = deposit + cus1.getBalance(id);
			cus1.changeCustomerBalance(id,deposit);
			
			log.info("You've Deposited "+dep+". Your Balance is "+balance+".");
			operations(id);
			}else {
				log.info("Deposite must be a number greater than 0. Duh.");
				operations(id);
			}
		}
		if(op.equals("bal")||op.equals("balance")||op.equals("Bal")||op.equals("Balance")||op.equals("B")||op.equals("b")||op.equals("v")||op.equals("V")||op.equals("view")||op.equals("View")) {
			//viewBalance();
			operations(id);
		}
		if(op.equals("w")||op.equals("W")||op.equals("Withdrawl")||op.equals("withdraw")) {
			//withdrawl();
		}
		if(op.equals("exit")||op.equals("logout")||op.equals("l")||op.equals("e")||op.equals("E")||op.equals("Logout"));
			log.info("Logout Successful. Goodbye.");
			log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");
			Login();
			return;
		}
	

	
	
	
	
	
}
