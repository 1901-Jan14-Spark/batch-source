package com.revature.model;

import org.springframework.stereotype.Component;

@Component
public class Reimbursement {

	private Integer reimbursementId;
	private Integer employeeId;
	private double balance;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(Integer reimbursementId, Integer employeeId, double balance) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.balance = balance;
	}

	public Integer getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(Integer reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((reimbursementId == null) ? 0 : reimbursementId.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (reimbursementId == null) {
			if (other.reimbursementId != null)
				return false;
		} else if (!reimbursementId.equals(other.reimbursementId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", balance="
				+ balance + "]";
	}

	
}