package com.revature.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Employee {
 
	private int EmpId;
	private String EmpName;
	private String position;
	private List<Reimbursement> reimbursements;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, String position, List<Reimbursement> reimbursements) {
		super();
		EmpId = empId;
		EmpName = empName;
		this.position = position;
		this.reimbursements = reimbursements;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}
	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", position=" + position + ", reimbursements="
				+ reimbursements + "]";
	}
	
	
	
	
	
	
}
