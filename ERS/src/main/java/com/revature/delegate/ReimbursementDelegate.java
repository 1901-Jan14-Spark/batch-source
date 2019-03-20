package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

public class ReimbursementDelegate {

	ReimbursementService rService = new ReimbursementService();

	public void getReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();

		String idStr = request.getParameter("id");
		System.out.println(idStr);

		String employeeJSON;

		if (idStr != null && idStr != "") {
			int id = Integer.parseInt(idStr);
			Reimbursement r = rService.getById(id);
			if (r == null) {
//				employeeJSON = "No employee with provided id was found";
				employeeJSON = "";
				response.setStatus(404);
			} else {
				employeeJSON = om.writeValueAsString(r);
			}
		} else {
			// get all of our employees from our service layer
			List<Reimbursement> reimbursements = rService.getAll();

			// convert the arraylist of employees to json
			employeeJSON = om.writeValueAsString(reimbursements);
		}

		// print my json to the response body of my http response
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
		pw.close();
	}
	
	public void updateReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBody = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Reimbursement exp = om.readValue(requestBody, Reimbursement.class);
		
		int reimbursementsUpdated = rService.update(exp);
		request.getRequestDispatcher("managerreq");
		if (reimbursementsUpdated == 1) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
	}

	
	
	public void createReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int price = Integer.parseInt(request.getParameter("price"));
//		String status = request.getParameter("status");
//		String resolvedby = request.getParameter("");
		
		Reimbursement r = new Reimbursement();
		r.setEmail((String) request.getSession().getAttribute("email"));
		r.setPrice(price);
		r.setResolvedby("");
		r.setStatus("PENDING");
		
		System.out.println(r);
		
		int numCreated = rService.create(r);
		System.out.println(numCreated);
		
		response.sendRedirect("employee");
	}
}
