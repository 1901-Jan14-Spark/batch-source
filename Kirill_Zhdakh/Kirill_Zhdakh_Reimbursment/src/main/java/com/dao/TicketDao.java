package com.dao;

import java.util.List;
import com.model.Ticket;

public interface TicketDao {
	public List<Ticket> getTickets();
	public List<Ticket> getTicketsById(int id);
	public boolean createTicket(Ticket ticket);
	public boolean updateTicket(Ticket ticket);
	public boolean deleteTicket(int id);
}
