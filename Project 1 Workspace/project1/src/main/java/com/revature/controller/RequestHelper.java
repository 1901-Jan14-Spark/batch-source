package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.LoginDelegate;
import com.revature.delegate.ReimbursementDelegate;
import com.revature.delegate.SessionDelegate;
import com.revature.delegate.ViewDelegate;

public class RequestHelper {

	EmployeeDelegate ed = new EmployeeDelegate();
	ReimbursementDelegate rd = new ReimbursementDelegate();
	ViewDelegate vd = new ViewDelegate();
	LoginDelegate ld = new LoginDelegate();
	SessionDelegate sd = new SessionDelegate();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")) {
			String record = uri.substring(5);
			System.out.println(record);
			switch(record) {
			case "employees":
				if("GET".equals(request.getMethod())) {
					ed.getEmployees(request, response);
				}
				else if("POST".equals(request.getMethod())) {
					ed.createEmployee(request, response);
				}
				else if ("PUT".equals(request.getMethod())) {
					ed.updateEmployee(request, response);
				}
				else if ("DELETE".equals(request.getMethod())){
					ed.deleteEmployee(request, response);
				}
				else {
					response.sendError(405, "Method Not Supported for /" + record);
				}
				break;
			case "reimbursements":
				if("GET".equals(request.getMethod())) {
					rd.getReimbursements(request, response);
				}
				else if ("POST".equals(request.getMethod())) {
					rd.createReimbursement(request, response);
				}
				else if ("PUT".equals(request.getMethod())) {
					rd.updateReimbursement(request, response);
				}
				else if ("DELETE".equals(request.getMethod())){
					rd.deleteReimbursement(request, response);
				}
				else {
					response.sendError(405, "Method Not Supported for /" + record);
				}
				break;
			default:
				response.sendError(404, "Record Not Supported");
			}
		}
		else if(uri.startsWith("/getlogin")) {
				ld.getLogin(request, response);
		}
		else if(uri.startsWith("/logout"))	{
			request.getSession(false).invalidate();
			response.sendRedirect("../login");
		}
		else if(uri.startsWith("/session")) {
				sd.session(request, response);
		}
		else {
			vd.returnView(request, response);
		}
	}
}
