package com.revature.main;
import com.revature.model.Customer;
import com.revature.model.Account;
import java.util.List;
import org.apache.log4j.Logger;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.CustomerDaoImpl;
import com.revature.util.ConnectionUtil;
import com.revature.util.InChecker;
public class Driver{
	static Logger log = Logger.getRootLogger();
	static CustomerDaoImpl cd = new CustomerDaoImpl();
	static AccountDaoImpl ad = new AccountDaoImpl();
	public static void main(String[] args) {
		while(true) {
			List<Customer> clist = cd.getAllCustomers();
			log.info("Welcome to Revature Bank, please choose an option: [1] Customer login [2] New Customer [3] Exit");
			int option = InChecker.getGoodInt(1, 3);
			
			if(option==1) {
				Customer ctemp = authenticate(clist);
				ctemp.setAcc(ad.getAccountById(ctemp.getAid()));
				loggedInOptions(ctemp,clist);
				continue;
			}
			if(option == 2) {
				log.info("Welcome to account creation, would you like to: [1]Create new bank account "
						+ "[2]New authroized user on existing");
				option = InChecker.getGoodInt(1, 2);
				Customer newCust= newCustomer();
				if(option==1) {
					newCust.setAid(ad.createAccount());
					cd.createCustomer(newCust);
				}else if(option == 2) {
					log.info("Enter existing customer's email: ");
					Customer temp = authenticate(clist);
					newCust.setAid(temp.getAid());
					cd.createCustomer(newCust);
				}
				log.info("Account creation successful!");
			}
			if(option == 3) {
				log.info("Exit has been chosen, goodbye!");
				break;
			}
		}

	}
	public static Customer authenticate(List<Customer> clist) {
		String ueml = InChecker.getGoodEmail();
		Customer ctemp = new Customer();
		ctemp.setEmail(ueml);
		while(!clist.contains(ctemp)) {
			log.info("Email not found!");
			ueml = InChecker.getGoodEmail();
			ctemp.setEmail(ueml);
		}
		ctemp = clist.get(clist.indexOf(ctemp));
		log.info("Enter the password!");
		String upw = InChecker.getGoodPassword();
		while(!(upw.equals( ctemp.getPassword()))) {
			log.info("Attempt failed, try again!");
			upw = InChecker.getGoodPassword();
		}
		return ctemp;
	}
	public static void loggedInOptions(Customer cLoggedIn, List<Customer>clist) {
		log.info("Hello "+cLoggedIn.getFirstname()+" please select an option:");
		log.info("A. Check [1]checking/[2]saving account balance");
		log.info("B. Deposit into [3]checking/[4]saving account");
		log.info("C. Withdraw from [5]checking/[6]saving account");
		log.info("D. Transfer from [7]checking/[8]saving to [7]saving/[8]checking");
		log.info("E. [9]Transfer from checking account funds to another user's account");
		log.info("F. [10] Transaction History");
		log.info("G. [11] Logout");
		int options = InChecker.getGoodInt(1, 11);
		String eml = "";
		Customer target = new Customer();
		double amount = 0.0;
		 choices: while(true) {
			switch(options) {
			case 1:
				log.info("Your checkings balance is $"+cLoggedIn.getAcc().getCheckingBalance());
				break;
			case 2:
				log.info("Your savings balance is $"+cLoggedIn.getAcc().getSavingsBalance());
				break;
			case 3:
				amount = InChecker.getGoodAmount();
				cLoggedIn.getAcc().depositFunds(amount, 'c');
				break;
			case 4:
				amount = InChecker.getGoodAmount();
				cLoggedIn.getAcc().depositFunds(amount, 's');
				break;
			case 5:
				amount = InChecker.getGoodAmount();
				cLoggedIn.getAcc().withdrawFunds(amount, 'c');
				break;
			case 6:
				amount = InChecker.getGoodAmount();
				cLoggedIn.getAcc().withdrawFunds(amount, 's');
				break;
			case 7:
				amount = InChecker.getGoodAmount();
				if(cLoggedIn.getAcc().withdrawFunds(amount, 'c'))
					cLoggedIn.getAcc().depositFunds(amount, 's');
				break;
			case 8:
				amount = InChecker.getGoodAmount();
				if(cLoggedIn.getAcc().withdrawFunds(amount, 's'))
					cLoggedIn.getAcc().depositFunds(amount, 'c');
				break;
			case 9:
				eml= "";
				target= null;
				while(!clist.contains(target)) {
					eml = InChecker.getGoodEmail();
					target = new Customer();
					target.setEmail(eml);
				}
				target = clist.get(clist.indexOf(target));
				target.setAcc(ad.getAccountById(target.getAid()));
				amount = InChecker.getGoodAmount();
				if(cLoggedIn.getAcc().withdrawFunds(amount, 'c'))
					target.getAcc().depositFunds(amount, 'c');
				ad.updateAccount(target.getAcc());
				break;
			case 10:
				// space for future functionality
				break;
			case 11:
				ad.updateAccount(cLoggedIn.getAcc());
				log.info("User logged out!");
				break choices;
			}
			log.info("Hello "+cLoggedIn.getFirstname()+" please select an option:");
			log.info("A. Check [1]checking/[2]saving account balance");
			log.info("B. Deposit into [3]checking/[4]saving account");
			log.info("C. Withdraw from [5]checking/[6]saving account");
			log.info("D. Transfer from [7]checking/[8]saving to [7]saving/[8]checking");
			log.info("E. [9]Transfer from checking account funds to another user's account");
			log.info("F. [10] Transaction History");
			log.info("G. [11] Logout");
			options = InChecker.getGoodInt(1, 11);
		}
	}
	public static Customer newCustomer() {
		Customer nCust = new Customer();
		log.info("Enter your first name: ");
		nCust.setFirstname(InChecker.getGoodName());
		log.info("Enter your last name: ");
		nCust.setLastname(InChecker.getGoodName());
		log.info("Enter your email address: ");
		nCust.setEmail(InChecker.getGoodEmail());
		log.info("Enter a password greater than 7 characters with no spaces: ");
		nCust.setPassword(InChecker.getGoodPassword());
		return nCust;
	}
}