package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.model.User;


public class UpdateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public UpdateRequestServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!User.isNull() && User.isManager()) {
			double amount = Double.parseDouble(request.getParameter("amount"));
			String status = request.getParameter("status");
			int id = Integer.parseInt(request.getParameter("id"));
			RequestDao rd = new RequestDaoImpl();
			Request r = new Request();
			Employee e = new EmployeeDaoImpl().getEmployeeById(User.getUserId());
			Manager m = new ManagerDaoImpl().getManagerById(User.getUserId());
			r.setId(id);
			r.setStatus(status);
			r.setAmount(amount);
			r.setEmployee(e);
			r.setManager(m);
			rd.updateRequest(r);
			response.sendRedirect("managerhome");
		} else {
			response.sendRedirect("login");
		}

	}

}
