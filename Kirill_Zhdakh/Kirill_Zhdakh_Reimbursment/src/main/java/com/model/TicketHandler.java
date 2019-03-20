package com.model;

import java.io.Serializable;

public class TicketHandler implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	private String status;
	public TicketHandler(int userId, String status)
	{
		this.userId = userId;
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
