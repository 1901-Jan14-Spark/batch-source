package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String result = (String) request.getAttribute("result");
		
//		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<p>Your result is: "+result+"</p>");
		pw.write("<p><a href=\"calculator.html\"> Calculate Again! </a> </p>");
		
	}
}
