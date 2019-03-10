package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.LoginService;


public class LoginServlet extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = -6373916439463578962L;
	private LoginService ls = new LoginService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd =request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		System.out.println("Username: " + user + ", and password: " + pass);

		boolean loggedIn = ls.login(user, pass);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		if(loggedIn) {
			pw.write("<p>Loged successful!</p>");
		} else {
			pw.write("<p>Login failure.<br><a href=\"index.html\">Try Again</a></p>");
		}
	}


}
