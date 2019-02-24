package models;

import workers.Reader;
import workers.Writer;

public class AccountHandler {

	private Reader r = Reader.getReader();
	private Writer w = Writer.getWriter();

	public AccountHandler() {
	}


	public AccountManager login(String userName, String password) {
		if (!r.existsInDb(userName)) {
			System.out.println("Account Handler - login - Invalid UserName.");
			return null;
		}
		Account temp = r.retrieveFromDb(userName);
		if (!temp.getPassword().equals(password)) {
			System.out.println("Invalid Password");
			return null;
		}
		if(temp.isLoggedIn()) {
			System.out.println("User already logged in.");
			return null;
		}
		temp.setLoggedIn(true);
		w.addToDb(temp);
		return new AccountManager(temp);
	}

	public boolean createAccount(String firstName, String lastName, String username, String password) {
		if (r.existsInDb(username)) {
			return false;
		}
		Account myAccount = new Account(firstName, lastName, username, password);

		Writer w = Writer.getWriter();

		w.addToDb(myAccount);

		return true;
	}
}
