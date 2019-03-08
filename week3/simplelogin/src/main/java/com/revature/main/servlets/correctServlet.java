package com.revature.main.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class correctServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2982798417211532103L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = (String) request.getAttribute("email");
		String password = (String) request.getAttribute("password");
		
		response.setContentType("text/html;charset=UTF-8");

		
		PrintWriter pw = response.getWriter();
		pw.write("<p> Email: "+email+"</p>");
		pw.write("<p> Password: "+password+"</p>");
		pw.write("<p><a href=\"login.html\" >Logout</a></p>");
	}
}
