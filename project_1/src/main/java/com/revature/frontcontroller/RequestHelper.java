package com.revature.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.ReimbursementDelegate;

public class RequestHelper {

	private EmployeeDelegate ed = new EmployeeDelegate();
	private ReimbursementDelegate rd = new ReimbursementDelegate();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());

		if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
			switch (record) {
			case "employees":
				if ("GET".equals(request.getMethod())) {
					ed.getsEmployees(request, response);
				} else if ("POST".equals(request.getMethod())) {
					ed.createsEmployee(request, response);
				} else if ("PUT".equals(request.getMethod())) {
					ed.updatesEmployee(request, response);
				}else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;
			case "reimbursements":
				if ("GET".equals(request.getMethod())) {
					rd.getsReimbursements(request, response);
				} else if ("POST".equals(request.getMethod())) {
					rd.createsReimbursement(request, response);
				}else if ("PUT".equals(request.getMethod())) {
					rd.updatesReimbursement(request, response);
				} else {
					response.sendError(405, "Method not supported for /" + record);
				}
				break;

			default:
				response.sendError(404, "Record not supported");
				break;
			}
		} else {
//			vd.returnView(request, response);
		}
	}
}
