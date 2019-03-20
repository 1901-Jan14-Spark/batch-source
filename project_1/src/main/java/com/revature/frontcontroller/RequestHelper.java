package com.revature.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.LoginDelegate;
import com.revature.delegates.LogoutDelegate;
import com.revature.delegates.ReimbursementDelegate;
import com.revature.delegates.SessionDelegate;
import com.revature.delegates.ViewDelegate;

public class RequestHelper {

	private EmployeeDelegate ed = new EmployeeDelegate();
	private ReimbursementDelegate rd = new ReimbursementDelegate();
	private LoginDelegate ld = new LoginDelegate();
	private LogoutDelegate lod = new LogoutDelegate();
	private ViewDelegate vd = new ViewDelegate();
	private SessionDelegate sd = new SessionDelegate();

	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String uri = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(uri);
			if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
			switch (record) {
			case "employees":
				if ("GET".equals(request.getMethod())) {
					ed.getsEmployees(request, response);
				} else if ("POST".equals(request.getMethod())) {
					System.out.println("Post Received!");
					ed.createsEmployee(request, response);
				} else if ("PUT".equals(request.getMethod())) {
					ed.updatesEmployee(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "employees/emp":
				if ("GET".equals(request.getMethod())) {
					ed.getsEmployee(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "reimbursements/emp":
				if ("GET".equals(request.getMethod())) {
					rd.getsReimbursementsAssociated(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "reimbursement/validate":
				if ("PUT".equals(request.getMethod())) {
					rd.validateReimbursement(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "reimbursement/decline":
				if ("PUT".equals(request.getMethod())) {
					rd.declinesReimbursement(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "reimbursements":
				if ("GET".equals(request.getMethod())) {
					rd.getsReimbursements(request, response);
				} else if ("POST".equals(request.getMethod())) {
					rd.createsReimbursement(request, response);
				} else if ("PUT".equals(request.getMethod())) {
					rd.updatesReimbursement(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "login":
				if ("POST".equals(request.getMethod())) {
					ld.login(request, response);
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
				response.sendError(404, "Record not supported");
				break;
			}
		} else {
			vd.returnView(request, response);
		}
	}
}
