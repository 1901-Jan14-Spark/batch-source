package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.LoginDelegate;
import com.revature.delegate.LogoutDelegate;
import com.revature.delegate.ManagerDelegate;
import com.revature.delegate.PageDirectDelegate;
import com.revature.delegate.ReimbursementDelegate;
import com.revature.delegate.SessionDelegate;

public class RequestHelper {
	
	EmployeeDelegate ed = new EmployeeDelegate();
	LoginDelegate lid = new LoginDelegate();
	LogoutDelegate lod = new LogoutDelegate();
	ManagerDelegate md = new ManagerDelegate();
	ReimbursementDelegate rd = new ReimbursementDelegate();
	PageDirectDelegate pd = new PageDirectDelegate();
	SessionDelegate sd = new SessionDelegate();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
				if(uri.startsWith("/login")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/sendLogin")) {
					lid.checkLogin(request, response);
				} else if(uri.startsWith("/managerLogin")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/Mprofile")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/mReimbursement")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/employee")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/eProfile")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/eReimbursement")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/hrmanagerLogin")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/hrmanagerProfile")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/hrReimbursement")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/hrEmployeeCreation")) {
					pd.pageDirect(request, response);
				} else if(uri.startsWith("/logout")) {
					lod.logoutUser(request, response);
				} else if(uri.startsWith("/session")) {
					sd.session(request, response);
				}else if(uri.startsWith("/api/")) {
					String record = uri.substring(5);
					switch(record) {
					case "employees":
						if("GET".equals(request.getMethod())) {
							ed.getEmployees(request, response);
						} 
					else {
							response.sendError(405, "Method not supported for /"+record);
						}
						return;
					case "reimbursements":
						if("GET".equals(request.getMethod())) {
							rd.getReimbursements(request, response);
						} else if ("POST".equals(request.getMethod())) {
							rd.createReimbursement(request, response);	
						}
						return;
					default: 
						response.setStatus(404);
					}
				}else {
					
				}
				
				
	}
	
	
	
}
