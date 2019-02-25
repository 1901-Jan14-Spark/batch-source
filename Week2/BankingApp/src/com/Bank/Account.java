package com.Bank;

import java.io.Serializable;

public class Account  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6271253464276457835L;
	private String password;
	private static int ID = 0;
	private int balance;
	
	public Account() {
		super();
		ID++;
		
	}

	
	public Account(String password, int balance) {
		super();
		this.password = password;
		this.balance = balance;
		ID++;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public boolean depositMoney(int value) {
		
		
		this.balance += value; 
		
		return true;
	
		
	}
	public boolean withdrawMoney(int value) {
		
		if ( balance - value >= 0) {
	   
			
			this.balance -= value; 
			return true; 
	
		}
		else {
			
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
