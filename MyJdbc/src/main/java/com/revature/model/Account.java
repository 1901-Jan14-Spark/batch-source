package com.revature.model;

import java.io.Serializable;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int accountId;
	private double accountBalance;
	private String typeOfAccount;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountId, double accountBalance, String typeOfAccount) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.typeOfAccount = typeOfAccount;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getTypeOfAccount() {
		return typeOfAccount;
	}
	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountBalance=" + accountBalance + ", typeOfAccount="
				+ typeOfAccount + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + accountId;
		result = prime * result + ((typeOfAccount == null) ? 0 : typeOfAccount.hashCode());
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountId != other.accountId)
			return false;
		if (typeOfAccount == null) {
			if (other.typeOfAccount != null)
				return false;
		} else if (!typeOfAccount.equals(other.typeOfAccount))
			return false;
		return true;
	}
	
	}
