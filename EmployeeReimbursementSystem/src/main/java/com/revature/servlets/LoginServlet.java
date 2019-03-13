package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.utility.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("Views/Login.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();

		if (request.getParameter("btn").equals("I'm a Manager")) {
			ManagerDao md = new ManagerDaoImpl();
			Manager manager = md.getManagerByUsername(username);
			if (manager.login(password)) {
				User.setUser(manager.getId(), true);
				session.setAttribute("username", manager);
				response.sendRedirect("managerhome");
			} else {
				response.sendRedirect("login");
			}
		} else if (request.getParameter("btn").equals("I'm an Employee")) {
			EmployeeDao ed = new EmployeeDaoImpl();
			Employee employee = ed.getEmployeeByUsername(username);
			if (employee.login(password)) {
				User.setUser(employee.getId(), false);
				session.setAttribute("username", employee);
				response.sendRedirect("employeehome");
			} else {
				response.sendRedirect("login");
			}
		}

	}

}
