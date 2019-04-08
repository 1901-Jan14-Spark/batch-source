package com.revature.models;
import org.springframework.stereotype.Component;

@Component
public class Reimbursement {
	private int reimbursementId;
	private int employeeId;
	private boolean isResolved;
	private String status;
	private double amount;
	public Reimbursement() {
		super();
	}
	public Reimbursement(int reimbursementId, int employeeId, boolean isResolved, String status, double amount) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.isResolved = isResolved;
		this.status = status;
		this.amount = amount;
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
	public boolean isResolved() {
		return isResolved;
	}
	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		result = prime * result + (isResolved ? 1231 : 1237);
		result = prime * result + reimbursementId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (isResolved != other.isResolved)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", isResolved="
				+ isResolved + ", status=" + status + ", amount=" + amount + "]";
	}
	
	
}
