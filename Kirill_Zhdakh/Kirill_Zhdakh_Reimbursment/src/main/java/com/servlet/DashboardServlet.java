package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("username")==null) {
			response.sendRedirect("login");
		} else {
			request.getSession().removeAttribute("error");
			if ("Employee".equals(request.getSession().getAttribute("title")))
				request.getRequestDispatcher("Views/EmployeeDashboard.html").forward(request, response);
			else
				request.getRequestDispatcher("Views/ManagerDashboard.html").forward(request, response);
		}
	}
}
