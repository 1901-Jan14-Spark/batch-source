package com.revature.servlet.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Department;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private EmployeeService eService = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		ObjectMapper om = new ObjectMapper();
		
		//get all of our employees from our service layer
		List<Employee> employees = eService.getAll();
		
		//convert the arraylist of employees to json
		String employeeJSON = om.writeValueAsString(employees);
		
		//print my json to the response body of my http response
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String name = request.getParameter("name");
		int departmentId = Integer.parseInt(request.getParameter("department"));
		
		Employee e = new Employee();
		e.setName(name);
		
		Department d = new Department();
		d.setId(departmentId);
		e.setDepartment(d);
		e.setId(11);
		
		System.out.println(e);
		
		int numCreated = eService.create(e);
		System.out.println(numCreated);
		
		response.sendRedirect("../employees");
	}
	
	
}
