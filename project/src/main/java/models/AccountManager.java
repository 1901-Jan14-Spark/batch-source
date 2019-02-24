package models;

import workers.Writer;

public class AccountManager {

	private Account account;
	private Writer w = Writer.getWriter();
	
	public AccountManager() {}
	
	public AccountManager(Account account) {
		this.account = account;
	}
	
	public boolean deposit(double amount) {
		if(amount < 0) {
			return false;
		}
		account.setBalance(account.getBalance() + amount);
		w.addToDb(account);
		return true;
	}
	
	public boolean withdraw(double amount) {
		if(account.getBalance() - amount < 0) {
			return false;
		}
		account.setBalance(account.getBalance() - amount);
		w.addToDb(account);
		return true;
	}
	
	public double getBalance() {
		return account.getBalance();
	}
	public String getName() {
		return account.getFirstName();
	}
	public boolean logout() {
		account.setLoggedIn(false);
		w.addToDb(account);
		return true;
	}
}
