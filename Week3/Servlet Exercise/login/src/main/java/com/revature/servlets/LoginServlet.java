package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.LoginService;

public class LoginServlet extends HttpServlet {

	LoginService loginService = new LoginService();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("do get request handler method invoked in our login servlet");

		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Boolean result = loginService.validate(username, password);

		PrintWriter pw = response.getWriter();

		response.setContentType("text/html;charset=UTF-8");

		pw.write("<p> Your result is: " + result + "</p>");
		if (result == false) {
			pw.write("<p><a href=\"login.html\" > Login Again! </a> </p>");
		}

		pw.close();
	}

}
