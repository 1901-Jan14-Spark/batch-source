package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		RequestDispatcher rd = request.getRequestDispatcher("resources/login.html");
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals("un") && password.equals("pw")) {
			RequestDispatcher rd = request.getRequestDispatcher("success");
			rd.forward(request, response);
		}else {
	
			RequestDispatcher rd = request.getRequestDispatcher("failure");
			rd.forward(request, response);
		}
	}
	
}
