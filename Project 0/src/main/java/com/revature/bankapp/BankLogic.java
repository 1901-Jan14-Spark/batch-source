package com.revature.bankapp;

public interface BankLogic {
	
	public abstract double addDeposit(double balance);

	public abstract double processWithdrawal(double balance);
}
