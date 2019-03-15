package com.revature.model;

public class Reimbursement {

	private int id;
	private String email;
	private int price;
	private String status;
	private String resolvedby;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int id, String email, int price, String status, String resolvedby) {
		super();
		this.id = id;
		this.email = email;
		this.price = price;
		this.status = status;
		this.resolvedby = resolvedby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolvedby() {
		return resolvedby;
	}

	public void setResolvedby(String resolvedby) {
		this.resolvedby = resolvedby;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", email=" + email + ", price=" + price + ", status=" + status
				+ ", resolvedby=" + resolvedby + "]";
	}
	
	
}
