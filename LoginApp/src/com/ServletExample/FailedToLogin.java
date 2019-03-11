package com.ServletExample;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FailedToLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String result = (String) request.getAttribute("result");
		
		response.setContentType("text/html;charset=UTF-8");

		

		//String userName = request.getParameter("goBack");
		
		
		
		PrintWriter pw = response.getWriter();
	pw.write("<p> Invalid login</p>");
		pw.write("<p><a href=\"../LoginApp\" > Try Again! </a> </p>");
	
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/");
		//rd.forward(request, response);
		
	}

}


