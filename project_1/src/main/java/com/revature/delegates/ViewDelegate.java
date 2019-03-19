package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {

	public void returnView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String address = request.getRequestURI().substring(request.getContextPath().length() + 1);
		switch (address) {

		case "login":
			request.getRequestDispatcher("/static/Views/login.html").forward(request, response);
			return;
		case "dashboard":
			if (request.getSession().getAttribute("id") == null) {
				request.getSession().invalidate();
				response.sendRedirect("/ReimbursementApp/login");
			} else {
				request.getRequestDispatcher("/static/Views/dashboard.html").forward(request, response);
			}
			return;
		case "mdashboard":
			if (request.getSession().getAttribute("id") == null) {
				request.getSession().invalidate();
				response.sendRedirect("/ReimbursementApp/login");
			} else {
				request.getRequestDispatcher("/static/Views/m-dashboard.html").forward(request, response);
			}
			return;
		case "reimbursement-form":
			if (request.getSession().getAttribute("id") == null) {
				request.getSession().invalidate();
				response.sendRedirect("/ReimbursementApp/login");
			} else {
				request.getRequestDispatcher("/static/Views/ReimbursementForm.html").forward(request, response);
			}
			return;
		case "update-reimbursement":
			if (request.getSession().getAttribute("id") == null) {
				request.getSession().invalidate();
				response.sendRedirect("/ReimbursementApp/login");
			} else {
				request.getRequestDispatcher("/static/Views/UpdateReimbursement.html").forward(request, response);
			}
			return;
		case "update-information":
			if (request.getSession().getAttribute("id") == null) {
				request.getSession().invalidate();
				response.sendRedirect("/ReimbursementApp/login");
			} else {
				request.getRequestDispatcher("/static/Views/UpdateEmpInformation.html").forward(request, response);
			}
			return;
		case "viewReimbursements":
			if (request.getSession().getAttribute("id") == null) {
				request.getSession().invalidate();
				response.sendRedirect("/ReimbursementApp/login");
			} else {
				request.getRequestDispatcher("/static/Views/ViewReimbursements.html").forward(request, response);
			}
			return;
		default:
			response.sendError(404, "Static resource not found");

		}
	}

}