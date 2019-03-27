package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.company.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementDelegate {
	
	private ReimbursementService rbService = new ReimbursementService();
	
	public void getRefunds(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ObjectMapper om = new ObjectMapper();
		
		String idStr = request.getParameter("reimbId");
		
		String reimbJSON;
		
		if(idStr != null && idStr != "") {
			int id = Integer.parseInt(idStr);
			Reimbursement rb = rbService.getById(id);
			if(rb == null) {
				reimbJSON = "";
				response.setStatus(404);
			} else {
				reimbJSON = om.writeValueAsString(rb);
			}
		} else {
			List<Reimbursement> reimbursements = rbService.getAll();
			reimbJSON = om.writeValueAsString(reimbursements);
		}
		
		PrintWriter pw = response.getWriter();
		pw.write(reimbJSON);
		pw.close();		
	}
	
	public void getIndividualRefund(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ObjectMapper om = new ObjectMapper();

		String ReimbursementJSON;

		int id = (int) request.getSession().getAttribute("id");

		List<Reimbursement> Reimbursements = rbService.getEmployeesReimbursements(id);
		System.out.println(Reimbursements);
		ReimbursementJSON = om.writeValueAsString(Reimbursements);

		PrintWriter pw = response.getWriter();
		pw.write(ReimbursementJSON);
		pw.close();
	}
	
	public void createRefundRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int reimbId = 0;
		int empId = 0;
		double amount = 0.0;
		boolean approved = false;
//		Timestamp reqDate = new Timestamp(empId);
//		Timestamp appDate = new Timestamp(empId);
		
		Reimbursement rb = new Reimbursement();
		rb.setReimbursementId(reimbId);
		rb.setEmployeeId(empId);
		rb.setAmount(amount);
		rb.setApproved(approved);
//		rb.setRequestDate(reqDate);
//		rb.setApprovalDate(appDate);
		
		int refundrequestCreated = rbService.newRequest(rb);
		response.sendRedirect("/edash");
	}	
	
	public void updateRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	public void approveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		
	}
	
	public void denyRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	

	
}
