package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String result = (String) request.getAttribute("result");
		PrintWriter pw = response.getWriter();
		
		if(result.equals("Login Successful!")) {
			pw.write("<p> " + result + "</p>");
		} else {
			pw.write("<p> " + result + "</p>");
			pw.write("<p><a href=\"Login.html\" >Login Again!</a></p>");
		}		
	}
	
	

}
