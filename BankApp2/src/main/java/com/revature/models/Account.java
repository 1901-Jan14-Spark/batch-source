package com.revature.models;

public class Account {

	private User user;
	private double checkings;
	private double savings;
	
	public Account() {
		super();
	}

	public Account(User user, double checkings, double savings) {
		super();
		this.user = user;
		this.checkings = checkings;
		this.savings = savings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getCheckings() {
		return checkings;
	}

	public void setCheckings(double checkings) {
		this.checkings = checkings;
	}

	public double getSavings() {
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}

	@Override
	public String toString() {
		return "Account [user=" + user + ", checkings=" + checkings + ", savings=" + savings + "]";
	}
	
	
	
}
