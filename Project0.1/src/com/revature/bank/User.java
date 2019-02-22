package com.revature.bank;

public class User {
	
	// the instance variables that make up a user's account
	public String userName;
	public String password;
	public String accountNumber;
	public double accountBalance;
	
	// no arguments constructor
	public User() {
		super();
	}
	
	// new user constructor
	public User(String userName, String password, double accountBalance) {
		this.userName = userName;
		this.password = password;
		this.accountBalance = accountBalance;
		
	}

	// getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String setAccountNumber() {
		//randomly generate a unique account number for each new user
		String randomNum = "";
		for(int i = 0; i < 8; i++) {
			// randomly generate 8 digits and append them together to create the account number String
			randomNum = randomNum + ((int)(Math.random()*10));
		}
		return randomNum;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	// toString method which only prints the user's name, account, and balance
	@Override
	public String toString() {
		return "User: " + userName + "\nAccount Number: " + accountNumber
				+ "\nBalance: " + accountBalance;
	}
	
	
	
	

}
