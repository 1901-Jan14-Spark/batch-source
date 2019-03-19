package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class SessionDelegate {
	private EmployeeService eService = new EmployeeService();
	public void checkSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		String employeeJSON;
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if( session!=null && session.getAttribute("username")!=null) {
			Employee emp=eService.getEmployeeByUsername((String) session.getAttribute("username"));
			employeeJSON = om.writeValueAsString(emp);
			
			pw.write(employeeJSON);
			System.out.println("writing1");
			System.out.println(session.getAttribute("username"));
		} else {
			pw.write("{\"username\": null }");
			System.out.println("writing2");
		}
		pw.close();
		
	}
}
