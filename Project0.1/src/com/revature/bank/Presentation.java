package com.revature.bank;

import java.util.Scanner;
import com.revature.bank.Persistence;

public class Presentation extends Persistence {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {			
		System.out.println("__________________________");
		System.out.println("|                        |");
		System.out.println("|       THE BANK         |");
		System.out.println("|________________________|");
		System.out.println();
		System.out.println();
		System.out.println("Welcome to the Bank");
		System.out.println();
		System.out.println("1: Login\n2: Create Account");
		int option = scan.nextInt();
		if(option == 1) {
			//logIn();
		} else if (option == 2) {
			// create a new member object
			System.out.println("Username: ");
			String newUsername = scan.next();
			System.out.println("Email: ");
			String newUserEmail = scan.next();
			System.out.println("Password: ");
			String newUserPassword = scan.next();
			System.out.println("Deposit Amount: ");
			double newUserDeposit = scan.nextDouble();
			Member newMember = new Member(newUsername, newUserEmail, newUserPassword, newUserDeposit);
			System.out.println("Account successfully created!");
			addNewBankMember(newMember);
			adjustAccountBalance(newMember.accountBalance);
			
		}
		
		

	}
		
	
}
