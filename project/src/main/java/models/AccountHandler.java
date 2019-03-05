package models;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.AccountHolderDao;
import dao.AccountHolderDaoImpl;
import dao.AccountManagerDao;
import dao.AccountManagerDaoImpl;
import dao.TransactionDao;
import dao.TransactionDaoImpl;

public class AccountHandler {

	private AccountDao ad = new AccountDaoImpl();
	private AccountHolderDao ahd = new AccountHolderDaoImpl();
	private AccountManagerDao amd = new AccountManagerDaoImpl();
	private TransactionDao td = new TransactionDaoImpl();

	public AccountHandler() {
	}


	public AccountManager2 login(String userName, String password) {
		AccountHolder ah = ahd.getAccountHolderByUsername(userName);
		if(ah == null) {
			System.out.println("Account Handler - login - Invalid UserName.");
			return null;
		}
		if (!ah.getPassword().equals(password)) {
			System.out.println("Invalid Password");
			return null;
		}
		if(ah.isLoggedIn()) {
			System.out.println("User already logged in.");
			return null;
		}
		ahd.updateAccountHolderLogin(ah);
		ah.setLoggedIn(true);
		return new AccountManager2(ah);
	}

	public boolean createAccountHolder(String username, String password, String firstName, String lastName) {
		AccountHolder ah = ahd.getAccountHolderByUsername(username);
		if(ah != null) {
			System.out.println("Account Handler - login - Invalid UserName. " + username);
			return false;
		}else {
		AccountHolder myAccount = new AccountHolder(username, password, firstName, lastName);
		
		ahd.createAccountHolder(myAccount);
		}

		return true;
	}
	
	

}
