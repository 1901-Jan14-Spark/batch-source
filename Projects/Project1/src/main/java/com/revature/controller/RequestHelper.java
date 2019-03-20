package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.DepartmentDelegate;
import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.LoginDelegate;
import com.revature.delegate.LogoutDelegate;
import com.revature.delegate.ReimbursementDelegate;
import com.revature.delegate.SessionDelegate;
import com.revature.delegate.ViewDelegate;

public class RequestHelper {
	
	EmployeeDelegate ed = new EmployeeDelegate();
	DepartmentDelegate dd = new DepartmentDelegate();
	ReimbursementDelegate rd = new ReimbursementDelegate();
	LoginDelegate lid = new LoginDelegate();
	LogoutDelegate lod = new LogoutDelegate();
	ViewDelegate vd = new ViewDelegate();
	SessionDelegate sd = new SessionDelegate();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
			System.out.println(record);
			switch (record) {
			case "employees":
				// direct request and response to employee delegate
				if ("GET".equals(request.getMethod())) {
					ed.getEmployees(request, response);
				} else if ("POST".equals(request.getMethod())) {
					ed.updateEmployee(request, response);
				} else {
					response.sendError(405, "Method Not Supported For /" + record);
				}
				break;
			case "employees/emp":
				if ("GET".equals(request.getMethod())) {
					ed.getEmployee(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "reimbursements":
				// direct request and response to department delegate
				if ("GET".equals(request.getMethod())) {
					rd.getRefunds(request, response);
				} else if ("POST".equals(request.getMethod())) {
					rd.createRefundRequest(request, response);
				} else if ("PUT".equals(request.getMethod())) {
					rd.createRefundRequest(request, response);
				} else {
					response.sendError(405, "Method Not Supported For /" + record);
				}
				break;
			case "reimbursements/emp":
				if ("GET".equals(request.getMethod())) {
					rd.getRefunds(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "reimbursement/validate":
				if ("PUT".equals(request.getMethod())) {
					
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "reimbursement/decline":
				if ("PUT".equals(request.getMethod())) {
					rd.approveRequest(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "login":
				if ("POST".equals(request.getMethod())) {
					lid.login(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "logout":
				if ("GET".equals(request.getMethod())) {
					lod.logout(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "session":
				if ("GET".equals(request.getMethod())) {
					sd.check(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			default:
				response.sendError(404, "Record Not Supported");
				break;
			}
		} else {
			vd.returnView(request, response);
		}
	}
}
