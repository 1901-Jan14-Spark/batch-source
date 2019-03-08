package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.LoginService;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5901784448217028279L;
	private LoginService ls = new LoginService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd =request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		
		System.out.println("Username: " + n1 + ", and password: " + n2);
		
		boolean loggedIn = ls.login(n1, n2);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		if(loggedIn) {
			pw.write("<p>Login successful!</p>");
		} else {
			pw.write("<p>Login failure.<br><a href=\"login.html\">Try Again</a></p>");
		}
	}
	
}
