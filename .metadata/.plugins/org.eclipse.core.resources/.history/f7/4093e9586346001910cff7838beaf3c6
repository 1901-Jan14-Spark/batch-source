package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.LoginService;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	LoginService login = new LoginService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Get Handler MEthod");
		response.setContentType("text/html;charset=UTF-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String result = login.loginResult(username,  password);
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("result");
		rd.forward(request, response);
	}

}
