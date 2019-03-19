package com.dao.imp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dao.TicketDao;
import com.model.Ticket;
import com.util.ConnectionUtil;

public class TicketDaoImp implements TicketDao {

	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getTicketsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createTicket(Ticket ticket) {
		String sql = "INSERT INTO TICKET (TICKET_USERID,"
				+"TICKET_RESOLVER,TICKET_NAME,TICKET_AMOUNT,"
				+"TICKET_STATUS)"
				+" VALUES (?,?,?,?,?)";
	
		try(Connection c = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = c.prepareStatement(sql))
		{		
			ps.setInt(1, ticket.getUserId());
			ps.setString(2, "None");
			ps.setString(3, ticket.getName());
			ps.setFloat(4, ticket.getAmount());
			ps.setString(5, ticket.getStatus());
			ps.executeQuery();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTicket(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
