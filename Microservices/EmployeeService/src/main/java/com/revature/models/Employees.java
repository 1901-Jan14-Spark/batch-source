package com.revature.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Employees {
	
	private int empId;
	private String name;
	private List<Reimbursements> reims;
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
	public List<Reimbursements> getReims() {
		return reims;
	}
	public void setReims(List<Reimbursements> reims) {
		this.reims = reims;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reims == null) ? 0 : reims.hashCode());
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
		Employees other = (Employees) obj;
		if (empId != other.empId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reims == null) {
			if (other.reims != null)
				return false;
		} else if (!reims.equals(other.reims))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", name=" + name + ", reims=" + reims + "]";
	}
	public Employees(int empId, String name, List<Reimbursements> reims) {
		super();
		this.empId = empId;
		this.name = name;
		this.reims = reims;
	}
	public Employees(String name, List<Reimbursements> reims) {
		super();
		this.name = name;
		this.reims = reims;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
