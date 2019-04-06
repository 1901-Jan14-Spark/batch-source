package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Reimbursement {
	private int rId;
	private int empId;
	private double amount;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int rId, int empId, double amount) {
		super();
		this.rId = rId;
		this.empId = empId;
		this.amount = amount;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", empId=" + empId + ", amount=" + amount + "]";
	}

}