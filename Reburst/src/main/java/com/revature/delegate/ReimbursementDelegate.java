package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;

public class ReimbursementDelegate {

ReimbursementService rService = new ReimbursementService();
EmployeeService eService = new EmployeeService();
	
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
		String emailSession = (String) request.getSession().getAttribute("email");
		Employee temp = eService.getEmployeeByEmail(emailSession);
		newR.setrStatusChange(temp.geteId());
		System.out.println(newR + "nothing");
		
		int reimbursementsUpdated = rService.resolveReimbursements(newR);
		System.out.println(reimbursementsUpdated + "nothing");
		if (reimbursementsUpdated == 1) {
			response.setStatus(201);
			System.out.println("woo");
		} else {
			response.setStatus(400);
			System.out.println("boo");
		}
	}
	
	public void createReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Reimbursement newR = om.readValue(requestBodyText, Reimbursement.class);
		String emailSession = (String) request.getSession().getAttribute("email");
		Employee temp = eService.getEmployeeByEmail(emailSession);
		newR.setEmployee_id(temp.geteId());
		System.out.println(newR + "nothing");
		
		int reimbursementsUpdated = rService.createReimbursement(newR);
		if (reimbursementsUpdated == 1) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
	}
		
	}

