package com.revature.banking;

public class Savings extends Account {
	private static String accountType = "Savings";
	
	Savings(double initialDeposit) {
		super();
		this.setBalance(initialDeposit);
	}

	@Override
	public String toString() {
		return " Your current balance is: $" + getBalance();
	}
	
	
}
