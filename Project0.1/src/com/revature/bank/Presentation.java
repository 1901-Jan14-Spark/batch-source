package com.revature.bank;

import java.util.Scanner;
import com.revature.bank.Service;

public class Presentation {
	
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
			// call the logIn method in the Service class
			System.out.println("login");
		} else if (option == 2) {
			// call the create new account method
		}
		
		

	}
		
	
}
