package frontend;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.AccountHolderDao;
import dao.AccountHolderDaoImpl;
import dao.AccountManagerDao;
import dao.AccountManagerDaoImpl;
import dao.TransactionDao;
import dao.TransactionDaoImpl;
import models.Account;
import models.AccountHandler;
import models.AccountManager2;
import models.Transaction;

public class Interface {

	private static Scanner sc = new Scanner(System.in);
	private static AccountHandler ah = new AccountHandler();
	private static TransactionDao td = new TransactionDaoImpl();
	private static AccountDao ad = new AccountDaoImpl();
	private static AccountManagerDao amd = new AccountManagerDaoImpl();
	private static AccountHolderDao ahd = new AccountHolderDaoImpl();

	public static void start() {
		boolean go = true;
		while (go) {
			String welcomeMessage = "Welcome to the terminal banking application! \nTo login press: 1.     To create an account press: 2.     To exit press: 3.";
			System.out.println(welcomeMessage);
			String input = sc.nextLine();
			switch (input) {
			case "1":
				login();
				break;
			case "2":
				createAccount();
				break;
			case "3":
				go = false;
				break;
			default:
				System.out.println("Operation not recognized.\n");
				break;
			}
		}
		System.out.println("\nThank you for using our services!");
	}

	public static void createAccount() {
		System.out.println("\nPlease enter your first name.");
		String firstName = sc.nextLine();
		System.out.println("Please enter your last name.");
		String lastName = sc.nextLine();
		System.out.println("Please enter your username.");
		String username = sc.nextLine();
		System.out.println("Please enter your password.");
		String password = sc.nextLine();
		System.out.println("Please re-enter your password.");
		String password2 = sc.nextLine();
		System.out.println("Please press 1 to select a Checking account or press 2 for a Savings account.");
		String accountChoice = sc.nextLine();
		if (firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0 && username != null
				&& username.length() > 0 && password != null && password.length() > 0 && (accountChoice.equals("1") || accountChoice.equals("2"))) {
			if (password.equals(password2)) {
				if (ah.createAccountHolder(username, password, firstName, lastName)) {
					int tempId = ad.getAccSeq();
					System.out.println("\nRetrieving account associated with user.");
					if (Integer.parseInt(accountChoice) == 1) {
					ad.createAccount(new Account(0));
					} else {
						ad.createAccount(new Account(1));
					}
					System.out.println("\nAssociating account with user.");
					amd.assignAccount(ad.getAccountByID(tempId), ahd.getAccountHolderByUsername(username));
					System.out.println("Account set up.\n");
				} else {
					System.out.println("Username is already present, unable to create account.\n");
				}
			} else {
				System.out.println("Passwords do not match.\n");
			}
		} else {
			System.out.println("Invalid input.\n");
		}
	}

	public static void login() {
		System.out.println("\nPlease enter your username.");
		String userName = sc.nextLine();
		System.out.println("Please enter your password.");
		String password = sc.nextLine();
		System.out.println("Retrieving account...");
		AccountManager2 am = ah.login(userName, password);
		if (am != null) {
			System.out.println("Successfully logged in.");
			boolean loggedIn = true;
			List<Account> list;
			while (loggedIn == true) {
				System.out.println("\nWelcome back " + am.getAccountHolder().getFirstname()
						+ ".\nTo make a deposit press: 1.     To make a withdrawal press: 2.     To view your accounts press: 3.     To access an existing account press: 4.	To view previous transactions press: 5.	To logout press 6.	To make a transfer press: 7.");
				String input = sc.nextLine();
				switch (input) {
				case "1":
					makeDeposit(am);
					break;
				case "2":
					makeWithdrawal(am);
					break;
				case "3":
					list = am.getAccounts();
					for (Account a : list) {

						if (a.getType() == 0) {

						}
						System.out.println(a);
					}
					break;
				case "4":
					System.out.println("Please enter the account id you are trying to access.");
					String accId = sc.nextLine();
					if (am.accessAccount(Integer.parseInt(accId))) {
						System.out.println("Account Successfully added.");
					} else {
						System.out.println("Unable to add account.");
					}
					break;
				case "5":
					getTransactions(am);
					break;
				case "6":
					loggedIn = false;
					am.logout();
					System.out.println("Successfully logged out!\n\n");
					break;
				case "7":
					makeTransfer(am);
					break;
				default:
					System.out.println("Invalid Input.");
					break;

				}
			}
		} else {
			System.out.println("Unable to login.\n");
		}
	}

	public static void makeDeposit(AccountManager2 am) {
		am.printAccounts();
		String accIds = sc.nextLine();
		if (accIds.matches("[0-9]+")) {
			Account temp = null;
			for (Account a : am.getAccounts()) {
				if (a.getId() == Integer.parseInt(accIds)) {
					temp = a;
				}
			}

			System.out.println("Please enter an amount. Press 'c' to cancel.");
			System.out.print("$");
			String input = sc.nextLine();
			if (Pattern.matches("\\d+(\\.\\d{1,2})?+", input)) {

				if (am.deposit(new BigDecimal(Double.parseDouble(input)), temp)) {
					System.out.println("Deposit completed, your new balance is: $"
							+ temp.getBalance().setScale(2, RoundingMode.CEILING) + ".\n");
				}
			} else if (input.equals("c")) {
				System.out.println("Transaction canceled.");
			} else {
				System.out.println("Invalid input.\n");
			}

		} else {
			System.out.println("Invalid input.\n");
		}

	}

	public static void makeWithdrawal(AccountManager2 am) {
		am.printAccounts();
		String accIds = sc.nextLine();
		if (Pattern.matches("[0-9]+", accIds)) {
			Account temp = null;
			for (Account a : am.getAccounts()) {
				if (a.getId() == Integer.parseInt(accIds)) {
					temp = a;
				}
			}
			System.out.println("Please enter an amount. Press 'c' to cancel.");
			System.out.print("$");
			String input = sc.nextLine();
			if (Pattern.matches("\\d+(\\.\\d{1,2})?+", input)) {
				if (am.withdraw(new BigDecimal(Double.parseDouble(input)), temp)) {
					System.out.println("Withdrawal completed, your new balance is: $"
							+ temp.getBalance().setScale(2, RoundingMode.CEILING) + ".\n");
				} else {
					System.out.println("Unable to complete transaction: insufficient funds.\n");
				}
			} else if (input.equals("c")) {
				System.out.println("Transaction canceled.");
			} else {
				System.out.println("Invalid input.\n");
			}
		}
	}

	public static void getTransactions(AccountManager2 am) {
		am.printAccounts();
		System.out.println("Press c to cancel.");
		String accIds = sc.nextLine();
		if (Pattern.matches("[0-9]+", accIds)) {
			Account temp = null;
			for (Account a : am.getAccounts()) {
				if (a.getId() == Integer.parseInt(accIds)) {
					temp = a;
				}
			}
			List<Transaction> list = td.getTransactionForAccount(temp);
			for (Transaction t : list) {
				System.out.println(t);
			}
		} else if (accIds.equals("c")) {
			System.out.println("Transaction canceled.");
		} else {
			System.out.println("Invalid input.\n");
		}
	}

	public static boolean makeTransfer(AccountManager2 am) {
		am.printAccounts();
		String accIds = sc.nextLine();
		if (Pattern.matches("[0-9]+", accIds)) {
			Account temp = null;
			for (Account a : am.getAccounts()) {
				if (a.getId() == Integer.parseInt(accIds)) {
					temp = a;
				}
			}
			System.out.println("Please enter the id of the account for the transfer:");
			String accIds1 = sc.nextLine();
			if (Pattern.matches("[0-9]+", accIds1)) {
				Account temp1 = null;
				temp1 = ad.getAccountByID(Integer.parseInt(accIds1));
				if (temp1 == null) {
					System.out.println("Account not found.");
					return false;
				}
				System.out.println("Please enter an amount. Press 'c' to cancel.");
				System.out.print("$");
				String input = sc.nextLine();
				if (Pattern.matches("\\d+(\\.\\d{1,2})?+", input)) {
					if (am.transfer(new BigDecimal(Double.parseDouble(input)), temp, temp1)) {
						System.out.println("Transfer completed, your new balance is: $"
								+ temp.getBalance().setScale(2, RoundingMode.CEILING) + ".\n");
					} else {
						System.out.println("Unable to complete transaction: insufficient funds.\n");
					}
				} else if (input.equals("c")) {
					System.out.println("Transaction canceled.");
				} else {
					System.out.println("Invalid input.\n");
				}
			}
		}
		return true;
	}
}