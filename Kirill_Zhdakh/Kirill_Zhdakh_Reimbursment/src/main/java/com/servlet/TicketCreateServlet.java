package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TicketDao;
import com.dao.imp.TicketDaoImp;
import com.model.Ticket;

public class TicketCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ticket ticket = new Ticket();
		TicketDao ticketdao = new TicketDaoImp();
		
		ticket.setUserId((int)request.getSession().getAttribute("id"));
		ticket.setStatus("Pending");
		ticket.setName(request.getParameter("descript"));
		ticket.setAmount(Float.parseFloat(request.getParameter("amount")));
		ticketdao.createTicket(ticket);
		response.sendRedirect("dashboard");
	}

}
