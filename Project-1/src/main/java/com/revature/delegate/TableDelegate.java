package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
