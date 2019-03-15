package com.revature.servlets.manager;

import java.io.IOException;
import java.math.BigDecimal;

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
import com.revature.utility.User;


public class UpdateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public UpdateRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!User.isNull() && User.isManager()) {
			double a = Double.parseDouble(request.getParameter("amount"));
			BigDecimal amount = BigDecimal.valueOf(a);
			String status = request.getParameter("status");
			int id = Integer.parseInt(request.getParameter("id"));
			// request.getParameter("reason");
			RequestDao rd = new RequestDaoImpl();
			Request r = new Request();
			r.setId(id);
			r.setStatus(status);
			r.setAmount(amount);
			Employee e = new EmployeeDaoImpl().getEmployeeById(User.getUserId());
			r.setEmployee(e);
			Manager m = new ManagerDaoImpl().getManagerById(User.getUserId());
			r.setManager(m);
			rd.updateRequest(r);
			response.sendRedirect("managerhome");
		} else {
			response.sendRedirect("login");
		}

	}

}
