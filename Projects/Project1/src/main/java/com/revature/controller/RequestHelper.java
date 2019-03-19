package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.DepartmentDelegate;
import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.ViewDelegate;

public class RequestHelper {
	
	EmployeeDelegate ed = new EmployeeDelegate();
	DepartmentDelegate dd = new DepartmentDelegate();
	ViewDelegate vd = new ViewDelegate();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if (uri.startsWith("/Project1/")) {
			String record = uri.substring(10);
			switch (record) {
			case "login":
				// direct request and response to employee delegate
				if ("GET".equals(request.getMethod())) {
					ed.getEmployees(request, response);
				} else if ("POST".equals(request.getMethod())) {
//					ed.createReimbursement(request, response);
				} else {
					response.sendError(405, "Method Not Supported For /" + record);
				}
				break;
			case "departments":
				// direct request and response to department delegate
				if ("GET".equals(request.getMethod())) {
					dd.getDepartments(request, response);
				} else {
					response.sendError(405, "Method Not Supported For /" + record);
				}
				break;
			default:
				response.sendError(404, "Record Not Supported");
			}
		} else {
			vd.returnView(request, response);
		}
	}
	

}
