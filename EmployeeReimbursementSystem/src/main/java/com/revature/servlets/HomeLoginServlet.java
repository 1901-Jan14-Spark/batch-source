package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.utility.User;

public class HomeLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HomeLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = null;
		
		if (request.getParameter("btn").equals("I'm a Manager")) {
			ManagerDao md = new ManagerDaoImpl();
			String username = request.getParameter("username");
			Manager manager = md.getManagerByUsername(username);
			String password = request.getParameter("password");
			if (manager.login(password)) {
				rq = request.getRequestDispatcher("employeehome.html");
			}
		} else if (request.getParameter("btn").equals("I'm an Employee")) {
			EmployeeDao ed = new EmployeeDaoImpl();
			String username = request.getParameter("username");
			Employee employee = ed.getEmployeeByUsername(username);
			String password = request.getParameter("password");
			if (employee.login(password)) {
				rq = request.getRequestDispatcher("employeehome.html");
			} else {
				rq = request.getRequestDispatcher("login.html");
			}
		}
		rq.forward(request, response);
	}
	
	
}
