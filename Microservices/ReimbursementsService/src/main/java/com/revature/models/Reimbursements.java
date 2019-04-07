package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Reimbursements {

	private int reimId;
	private int empId;
	private double reimAmount;
	public int getReimId() {
		return reimId;
	}
	public void setReimId(int reimId) {
		this.reimId = reimId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getReimAmount() {
		return reimAmount;
	}
	public void setReimAmount(double reimAmount) {
		this.reimAmount = reimAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		long temp;
		temp = Double.doubleToLongBits(reimAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimId;
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
		if (empId != other.empId)
			return false;
		if (Double.doubleToLongBits(reimAmount) != Double.doubleToLongBits(other.reimAmount))
			return false;
		if (reimId != other.reimId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursements [reimId=" + reimId + ", empId=" + empId + ", reimAmount=" + reimAmount + "]";
	}
	public Reimbursements(int reimId, int empId, double reimAmount) {
		super();
		this.reimId = reimId;
		this.empId = empId;
		this.reimAmount = reimAmount;
	}
	public Reimbursements(int empId, double reimAmount) {
		super();
		this.empId = empId;
		this.reimAmount = reimAmount;
	}
	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}

}
