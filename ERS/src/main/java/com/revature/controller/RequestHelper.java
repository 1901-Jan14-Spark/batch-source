package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.LoginDelegate;
import com.revature.delegate.LogoutDelegate;
import com.revature.delegate.ReimbursementDelegate;
import com.revature.delegate.SessionDelegate;
import com.revature.delegate.ViewDelegate;


public class RequestHelper {

	EmployeeDelegate ed = new EmployeeDelegate();
	ReimbursementDelegate rd = new ReimbursementDelegate();
	ViewDelegate vd = new ViewDelegate();
	LoginDelegate ld = new LoginDelegate();
	SessionDelegate sd = new SessionDelegate();
	LogoutDelegate logoutd = new LogoutDelegate();

	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		if (uri.startsWith("/login")){
			ld.checkLogin(request, response);
		}
		if (uri.startsWith("/session")){
			sd.viewSession(request, response);
		}
		if(uri.startsWith("/updateEmp")) {
			ed.updateEmployee(request, response);
		}
		if(uri.startsWith("/resolvereq")) {
			rd.updateReimbursement(request, response);
		}
		if(uri.startsWith("/sendReq")) {
			rd.createReimbursement(request, response);
		}
		if(uri.startsWith("/logout")) {
			logoutd.logoutUser(request, response);
		}
		
		
		if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
			System.out.println(record);
			switch (record) {
			case "employees":
				// direct request/response to employee delegate
				if ("GET".equals(request.getMethod())) {
					ed.getEmployees(request, response);
//				} else if ("POST".equals(request.getMethod())) {
//					ed.createEmployee(request, response);
				} else {
					response.sendError(405, "Method Not Supported for /" + record);
				}
				break;
			case "reimbursements":
				// direct request/response to expense delegate
				if ("GET".equals(request.getMethod())) {
					rd.getReimbursements(request, response);
				} else if ("POST".equals(request.getMethod())) {
//					rd.createReimbursement(request, response);
					rd.updateReimbursement(request, response);
					
				} else {
					response.sendError(405, "Method Not Supported for /" + record);
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
