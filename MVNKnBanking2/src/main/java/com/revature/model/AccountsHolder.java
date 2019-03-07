package com.revature.model;

import java.io.Serializable;

public class AccountsHolder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8870463225814964079L;
	/**
	 * 
	 */

	private int ID;
	private String Username;
	private String Userpass;
	private long CheckAcocuntNum;
	private long SavingAcocuntNum;
	private CheckingAccount caObject;
	private SavingAccount saObject;
	
	
	public SavingAccount getSaObject() {
		return saObject;
	}



	public void setSaObject(SavingAccount saObject) {
		this.saObject = saObject;
	}


	
	
	public CheckingAccount getCaObject() {
		return caObject;
	}



	public void setCaObject(CheckingAccount caObject) {
		this.caObject = caObject;
	}



	public AccountsHolder() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AccountsHolder( String username, String userpass, long checkAcocuntNum, long savingAcocuntNum) {
		super();
		Username = username;
		Userpass = userpass;
		CheckAcocuntNum = checkAcocuntNum;
		SavingAcocuntNum = savingAcocuntNum;
	}
	
	public AccountsHolder(String username, String userpass) {
		Username = username;
		Userpass = userpass;
	}

	
	public AccountsHolder(String username,  long checkAcocuntNum, long savingAcocuntNum) {
		super();
		Username = username;
		CheckAcocuntNum = checkAcocuntNum;
		SavingAcocuntNum = savingAcocuntNum;
	}


	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public String getUsername() {
		return Username;
	}



	public void setUsername(String username) {
		Username = username;
	}



	public String getUserpass() {
		return Userpass;
	}



	public void setUserpass(String userpass) {
		Userpass = userpass;
	}



	public long getCheckAcocuntNum() {
		return CheckAcocuntNum;
	}



	public AccountsHolder(String username, String userpass, CheckingAccount caObject, SavingAccount saObject) {
		super();
		Username = username;
		Userpass = userpass;
		this.caObject = caObject;
		this.saObject = saObject;
	}



	public void setCheckAcocuntNum(long checkAcocuntNum) {
		CheckAcocuntNum = checkAcocuntNum;
	}



	public long getSavingAcocuntNum() {
		return SavingAcocuntNum;
	}



	public void setSavingAcocuntNum(long savingAcocuntNum) {
		SavingAcocuntNum = savingAcocuntNum;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(CheckAcocuntNum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ID;
		temp = Double.doubleToLongBits(SavingAcocuntNum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Username == null) ? 0 : Username.hashCode());
		result = prime * result + ((Userpass == null) ? 0 : Userpass.hashCode());
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
		AccountsHolder other = (AccountsHolder) obj;
		if (Double.doubleToLongBits(CheckAcocuntNum) != Double.doubleToLongBits(other.CheckAcocuntNum))
			return false;
		if (ID != other.ID)
			return false;
		if (Double.doubleToLongBits(SavingAcocuntNum) != Double.doubleToLongBits(other.SavingAcocuntNum))
			return false;
		if (Username == null) {
			if (other.Username != null)
				return false;
		} else if (!Username.equals(other.Username))
			return false;
		if (Userpass == null) {
			if (other.Userpass != null)
				return false;
		} else if (!Userpass.equals(other.Userpass))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "AccountsHolder [Username=" + Username + ", caObject=" + caObject + ", saObject="
				+ saObject + "]";
	}
	
	
	
	
}
