package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.delegate.EmployeeDelegate;
import com.revature.delegate.LoginHandler;
import com.revature.delegate.ReimbursementDelegate;
import com.revature.model.Employee;


public class RequestHelper {

	EmployeeDelegate ed = new EmployeeDelegate();
	ReimbursementDelegate rd = new ReimbursementDelegate();
	ViewDelegate vd = new ViewDelegate();
	HttpSession session;

	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		
	  System.out.println("printing uri"  + uri);
		
	
		 if (uri.startsWith("/api/")) {
			String record = uri.substring(5);
		
			switch (record) {
			case "employees":
			
				// direct req/resp to employee delegate
			
			
			
				if ("GET".equals(request.getMethod())) {
					
					ed.getEmployees(request, response);
					
				} else if ("POST".equals(request.getMethod())) {
					
					
					ed.createEmployee(request, response);
				} else {
					response.sendError(405, "Method Not Supported for /" + record);
				}
				break;
			case "reimbursement":
				
			
				// direc req/resp to department delegate
				if ("GET".equals(request.getMethod())) {
					
					rd.getReimbursement(request, response);
					
					
				} else if ("POST".equals(request.getMethod())) {
					
					
 	            
					rd.dispatchPostReimbursement(request, response);
					
					
				} else {
					response.sendError(405, "Method Not Supported for /" + record);
				}
				break;
				
			
			default:
				response.sendError(404, "Record Not Supported");
			}
		} 
//		 else if(uri.startsWith("/homepage")) {
//			 
//		System.out.println( "printing session ob" +request.getSession().getAttribute("employee"));
//		request.getRequestDispatcher("HomePage.html").forward(request, response);
//			 
//		 }
		 else if (uri.startsWith("/login-out")) {
		
			// session.invalidate();
			 request.getRequestDispatcher("/static/Views/Login.html").forward(request, response);
			 
		 }
		
		
		else {
			
			System.out.println("near vd <------");
			vd.returnView(request, response);
		}

	}
	
	
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
   
		LoginHandler lh = new LoginHandler();
		Employee e = new Employee();
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		 session = request.getSession();
		e = lh.validateCredental(pass, user);
		
		
		
		if(e != null) {
			
		
		
		session.setAttribute("employee", e);
		
		
			response.sendRedirect("/project-one/static/Views/HomePage.html");
		} else {
		  
			
			//System.out.println("in log in ---------------");
			request.getRequestDispatcher("/project-one/static/Views/Login.html").forward(request, response);
		}
		
	
		
		
		
		
		
		
		
	}
	

}
