package com.revature.banking;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	static String dbPath = "src/com/revature/banking/db.txt";
	Scanner scanner = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit;

	public static void main(String[] args) {
		Menu m = new Menu();
		m.runMenu();
		
	}

	public void runMenu() {
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}

	private void printHeader() {
		System.out.println("+-------------------------------------+");
		System.out.println("|             Welcome to              |");
		System.out.println("|            Revature Bank            |");
		System.out.println("+-------------------------------------+");
	}

	private void printMenu() {
		System.out.println("Please make a selection:");
		System.out.println("1) Create a new account");
		System.out.println("2) Make a deposit");
		System.out.println("3) Make a withdrawal");
		System.out.println("4) List account balance");
		System.out.println("0) Exit");
	}

	private int getInput() {
		int choice = -1;
		do {
			System.out.println("Enter your choice: ");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid selection. Numbers only please.");
			}
			if(choice < 0 || choice > 4) {
				System.out.println("Choice is outside of range. Please chose again.");
			}
		} while (choice < 0 || choice > 4);
		return choice;
	}



	private void performAction(int choice) {
		switch (choice) {
		case 0:
			System.out.println("Thank you for using our application.");
			System.exit(0);
			break;
		case 1:
			createAnAccount();
			break;
		case 2:
			makeADeposit();
			break;
		case 3:
			makeAWithdrawal();
			break;
		case 4:
			ListBalances();
			break;
		default:
			System.out.println("Unknown error has occured.");
		}

	}

	private void createAnAccount() {
		String userName, password, accountType = "";
		double initialDeposit = 0;
		boolean valid = false;
		while(!valid) {
			System.out.println("Please enter an account type(checking/savings): ");
			accountType = scanner.nextLine();
			if(accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")) {
				valid = true;
			} else {
				System.out.println("Invalid account type selected. Please enter checking or savings.");
			}
		}
		System.out.println("Please enter your username: ");
		userName = scanner.nextLine();
		System.out.println("Please enter your password");
		password = scanner.nextLine();
		valid = false;
		while(!valid) {
			System.out.print("Please enter an initial deposit: ");
			try {
				initialDeposit = Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Deposit must be a number.");
			}
			if (accountType.equalsIgnoreCase("checking")) {
				if(initialDeposit < 100) {
					System.out.println("Checking accounts required a minimum of $100 dollars to open");
				} else {
					valid = true;
				}
			}
			if (accountType.equalsIgnoreCase("savings")) {
				if(initialDeposit < 50) {
					System.out.println("Savings accounts required a minimum of $50 dollars to open");
				} else {
					valid = true;
				}
			}
		}

		Account account;
		if (accountType.equalsIgnoreCase("checking")) {
			account = new Checking(initialDeposit);
		} else {
			account = new Savings(initialDeposit);
		}
		Customer customer = new Customer(userName, password, account);
		bank.addCustomer(customer);
		writeCustomerToDatabase(userName, password, account);
	}
	
	private void makeADeposit() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.println("How much would you like to deposit?: ");
			double amount = 0;
			try {
				amount = Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				amount = 0;
			}
			bank.getCustomer(account).getAccount().deposit(amount);
		}
	}
	
	

	private void makeAWithdrawal() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.println("How much would you like to withdraw?: ");
			double amount = 0;
			try {
				amount = Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				amount = 0;
			}
			bank.getCustomer(account).getAccount().withdraw(amount);
		}

	}

	private void ListBalances() {
		int account = selectAccount();
		if(account >= 0) {
			System.out.println(bank.getCustomer(account).getAccount());;
		}
	}

	private int selectAccount() {
		ArrayList<Customer> customers = bank.getCustomers();
		if(customers.size() <= 0) {
			System.out.println("No customers at your bank.");
			return -1;
		}
		System.out.println("Select an account:");
		for(int i = 0; i < customers.size(); i++) {
			System.out.println((i+1) + ") " + customers.get(i).basicInfo());
		}
		int account = 0;
		System.out.print("Please enter your selection: ");
		try {
			account = Integer.parseInt(scanner.nextLine()) - 1;
		} catch (NumberFormatException e) {
			account = -1;
		}
		if(account < 0 || account > customers.size()) {
			System.out.println("Invalid account selected");
			account = -1;
		}
		return account;
	}

	public static void writeCustomerToDatabase(String userName, String password, Account account) {

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(dbPath));){
			bw.write("Username: " + userName);
			bw.write("\n Password: " + password);
//			bw.append("\n Account: " + account);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
