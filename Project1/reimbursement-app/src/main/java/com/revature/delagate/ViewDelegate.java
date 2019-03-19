package com.revature.delagate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewDelegate {
	public void returnView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String address = request.getRequestURI().substring(request.getContextPath().length() + 1);
		// todo: alter below to static resources
		HttpSession session = request.getSession(false);
		switch (address) {
		case "login":
			if(session!=null) {
			session.invalidate();
			}
			request.getRequestDispatcher("/static/Views/login.html").forward(request, response);
			break;
		case "home":
			if (session != null) {
				if ((boolean) session.getAttribute("isManager")) {
					request.getRequestDispatcher("/static/Views/Manager.html");
				} else {
					request.getRequestDispatcher("/static/Views/Employee.html").forward(request, response);
				}
				break;
			}
		default:
			if (session == null) {
				response.sendRedirect("http://localhost:8080/reimbursement-app/login");
			} else {
				response.sendRedirect("http://localhost:8080/reimbursement-app/home");
			}
		}
	}

}
