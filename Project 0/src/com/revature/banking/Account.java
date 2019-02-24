package com.revature.banking;

public class Account {
	private double balance = 0;
	private int accountNumber;
	private static int numberOfAccount = 1000;
	
	Account() {
		accountNumber = numberOfAccount++;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void withdraw(double amount) {
		if(amount > balance) {
			System.out.println("You have insufficient funds.");
			return;
		} 
		balance -= amount;
		System.out.println("You have withdrawn $" + amount);
		System.out.println("You now have a balance of $" + balance);
	}
	
	public void deposit(double amount) {
		if(amount <= 0) {
			System.out.println("You cannot deposit negative money.");
			return;
		}
		balance += amount;
		System.out.println("You have deposited $" + amount);
		System.out.println("You now have a blance of $" + balance);
	}
	
}
