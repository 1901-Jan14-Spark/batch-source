package com.dao.imp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.TicketDao;
import com.model.Ticket;
import com.model.User;
import com.util.ConnectionUtil;

public class TicketDaoImp implements TicketDao {

	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getTicketsByStatus(String status) {
		List<Ticket> ticketList = new ArrayList<>();
		Ticket ticket = new Ticket();
		String sql = "SELECT T.*, UT.USER_FIRSTNAME, UT.USER_LASTNAME, UT.USER_TITLE FROM TICKET T JOIN USER_TABLE UT ON T.TICKET_USERID = UT.USER_ID AND T.TICKET_STATUS = ? ORDER BY T.TICKET_AMOUNT DESC";
		try(Connection c = ConnectionUtil.getConnectionFromFile();
			PreparedStatement ps = c.prepareStatement(sql))
		{		
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				User user = new User();
				ticket = new Ticket(rs.getInt("TICKET_USERID"), rs.getString("TICKET_NAME"), rs.getString("TICKET_RESOLVER"), rs.getFloat("TICKET_AMOUNT"), rs.getString("TICKET_STATUS"));
				user.setFirstName(rs.getString("USER_FIRSTNAME"));
				user.setLastName(rs.getString("USER_LASTNAME"));
				user.setTitle(rs.getString("USER_TITLE"));
				ticket.setTicketOpener(user);
				ticketList.add(ticket);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return ticketList;
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
