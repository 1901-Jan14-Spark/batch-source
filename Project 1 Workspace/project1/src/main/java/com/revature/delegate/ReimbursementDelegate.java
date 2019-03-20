package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementDelegate {
	ReimbursementService rService = new ReimbursementService();
	
	ObjectMapper om = new ObjectMapper();
	
	String reimbursementJSON;
	
	
	public void getReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int empId = (int) request.getSession().getAttribute("id");
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(uri);
		if(uri.endsWith("reimbursements")) {
			List<Reimbursement> reimbursements = rService.getAll();
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if(uri.endsWith("pending/id")) {
			List<Reimbursement> reimbursements = rService.getPendingReimbursementsByEmpId(empId);
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if(uri.endsWith("pending")) {
			List<Reimbursement> reimbursements = rService.getPendingReimbursements();
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if(uri.endsWith("resolved/id")) {
			List<Reimbursement> reimbursements = rService.getResolvedReimbursementsByEmpId(empId);
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if(uri.endsWith("resolved")) {
			List<Reimbursement> reimbursements = rService.getResolvedReimbursements();
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if(uri.endsWith("empId")) {
			List<Reimbursement> reimbursements = rService.getReimbursementsByEmpId(empId);
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if (uri.endsWith("reimbursements/id")) {
			int id = Integer.parseInt(request.getParameter("rId"));
			Reimbursement r = rService.getById(id);
			reimbursementJSON = om.writeValueAsString(r);
			
		}
		PrintWriter pw = response.getWriter();
		pw.write(reimbursementJSON);
		pw.close();
		
	}
	public void createReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Reimbursement newR = om.readValue(requestBodyText, Reimbursement.class);
		
		int reimbursementsCreated = rService.create(newR);
		if(reimbursementsCreated == 1) {
			response.setStatus(201);
		}
		else {
			response.setStatus(400);
		}
		
	}
	public void updateReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Reimbursement newR = om.readValue(requestBodyText, Reimbursement.class);
		
		int reimbursementsUpdated = rService.update(newR);
		if(reimbursementsUpdated == 1) {
			response.setStatus(202);
		}
		else {
			response.setStatus(400);
		}
	}
	public void deleteReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Reimbursement newR = om.readValue(requestBodyText, Reimbursement.class);
		
		int reimbursementsDeleted = rService.deleteById(newR.getR_id());
		if(reimbursementsDeleted == 1) {
			response.setStatus(202);
		}
		else {
			response.setStatus(400);
		}
	}
}
