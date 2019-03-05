package com.Bank;

import java.io.Serializable;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6271253464276457835L;

	private static int ID = 0;
	private double checking;
	private double saving;
	private AccountDaoImp ADI;

	public AccountDaoImp getADI() {
		return ADI;
	}

	public void setADI(AccountDaoImp aDI) {
		ADI = aDI;
	}

	public Account() {
		super();
		ADI = new AccountDaoImp();

	}

	public Account(double checking, double saving) {
		super();

		this.checking = checking;
		this.saving = saving;
		ID++;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean depositChecking(User user, double value) {

		// set current status
		this.checking += value;

		// make deposit

		ADI.saveAccount(user);

		return true;

	}

	public boolean depositSaving(User user, double value) {

		this.saving += value;
		ADI.saveAccount(user);
		return true;

	}

	public boolean withdrawMoneySaving(double value, User user) {

		if (saving - value >= 0) {

			saving -= value;
			ADI.saveAccount(user);
			return true;

		} else {

			return false;
		}
	}

	public boolean withdrawMoneyChecking(double value, User user) {

		if (checking - value >= 0) {

			checking -= value;
			ADI.saveAccount(user);
			return true;

		} else {

			return false;
		}

	}

	public double getChecking() {
		return checking;
	}

	public void setChecking(double checking) {
		this.checking = checking;
	}

	public double getSaving() {
		return saving;
	}

	public void setSaving(double saving) {
		this.saving = saving;
	}

}
