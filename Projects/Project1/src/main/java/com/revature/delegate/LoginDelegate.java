package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.company.Employee;
import com.revature.services.LoginService;

public class LoginDelegate {
	
	private LoginService ls = new LoginService();

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		System.out.println("Attempted login with user: " + username + " and pass: " + password);
		Employee e = ls.loginResult(username, password);

		if (e != null) {
			session.setAttribute("id", e.getEmpId());
			session.setAttribute("username", e.getUsername());
			session.setAttribute("firstname", e.getFirstName());
			session.setAttribute("lastname", e.getLastName());

			System.out.println("Successful login");
			
			if (username.equals("user") && password.equals("password")) {
				response.sendRedirect("/Project1/MangDash");
			} else {
				response.sendRedirect("/Project1/EmpDash");			
			}

//			if ((e.getEmpId() == 2) || (e.getEmpId() == 4) || (e.getEmpId() == 11) || (e.getEmpId() == 13) || (e.getEmpId() == 18)) {
//				response.sendRedirect("/Project1/MangDash");
//			} else {
//				response.sendRedirect("/Project1/EmpDash");			
//			}
		} else {
			response.sendRedirect("/Project1/login");
		}

	}

}
