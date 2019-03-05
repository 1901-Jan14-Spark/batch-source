package frontend;

import java.util.Scanner;
import java.util.regex.Pattern;

import models.AccountHandler;
import models.AccountManager;

public class Interface {

//	private static Scanner sc = new Scanner(System.in);
//	private static AccountHandler ah = new AccountHandler();
//
//	public static void start() {
//		boolean go = true;
//		while (go) {
//			String welcomeMessage = "Welcome to the terminal banking application! \nTo login press: 1.     To create an account press: 2.     To exit press: 3.";
//			System.out.println(welcomeMessage);
//			String input = sc.nextLine();
//			switch (input) {
//			case "1":
//				login();
//				break;
//			case "2":
//				createAccount();
//				break;
//			case "3":
//				go = false;
//				break;
//			default:
//				System.out.println("Operation not recognized.\n");
//				break;
//			}
//		}
//		System.out.println("\nThank you for using our services!");
//	}
//
//	public static void createAccount() {
//		System.out.println("\nPlease enter your first name.");
//		String firstName = sc.nextLine();
//		System.out.println("Please enter your last name.");
//		String lastName = sc.nextLine();
//		System.out.println("Please enter your username.");
//		String username = sc.nextLine();
//		System.out.println("Please enter your password.");
//		String password = sc.nextLine();
//		System.out.println("Please re-enter your password.");
//		String password2 = sc.nextLine();
//		if (firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0 && username != null
//				&& username.length() > 0 && password != null && password.length() > 0) {
//			if (password.equals(password2)) {
//				if (ah.createAccount(firstName, lastName, username, password)) {
//					System.out.println("Account Created.\n");
//				} else {
//					System.out.println("Username is already present, unable to create account.\n");
//				}
//			} else {
//				System.out.println("Passwords do not match.\n");
//			}
//		} else {
//			System.out.println("Invalid input.\n");
//		}
//	}
//
//	public static void login() {
//		System.out.println("\nPlease enter your username.");
//		String userName = sc.nextLine();
//		System.out.println("Please enter your password.");
//		String password = sc.nextLine();
//		AccountManager am = ah.login(userName, password);
//		if (am != null) {
//			boolean loggedIn = true;
//			while (loggedIn == true) {
//				System.out.println("\nWelcome back " + am.getName()
//						+ ".\nTo make a deposit press: 1.     To make a withdrawal press: 2.     To view your balance press: 3.     To logout press 4.");
//				String input = sc.nextLine();
//				switch (input) {
//				case "1":
//					makeDeposit(am);
//					break;
//				case "2":
//					makeWithdrawal(am);
//					break;
//				case "3":
//					System.out.println("\nYour balance is: $" + am.getBalance() + ".\n");
//					break;
//				case "4":
//					loggedIn = false;
//					am.logout();
//					break;
//				default:
//					System.out.println("Invalid Input.");
//					break;
//
//				}
//			}
//		} else {
//			System.out.println("Unable to login.\n");
//		}
//	}
//
//	public static void makeDeposit(AccountManager am) {
//		System.out.println("Please enter an amount. Press 'c' to cancel.");
//		System.out.print("$");
//		String input = sc.nextLine();
//		if (Pattern.matches("\\d+(\\.\\d{1,2})?+", input)) {
//			
//			if (am.deposit(Double.parseDouble(input))) {
//				System.out.println("Deposit completed, your new balance is: $" + am.getBalance() + ".\n");
//			}
//		} else if (input.equals("c")) {
//			System.out.println("Transaction canceled.");
//		} else {
//			System.out.println("Invalid input.\n");
//		}
//	}
//
//	public static void makeWithdrawal(AccountManager am) {
//		System.out.println("Please enter an amount. Press 'c' to cancel.");
//		System.out.print("$");
//		String input = sc.nextLine();
//		if (Pattern.matches("\\d+(\\.\\d{1,2})?+", input)) {
//			if (am.withdraw((double)(Math.round(Double.parseDouble(input)*100))/100)) {
//				System.out.println("Withdrawal completed, your new balance is: $" + am.getBalance() + ".\n");
//			} else {
//				System.out.println("Unable to complete transaction: insufficient funds.\n");
//			}
//		} else if (input.equals("c")) {
//			System.out.println("Transaction canceled.");
//		} else {
//			System.out.println("Invalid input.\n");
//		}
//	}
}
