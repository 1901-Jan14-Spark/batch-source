package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.LoginDelegate;
import delegates.LogoutDelegate;
import delegates.SessionDelegate;
//import delegates.ManagerDelegate;
import delegates.ViewDelegate;

public class RequestHelper {

//	ManagerDelegate mngDel = new ManagerDelegate();
	ViewDelegate viewDel = new ViewDelegate();
	LoginDelegate loginDel = new LoginDelegate();
	LogoutDelegate logoutDel = new LogoutDelegate();
	SessionDelegate sessDel = new SessionDelegate();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		//sending to login page/home page
		if(uri.startsWith("/login")) {
			viewDel.returnView(request, response);
		}
		
//		post request for login --> going to use post
		if(uri.startsWith("/sendLogin")) {
			loginDel.checkLogin(request, response);
			System.out.println();
		}
		
		if(uri.startsWith("/managerLogin")) {
			viewDel.returnView(request, response);
		}
		
		//logging a user out
		if(uri.startsWith("/logout")) {
			logoutDel.logoutUser(request, response);
		}
		
		//using session for some js decision
		if(uri.startsWith("/session")) {
			sessDel.createSessionApi(request, response);
		}
		
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
				return;
			case "managers":
				if("GET".equals(request.getMethod())) {
//					mngDel.getDepartments(request, response);
				}	else {
//					response.sendError(405, "Method not supported for /"+record);
				}
				return;
			default: 
				response.setStatus(404);
			}
		}
		
		}
}
