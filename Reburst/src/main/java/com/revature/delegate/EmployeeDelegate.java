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

}
