package com.revature.models;

import java.io.Serializable;

public class Bank_Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	double balance;
	int id;
	public Bank_Account() {
		super();
		
	}
	public Bank_Account(double balance, int id) {
		super();
		this.balance = balance;
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
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
		Bank_Account other = (Bank_Account) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bank_Account [balance=" + balance + ", id=" + id + "]";
	}
	
	
}
