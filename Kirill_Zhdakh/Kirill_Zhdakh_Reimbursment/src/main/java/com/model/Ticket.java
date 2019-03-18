package com.model;

import java.io.Serializable;

public class Ticket implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private User user;
	private User resolvedBy;
	private String name;
	private float amount;
	private String status;
	
	public Ticket() {}
	
	public Ticket(User user, User resolvedBy, String name, float amount, String status)
	{
		this.user = user;
		this.resolvedBy = resolvedBy;
		this.name = name;
		this.amount = amount;
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(User resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
