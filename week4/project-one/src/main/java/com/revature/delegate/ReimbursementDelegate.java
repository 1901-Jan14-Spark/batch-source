package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;

public class ReimbursementDelegate {
	
	ReimbursementService dService = new ReimbursementService();
	List<Reimbursement> reimbursementQuery = new ArrayList<>();

	public void getReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();

	//	String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		 String parameterName;
		if( request.getParameterNames().hasMoreElements()) {
           parameterName = (String) request.getParameterNames().nextElement();}
		else {
			parameterName = "none";
		}
	       
          switch (parameterName) {
          case "status" :
			if (request.getParameter("status") != "" && request.getParameter("status").matches("^\\d+$")){
				 
				int statusCode =  Integer.parseInt(request.getParameter("status")) ;

			
				
				switch (statusCode) {
				case 1:reimbursementQuery = dService.getReimbursementStatus(1);
					
					break;
				case 2:reimbursementQuery = dService.getReimbursementStatus(2);
				
				break;

				default:reimbursementQuery = dService.getReimbursementStatus();
					break;
				}
				
			}
			else {
				reimbursementQuery = dService.getReimbursementStatus();
				
		
				
			}
			break;
          case "id" :
        	  if (request.getParameter("id") != "" && request.getParameter("id").matches("^\\d+$")) {
  			
        		  reimbursementQuery = dService.getByEId(Integer.parseInt(request.getParameter("id")) );
			
			
                }
        	  else {
        			reimbursementQuery = dService.getReimbursementStatus();
        	  }
        	  break;
			default:reimbursementQuery = dService.getReimbursementStatus();
				
			
			
	
			
			
          }
	
	
		
		PrintWriter pw = response.getWriter();
		pw.write(om.writeValueAsString(reimbursementQuery));
		pw.close();
	
	}
	
	public void dispatchPostReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		
		String requestBodyText = request.getReader().readLine();
	
		
		
		
		
		Reimbursement r = om.readValue(requestBodyText, Reimbursement.class);
		
	 
		//0 means create request
		if (r.getrID() == 0) {
			System.out.println("creating");
			dService.create(r);
		}
		else {
			 dService.update(r);
		}
		
	
		
		response.sendRedirect("../employees");
	}
	

	
	
	

}
