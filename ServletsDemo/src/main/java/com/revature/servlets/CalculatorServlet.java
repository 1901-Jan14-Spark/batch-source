package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.CalculatorService;

public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	CalculatorService calcServ = new CalculatorService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		System.out.println("do get request handler method invoked in our calculator servlet");
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/html;charset=UTF-8");
//		pw.write("<h2>My Calculator Page</h2>");
		
		RequestDispatcher rd = request.getRequestDispatcher("calculator.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//get our operation --> get "operation" parameter from our request object
			String operation = request.getParameter("operation");
		
		//get numeric inputs --> get "n1" and "n2" parameters from our request object, parse to int
			String n1 = request.getParameter("n1");
			String n2 = request.getParameter("n2");
			
			System.out.println(operation+" on "+n1+ " and "+n2);
			
			int num1 = Integer.parseInt(n1);
			int num2 = Integer.parseInt(n2);
			int result = calcServ.calculate(num1, num2, operation);
//			PrintWriter pw = response.getWriter();
////			response.setContentType("text/html;charset=UTF-8");
//			pw.write("<p> The answer is: "+result+"</p>");
			
			request.setAttribute("result", Integer.toString(result));
			RequestDispatcher rd = request.getRequestDispatcher("answer");
			rd.forward(request, response);
		
	}
}
