package com.revature.delegate;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutDelegate {

	public void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		
		response.sendRedirect("http://localhost:8080/EmployeePortal/login");
	}
}

