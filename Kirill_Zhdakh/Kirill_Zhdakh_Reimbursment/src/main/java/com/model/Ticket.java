package com.model;

import java.io.Serializable;

public class Ticket implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String name;
	private float amount;
	private String status;
	private String ticketResolver;
	private User ticketOpener;
	
	public Ticket() {}
	
	public Ticket(int userId, String name, String ticketResolver, float amount, String status)
	{
		this.userId = userId;
		this.name = name;
		this.ticketResolver = ticketResolver;
		this.amount = amount;
		this.status = status;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTicketResolver() {
		return ticketResolver;
	}

	public void setTicketResolver(String ticketResolver) {
		this.ticketResolver = ticketResolver;
	}

	public User getTicketOpener() {
		return ticketOpener;
	}

	public void setTicketOpener(User ticketOpener) {
		this.ticketOpener = ticketOpener;
	}
}
