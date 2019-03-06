package com.revature.model;

import org.apache.log4j.Logger;

public class Account {
private static Logger log = Logger.getRootLogger();
private int accId;
private double checkingBalance;
private double savingsBalance;

public Account(int accId, double checkingBalance, double savingsBalance) {
	super();
	this.accId = accId;
	this.checkingBalance = checkingBalance;
	this.savingsBalance = savingsBalance;
}
public Account() {
	super();
}

public int getAccId() {
	return accId;
}
public void setAccId(int accId) {
	this.accId = accId;
}
public double getCheckingBalance() {
	return checkingBalance;
}
public void setCheckingBalance(double checkingBalance) {
	this.checkingBalance = checkingBalance;
}
public double getSavingsBalance() {
	return savingsBalance;
}
public void setSavingsBalance(double savingsBalance) {
	this.savingsBalance = savingsBalance;
}
public boolean depositFunds(double amount, char type) {
	if(amount<0)
		return false;
	if(type=='c') {
		log.info(accId+" Transaction success! "+amount+" was deposited checking!");
		checkingBalance += amount;
		return true;
	}
	else if(type=='s') {
		log.info(accId+" Transaction success! "+amount+" was deposited to savings!");
		savingsBalance += amount;
		return true;
	}else
		return false;
}
public boolean withdrawFunds(double amount, char type) {
	if(amount<0)
		return false;
	if(type=='c' && ((checkingBalance-amount)>0)) {
		log.info(accId+" Transaction success! "+amount+" was withdrawn from checking!");
		checkingBalance -= amount;
		return true;
	}
	else if(type=='s'&& ((savingsBalance-amount)>0)) {
		log.info(accId+" Transaction success! "+amount+" was withdrawn from savings!");
		savingsBalance -= amount;
		return true;
	}else {
		log.info("Insufficient funds!");
		return false;
	}
}
@Override
public String toString() {
	return "Account [accId=" + accId + ", checkingBalance=" + checkingBalance + ", savingsBalance=" + savingsBalance
			+ "]";
}

}
