package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TicketDao;
import com.dao.imp.TicketDaoImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Ticket;

public class DeclinedTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TicketDao ticketdao = new TicketDaoImp();
		List<Ticket> tickets = ticketdao.getTicketsByStatus("Declined");
		ObjectMapper om = new ObjectMapper();
		String ticketJSON = om.writeValueAsString(tickets);
		PrintWriter pw = response.getWriter();
		pw.print(ticketJSON);
		pw.close();
	}
}
