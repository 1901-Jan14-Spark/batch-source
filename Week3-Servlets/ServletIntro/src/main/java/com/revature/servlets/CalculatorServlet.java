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
	
	CalculatorService calculatorService = new CalculatorService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//		System.out.println("do get request handler method invoked in our calculator servlet");
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter pw = response.getWriter();
//		pw.write("<p><h2>My Calculator Page </h2></p>");
//		pw.close();
		
		RequestDispatcher rd = request.getRequestDispatcher("Calculator.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// get our operation --> get "operation" parameter from our request object
		String operation = request.getParameter("operation");
		
		// get our numeric inputs --> get "n1" and "n2" parameters from our request object and parse them
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		
		System.out.println(operation+" on "+ n1+ " and "+ n2);
		
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		
		// perform operation
		int result = calculatorService.caculate(num1, num2, operation);
		
		// return result --> use print writer to print to our page
//		PrintWriter pw = response.getWriter();
//		pw.write("<p> The answer is: "+ result+"</p>");
		
		request.setAttribute("result", Integer.toString(result));
		
		PrintWriter pw = response.getWriter();
		pw.write("<p>CalculatorServlet before including</p>");
		
		RequestDispatcher rd = request.getRequestDispatcher("answer");
		rd.include(request, response);
		
		pw.write("<p>CalculatorServlet after including</p>");
		
	}

}
