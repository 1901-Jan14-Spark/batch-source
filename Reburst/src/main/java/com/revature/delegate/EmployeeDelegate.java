package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeDelegate {

	
EmployeeService eService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		String employeeJSON;
		
		List<Employee> employees = eService.getEmployeesList();
		
		employeeJSON = om.writeValueAsString(employees);
		
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
		pw.close();
	}
	
	public void updateTheEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Employee newE = om.readValue(requestBodyText, Employee.class);
		String emailSession = (String) request.getSession().getAttribute("email");
		Employee temp = eService.getEmployeeByEmail(emailSession);
		newE.seteId(temp.geteId());
		newE.setTitle(temp.getTitle());;
		System.out.println(newE + "nothing");
		
		int employeesUpdated = eService.resolveEmployees(newE);
		System.out.println(employeesUpdated + "nothing");
		if (employeesUpdated == 1) {
			request.getSession().setAttribute("email", newE.getEmail());
			request.getSession().setAttribute("fullname", newE.getFName() +" "+ newE.getLName());
			request.getSession().setAttribute("title", newE.getTitle());
			response.setStatus(201);
			System.out.println("woo");
		} else {
			response.setStatus(400);
			System.out.println("boo");
		}
	}
	
	public void createTheEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Employee newE = om.readValue(requestBodyText, Employee.class);
		System.out.println(newE + "nothing");
		
		int employeesCreated = eService.createEmployee(newE);
		System.out.println(employeesCreated + "nothing");
		if (employeesCreated == 1) {
			response.setStatus(201);
			System.out.println("woo");
		} else {
			response.setStatus(400);
			System.out.println("boo");
		}
	}

}
