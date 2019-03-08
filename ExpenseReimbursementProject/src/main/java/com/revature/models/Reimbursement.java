package com.revature.models;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6687521735669648255L;
	private int id;
	private int employee_id;
	private double amount;
	// 0 unresolved, 1 canceled, 2 approved, 3 rejected
	private int state;
	private Timestamp date;
	private String description;
	private Blob image;
	private int manager_id;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int id) {
		this.id =id;
	}
	public Reimbursement(int employee_id, double amount, int state, Timestamp date, String description, Blob image,
			int manager_id) {
		super();
		this.employee_id = employee_id;
		this.amount = amount;
		this.state = state;
		this.date = date;
		this.description = description;
		this.image = image;
		this.manager_id = manager_id;
	}
	public Reimbursement(int id, int employee_id, double amount, int state, Timestamp date, String description,
			Blob image, int manager_id) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.amount = amount;
		this.state = state;
		this.date = date;
		this.description = description;
		this.image = image;
		this.manager_id = manager_id;
	}
	public Reimbursement(int id, int employee_id, double amount, int state, Timestamp date, String description) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.amount = amount;
		this.state = state;
		this.date = date;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employee_id;
		result = prime * result + id;
		result = prime * result + manager_id;
		result = prime * result + state;
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (id != other.id)
			return false;
		if (manager_id != other.manager_id)
			return false;
		if (state != other.state)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", employee_id=" + employee_id + ", amount=" + amount + ", state=" + state
				+ ", date=" + date + ", description=" + description + ", manager_id=" + manager_id + "]";
	}
	
}
