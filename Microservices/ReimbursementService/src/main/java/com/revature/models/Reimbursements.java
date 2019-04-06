package com.revature.models;

public class Reimbursements {

	private int employeeId;
	private int reimbId;
	private double amount;
	
	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursements(int employeeId, int reimbId, double amount) {
		super();
		this.employeeId = employeeId;
		this.reimbId = reimbId;
		this.amount = amount;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
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
		Reimbursements other = (Reimbursements) obj;
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
		return "Reimbursements [employeeId=" + employeeId + ", reimbId=" + reimbId + ", amount=" + amount + "]";
	}
}
