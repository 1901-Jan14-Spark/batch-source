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
}
