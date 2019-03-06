package com.rev.main;

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
		Login();
//		CustomerDao cus1 = new CustomerDaoImpl();
//		Customer bob = cus1.getCustomerById(4);
//		System.out.println(bob);
	}
	
	
	public static  void Login() {
		int cId = 0;
		log.info("\t\t\t\t\t\t\tAre you loggining in or signing up?");
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
				for(int i=0; i<30; i++) {
					log.info("");
				}
				log.info("You're Login Has Been Succesful");
				cId=cus1.getIdByUser(ans2);
				operations(cId);
				return;
			}else {
				log.info("Sorry but that is the wrong password");
				Login();
			}
		}else{
			log.info("Sorry, but that username is not in our system");
			Login();
		}
		
	}
	
	public static void CreateAccount() {
		CustomerDao cus1 = new CustomerDaoImpl();
		int cId = 0;
		log.info("\t\t\t\t\t\t\tCreate an account");
		log.info("\t\t\tPlease Create a username");
		log.info("");
		String name = "";
		String username = scan1.nextLine();
		if(cus1.getCustomerCredentials().containsKey(username)) {
			log.info("Sorry but the username "+username+" already exists");
			log.info("Please choose another username");
			CreateAccount();
			//return;
		}
		log.info(username+"?"+" Are you sure?");
		log.info("");
		String ans = scan1.nextLine();
		if(ans.equals("yes")||ans.equals("Yes")||ans.equals("y")||ans.equals("Y")||ans.equals("yea")||ans.equals("yep")) {
			log.info("Alright "+username+". Your username is set. Please Enter your password.");
			cId=cus1.getIdByname(username);
			//System.out.println(cId);
			
		}else{log.info("Well, what would you like your username to be?");
				username = scan1.nextLine();
				log.info("You're right. That is better");
				log.info("Alright "+username+". Your username is set. Please Enter your password.");
				cId = cus1.getIdByname(username);
				
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
		log.info("Great. Lastly, what's your first name?");
		log.info("First name: " );
		String name1 = scan1.nextLine();
		System.out.print("Ok "+name1+" your password: ");
		for(int i = 0; i<password.length(); i++) {
			System.out.print("x");
		}
		System.out.print(" and username are both set and will be saved.");
		
		
		int creat = cus1.addCustomer(new Customer(name1,0,username,password));
		//log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();log.info();
		cId =cus1.getIdByUser(username);
		operations(cId);
		
	}
	public static void operations(int id) {
		CustomerDao cus1 = new CustomerDaoImpl();
		for(int i=0; i<5; i++) {
			log.info("");
		}
		log.info("What Operation would you Like to Preform?");
		for(int i=0; i<5; i++) {
			log.info("");
		}
		log.info("Deposit\t\t\t\tWithdraw\t\t\t\tView Balance\t\t\t\t\t\tLogout");
		log.info("Type D\t\t\t\tType W\t\t\t\t\t  Type V\t\t\t\t\t\tType L");
		for(int i=0; i<5; i++) {
			log.info("");
		}
		String op = scan1.nextLine();
		if(op.equals("d")||op.equals("D")||op.equals("deposit")||op.equals("Deposit")){
			log.info("How much would you like to deposit?");
			String dep = scan1.nextLine();
			dep = dep.toLowerCase();
			if(dep.matches(".*[a-z].*")) {
				log.info("We cannot deposit letters. Only money. Enter a numeric value");
				operations(id);
			}else if(dep.matches(".*[0-9].*")) {
			double deposit = Double.parseDouble(dep);
			if(deposit>0) {
			double balance = deposit + cus1.getBalance(id);
			cus1.changeCustomerBalance(id,deposit);
			
			log.info("You've Deposited "+dep+". Your Balance is "+balance+".");
			operations(id);
			}else{
				log.info("Deposite must be a number greater than 0. Duh.");
				operations(id);
			}
		}else {
			log.info("did you include a special charector? Don't do that.");
			operations(id);
		}
		}
		else if(op.equals("bal")||op.equals("balance")||op.equals("Bal")||op.equals("Balance")||op.equals("B")||op.equals("b")||op.equals("v")||op.equals("V")||op.equals("view")||op.equals("View")) {
			log.info("Current balance is "+cus1.getBalance(id));
			operations(id);
		}
		else if(op.equals("w")||op.equals("W")||op.equals("Withdrawl")||op.equals("withdraw")) {
			
			cus1.withdraw(id,cus1.getBalance(id));
			operations(id);
		}
		else if(op.equals("exit")||op.equals("logout")||op.equals("l")||op.equals("e")||op.equals("E")||op.equals("Logout")) {
			
			for(int i = 0; i<50; i++) {
				log.info("");
			}
			log.info("Logout Successful. Goodbye.");
			log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");log.info("");
			Login();
			return;
		}else{
			log.info("Didn't quite get that.");
			operations(id);
		} 
		
	}
	
		
	
	
	
	
	
}
