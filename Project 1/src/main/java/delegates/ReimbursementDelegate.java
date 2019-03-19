package delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Employee;
import models.Reimbursements;
import services.ReimbursementService;

public class ReimbursementDelegate {

	ReimbursementService reimbService = new ReimbursementService();
	ViewDelegate viewDel = new ViewDelegate();
	
	public void getReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		String reimbursementsJSON;
		
		List<Reimbursements> reimbursements = reimbService.getReimbursements();
		
		reimbursementsJSON = om.writeValueAsString(reimbursements);
		
		PrintWriter pw = response.getWriter();
		pw.write(reimbursementsJSON);
		pw.close();
		
	}
	
	public void resolveReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Reimbursements newReim = om.readValue(requestBodyText, Reimbursements.class);
		
		int reimbursementsUpdated = reimbService.resolveReimbursements(newReim);
		if (reimbursementsUpdated == 1) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
	}
	
	public void createReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		int reimbId = Integer.parseInt(request.getParameter("reimbursementId"));
		int empId = Integer.parseInt(request.getParameter("formempId"));
		String content = request.getParameter("content");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String formRes = request.getParameter("formResolved");
		int isResolved = Integer.parseInt(formRes);
		String formResMess = request.getParameter("formResMess");
		String mngRes = request.getParameter("formMngRes");
		
		Reimbursements newReim = new Reimbursements(reimbId, empId, content, amount, isResolved, formResMess, mngRes);
		
		int reimbursementsUpdated = reimbService.createReimbursement(newReim);
		if (reimbursementsUpdated == 1) {
			response.setStatus(201);
			System.out.println("Woot");
			try {
				viewDel.returnView(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			response.setStatus(400);
		}
	}
		
	}
