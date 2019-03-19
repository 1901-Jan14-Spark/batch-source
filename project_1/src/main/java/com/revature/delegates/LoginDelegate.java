package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Employee;
import com.revature.services.LoginService;

public class LoginDelegate {

	private LoginService ls = new LoginService();

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		System.out.println("Attempted login with user: " + email + " and pass: " + password);
		Employee e = ls.login(email, password);

		if (e != null) {
			session.setAttribute("id", e.getId());
			session.setAttribute("email", e.getEmail());
			session.setAttribute("firstname", e.getFirstname());
			session.setAttribute("lastname", e.getLastname());
			session.setAttribute("managerLevel", e.getManagerLevel());

			System.out.println("Successful login");

			if (e.getManagerLevel() > 0) {
				response.sendRedirect("/ReimbursementApp/mdashboard");
			} else {
				response.sendRedirect("/ReimbursementApp/dashboard");
				
			}

		} else {
			response.sendRedirect("/ReimbursementApp/login");
		}

	}
}
