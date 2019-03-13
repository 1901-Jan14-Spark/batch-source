package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.utility.User;

public class ManagerHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagerHomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!User.isNull() && User.isManager() && request.getSession().getAttribute("username") != null ) {
			request.getRequestDispatcher("Views/ManagerHome.html").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

}
