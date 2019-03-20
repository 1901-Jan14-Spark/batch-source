package com.revature.delegate;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.service.EmployeeService;

public class ReimbursementDelegate {
	public void createReimbursement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper om = new ObjectMapper();
		EmployeeService eService=new EmployeeService();
		JsonNode object =om.readTree(request.getReader().readLine());
		String category=object.get("category").asText();
		System.out.println(category);
		int cost = object.get("cost").asInt();
		System.out.println("cost: " + cost);
		String merchant = object.get("merchant").asText();
		String date = object.get("date").asText();
		HttpSession session = request.getSession();
		Employee emp= new Employee();
		emp=eService.getEmployeeByUsername((String) session.getAttribute("username"));
		
		Request req =new Request(); 
		req.setCategory(category);
		req.setMerchant(merchant);
		req.setPurchaseDate(date);
		req.setCost((cost));
		req.setApprovedBy(0);
		req.setDeniedBy(0);
		req.setEmpName(emp.getName());
		
		eService.createRequest(req);
	}
	public void approve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper om = new ObjectMapper();
		System.out.println("Approve2");
		EmployeeService eService=new EmployeeService();
		JsonNode object =om.readTree(request.getReader().readLine());
		int ReimId=object.get("id").asInt();
		System.out.println(ReimId);
		
		HttpSession session = request.getSession();
		Employee emp= new Employee();
		emp=eService.getEmployeeByUsername((String) session.getAttribute("username"));
		int EmpId=emp.getId();
		System.out.println(EmpId);
		eService.approveRequest(ReimId, EmpId);
		
	}
	public void deny(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper om = new ObjectMapper();
		System.out.println("deny2");
		EmployeeService eService=new EmployeeService();
		JsonNode object =om.readTree(request.getReader().readLine());
		int ReimId=object.get("id").asInt();
		System.out.println(ReimId);
		
		HttpSession session = request.getSession();
		Employee emp= new Employee();
		emp=eService.getEmployeeByUsername((String) session.getAttribute("username"));
		int EmpId=emp.getId();
		System.out.println(EmpId);
		eService.denyRequest(ReimId, EmpId);
		
	}
	public void viewActive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		EmployeeService eService=new EmployeeService();
		ObjectMapper om = new ObjectMapper();
		String employeeJSON;
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		System.out.println("writing100");
		if( session!=null && session.getAttribute("username")!=null) {
			System.out.println("the username is" + ((String) session.getAttribute("username")));
			Employee emp=eService.getEmployeeByUsername((String) session.getAttribute("username"));
			System.out.println(emp.getName());
			List<Request> requests=eService.getActiveRequest(emp.getName());
			employeeJSON = om.writeValueAsString(requests);
			System.out.println(employeeJSON);
			pw.write(employeeJSON);
			System.out.println("writing100");
			System.out.println(session.getAttribute("username"));
		} else {
			pw.write("{\"username\": null }");
			System.out.println("writing2");
		}
		pw.close();
		
	}
	public void viewResolved(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		EmployeeService eService=new EmployeeService();
		ObjectMapper om = new ObjectMapper();
		String employeeJSON;
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		System.out.println("Rwriting100");
		if( session!=null && session.getAttribute("username")!=null) {
			System.out.println("R the username is" + ((String) session.getAttribute("username")));
			Employee emp=eService.getEmployeeByUsername((String) session.getAttribute("username"));
			System.out.println(emp.getName());
			List<Request> requests=eService.getResolvedRequest(emp.getName());
			employeeJSON = om.writeValueAsString(requests);
			System.out.println(employeeJSON);
			pw.write(employeeJSON);
			System.out.println("RR writing100");
			System.out.println(session.getAttribute("R username"));
		} else {
			pw.write("{\"username\": null }");
			System.out.println("writing2");
		}
		pw.close();
		
	}
	
	}

