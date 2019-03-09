package com.revature.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Service.LogInService;

public class LogInServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	LogInService logInService = new LogInService();
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	
		
		
//		PrintWriter pw = response.getWriter();
//		pw.print("<p> Servlet works</p>");
//		pw.close();

	RequestDispatcher rd = request.getRequestDispatcher("LogIn.html");
	rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean result = LogInService.varify(username, password);
		
		if (result) {
			RequestDispatcher rd = request.getRequestDispatcher("Success.html");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Incorrect.html");
			rd.forward(request, response);
		}
		
	
		
	
		
		
		PrintWriter pw = response.getWriter();
		pw.write("<p> Servlet works</p>");
		
		
		
	}

}
	
	
	

