package com.revature.models;

public class Reimbursement {

	private int ReimId;
	private int EmpId;
	private double cost;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int reimId, int empId, double cost) {
		super();
		ReimId = reimId;
		EmpId = empId;
		this.cost = cost;
	}


	public int getReimId() {
		return ReimId;
	}


	public void setReimId(int reimId) {
		ReimId = reimId;
	}


	public int getEmpId() {
		return EmpId;
	}


	public void setEmpId(int empId) {
		EmpId = empId;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "Reimbursement [ReimId=" + ReimId + ", EmpId=" + EmpId + ", cost=" + cost + "]";
	}
	
	
	
}
