package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Reimburstment {
	private int reimburstmentId;
	private int employeeId;
	private String description;
	private int amount;
	
	public Reimburstment() {
		super();
	}
	
	public Reimburstment(int reimburstmentId, int employeeId, String description) {
		super();
		this.reimburstmentId = reimburstmentId;
		this.employeeId = employeeId;
		this.description = description;
	}

	public int getReimburstmentId() {
		return reimburstmentId;
	}
	public void setReimburstmentId(int reimburstmentId) {
		this.reimburstmentId = reimburstmentId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employeeId;
		result = prime * result + reimburstmentId;
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
		Reimburstment other = (Reimburstment) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (reimburstmentId != other.reimburstmentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimburstment [reimburstmentId=" + reimburstmentId + ", employeeId=" + employeeId + ", description="
				+ description + "]";
	}
}
