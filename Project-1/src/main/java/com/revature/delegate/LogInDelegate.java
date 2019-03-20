package com.revature.delegate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.LogIn_Service;

public class LogInDelegate {

	public void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRequestURI().substring(request.getContextPath().length()+1);
		System.out.println(address);
		switch(address) {
		case "LogIn":
//			HttpSession session = request.getSession();
//			session.invalidate();
			request.getRequestDispatcher("/static/Views/LogIn.html").forward(request, response);
			break;
		case "LogOut":
//			HttpSession session = request.getSession();
//			session.invalidate();
			//			request.getRequestDispatcher("/static/Views/Directory.html").forward(request, response);
			request.getRequestDispatcher("/static/Views/LogIn.html").forward(request, response);
			break;
		default:
			response.sendError(404,"Static Resource Was Not Found");
		}
	}
		public void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String address = request.getRequestURI().substring(request.getContextPath().length()+1);
			System.out.println(address);
			switch(address) {
			case "LogOut":
//				HttpSession session = request.getSession();
//				session.invalidate();
				request.getRequestDispatcher("/static/Views/LogIn.html").forward(request, response);
				break;
			
			default:
				response.sendError(404,"Static Resource Was Not Found");
			}
	}

	public void validation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String position = request.getParameter("Position");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();


		int result = LogIn_Service.varifyEmp(position, username, password);
		System.out.println("result: "+result);
		switch(result) {
		case 0:
			RequestDispatcher rd = request.getRequestDispatcher("/static/Views/Incorrect.html");
			System.out.println("case 0");
			rd.forward(request, response);
			break;

		case 1:
			session.setAttribute("username", username);
			rd = request.getRequestDispatcher("/static/Views/EmployeeHomepage.html");
			rd.forward(request, response);
			break;
		case 2:
			session.setAttribute("username", username);
			rd = request.getRequestDispatcher("/static/Views/ManagerHomePage.html");
			rd.forward(request, response);
			break;
			default:
				 rd = request.getRequestDispatcher("/static/Views/Incorrect.html");
				System.out.println("default case");
				rd.forward(request, response);
		}
		//		System.out.println("result" + result);
		//		if("Employee".contentEquals(position)) {
		//			boolean result = LogIn_Service.varifyEmp(position, username, password);
		//			if (result) {
		//				RequestDispatcher rd = request.getRequestDispatcher("/static/Views/EmployeeHomepage.html");
		//				rd.forward(request, response);
		//			}else {
		//				RequestDispatcher rd = request.getRequestDispatcher("/static/Views/Incorrect.html");
		//				rd.forward(request, response);
		//			}
		//		}else {
		//			boolean result = LogIn_Service.varifyMan(position, username, password);
		//			if (result) {
		//				RequestDispatcher rd = request.getRequestDispatcher("/static/Views/ManagerHomePage.html");
		//				rd.forward(request, response);
		//			}else {
		//				RequestDispatcher rd = request.getRequestDispatcher("/static/Views/Incorrect.html");
		//				rd.forward(request, response);
		//			}

	}


}
