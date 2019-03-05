package com.rev.bank;

import java.util.LinkedList;
import java.util.Scanner;

import com.rev.main.Amap;
import com.rev.util.CustomerDao;
import com.rev.util.CustomerDaoImpl;
//import CustomerDaoImpl.java;
public class Bank {

	CustomerDao cc = new CustomerDaoImpl();

	
		static Scanner scan1= new Scanner(System.in);
		static String accountPath = "src/bank/account.txt";
		static LinkedList<String> tack = new LinkedList<String>();



	public static void main(String[] args) {
		//CreateAccount();
		//CustomerDao cc = new CustomerDaoImpl();
		Login();
		//operations();
		//getBalance();
		//viewBalance();
		//withdrawl();
	}

	public static void Login() {
		System.out.println("\t\t\t\t\t\t\tAre you logining in or signing up?");
		System.out.println("Type: Login or Sign");
		String ans = scan1.nextLine();
		
		if(ans.equals("Login")||ans.equals("login")||ans.equals("l")){
			System.out.println("Please enter your credentials");
		}
		if(ans.equals("Sign")||ans.equals("sign")||ans.equals("s")) {
			CreateAccount();
		}
		
		
		System.out.println("Username: ");
		String ans2 = scan1.nextLine();
		if(CustomerDaoImpl.getCustomerCredentials().containsKey(ans2)) {
			System.out.println("Password: ");
			String ans3 = scan1.nextLine();
			if(getCustomerCredentials().get(ans2).equals(ans3)) {
				System.out.println("You're Login Has Been Succesful");
				operations();
				return;
			}
		}
		//System.out.println(getInfo());
	}


	static int viewBalance() {
		int balance = Integer.parseInt(getBalance().peek());
		System.out.println("Your balance as of now is $"+balance+". ");
		//operations();
		return balance;
		
	}

	 static LinkedList<String> getBalance() {
		try(BufferedReader br = new BufferedReader(new FileReader(accountPath))){
			String bal = br.readLine();
			while(bal!=null) {
				tack.push(bal);
				bal =br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(tack);
		return tack;
		
	}
	public static void withdrawl() {
		System.out.println("\t\t\t\t\t\tHow much would you like to withdrawl?");
		viewBalance();
		//System.out.println("Your balance is $"+bal+".");
		String subtract= scan1.nextLine();
		if(subtract.contains("[a-z]")) {
			System.out.println("Numbers only please");
		}
		int sub = Integer.parseInt(subtract);
		System.out.println("Are you sure you want to withdraw $"+sub+"?");
		String ans4 = scan1.nextLine();
		if(ans4.equals("y")||ans4.equals("Y")||ans4.equals("yes")||ans4.equals("Yes")) {
			int balance = Integer.parseInt(getBalance().peek());
			int bal = balance - sub;

			try(FileWriter fw = new FileWriter(accountPath,true); BufferedWriter bw = new BufferedWriter(fw)){
				bw.append(bal+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			viewBalance();
		}
		operations();
		
	}
	 
	 
	 

	public static void operations() {
		System.out.println("What Operation would you Like to Preform?");
		System.out.println("Deposit\t\t\t\tWithdraw\t\t\t\tView Balance\t\t\t\t\t\tLogout");
		String op = scan1.nextLine();
		if(op.equals("d")||op.equals("D")||op.equals("deposit")||op.equals("Deposit")){
			System.out.println("How much would you like to deposit?");
			String dep= scan1.nextLine();
			int deposit= Integer.parseInt(dep);
			int balance = deposit + Integer.parseInt(getBalance().peek());
			try(FileWriter fw = new FileWriter(accountPath,true); BufferedWriter bw = new BufferedWriter(fw)){
				bw.append(balance+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("You've Deposited "+dep+". Your Balance is "+balance+".");
			operations();
		}
		if(op.equals("bal")||op.equals("balance")||op.equals("Bal")||op.equals("Balance")||op.equals("B")||op.equals("b")||op.equals("v")||op.equals("V")||op.equals("view")||op.equals("View")) {
			viewBalance();
			operations();
		}
		if(op.equals("w")||op.equals("W")||op.equals("Withdrawl")||op.equals("withdraw")) {
			withdrawl();
		}
		if(op.equals("exit")||op.equals("logout")||op.equals("l")||op.equals("e")||op.equals("E")||op.equals("Logout"));
			System.out.println("Logout Successful. Goodbye.");
			System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
			Login();
			return;
		}



	public static void CreateAccount() {
		System.out.println("\t\t\t\t\t\t\tCreate an account");
		System.out.println("\t\t\t\tPlease Create a username");
		System.out.println();
		String username = scan1.nextLine();
		if(getInfo().containsKey(username)) {
			System.out.println("Sorry but the username "+username+" already exists");
			System.out.println("Please choose another username");
			CreateAccount();
			return;
		}
		System.out.println(username+"?"+" Are you sure?");
		System.out.println();
		String ans = scan1.nextLine();
		if(ans.equals("yes")||ans.equals("Yes")||ans.equals("y")||ans.equals("Y")||ans.equals("yea")||ans.equals("yep")) {
			System.out.println("Alright "+username+". Your username is set. Please Enter your password.");
			
		}else{System.out.println("Well, what would you like your username to be?");
				username = scan1.nextLine();
				System.out.println("You're right. That is better");
				System.out.println("Alright "+username+". Your username is set. Please Enter your password.");
		}
		String password = scan1.nextLine();
		
		//System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("Ok "+username+" your password: ");
		for(int i = 0; i<password.length(); i++) {
			System.out.print("x");
		}
		System.out.println(" and username are both set and will be saved.");
		setUser(username, password);
		//System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
		operations();
	}



	}

}
