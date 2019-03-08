package com.revature.main.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

	private static final long serialVersionUID = 6831085441048570808L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String username = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		
		RequestDispatcher rd;
		
		if(username.equals("login@login.com") && password.equals("login")) {
			request.setAttribute("email", username);
			request.setAttribute("password", password);
			rd = request.getRequestDispatcher("correct");
		} else {
			rd = request.getRequestDispatcher("wrong");
		}
		
		rd.forward(request, response);
	}
}
