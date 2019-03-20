package com.revature.delegate;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.Employee;
import com.revature.services.LoginService;

public class LoginDelegate {
	LoginService lService = new LoginService();
	
	
	public void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String asM = request.getParameter("asManager");
		
		HttpSession session = request.getSession();
		
		String uri;
		Employee e = lService.getLogin(user, pass);
		if("true".equals(asM) && e.getIsManager() == 1) {
			int id = e.getId();
			uri = "/manager";
			session.setAttribute("id", id);
		}
		else if(!"true".equals(asM)) {
			uri = "/employee";
			if(e==null) {
			response.setStatus(404);
			}
			else {
				int id = e.getId();
				session.setAttribute("id", id);
			}
		}
		else {
			uri = "/login";
			response.setStatus(404);
		}
		
		response.sendRedirect("/HelloWorld" + uri);
	}
}