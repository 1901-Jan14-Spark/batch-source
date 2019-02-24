package com.revature.banking;
//import java.util.Scanner;
//import java.sql.*;
//
//public class BankingApplication {
//	
//	public static void main(String[] args) throws Exception {
//		String url = "";
//		String uname = "root";
//		String pass = "";
//		
////		Class.forName("com.mysql.jdbc.Driver");
////		Connection con = DriverManager.getConnection(url, uname, pass);
//		
//		BankAccount obj1 = new BankAccount("Dat", "password123");
//		obj1.showMenu();
//	}
//}//
//class BankAccount {
//	double balance;
//	String username;
//	String password;
//	
//	public BankAccount(String cUsername, String cPassword) {
//		super();
//		this.username = cUsername;
//		this.password = cPassword;
//	}
//
//	void deposit(double amount) {
//		if(amount > 0.0) {
//			balance += amount;
//		}
//	}
//	
//	void withdraw(double amount) {
//		if (amount > 0.0) {
//			balance -= amount;
//		}
//	}
//	
//	void showMenu() {
//		char option= '\0';
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Welcome " + username);
//		System.out.println("\n");
//		System.out.println("A. Check Balance");
//		System.out.println("B. Deposit");
//		System.out.println("C. Withdraw");
//		System.out.println("D. Exit application");
//		
//		do {
//			System.out.println("===============================================================");
//			System.out.println("Enter an option");
//			System.out.println("===============================================================");
//			option = scanner.next().charAt(0);
//			option = Character.toUpperCase(option);
//			System.out.println("\n");
//			
//			switch(option) {
//				case 'A':
//					System.out.println("-------------------------------------------");
//					System.out.println("Balance = " + balance);
//					System.out.println("-------------------------------------------");
//					System.out.println("\n");
//					break;
//					
//				case 'B':
//					System.out.println("-------------------------------------------");
//					System.out.println("Enter an amount to deposit:" );
//					System.out.println("-------------------------------------------");
//					double amount = scanner.nextDouble();
//					deposit(amount);
//					System.out.println("\n");
//					break;
//					
//				case 'C':
//					System.out.println("-------------------------------------------");
//					System.out.println("Enter an amount to withdraw:");
//					System.out.println("-------------------------------------------");
//					double amount2 = scanner.nextDouble();
//					withdraw(amount2);
//					System.out.println("\n");
//					break;
//					
//				case 'D':
//					System.out.println("***************************************************************");
//					break;
//					
//				default:
//					System.out.println("Invalid Option!! Please enter again");
//					break;
//			}
//		} while (option != 'D');
//			System.out.println("Thank you for using our services");
//
//	}
//	
//}
