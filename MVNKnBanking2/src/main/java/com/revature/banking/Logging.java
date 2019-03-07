
package com.revature.banking;


import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.dao.AccountsHolderDao;
import com.revature.dao.AccountsHolderDaoImpl;
import com.revature.dao.CheckingAccountDao;
import com.revature.dao.CheckingAccountDaoImpl;
import com.revature.dao.SavingAccountDao;
import com.revature.dao.SavingAccountDaoImpl;
import com.revature.model.AccountsHolder;
import com.revature.model.CheckingAccount;
import com.revature.model.SavingAccount;

public class Logging  {

	private static Logger log = Logger.getRootLogger();

	static Scanner reader = new Scanner(System.in);

	static AccountsHolderDao a = new AccountsHolderDaoImpl();
	static CheckingAccountDao ca = new CheckingAccountDaoImpl();
	static SavingAccountDao sa = new SavingAccountDaoImpl();

	static AccountsHolder temp;
	
	public static boolean passVerification(String userPass) {
		if(userPass.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$")){
			return true;
		}else {
			return false;
		}
	}
	


	public static void createUser() {
		log.info("Please enter your prefered username :");
		String user = reader.nextLine();
		if(user.length()<8) {
			log.info("Please enter a valid username of at least 8 Characters : ");
			user= reader.nextLine();
		}
		log.info("Please enter your new Password: ");
		String password = reader.nextLine();
		passVerification(password);
		log.info("Please enter your please confirm new Password : ");
		String passwordConfirm = reader.nextLine();
		while(!passwordConfirm.matches(password)) {
			log.info("Passwords didn't match or invalid choice please re-enter ");
			log.info("Please enter your new Password: ");
			password = reader.nextLine();
			log.info("Please enter your please confirm new Password : ");
			passwordConfirm = reader.nextLine();
		}
		log.info("Thanks for registering please Login as "+user );
		CheckingAccount ctest = new CheckingAccount((long) (Math.random()*999999999), 0);
		SavingAccount stest = new SavingAccount((long) (Math.random()*999999999), 0);
		temp = new AccountsHolder(user, password, ctest.getCheckAcocuntNum(), stest.getSavingAcocuntNum() );
		ca.createCAccount(ctest);
		sa.createSAccount(stest);
		a.createUser(temp);
		logInUser();
	}

	public static void logInUser() {
		log.info("Welcome to KnBanking thank you for choosing us for your financial needs. ");
		log.info("Existing Users type Login");
		log.info("New Users please type Register");
		String checkLogginIn = reader.nextLine();
		if(checkLogginIn.equals("Login")) {
			log.info("Please sumbit both username and password");
			log.info("Enter Username: ");
		} else if(checkLogginIn.equals("Register")) {
			createUser();
		} else if((!checkLogginIn.matches("Login"))||(!checkLogginIn.matches("Register"))) {
			log.info("Please insert a valid Input.");
			logInUser();
		}

		String loggingIn = reader.nextLine();
		log.info("Please Enter Password:");
		String loggingPass = reader.nextLine();
		AccountsHolder loggedInAccountsHolder = a.validate(loggingIn,loggingPass);
		while(loggedInAccountsHolder == null) {
			log.info("Password & Username didn't match try again.");
			log.info("Enter Username : ");
			loggingIn = reader.nextLine();
			log.info("Please Enter Password :");
			loggingPass = reader.nextLine();
			loggedInAccountsHolder = a.validate(loggingIn,loggingPass);
			System.out.println("Loggingin : "+ loggingIn);
			System.out.println("LoggingPass : "+ loggingPass);
			System.out.println(loggedInAccountsHolder);
		}
		temp = loggedInAccountsHolder;
		System.out.println("Loggingin : "+ loggingIn);
		System.out.println("LoggingPass : "+ loggingPass);
		log.info("Login Successful Welcome "+loggingIn);
		traverseBankApp();
	}

	public static void traverseBankApp() {
		log.info("What financial help my we provide today?");
		log.info("Current Checking Balance: $"+temp.getCaObject().getCheckBalance() +". Current Savings Balance: $" + temp.getSaObject().getSaveBalance());
		log.info(">  Checking");
		log.info(">  Saving");
		log.info(">  Logout");
		String option = reader.nextLine();
		if(option.matches("Checking")) {
			log.info(">  Deposit");
			log.info(">  Withdraw");
			String option2 = reader.nextLine();
			if(option2.matches("Deposit")) {
				log.info("How much would you like to Deposit to Account");
				String transAmount = reader.nextLine();
				double balanceChange = Double.parseDouble(transAmount);
				log.info("You've requested to deposit $"+balanceChange+" is this correct?");
				log.info("If correct type Yes, if incorrect type No");
				String transVerification = reader.nextLine();
				if(transVerification.matches("Yes")) {
					temp.getCaObject().setCheckBalance(temp.getCaObject().getCheckBalance() + balanceChange);
					ca.updateCAccountDeposit(temp.getCaObject(), balanceChange);
					traverseBankApp();
				} else if (transVerification.matches("No")) {
					traverseBankApp();
				} else {
					log.info("Invalid Input");
					traverseBankApp();
				}
			} else if(option2.matches("Withdraw")) {
				log.info("How much would you like to Withdraw from Account");
				String transAmount = reader.nextLine();
				double balanceChange = Double.parseDouble(transAmount);
				log.info("You've requested to Withdraw $"+balanceChange+" is this correct?");
				log.info("If correct type Yes, if incorrect type No");
				String transVerification = reader.nextLine();
				if(transVerification.matches("Yes") && balanceChange< temp.getCaObject().getCheckBalance()) {
					temp.getCaObject().setCheckBalance(temp.getCaObject().getCheckBalance() - balanceChange);
					ca.updateCAccountDeposit(temp.getCaObject(), -balanceChange);
					traverseBankApp();
				} else if (transVerification.matches("No")) {
					traverseBankApp();
				} else {
					log.info("Invalid Input");
					traverseBankApp();
				}
			}else {
				log.info("Invalid Input");
				traverseBankApp();
			}
		}else if(option.matches("Saving")) {
			log.info(">  Deposit");
			log.info(">  Withdraw");
			String option2 = reader.nextLine();
			if(option2.matches("Deposit")) {
				log.info("How much would you like to Deposit to Account");
				String transAmount = reader.nextLine();
				double balanceChange = Double.parseDouble(transAmount);
				log.info("You've requested to deposit $"+balanceChange+" is this correct?");
				log.info("If correct type Yes, if incorrect type No");
				String transVerification = reader.nextLine();
				if(transVerification.matches("Yes")) {
					temp.getSaObject().setSaveBalance(temp.getSaObject().getSaveBalance() + balanceChange);
					sa.updateSAccountDeposit(temp.getSaObject(), balanceChange);
					traverseBankApp();
					
				} else if (transVerification.matches("No")) {
					traverseBankApp();
				} else {
					log.info("Invalid Input");
					traverseBankApp();
				}
			} else if(option2.matches("Withdraw") ) {
				log.info("How much would you like to Withdraw from Account");
				String transAmount = reader.nextLine();
				double balanceChange = Double.parseDouble(transAmount);
				log.info("You've requested to Withdraw $"+balanceChange+" is this correct?");
				log.info("If correct type Yes, if incorrect type No");
				String transVerification = reader.nextLine();
				if(transVerification.matches("Yes")&& balanceChange< temp.getSaObject().getSaveBalance()) {
					temp.getSaObject().setSaveBalance(temp.getSaObject().getSaveBalance() - balanceChange);
					sa.updateSAccountDeposit(temp.getSaObject(), -balanceChange);
					traverseBankApp();
				} else if (transVerification.matches("No")) {
					traverseBankApp();
				} else {
					log.info("Invalid Input");
					traverseBankApp();
				}
			}else {
				log.info("Invalid Input");
				traverseBankApp();
			}
		}else if(option.matches("Logout")) {

			logInUser();
		}else if((!option.matches("View Balance"))||(!option.matches("Deposit"))||(!option.matches("Withdraw"))||(!option.matches("Logout"))) {

			log.info("Please Choose a Valid Option");
			traverseBankApp();
		}

	}

}
