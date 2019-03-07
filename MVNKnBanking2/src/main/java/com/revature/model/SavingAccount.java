package com.revature.model;

import java.io.Serializable;

public class SavingAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5588449168826808338L;
	

	private long SavingAcocuntNum;  
	private double SaveBalance;
	
	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(long savingAcocuntNum, double saveBalance) {
		super();
		SavingAcocuntNum = savingAcocuntNum;
		SaveBalance = saveBalance;
	}

	public long getSavingAcocuntNum() {
		return SavingAcocuntNum;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSavingAcocuntNum(long savingAcocuntNum) {
		SavingAcocuntNum = savingAcocuntNum;
	}

	public double getSaveBalance() {
		return SaveBalance;
	}

	public void setSaveBalance(double saveBalance) {
		SaveBalance = saveBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(SaveBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = (int) (prime * result + SavingAcocuntNum);
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
		SavingAccount other = (SavingAccount) obj;
		if (Double.doubleToLongBits(SaveBalance) != Double.doubleToLongBits(other.SaveBalance))
			return false;
		if (SavingAcocuntNum != other.SavingAcocuntNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SavingAccount [SavingAcocuntNum=" + SavingAcocuntNum + ", SaveBalance=" + SaveBalance + "]";
	}
	
	
	
	
	

}
