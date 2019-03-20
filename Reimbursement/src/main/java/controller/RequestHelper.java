package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.EmployeesDelegate;
import delegates.LoginDelegate;
import delegates.LogoutDelegate;
import delegates.ReimbursementsDelegate;
import delegates.SessionDelagate;
import delegates.ViewsDelegate;

public class RequestHelper {
	EmployeesDelegate ed = new EmployeesDelegate();
	ReimbursementsDelegate rdel = new  ReimbursementsDelegate();
	ViewsDelegate vd = new ViewsDelegate();
	SessionDelagate sd = new SessionDelagate();
	LogoutDelegate outDel = new LogoutDelegate();
	LoginDelegate ld = new LoginDelegate();	
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
			System.out.println(record);
			switch (record) {
			case "employeeslist":
				if ("GET".equals(request.getMethod())) {
					ed.getEmployees(request, response);
				} else if ("POST".equals(request.getMethod())) {
					ed.createEmployees(request, response);;
				} else {
					response.sendError(405, "Method "+ record +" Not Available");
				}
				return;
			case "reimbursementslist":
				if ("GET".equals(request.getMethod())) {
					rdel.getReimbursements(request, response);
				} else if ("POST".equals(request.getMethod())) {
					rdel.CreateReims(request, response);
				} else if ("PUT".equals(request.getMethod())) {
					rdel.updateReims(request, response);
				} else {
					response.sendError(405, "Method "+ record +" Not Available");
				}
				return;
			case "session":
				if ("GET".equals(request.getMethod())) {
					sd.doGet(request, response);
				} else {
					response.sendError(405, "Method "+ record +" Not Available");
				}
				return;
			case "logout":
				if("GET".contentEquals(request.getMethod())) {
					outDel.doGet(request, response);
					}
					return;
			default:
				response.sendError(404, "Method Not Supported");
			}
		} else {
			vd.returnView(request, response);
		}

	}
}
