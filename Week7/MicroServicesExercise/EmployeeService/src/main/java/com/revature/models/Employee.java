package com.revature.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int empId;
	private String name;
	private String email;
	private List<Reimbursement> reimbursements;
	
	public Employee() {
		super();
	}

	public Employee(int empId, String name, String email, List<Reimbursement> reimbursements) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.reimbursements = reimbursements;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", reimbursements=" + reimbursements
				+ "]";
	}
	
}