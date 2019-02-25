package com.revature.banking;

public class Checking extends Account {
	private static String accountType = "Checking";

	Checking(double initialDeposit) {
		super();
		this.setBalance(initialDeposit);
	}

	@Override
	public String toString() {
		return " Your current balance is: $" + getBalance();
	}

}
