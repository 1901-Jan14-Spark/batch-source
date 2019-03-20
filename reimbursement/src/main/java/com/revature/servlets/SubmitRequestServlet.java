package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.model.User;

public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = -5296796852497141597L;

	public SubmitRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!User.isNull() && !User.isManager()) {
			
			double amount = Double.parseDouble(request.getParameter("amount"));	
//			Integer n = Integer.parseInt(request.getParameter("managerId"));
//			Manager m = new ManagerDaoImpl().getManagerById(n);
			
			RequestDao rd = new RequestDaoImpl();
			Employee e = new EmployeeDaoImpl().getEmployeeById(User.getUserId());

			Request r = new Request();
			
			r.setStatus("pending");
			r.setAmount(amount);
			r.setEmployee(e);		
			r.setManager(null);
			
			rd.addRequest(r);
			response.sendRedirect("employeehome");
		} else {
			response.sendRedirect("login");
		}

	}
	
}