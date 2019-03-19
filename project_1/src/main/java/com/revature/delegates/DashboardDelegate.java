package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DashboardDelegate {

	public void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("username")==null) {
			request.getSession().invalidate();
			response.sendRedirect("login");
		} else {
			request.getRequestDispatcher("Profile.html").forward(request, response);
		}
	}
}
