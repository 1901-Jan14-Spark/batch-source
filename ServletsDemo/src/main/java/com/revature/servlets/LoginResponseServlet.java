package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginResponseServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String messageResult = (String) request.getAttribute("message");
		
		PrintWriter pw = response.getWriter();
		pw.write("<p>"+messageResult+"</p>");
		pw.write("<p><a href=\"login.html\">Try again?</p>");
	}
}
