package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * This class will contain the implementation to forward any static requests 
 * to the appropriate static resource
 * 
 */
public class ViewDelegate {
	
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRequestURI().substring(request.getContextPath().length()+1);
		switch(address) {
		case "new":
			request.getRequestDispatcher("/static/Views/NewEmployee.html").forward(request, response);
			break;
		case "employees":
			request.getRequestDispatcher("/static/Views/Directory.html").forward(request, response);
			break;
		default:
			response.sendError(404,"Static Resource Not Found");
		}
	}

}
