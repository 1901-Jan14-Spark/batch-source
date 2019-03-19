package com.revature.delagate;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;

public class EmployeeDelegate {
	EmployeeDaoJdbc edj = new EmployeeDaoJdbc();
	public void validateLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String password = request.getParameter("password");
		System.out.println(password);
		String email =  request.getParameter("email");
		System.out.println(email);
		Employee e = edj.getEmployeeByEmail(email);
		//System.out.println(e.toString());
		if(e!=null && password.equals(e.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("eId", e.geteID());
			session.setAttribute("isManager", e.isManager());
			response.sendRedirect("home");
		}
		else {
			String results = "<p> Email/password invalid!<p>";
			request.setAttribute("results", results);
			request.getRequestDispatcher("localhost:8080/reimbursement-app/static/Views/login.html").forward(request, response);		
		}
	}
}
