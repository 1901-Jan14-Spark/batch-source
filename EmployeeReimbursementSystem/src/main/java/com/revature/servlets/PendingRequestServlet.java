package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.model.Request;
import com.revature.utility.User;

public class PendingRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PendingRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(!User.isNull() && !User.isManager()) {
			RequestDao rd = new RequestDaoImpl();
			ObjectMapper om = new ObjectMapper();
			PrintWriter pw = response.getWriter();
			List<Request> requests = rd.getPendingRequestsByEmployeeId(User.getUserId());
			String requestString = om.writeValueAsString(requests);
			requestString = "{\"requests\":" + requestString+"}";
			pw.print(requestString);
		} else {
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
