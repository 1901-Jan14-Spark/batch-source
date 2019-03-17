package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageDirectDelegate {
	public void pageDirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRequestURI().substring(request.getContextPath().length()+1);
		
		switch(address) {
		case "login":
			request.getRequestDispatcher("/static/Views/index.html").forward(request, response);
			return;
		case "employee":
			request.getRequestDispatcher("/static/Views/employee.html").forward(request, response);
			return;
		case "eProfile":
			request.getRequestDispatcher("/static/Views/Eprofile.html").forward(request, response);
			return;
		case "eReimbursement":
			request.getRequestDispatcher("/static/Views/eReimbursement.html").forward(request, response);
			return;
		case "managerLogin":
			request.getRequestDispatcher("/static/Views/manager.html").forward(request, response);
			return;
		case "Mprofile":
			request.getRequestDispatcher("/static/Views/Mprofile.html").forward(request, response);
			return;	
		case "mReimbursement":
			request.getRequestDispatcher("/static/Views/mReimbursement.html").forward(request, response);
			return;
		case "hrmanagerLogin":
			request.getRequestDispatcher("/static/Views/hrmanager.html").forward(request, response);
			return;
		case "hrmanagerProfile":
			request.getRequestDispatcher("/static/Views/hrProfile.html").forward(request, response);
			return;
		case "hrReimbursement":
			request.getRequestDispatcher("/static/Views/hrReimbursement.html").forward(request, response);
			return;	
		case "hrEmployeeCreation":
			request.getRequestDispatcher("/static/Views/newEmployePage.html").forward(request, response);
			return;	
		default:
			response.sendError(404, "Static Resource Not Found");
		}
	}
}
