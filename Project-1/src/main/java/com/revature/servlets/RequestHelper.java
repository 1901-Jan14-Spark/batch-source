package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.LogInDelegate;
import com.revature.delegate.ReimbursementDelegate;
import com.revature.delegate.SessionDelegate;
import com.revature.delegate.TableDelegate;


public class RequestHelper {

	LogInDelegate ld = new LogInDelegate();
	TableDelegate td = new TableDelegate();
	SessionDelegate sd= new SessionDelegate();
	ReimbursementDelegate rd= new ReimbursementDelegate();
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
			System.out.println(record);
			switch (record) {
			case "table":
				System.out.println("table case");
				// direct req/resp to employee delegate
				if ("GET".equals(request.getMethod())) {
					td.getEmployees(request, response);
				}
//				} else if ("POST".equals(request.getMethod())) {
//					ed.createEmployee(request, response);
//				} else {
//					response.sendError(405, "Method Not Supported for /" + record);
//				}
				
				break;
			case "session":
			
				if ("GET".equals(request.getMethod())) {
					System.out.println("session");
					sd.checkSession(request, response);
				}
				break;
			case "approve":
				System.out.println("Approve");
				if ("POST".equals(request.getMethod())) {
					System.out.println("post");
					rd.approve(request, response);
				}
				break;
			case "viewActive":
				System.out.println("pam");
				if ("GET".equals(request.getMethod())) {
					System.out.println("post");
					rd.viewActive(request, response);
				}
				break;
			case "viewResolved":
				System.out.println("pam");
				if ("GET".equals(request.getMethod())) {
					System.out.println("post");
					rd.viewResolved(request, response);
				}
				break;
			case "deny":
				System.out.println("Deny");
				if ("POST".equals(request.getMethod())) {
					System.out.println("post");
					rd.deny(request, response);
				}
				break;
			case "active":
				// direct req/resp to department delegate
				if ("GET".equals(request.getMethod())) {
					System.out.println("session");
					td.getActive(request, response);
				}
				break;
			case "resolve":
				// direct req/resp to department delegate
				System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
				if ("GET".equals(request.getMethod())) {
					System.out.println("session");
					td.getResolve(request, response);
				}
				break;
			case "createReimbursement":
				if ("POST".equals(request.getMethod())) {
					System.out.println("Creating Reimbursment");
					rd.createReimbursement(request, response);
				}
				break;
			
			case "changeInfo":
				if ("POST".equals(request.getMethod())) {
					System.out.println("Creating Reimbursment");
					td.changeInfo(request, response);
				}
				break;
			default:
				response.sendError(404, "Record Not Supported");
			}
		} else {
			// direct req/resp to view delegate
			// invoke its method which handles forwarding to the appropriate static web page
			if ("POST".equals(request.getMethod())) {
				ld.validation(request, response);
			}
			ld.logIn(request, response);
			System.out.println(request);
		

	}
	}
}