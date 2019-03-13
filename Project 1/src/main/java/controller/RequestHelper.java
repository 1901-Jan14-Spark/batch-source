package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import delegates.ManagerDelegate;
import delegates.ViewDelegate;

public class RequestHelper {

//	ManagerDelegate mngDel = new ManagerDelegate();
	ViewDelegate viewDel = new ViewDelegate();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")) {
			String record = uri.substring(5);
			switch(record) {
			case "employees":
				//direct to EmployeeDelegate
				if("GET".equals(request.getMethod())) {
//					empDel.returnAllEmployees(request, response);
				} else if("POST".equals(request.getMethod())) {
//					empDel.createEmployee(request, response);
				} else {
//					response.sendError(405, "Method not supported for /"+record);
				}
				break;
			case "managers":
				if("GET".equals(request.getMethod())) {
//					mngDel.getDepartments(request, response);
				}	else {
//					response.sendError(405, "Method not supported for /"+record);
				}
				break;
			default: 
				response.setStatus(404);
			}
		} else {
			//direct rep/resp to view delegate (static pages)
			viewDel.returnView(request, response);
		}
		
	}
}
