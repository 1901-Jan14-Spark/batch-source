package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String address = request.getRequestURI().substring(request.getContextPath().length()+1);
		switch(address) {
		case "employee":
			request.getRequestDispatcher("/static/Views/Employee.html").forward(request, response);
			break;
		case "manager":
			request.getRequestDispatcher("/static/Views/Manager.html").forward(request, response);
			break;
		default:
			response.sendError(404, "Static Resource Not Found");
		}
	}
}
