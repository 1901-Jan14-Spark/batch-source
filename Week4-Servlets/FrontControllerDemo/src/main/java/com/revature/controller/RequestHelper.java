package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegate.DepartmentDelegate;
import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.ViewDelegate;

public class RequestHelper {
	
	EmployeeDelegate ed = new EmployeeDelegate();
	DepartmentDelegate dd = new DepartmentDelegate();
	ViewDelegate vd = new ViewDelegate();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.startsWith("/api/")) {
			String record = uri.substring(5);
			System.out.println(record);
			switch(record) {
			case "employees":
				//direct req/resp to employee delegate
				break;
			case "departments":
				//direct req/resp to department delegate
				
				break;
			default:
				response.sendError(404, "Record Not Supported");
			}
		} else {
			//direct req/resp to view delegate
			//invoke its method which handles forwarding to the appropriate static web page 
			vd.returnView(request, response);
		}
		
	}

}
