package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Reimbursement {
	
	private int reimbId;
	private int employeeId;
	private double amount;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int reimbId, int employeeId, double amount) {
		super();
		this.reimbId = reimbId;
		this.employeeId = employeeId;
		this.amount = amount;
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + employeeId;
		result = prime * result + reimbId;
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (reimbId != other.reimbId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", employeeId=" + employeeId + ", amount=" + amount + "]";
	}
	
	

}
