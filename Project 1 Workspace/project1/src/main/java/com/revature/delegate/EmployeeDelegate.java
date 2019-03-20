package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {
	EmployeeService eService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ObjectMapper om = new ObjectMapper();
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		int empId = (int) request.getSession().getAttribute("id");
		System.out.println("empId: " + empId);
		
		String employeeJSON;
		System.out.println(uri);
		if(uri.endsWith("/employees/id")) {
			int id = empId;
			Employee e = eService.getById(id);
			if(e == null) {
				employeeJSON = "";
				response.setStatus(404);
			}
			else {
				employeeJSON = om.writeValueAsString(e);
			}
		}
		else {
			List<Employee> employees = eService.getAll();
			employeeJSON = om.writeValueAsString(employees);
		}
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
		pw.close();
	}
	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		int isManager = Integer.parseInt(request.getParameter("isManager"));
		
		Employee e = new Employee();
		e.setId(employeeId);
		e.setUsername(username);
		e.setPassword(password);
		e.setEmail(email);
		e.setAddress(address);
		e.setPhone(phone);
		e.setIsManager(isManager);
		
		System.out.println(e);
		
		int numCreated = eService.create(e);
		System.out.println(numCreated);
		
		response.sendRedirect("../employee");
	}
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException{
	String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Employee newE = om.readValue(requestBodyText, Employee.class);
		
		int employeesUpdated = eService.update(newE);
		if(employeesUpdated == 1) {
			response.setStatus(202);
		}
		else {
			response.setStatus(400);
		}
	}
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException{
	String requestBodyText = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Employee newE = om.readValue(requestBodyText, Employee.class);
		
		int employeesDeleted = eService.deleteById(newE.getId());
		if(employeesDeleted == 1) {
			response.setStatus(202);
		}
		else {
			response.setStatus(400);
		}
	}
}
