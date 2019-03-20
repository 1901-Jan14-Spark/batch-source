package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.service.EmployeeService;

public class TableDelegate {
	
	private EmployeeService eService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		
		String employeeJSON;
		List<Employee> employees = eService.getAll();
		
		employeeJSON = om.writeValueAsString(employees);
		
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
		pw.close();
	}
	public void getActive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		
		String requestJSON;
		List<Request> requests = eService.getActive();
		
		requestJSON = om.writeValueAsString(requests);
		
		PrintWriter pw = response.getWriter();
		pw.write(requestJSON);
		pw.close();
	}
	public void getResolve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		
		String requestJSON;
		List<Request> requests = eService.getResolve();
		
		requestJSON = om.writeValueAsString(requests);
		
		PrintWriter pw = response.getWriter();
		pw.write(requestJSON);
		pw.close();
	}
	public void changeInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper om = new ObjectMapper();
		EmployeeService eService=new EmployeeService();
		JsonNode object =om.readTree(request.getReader().readLine());
		String name=object.get("name").asText();
		System.out.println(name);
		String user = object.get("user").asText();
		
		String pass = object.get("pass").asText();
		
		HttpSession session = request.getSession();
		Employee emp= new Employee();
		emp=eService.getEmployeeByUsername((String) session.getAttribute("username"));
		int id =emp.getId();
		
		
		eService.changeInfo(id, name, user, pass);
	}
}
