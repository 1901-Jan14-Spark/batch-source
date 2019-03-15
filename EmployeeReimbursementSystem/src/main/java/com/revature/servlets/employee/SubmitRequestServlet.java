package com.revature.servlets.employee;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.utility.User;

public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = -5296796852497141597L;

	public SubmitRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!User.isNull() && !User.isManager()) {
			double a = Double.parseDouble(request.getParameter("amount"));
			BigDecimal amount = BigDecimal.valueOf(a);
			// request.getParameter("reason");
			RequestDao rd = new RequestDaoImpl();
			Request r = new Request();
			r.setStatus("pending");
			r.setAmount(amount);
			Employee e = new EmployeeDaoImpl().getEmployeeById(User.getUserId());
			r.setEmployee(e);
			r.setManager(null);
			rd.addRequest(r);
			response.sendRedirect("employeehome");
		} else {
			response.sendRedirect("login");
		}

	}
	
}