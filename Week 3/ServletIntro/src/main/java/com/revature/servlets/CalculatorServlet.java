package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.CalculatorService;

public class CalculatorServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	CalculatorService calc = new CalculatorService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//		System.out.println("do get request handler method invoked in our calculator servlet");
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter pw = response.getWriter();
//		pw.write("<h2>My Calculator Page</h2>");
//		pw.close();
		
		RequestDispatcher rd = request.getRequestDispatcher("Calculator.html");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//get our operation --> get "Operation" parameter from out request object
		String operation = request.getParameter("operation");
		
		//get our numeric inputs --> get "n1" and "n2" parameters from our request object and parse them
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		
		//perform operation
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		
		int result = calc.caculate(num1, num2, operation);
		
		//return result --> use print writer to print to our page
//		PrintWriter pw = response.getWriter();
//		pw.write("<p> The anwser is: " +result+"</p>");
		RequestDispatcher rd = request.getRequestDispatcher("answer");
		rd.forward(request, response);
		
	}
}
