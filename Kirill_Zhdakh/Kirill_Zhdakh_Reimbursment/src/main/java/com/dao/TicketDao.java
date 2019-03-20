package com.dao;

import java.util.List;
import com.model.Ticket;

public interface TicketDao {
	public List<Ticket> getTickets();
	public List<Ticket> getTicketsByStatus(String status);
	public List<Ticket> getTicketsByStatusEmp(String status, int id);
	public boolean createTicket(Ticket ticket);
	public boolean updateTicket(int ticketId, String status, String resolvedBy);
	public boolean deleteTicket(int id);
}
