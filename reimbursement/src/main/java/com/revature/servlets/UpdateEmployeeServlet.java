package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.model.User;

public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!User.isNull() && !User.isManager()) {
			
			int eId = new EmployeeDaoImpl().getEmployeeById(User.getUserId()).getId();
			String firstname = request.getParameter("first_name");
			String lastname = request.getParameter("last_name");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			EmployeeDao ed = new EmployeeDaoImpl();
			Employee e = new Employee();
			e.setId(eId);
			e.setFirstname(firstname);
			e.setLastname(lastname);
			e.setUsername(username);
			e.setPassword(password);
			
			ed.updateEmployee(e);;
			response.sendRedirect("employeehome");
		} else {
			response.sendRedirect("login");
		}

	}

}
