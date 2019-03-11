package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.LoginInService;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	LoginInService login = new LoginInService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher rd = request.getRequestDispatcher("SimpleLogIn.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int result = login.checkUser(username, password);
		
		request.setAttribute("result", ""+result);
		
		RequestDispatcher rd = request.getRequestDispatcher("result");
		rd.forward(request, response);
	}
	
}
