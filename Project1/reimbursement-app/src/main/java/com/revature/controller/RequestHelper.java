package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delagate.EmployeeDelegate;
import com.revature.delagate.ViewDelegate;

public class RequestHelper {
	ViewDelegate vd = new ViewDelegate();
	EmployeeDelegate ed = new EmployeeDelegate();
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
			System.out.println(record);
			switch (record) {
			case "employee":
				// direct req/resp to employee delegate
				if ("GET".equals(request.getMethod())) {
					//ed.getEmployees(request, response);
				} else if ("POST".equals(request.getMethod())) {
					//ed.createEmployee(request, response);
				} else {
					response.sendError(405, "Method Not Supported for /" + record);
				}
				break;
			case "reimbursement":
				if ("GET".equals(request.getMethod())) {
					//ed.getEmployees(request, response);
				} else if ("POST".equals(request.getMethod())) {
					//ed.createEmployee(request, response);
				} else {
					response.sendError(405, "Method Not Supported for /" + record);
				}
			default:
				response.sendError(404, "Record Not Supported");
			}
		}
		else if(uri.startsWith("/login")&& "POST".equals(request.getMethod())) {
				ed.validateLogin(request, response);
			}
		else {
			// direct req/resp to view delegate
			// invoke its method which handles forwarding to the appropriate static web page
			vd.returnView(request, response);
		}

	}

}
