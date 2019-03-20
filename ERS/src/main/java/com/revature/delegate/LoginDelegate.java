package com.revature.delegate;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.im.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.service.LoginService;

public class LoginDelegate {

	LoginService lService = new LoginService();
	
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String loginType = lService.redirectLogin(email, password);
		
		request.setAttribute("message", loginType);
		
		System.out.println("checkedInput " +loginType);
		
		if(loginType == "invalidEmail" || loginType == "incorrect") {
			response.sendRedirect("index");
		} else {
			if("manager".matches(loginType)) {
				HttpSession session = request.getSession();
				EmployeeDao eDao = new EmployeeDaoImpl();
				Employee e = eDao.getEmployeeByEmail(email);
				session.setAttribute("email", email);
				session.setAttribute("fname", e.getFname());
				session.setAttribute("lname", e.getLname());
				response.sendRedirect("manager");
			} else {
				HttpSession session = request.getSession();
				EmployeeDao eDao = new EmployeeDaoImpl();
				Employee e = eDao.getEmployeeByEmail(email);
				session.setAttribute("email", email);
				session.setAttribute("fname", e.getFname());
				session.setAttribute("lname", e.getLname());
				response.sendRedirect("employee");
			}		
		}
	}
}
