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
			request.getRequestDispatcher("/static/Views/Login.html").forward(request, response);
			break;
		case "edash":
			if(request.getSession().getAttribute("id") == null) {
				request.getSession().invalidate();
				response.sendRedirect("/login");
			} else {
				request.getRequestDispatcher("/static/Views/EmpDash.html").forward(request, response);
			}
			break;
		case "mdash":
			if(request.getSession().getAttribute("id") == null) {
				request.getSession().invalidate();
				response.sendRedirect("/login");
			} else {
				request.getRequestDispatcher("/static/Views/EmpDash.html").forward(request, response);
			}
			break;
		default:
			response.sendError(404, "Page Not Found");
		}
		
	}
}
