package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {

	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRequestURI().substring(request.getContextPath().length()+1);
		switch(address) {
		case "manager":
			request.getRequestDispatcher("/static/Views/Manager.html").forward(request, response);
			break;
		case "managerreq":
			request.getRequestDispatcher("/static/Views/ManagerReq.html").forward(request, response);
			break;
		case "allactivity":
			request.getRequestDispatcher("/static/Views/AllActivity.html").forward(request, response);
			break;
		case "employee":
			request.getRequestDispatcher("/static/Views/Employee.html").forward(request, response);
			break;
		case "allemployeereqs":
			request.getRequestDispatcher("/static/Views/MyRequests.html").forward(request, response);
			break;
		case "resolvedreqs":
			request.getRequestDispatcher("/static/Views/ResolvedReqs.html").forward(request, response);
			break;
		case "pendingreqs":
			request.getRequestDispatcher("/static/Views/PendingReqs.html").forward(request, response);
			break;
		case "eprofile":
			request.getRequestDispatcher("/static/Views/EProfile.html").forward(request, response);
			break;
		case "profile":
			request.getRequestDispatcher("/static/Views/Profile.html").forward(request, response);
			break;
		case "index":
			request.getRequestDispatcher("/static/Views/Login.html").forward(request, response);
			break;
//		default:
//			response.sendError(404,"Static Resource Not Found");
		}
	}
}
