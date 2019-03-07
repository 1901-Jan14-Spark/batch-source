package com.revature.model;

import java.io.Serializable;

public class CheckingAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3281340896856914692L;
	
	private long CheckAcocuntNum;
	private double CheckBalance;
	
	public CheckingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(long checkAcocuntNum, double checkBalance) {
		super();
		CheckAcocuntNum = checkAcocuntNum;
		CheckBalance = checkBalance;
	}

	public long getCheckAcocuntNum() {
		return CheckAcocuntNum;
	}

	public void setCheckAcocuntNum(long checkAcocuntNum) {
		CheckAcocuntNum = checkAcocuntNum;
	}

	public double getCheckBalance() {
		return CheckBalance;
	}

	public void setCheckBalance(double checkBalance) {
		CheckBalance = checkBalance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + CheckAcocuntNum);
		int temp;
		temp = (int) Double.doubleToLongBits(CheckBalance);
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
		CheckingAccount other = (CheckingAccount) obj;
		if (CheckAcocuntNum != other.CheckAcocuntNum)
			return false;
		if (Double.doubleToLongBits(CheckBalance) != Double.doubleToLongBits(other.CheckBalance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckingAccount [CheckAcocuntNum=" + CheckAcocuntNum + ", CheckBalance=" + CheckBalance + "]";
	}
	
	
	
	
	

}
