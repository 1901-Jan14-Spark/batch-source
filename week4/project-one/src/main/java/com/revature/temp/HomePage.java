package com.revature.temp;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String result = (String) request.getAttribute("result");
		
		response.setContentType("text/html;charset=UTF-8");

		

		//String userName = request.getParameter("goBack");
		
		
		
		PrintWriter pw = response.getWriter();
	pw.write("<p> Login Successfull!!</p>");
		
	
		
		
	}

}



