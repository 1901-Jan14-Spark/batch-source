package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.ReimbursementDelegate;
import com.revature.delegate.ViewDelegate;


public class RequestHelper {

	EmployeeDelegate ed = new EmployeeDelegate();
	ReimbursementDelegate rd = new ReimbursementDelegate();
	ViewDelegate vd = new ViewDelegate();

	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
			System.out.println(record);
			switch (record) {
			case "employees":
				// direct req/resp to employee delegate
				if ("GET".equals(request.getMethod())) {
					ed.getEmployees(request, response);
				} else if ("POST".equals(request.getMethod())) {
					ed.createEmployee(request, response);
				} else {
					response.sendError(405, "Method Not Supported for /" + record);
				}
				break;
			case "departments":
				// direct req/resp to expense delegate
				if ("GET".equals(request.getMethod())) {
					rd.getReimbursements(request, response);
				} else if ("POST".equals(request.getMethod())) {
					rd.createReimbursement(request, response);
				} else {
					response.sendError(405, "Method Not Supported for /" + record);
				}
				break;
			default:
				response.sendError(404, "Record Not Supported");
			}
		} else {
			// direct req/resp to view delegate
			// invoke its method which handles forwarding to the appropriate static web page
			vd.returnView(request, response);
		}

	}
}
