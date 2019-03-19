package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String address = request.getRequestURI().substring(request.getContextPath().length()+1);
		switch(address) {
		case "login":
			request.getRequestDispatcher("/Views/Login.html").forward(request, response);
		case "edash":
			request.getRequestDispatcher("/Views/EmpDash.html").forward(request, response);
			break;
		case "mdash":
			request.getRequestDispatcher("/Views/MangDash.html").forward(request, response);
			break;
		default:
			response.sendError(404, "Page Not Found");
		}
		
	}
}
