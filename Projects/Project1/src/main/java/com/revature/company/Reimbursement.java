package com.revature.company;

import java.sql.Timestamp;

public class Reimbursement {

	
	private int reimbursementId;
	private int employeeId;
	private double amount;
	private boolean approved;
	private Timestamp requestDate;
	private Timestamp approvalDate;
	
	
	public Reimbursement() {
		super();
	}


	public Reimbursement(int reimbursementId, int employeeId, double amount, boolean approved, Timestamp requestDate,
			Timestamp approvalDate) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.amount = amount;
		this.approved = approved;
		this.requestDate = requestDate;
		this.approvalDate = approvalDate;
	}


	public int getReimbursementId() {
		return reimbursementId;
	}


	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
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


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	public Timestamp getRequestDate() {
		return requestDate;
	}


	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}


	public Timestamp getApprovalDate() {
		return approvalDate;
	}


	public void setApprovalDate(Timestamp approvalDate) {
		this.approvalDate = approvalDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((approvalDate == null) ? 0 : approvalDate.hashCode());
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + employeeId;
		result = prime * result + reimbursementId;
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
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
		if (approvalDate == null) {
			if (other.approvalDate != null)
				return false;
		} else if (!approvalDate.equals(other.approvalDate))
			return false;
		if (approved != other.approved)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		return true;
	}
	
}
