package com.revature.model;

import java.util.List;

public class Employee {

	private Integer employeeId;
	private String name;
	private List<Reimbursement> reimbursements;
	
	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String name, List<Reimbursement> reimbursements) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.reimbursements = reimbursements;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reimbursements == null) ? 0 : reimbursements.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reimbursements == null) {
			if (other.reimbursements != null)
				return false;
		} else if (!reimbursements.equals(other.reimbursements))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", reimbursements=" + reimbursements + "]";
	}
	
	
}