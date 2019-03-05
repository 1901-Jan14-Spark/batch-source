package com.Bank;

import java.util.Observable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankView extends Observable {

	private Scanner SC;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private double checking;
	private double saving;
	private double enterdValue;
	private boolean status;
	private String enterdUsername;
	private String logedinAs;
	private boolean userNameExists;

	BankView() {
		super();
		SC = new Scanner(System.in);
		this.setLogedinAs(null);

	}

	public BankView(String userName, String firstName, String lastName, String password, double checking,
			double saving) {
		super();
		SC = new Scanner(System.in);
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.checking = checking;
		this.saving = saving;
	}

	public String getEnterdUsername() {
		return enterdUsername;
	}

	public void setEnterdUsername(String enterdUsername) {
		this.enterdUsername = enterdUsername;
	}

	public void rootPage() {

		splashPage();
		handleLogInOption();

		if (this.getLogedinAs() != null) {
			homePage();
		}

	}

	public void splashPage() {

		System.out.println("----------------------------------------------------------------------------------\n"
				+ "                  Welcome to Bank of Ruptcy");
		System.out.println("\n          Please Choose from the following option:");

	}

	public void homePage() {

		System.out.println("----------------------------------------------------------------------------------\n"
				+ "                           HomePage");
		System.out.println("\n Logged in as " + userName + "                                    Welcome home "
				+ firstName + " " + lastName);

		System.out.println("\n         Your Checking Balance - " + checking
				+ "                    Your Saving Balance + " + saving);

		System.out.println("\n         Press:\n            [X] - Deposit  [Y] - Withdraw  [E] - Logout ");

		loggedInMainMenu();
	}

	private void loggedInMainMenu() {

		String transactionChoice = SC.nextLine();

		while (!transactionChoice.equals("x") && !transactionChoice.equals("y") && !transactionChoice.equals("X")
				&& !transactionChoice.equals("Y") && !transactionChoice.equals("E") && !transactionChoice.equals("e")) {
			System.out.println("               Please Enter the right choice or press E to end the apllication");
			transactionChoice = SC.nextLine();
		}

		if (transactionChoice.equals("x") || transactionChoice.equals("X")) {
			depositMainMenu();

		} else if (transactionChoice.equals("y") || transactionChoice.equals("Y")) {
			withdrawMainMenu();
		} else if (transactionChoice.equals("e") || transactionChoice.equals("E")) {
			logout();
		} else {
			System.out.println("unexpected error occured, returning back to menu");
			handleLogInOption();

		}

	}

	private void depositMainMenu() {

		System.out.println(
				"\n         Press:\n            [X] - Deposit in to Checking  [Z] - Deposit in to Saving  [E] - Logout ");
		String transactionChoice = SC.nextLine();
		while (!transactionChoice.equals("X") && !transactionChoice.equals("x") && !transactionChoice.equals("Z")
				&& !transactionChoice.equals("z") && !transactionChoice.equals("E") && !transactionChoice.equals("e")) {
			System.out.println("               Please Enter the right choice or press E to end the apllication");
			transactionChoice = SC.nextLine();
		}

		if (transactionChoice.equals("x") || transactionChoice.equals("X")) {
			depositMenuChecking();
		} else if (transactionChoice.equals("e") || transactionChoice.equals("E")) {
			logout();
		} else if (transactionChoice.equals("z") || transactionChoice.equals("Z")) {
			depositMenuSaving();
		} else {
			System.out.println("unexpected error occured, returning back to menu");
			handleLogInOption();

		}

	}

	private void withdrawMainMenu() {

		System.out.println(
				"\n         Press:\n            [X] - Withdraw From Checking  [Z] - Withdarw From Saving  [E] - Logout ");
		String transactionChoice = SC.nextLine();
		while (!transactionChoice.equals("X") && !transactionChoice.equals("x") && !transactionChoice.equals("Z")
				&& !transactionChoice.equals("z") && !transactionChoice.equals("E") && !transactionChoice.equals("e")) {
			System.out.println("               Please Enter the right choice or press E to end the apllication");
			transactionChoice = SC.nextLine();
		}

		if (transactionChoice.equals("x") || transactionChoice.equals("X")) {
			withdrawFromChecking();
		} else if (transactionChoice.equals("e") || transactionChoice.equals("E")) {
			logout();
		} else if (transactionChoice.equals("z") || transactionChoice.equals("Z")) {
			withdrawFromSaving();
		} else {
			System.out.println("unexpected error occured, returning back to menu");
			handleLogInOption();

		}

	}

	private void depositMenuSaving() {

		System.out.print("Deposit: \n ");
		this.enterdValue = validateInt();

		setChanged();
		notifyObservers("depositAmountSaving");

		System.out.println("\n Transaction status: ");
		System.out.println(status ? " success" : " fail");

		System.out.println("\n New Balance Amount: ");
		System.out.println(" " + this.saving);

		// update profile balance
		this.enterdValue = this.saving;
		setChanged();
		notifyObservers("updateBalance");

		homePage();

	}

	private void depositMenuChecking() {

		System.out.print("Deposit: \n ");
		this.enterdValue = validateInt();

		setChanged();
		notifyObservers("depositAmountChecking");
		System.out.println("\n Transaction status: ");
		System.out.println(status ? " success" : " fail");

		System.out.println("\n New Balance Amount: ");
		System.out.println(" " + this.checking);

		// update profile balance
		this.enterdValue = this.checking;
		setChanged();
		notifyObservers("updateBalance");

		homePage();

	}

	private void withdrawFromChecking() {

		System.out.print("Withdraw: \n ");

		this.enterdValue = validateInt();

		setChanged();
		notifyObservers("withdrawFromChecking");
		System.out.println("\n Transaction status: ");
		System.out.println(status ? " success" : " insufficient funds");

		// ask to save new balance if

		System.out.println("\n New Balance Amount: ");
		System.out.println(" " + this.checking);

		homePage();

	}

	private void withdrawFromSaving() {

		System.out.print("Withdraw: \n ");
		// post enterred value to global var to be picked up by controller
		this.enterdValue = validateInt();

		setChanged();
		notifyObservers("withdrawFromSaving");
		System.out.println("\n Transaction status: ");
		System.out.println(status ? " success" : " insufficient funds");

		// ask to save new balance if

		System.out.println("\n New Balance Amount: ");
		System.out.println(" " + this.saving);

		homePage();

	}

	public int validateInt() {

		int value;
		do {
			System.out.print("Please enter the amount ");
			while (!SC.hasNextInt()) {
				String input = SC.next();
				System.out.printf("\"%s\" is not a valid entry.\n", input);
			}
			value = SC.nextInt();
		} while (value < 0);

		System.out.printf("You have entered an amoount of %d.\n", value);

		return value;
	}

	public void handleLogInOption() {

		System.out.println("\n         Press:\n            [x] - Create Account  [Y] - Log IN");

		String logInChoice = SC.nextLine();

		System.out.println(logInChoice);

		while (!logInChoice.equals("x") && !logInChoice.equals("y") && !logInChoice.equals("X")
				&& !logInChoice.equals("Y") && !logInChoice.equals("e") && !logInChoice.equals("E")) {
			System.out.println("               Please Enter the right choice or press E to end the apllication");
			logInChoice = SC.nextLine();
		}

		if (logInChoice.equals("x") || logInChoice.equals("X")) {
			createAccountPage();

		} else if (logInChoice.equals("y") || logInChoice.equals("Y")) {
			logInmenuCheckUsername();
		} else if (logInChoice.equals("e") || logInChoice.equals("E")) {
			logout();
		} else {
			System.out.println("unexpected error occured, returning back to menu");
			handleLogInOption();

		}

	}

	public boolean logInmenuCheckPassword() {
		System.out.println("\n         Please enter your password");

		String enterdPassword = SC.nextLine();

		if (!validateUsernameString(enterdPassword)) {
			System.out.println("\n      Invalid entry, please try again");
			logInmenuCheckPassword();

		}

		if (password.contains(enterdPassword)) {

			return true;

		}

		return false;

	}

	public void logInmenuCheckUsername() {
		System.out.println("\n         Please enter your credentials and press enter");

		String userNameT = SC.nextLine();

		// check for invalid entry
		if (!validateUsernameString(userNameT)) {
			System.out.println("\n      Invalid entry, please try again");
			logInmenuCheckUsername();

		}
		this.enterdUsername = userNameT;
		setChanged();
		notifyObservers("logIn");

	}

	public void createAccountPage() {

		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		System.out.println(
				"\n      Thank you for choosing Bank of Ruptcy where you know your money is always safe with us. \n"
						+ "               As a token of appreciation we will deposit a free 10$ on your new account.\n"
						+ "                   Just follow directions to create and start your new account!! \n"
						+ " \n                   Please enter your First Name and last name \n    ");

		String name = SC.nextLine();

		validateandSetName(name);
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		System.out.println("\n                       Please enter a 6 or more digits new password: ");
		String password = SC.nextLine();
		validateAndSetPassword(password);
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		System.out.println("\n       Please enter a prefered username that includes only numbers and letters ");

		validateAndSetUserName();

		this.checking = 10;
		setChanged();
		notifyObservers("CreateNewAccount");
		System.out.println("\n       Account Page Created!! transferring you to your new homepage!!!... ");

	}

	private void logout() {

		// call controller to clear out session object
		setChanged();
		notifyObservers("loggedout");

		rootPage();

	}

	private void validateAndSetUserName() {

		String userNameT = SC.nextLine();

		while (!validateUsernameString(userNameT)) {
			System.out.println("       Invalid Input, please enter text with letters/numbers");
			userNameT = SC.nextLine();

		}
		// check to see if username already exists
		this.enterdUsername = userNameT;

		setChanged();
		notifyObservers("checkUserNameExist");

		// if its false then we can assign the user to new username

		System.out.println("printing result" + this.isUserNameExists());

		// check username logic
		if (this.isUserNameExists() == false) {

			this.userName = userNameT;
			this.setLogedinAs(userNameT);

		} // else tell the user to use another user name
		else {

			System.out.println("       Sorry, the username is taken, choose another one");
			validateAndSetUserName();
		}

		System.out.println(userNameT);
	}

	public boolean validateUsernameString(String userName) {

		if (!userName.matches("[a-zA-Z0-9]*")) {

			return false;
		}
		return true;

	}

	public void validateandSetName(String name) {

		while (name.split(" ").length != 2) {
			System.out
					.println("       Incorrect format. Please enter again in the following format: firstname lastname");
			name = SC.nextLine();

		}
		String[] splitName = name.split(" ");
		String firstNameT = splitName[0];
		String lastNameT = splitName[1];

		if (!validateNameString(firstNameT) || !validateNameString(lastNameT)) {
			System.out.println("       Invalid entry, please try again");
			name = SC.nextLine();
			validateandSetName(name);
		}

		setFirstName(firstNameT);
		setLastName(lastNameT);

	}

	public boolean validateNameString(String userName) {

		if (!userName.matches("[a-zA-Z]*")) {

			return false;
		}
		return true;

	}

	public void validateAndSetPassword(String passwordArg) {

		while (passwordArg.split(" ").length != 1) {
			System.out.println("       Password cannot be empty or have space, please enter a valid password");
			passwordArg = SC.nextLine();

		}

		while (passwordArg.length() < 6) {

			if (passwordArg.split(" ").length != 1) {
				validateAndSetPassword(passwordArg);
			}

			System.out.println("       Plesae enter a 6 or more characters password");
			passwordArg = SC.nextLine();

		}

		setPassword(passwordArg);

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {

		return userName;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public double getEnterdValue() {
		return enterdValue;
	}

	public void setEnterdValue(double enterdValue) {
		this.enterdValue = enterdValue;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getLogedinAs() {
		return logedinAs;
	}

	public void setLogedinAs(String logedinAs) {
		this.logedinAs = logedinAs;
	}

	public boolean isUserNameExists() {
		return userNameExists;
	}

	public void setUserNameExists(boolean userNameExists) {
		this.userNameExists = userNameExists;
	}

	public double getChecking() {
		return checking;
	}

	public void setChecking(double checking) {
		this.checking = checking;
	}

	public double getSaving() {
		return saving;
	}

	public void setSaving(double saving) {
		this.saving = saving;
	}

}