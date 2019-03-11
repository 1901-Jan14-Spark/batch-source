package com.revature.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
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

	private static final long serialVersionUID = 1L;

	public SubmitRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqD = null;
		
		if (!User.isNull() && !User.isManager()) {
			double a = Double.parseDouble(request.getParameter("amount"));
			BigDecimal amount = BigDecimal.valueOf(a);
			RequestDao rd = new RequestDaoImpl();
			Request r = new Request();
			r.setId(17);
			r.setStatus("pending");
			r.setAmount(amount);
			Employee e = new EmployeeDaoImpl().getEmployeeById(User.getUserId());
			r.setEmployee(e);
			r.setManager(null);
			rd.addRequest(r);
			reqD = request.getRequestDispatcher("requests.html");
		} else {
			reqD = request.getRequestDispatcher("login.html");
		}
		reqD.forward(request, response);
	}


}
