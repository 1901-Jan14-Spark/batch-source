package com.revature.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9204035542778925792L;
	
	
	private int rId;
	private double rAmount;
	private int rStatus;
	private Timestamp date;
	private String description;
	private Blob image;
	private int rStatusChange;
	private int employee_id;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int rId, double rAmount, int rStatus, Timestamp date, String description, Blob image,
			int rStatusChange, int employee_id) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		this.rStatus = rStatus;
		this.date = date;
		this.description = description;
		this.image = image;
		this.rStatusChange = rStatusChange;
		this.employee_id = employee_id;
	}

	

	public Reimbursement(int rId, double rAmount, int rStatus, Timestamp date, String description, int rStatusChange,
			int employee_id) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		this.rStatus = rStatus;
		this.date = date;
		this.description = description;
		this.rStatusChange = rStatusChange;
		this.employee_id = employee_id;
	}

	
	public Reimbursement(int rId, double rAmount, int rStatus, String description, int rStatusChange, int employee_id) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		this.rStatus = rStatus;
		this.description = description;
		this.rStatusChange = rStatusChange;
		this.employee_id = employee_id;
	}


	public int getrId() {
		return rId;
	}


	public void setrId(int rId) {
		this.rId = rId;
	}


	public double getrAmount() {
		return rAmount;
	}


	public void setrAmount(double rAmount) {
		this.rAmount = rAmount;
	}


	public int getrStatus() {
		return rStatus;
	}


	public void setrStatus(int rStatus) {
		this.rStatus = rStatus;
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


	public int getrStatusChange() {
		return rStatusChange;
	}


	public void setrStatusChange(int rStatusChange) {
		this.rStatusChange = rStatusChange;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employee_id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rId;
		result = prime * result + rStatus;
		result = prime * result + rStatusChange;
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
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (Double.doubleToLongBits(rAmount) != Double.doubleToLongBits(other.rAmount))
			return false;
		if (rId != other.rId)
			return false;
		if (rStatus != other.rStatus)
			return false;
		if (rStatusChange != other.rStatusChange)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", rAmount=" + rAmount + ", rStatus=" + rStatus + ", date=" + date
				+ ", description=" + description + ", image=" + image + ", rStatusChange=" + rStatusChange
				+ ", employee_id=" + employee_id + "]";
	}
	
	
	
	
	
	
	
}
