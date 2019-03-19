package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.company.Department;
import com.revature.company.Employee;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {
	
	private EmployeeService eService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ObjectMapper om = new ObjectMapper();
		
		String idStr = request.getParameter("empId");
		
		String employeeJSON;
		
		if(idStr != null && idStr != "") {
			int id = Integer.parseInt(idStr);
			Employee e = eService.getById(id);
			if (e == null) {
				employeeJSON = "";
				response.setStatus(404);
			} else {
				employeeJSON = om.writeValueAsString(e);
			}
		} else {
			List<Employee> employees = eService.getAll();		
			employeeJSON = om.writeValueAsString(employees);
		}
		
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
		pw.close();
	}
	
	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String firstName = "";
		String lastName = "";
		String email = "";
		String username = "";
		String password = "";
		int deptId = 2;
		
		Employee e = new Employee();
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setEmail(email);
		e.setUsername(username);
		e.setPassword(password);
		
		Department d = new Department();
		d.setDeptId(deptId);
		e.setD(d);
		
		int employeesCreated = eService.create(e);
		
		response.sendRedirect("../login");
		
		
		
	}
	

}
