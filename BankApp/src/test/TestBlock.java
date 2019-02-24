package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import application.FileEdit;

public class TestBlock {
	static String path = "src/storage/users.txt";
	static Scanner scan = new Scanner(System.in);
	
	public static void UserAccount(String userName) {
		System.out.println("\nSuccessfully logged in.");
		String option = "", confirm="";
		while(!option.equals("l")) {
			System.out.println("Welcome "+userName);
			String balance = FileEdit.readBalance(userName);
			System.out.println("Current balance: $"+balance);
			
			System.out.println("\nPlease select an option:");
			System.out.println("(d) Deposit.");
			System.out.println("(w) Withdraw.");
			System.out.println("(l) Log out.");
			option = scan.nextLine();
			
			switch(option) {
			case "d":
				System.out.println("\nDeposit option selected.");
				double amount = 0;
				boolean valid = false;
				while(!valid) {
				System.out.println("\nEnter amount to deposit: ");
					valid = scan.hasNextDouble();
					if(valid) {
						amount = scan.nextDouble();
					}
					else {
						System.out.println("Invalid input.");
						scan.nextLine();
					}
				}
				System.out.println("\nConfirm deposit amount: "+amount+" (y/n)?");
				confirm = scan.nextLine();
				if(confirm == "y") {
					System.out.println("confirm block tripped");
				}
				break;
			case "w":
				System.out.println("\nWithdraw option selected.\n");
				break;
			case "l":
				System.out.println("\nSuccessfully logged out.\n");
				break;
			default:
				System.out.println("Invalid selection.");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		UserAccount("andy");
	}

}
