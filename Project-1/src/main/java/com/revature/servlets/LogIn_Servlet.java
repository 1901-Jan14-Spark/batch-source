package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.LogIn_Service;
import com.revature.service.LogIn_Service;

public class LogIn_Servlet extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LogIn_Service logInService = new LogIn_Service();
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	
		
		
//		PrintWriter pw = response.getWriter();
//		pw.print("<p> Servlet works</p>");
//		pw.close();

//	RequestDispatcher rd = request.getRequestDispatcher("Views/LogIn.html");
//	rd.forward(request, response);
//		
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//		String position = request.getParameter("Position");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		boolean result = LogIn_Service.varify(position, username, password);
//		
//		if (result) {
//			RequestDispatcher rd = request.getRequestDispatcher("Views/EmployeeHomepage.html");
//			rd.forward(request, response);
//		}else {
//			RequestDispatcher rd = request.getRequestDispatcher("Views/Incorrect.html");
//			rd.forward(request, response);
//		}
//		
//	
//		
//	
//		
//		
//		PrintWriter pw = response.getWriter();
//		pw.write("<p> Servlet works</p>");
//		
//		
//		
//	}

}
}
