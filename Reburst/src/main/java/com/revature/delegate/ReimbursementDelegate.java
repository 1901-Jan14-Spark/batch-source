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
		String reimbursementsJSON;
		
		List<Reimbursement> reimbursements = rService.getReimbursements();
		
		reimbursementsJSON = om.writeValueAsString(reimbursements);
		
		PrintWriter pw = response.getWriter();
		pw.write(reimbursementsJSON);
		pw.close();
		
	}
	
	public void resolveReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Reimbursement newR = om.readValue(requestBodyText, Reimbursement.class);
		
		int reimbursementsUpdated = rService.resolveReimbursements(newR);
		if (reimbursementsUpdated == 1) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
	}
	
	public void createReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Reimbursement newR = om.readValue(requestBodyText, Reimbursement.class);
		
		int reimbursementsUpdated = rService.createReimbursement(newR);
		if (reimbursementsUpdated == 1) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
	}
		
	}

