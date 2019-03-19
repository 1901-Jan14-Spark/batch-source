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
	
	//get int for id from session
	int id = 0;
	
	public void getReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if(uri.endsWith("reimbursements/")) {
			List<Reimbursement> reimbursements = rService.getAll();
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if(uri.endsWith("pending/id/")) {
			List<Reimbursement> reimbursements = rService.getPendingReimbursementsByEmpId(id);
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if(uri.endsWith("pending/")) {
			List<Reimbursement> reimbursements = rService.getPendingReimbursements();
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if(uri.endsWith("resolved/id/")) {
			List<Reimbursement> reimbursements = rService.getResolvedReimbursementsByEmpId(id);
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if(uri.endsWith("resolved/")) {
			List<Reimbursement> reimbursements = rService.getResolvedReimbursements();
			reimbursementJSON = om.writeValueAsString(reimbursements);
		}
		else if (uri.endsWith("reimbursements/id")) {
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
