package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.EmployeesDelegate;
import delegates.ReimbursementsDelegate;
import delegates.ViewsDelegate;

public class RequestHelper {
 EmployeesDelegate ed = new EmployeesDelegate();
 ReimbursementsDelegate rdel = new  ReimbursementsDelegate();
 ViewsDelegate vd = new ViewsDelegate();
 
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
					} else {
						response.sendError(405, "Method "+ record +" Not Available");
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
