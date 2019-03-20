package com.model;

import java.io.Serializable;

public class TicketHandler implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ticketId;
	private String status;
	TicketHandler(){}
	public TicketHandler(int ticketId, String status)
	{
		this.ticketId = ticketId;
		this.status = status;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int userId) {
		this.ticketId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
