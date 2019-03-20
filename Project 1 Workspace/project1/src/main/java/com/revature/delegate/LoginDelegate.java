package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.LoginService;

public class LoginDelegate {
	LoginService lService = new LoginService();
	
	ObjectMapper om = new ObjectMapper();
	
	String loginJSON;
	
	public void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String asM = request.getParameter("asManager");
		
		String loginJSON;
		String uri;
		Employee e = lService.getLogin(user, pass);
		if("false".equals(asM)) {
			uri = "./employee";
			if(e==null) {
			loginJSON = "";
			response.setStatus(404);
			}
			else {
				Employee dummy = new Employee(e.getId());
				loginJSON = om.writeValueAsString(e);
				request.getSession().setAttribute("currentUser", dummy);
			}
		}
		else if("true".equals(asM) && e.getIsManager() == 1) {
			Employee dummy = new Employee(e.getId());
			uri = "./manager";
			loginJSON = om.writeValueAsString(e);
			request.getSession().setAttribute("currentUser", dummy);
		}
		else {
			loginJSON = "";
			uri = "./login";
			response.setStatus(404);
		}
		PrintWriter pw = response.getWriter();
		pw.write(loginJSON);
		pw.close();
		response.sendRedirect(uri);
	}
}