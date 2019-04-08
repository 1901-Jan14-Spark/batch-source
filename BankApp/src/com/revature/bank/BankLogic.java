package com.revature.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankLogic {
	
	static String path = "src/com/revature/bank/users.txt";
	
	static Scanner input = new Scanner(System.in); 

	public static void bank() {
		
		int choice = 0;
		
		System.out.println("~~~~Welcome to Hassan's Bank~~~~");
		System.out.println("| 1. Login");
		System.out.println("| 2. Register");
		System.out.println("| 3. Quit");
		
		
			choice = input.nextInt();
			try {
				while(choice != 1 && choice != 2 && choice != 3 ) {
					System.out.println("Try again...");
					choice = input.nextInt();
				}
			} catch(InputMismatchException e) {
				e.printStackTrace();
			}
		
			if(choice == 1) {
				login();
			} else if (choice == 2) {
				register();
			} else {
				System.exit(0);
			}
		
	}
	
	public static void login() {
		
		System.out.print("Username: ");
		String userUser = input.next();
		System.out.print("Password: ");
		String userPass = input.next();
		
		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr);){
			
			String line = br.readLine();
			if(line == null) {
				throw new IOException();
			} else {
				String[] lineStr = line.split(" ");
				if(lineStr[1].equals(userUser) && lineStr[2].equals(userPass)) {
					userAccount();
				} else {
					System.out.println("Wrong Username or Password.");
					bank();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		

	}
	
	public static void userAccount() {
		System.out.println("~~~~~~~~~~~~~~~~~");
		System.out.println("Select an Action:\n1. Deposit\n2. Withdraw \n3. Balance \n4. Logout");
		int choice = 0;
		try {
			choice = input.nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		switch (choice) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				showBal();
				break;
			case 4:
				System.out.println("Logging off...");
				bank();
			default:
				System.out.println("Invalid Input, try again.");
				userAccount();
		}
			
				
	}
	
	public static void deposit() {
		System.out.println("~~~~~DEPOSIT~~~~~");
		double userAmount = 0;
		try {
			userAmount = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Must only be numbers");
				deposit();
			}
		
       try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr);){
			
			String line = br.readLine();
			if(line == null) {
				throw new IOException();
			} else {
				String[] lineStr = line.split(" ");
				double accAmount = Double.parseDouble(lineStr[3]);
				try (FileWriter fw = new FileWriter(path); BufferedWriter bw = new BufferedWriter(fw);) {
					accAmount += userAmount;
					fw.write(lineStr[0]+" "+lineStr[1]+" "+lineStr[2]+" "+accAmount);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
       userAccount();
		
	}
	
	public static void withdraw() {
		System.out.println("~~~~~WITHDRAW~~~~");
		double userAmount = 0;
		try {
			userAmount = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Must only be numbers");
				deposit();
			}
		
		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr);){
			
			String line = br.readLine();
			if(line == null) {
				throw new IOException();
			} else {
				String[] lineStr = line.split(" ");
				double accAmount = Double.parseDouble(lineStr[3]);
				try (FileWriter fw = new FileWriter(path); BufferedWriter bw = new BufferedWriter(fw);) {
					accAmount -= userAmount;
					fw.write(lineStr[0]+" "+lineStr[1]+" "+lineStr[2]+" "+accAmount);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		userAccount();
	}
	
	public static void showBal() {
		System.out.println("~~~~~BALANCE~~~~~");
		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr);){
			
			String line = br.readLine();
			if(line == null) {
				throw new IOException();
			} else {
				String[] lineStr = line.split(" ");
				System.out.println(lineStr[3]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		userAccount();
	}
	
	public static void register() {
		System.out.println("~~~~~REGISTER~~~~");
		
			System.out.println("Input Email Address: ");
			String userEmail = input.next();
			System.out.println("Input username: ");
			String userName = input.next();
			System.out.println("Input password: ");
			String userPass = input.next();
			System.out.println("Input starting balance: ");
			double userBal = input.nextDouble();
			
			try (FileWriter fw = new FileWriter(path,true); BufferedWriter bw = new BufferedWriter(fw);) {
				bw.append(userEmail+" "+userName+" "+userPass+" "+userBal+"\n");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("User has been added. Please login");
			bank();
	}
}
