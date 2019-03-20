package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TicketDao;
import com.dao.imp.TicketDaoImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.TicketHandler;

public class TicketHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TicketDao ticketdao = new TicketDaoImp();
		ObjectMapper om = new ObjectMapper();
		HttpSession session = request.getSession();
		String[] strArr = request.getReader().readLine().replaceAll("[\\[\\]]+", "").split("[^,]+,[^,]+");
		System.out.println(strArr.length);
		for(int i = 0; i < strArr.length; ++i)
		{
			System.out.println(strArr[i]);
		}
//		TicketHandler th = om.readValue(request.getReader().readLine(), TicketHandler.class);
//		ticketdao.updateTicket(th.getUserId(), th.getStatus(), session.getAttribute("firstname") +" "+ session.getAttribute("lastname"));
	}
}
