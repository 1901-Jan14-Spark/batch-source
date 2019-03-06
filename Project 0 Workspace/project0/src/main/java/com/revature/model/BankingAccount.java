package com.revature.model;

import java.io.Serializable;

//Class that defines the structure of our BankingAccount object and the constructors used to make them
//get and setters are included as well as the overridden hashcode, equals, and the toString method
public class BankingAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int accountId;
	private String accountType;
	private double balance;
	public BankingAccount() {
		super();
	}
	public BankingAccount(int accountId, String accountType, double balance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public BankingAccount(int accountId) {
		super();
		this.accountId = accountId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BankingAccount other = (BankingAccount) obj;
		if (accountId != other.accountId)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BankingAccount [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance + "]";
	}
	

}
