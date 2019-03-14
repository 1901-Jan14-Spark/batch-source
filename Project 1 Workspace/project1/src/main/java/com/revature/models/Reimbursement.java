package com.revature.models;

import java.sql.Date;

public class Reimbursement {
	private int r_id;
	private int e_id;
	private double amount;
	private String status;
	private String r_Type;
	private Date submitted;
	private Date resolved;
	private int m_id;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reimbursement(int r_id) {
		super();
		this.r_id = r_id;
	}

	public Reimbursement(int r_id, int e_id, double amount, String status, String r_Type, Date submitted, Date resolved,
			int m_id) {
		super();
		this.r_id = r_id;
		this.e_id = e_id;
		this.amount = amount;
		this.status = status;
		this.r_Type = r_Type;
		this.submitted = submitted;
		this.resolved = resolved;
		this.m_id = m_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getR_Type() {
		return r_Type;
	}

	public void setR_Type(String r_Type) {
		this.r_Type = r_Type;
	}

	public Date getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}

	public Date getResolved() {
		return resolved;
	}

	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + e_id;
		result = prime * result + m_id;
		result = prime * result + ((r_Type == null) ? 0 : r_Type.hashCode());
		result = prime * result + r_id;
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
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
		if (e_id != other.e_id)
			return false;
		if (m_id != other.m_id)
			return false;
		if (r_Type == null) {
			if (other.r_Type != null)
				return false;
		} else if (!r_Type.equals(other.r_Type))
			return false;
		if (r_id != other.r_id)
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", e_id=" + e_id + ", amount=" + amount + ", status=" + status
				+ ", r_Type=" + r_Type + ", submitted=" + submitted + ", resolved=" + resolved + ", m_id=" + m_id + "]";
	}
	
}
