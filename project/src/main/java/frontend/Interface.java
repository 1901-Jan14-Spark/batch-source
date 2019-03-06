package frontend;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

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
import util.InputValidator;

public class Interface {

	private static Scanner sc = new Scanner(System.in);
	private static AccountHandler ah = new AccountHandler();
	private static TransactionDao td = new TransactionDaoImpl();
	private static AccountDao ad = new AccountDaoImpl();
	private static AccountManagerDao amd = new AccountManagerDaoImpl();
	private static AccountHolderDao ahd = new AccountHolderDaoImpl();
	static Logger log = Logger.getRootLogger();

	public static void start() {
		boolean go = true;
		while (go) {
			log.info("Welcome to the terminal banking application!"
					+ "\n----------------------------------------------------------------- "
					+ "\n\t- To login press: 1.\n\t- To create an account press: 2.\n\t- To exit press: 3.");
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
				log.info("Operation not recognized.\n");
				break;
			}
		}
		log.info("\n-----------------------------------------------------------------\n"
				+ "Thank you for using our services!");
	}

	public static boolean createAccount() {
		log.info("\n - Please enter your first name.");
		String firstName = sc.nextLine();
		if (!InputValidator.validateName(firstName)) {
			log.warn("Name should only be comprised of characters.\n");
			return false;
		}
		log.info(" - Please enter your last name.");
		String lastName = sc.nextLine();
		if (!InputValidator.validateName(lastName)) {
			log.warn("Name should only be comprised of characters.\n");
			return false;
		}
		log.info(" - Please enter your username.(At least 5 characters.)");
		String username = sc.nextLine();
		if (!InputValidator.validateUser(username)) {
			log.warn("Username should only be comprised of characters and numbers.(At least 5 characters.)\n");
			return false;
		}
		log.info(" - Please enter your password.\n\t-Must be longer than 6 characters."
				+ "\n\t-Must contain at least an uppercase character. \n\t-Lowercase character, a number.\n");
		String password = sc.nextLine();
		if (!InputValidator.validatePassword(password)) {
			log.warn("Invalid password.");
			return false;
		}
		log.info(" - Please re-enter your password.");
		String password2 = sc.nextLine();
		if (!password2.equals(password)) {
			log.info("Passwords do not match.\n");
			return false;
		}
		log.info(" - Press '1' to create a Checking account or press '2' for a Savings account.");
		String accountChoice = sc.nextLine();
		if (!(accountChoice.equals("1") || accountChoice.equals("2"))) {
			log.warn("Invalid input, requires either '1' or '2'.\n");
			return false;
		}
		log.info("\n... Creating user.");
		if (ah.createAccountHolder(username, password, firstName, lastName)) {
			int tempId = ad.getAccSeq();
			log.info("... Retrieving account associated with user.");
			if (Integer.parseInt(accountChoice) == 1) {
				ad.createAccount(new Account(0));
			} else {
				ad.createAccount(new Account(1));
			}
			log.info("... Associating account with user.");
			amd.assignAccount(ad.getAccountByID(tempId), ahd.getAccountHolderByUsername(username));
			log.info("... Account set up.\n");
		} else {
			log.info("Username is already present, unable to create account.\n");
			return false;
		}
		return true;
	}

	public static boolean login() {
		log.info("\n - Please enter your username.");
		String userName = sc.nextLine();
		log.info(" - Please enter your password.");
		String password = sc.nextLine();
		
		log.info("Retrieving account...");
		AccountManager2 am = ah.login(userName, password);
		
		if (am == null) {
			log.warn("Unable to login.\n");
			return false;
		}
		
		log.info("Successfully logged in.");
		
		boolean loggedIn = true;
		List<Account> list;
		
		while (loggedIn == true) {
			log.info("\nWelcome back " + am.getAccountHolder().getFirstname()
					+ ".\n-----------------------------------------------------------------\n\t- To make a transaction press: 1.\n\t- For account operations press: 2.\n\t- To view your accounts press: 3.\n\t- To log out press: 4.");
			String input = sc.nextLine();
			switch (input) {
			case "1":
				log.info(
						"\n\t- To make a deposit press: 1.\n\t- To make a withdrawal press: 2.\n\t- To make a transfer press: 3.\n\t- To go back, press: 4.\n");
				String input2 = sc.nextLine();
				switch (input2) {
				case "1":
					makeDeposit(am);
					break;
				case "2":
					makeWithdrawal(am);
					break;
				case "3":
					makeTransfer(am);
					break;
				default:
					break;
				}
				break;
			case "2":
				log.info(
						"\n\t- To create a separate account press: 1.\n\t- To join an account press: 2.\n\t- To view your previous transactions press: 3.\n\t- To go back, press: 4.\n");
				String input3 = sc.nextLine();
				switch (input3) {
				case "1":
					log.info(" - Please press 1 to create a Checking account or press 2 for a Savings account.");
					String accountChoice1 = sc.nextLine();
					int accountC = Integer.parseInt(accountChoice1);
					int tempId = ad.getAccSeq();
					createAccount(accountC, am);
					break;
				case "2":
					log.info("Please enter the account id of the account to be joined.");
					String accId = sc.nextLine();
					if (am.accessAccount(Integer.parseInt(accId))) {
						log.info("Account Successfully added.");
					} else {
						log.warn("Unable to add account.");
					}
					break;
				case "3":
					getTransactions(am);
					break;
				default:
					break;
				}
				break;
			case "3":
				list = am.getAccounts();
				for (Account a : list) {

					if (a.getType() == 0) {

					}
					log.info(a);
				}
				break;
			case "4":
				loggedIn = false;
				am.logout();
				log.info("Successfully logged out!\n\n");
				break;
			default:
				log.info("Invalid Input.\n");
				break;

			}
		}

		return true;
	}

	
	public static boolean createAccount(int account, AccountManager2 am) {
		int tempId = ad.getAccSeq();
		log.info("\n... Retrieving account associated with user.");
		if (account == 1) {
			ad.createAccount(new Account(0));
		} else {
			ad.createAccount(new Account(1));
		}
		log.info("... Associating account with user.");
		amd.assignAccount(ad.getAccountByID(tempId),
				ahd.getAccountHolderByUsername(am.getAccountHolder().getUsername()));
		log.info("... Account set up.\n");
		return true;
	}
	public static boolean makeDeposit(AccountManager2 am) {
		am.printAccounts();
		String accIds = sc.nextLine();
		if (accIds.matches("[0-9]+")) {
			Account temp = null;
			for (Account a : am.getAccounts()) {
				if (a.getId() == Integer.parseInt(accIds)) {
					temp = a;
				}
			}
			if (temp == null) {
				log.warn("Unable to retrieve account.");
				return false;
			}
			log.info("Please enter an amount. Press 'c' to cancel.");
			System.out.print("$");
			String input = sc.nextLine();
			if (Pattern.matches("\\d+(\\.\\d{1,2})?+", input)) {

				if (am.deposit(new BigDecimal(Double.parseDouble(input)), temp)) {
					log.info("Deposit completed, your new balance is: $"
							+ temp.getBalance().setScale(2, RoundingMode.CEILING) + ".\n");
				}
			} else if (input.equals("c")) {
				log.info("Transaction canceled.");
			} else {
				log.warn("Invalid input.\n");
			}

		} else {
			log.warn("Invalid input.\n");
		}

		return true;
	}

	public static boolean makeWithdrawal(AccountManager2 am) {
		am.printAccounts();
		String accIds = sc.nextLine();
		if (Pattern.matches("[0-9]+", accIds)) {
			Account temp = null;
			for (Account a : am.getAccounts()) {
				if (a.getId() == Integer.parseInt(accIds)) {
					temp = a;
				}
			}
			if (temp == null) {
				log.warn("Unable to retrieve account.");
				return false;
			}
			log.info("Please enter an amount. Press 'c' to cancel.");
			System.out.print("$");
			String input = sc.nextLine();
			if (Pattern.matches("\\d+(\\.\\d{1,2})?+", input)) {
				if (am.withdraw(new BigDecimal(Double.parseDouble(input)), temp)) {
					log.info("Withdrawal completed, your new balance is: $"
							+ temp.getBalance().setScale(2, RoundingMode.CEILING) + ".\n");
				} else {
					log.info("Unable to complete transaction: insufficient funds.\n");
				}
			} else if (input.equals("c")) {
				log.info("Transaction canceled.");
			} else {
				log.warn("Invalid input.\n");
			}
		}
		return true;
	}

	public static boolean getTransactions(AccountManager2 am) {
		am.printAccounts();
		log.info("Press c to cancel.");
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
				log.info(t);
			}
		} else if (accIds.equals("c")) {
			log.info("Transaction canceled.");
		} else {
			log.warn("Invalid input.\n");
			return false;
		}
		return true;
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
			if (temp == null) {
				log.info("Unable to retrieve account.");
				return false;
			}
			log.info("Please enter the id of the account for the transfer:");
			String accIds1 = sc.nextLine();
			if (Pattern.matches("[0-9]+", accIds1)) {
				Account temp1 = null;
				temp1 = ad.getAccountByID(Integer.parseInt(accIds1));
				if (temp1 == null) {
					log.warn("Account not found.");
					return false;
				}
				log.info("Please enter an amount. Press 'c' to cancel.");
				System.out.print("$");
				String input = sc.nextLine();
				if (Pattern.matches("\\d+(\\.\\d{1,2})?+", input)) {
					if (am.transfer(new BigDecimal(Double.parseDouble(input)), temp, temp1)) {
						log.info("Transfer completed, your new balance is: $"
								+ temp.getBalance().setScale(2, RoundingMode.CEILING) + ".\n");
					} else {
						log.fatal("Unable to complete transaction: insufficient funds.\n");
					}
				} else if (input.equals("c")) {
					log.info("Transaction canceled.");
				} else {
					log.warn("Invalid input.\n");
				}
			}
		}
		return true;
	}
}