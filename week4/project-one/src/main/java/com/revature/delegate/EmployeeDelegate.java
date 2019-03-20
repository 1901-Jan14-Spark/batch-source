package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;

/*
 * handle the Employee's crud operations
 * 
 */
public class EmployeeDelegate {
	
	String employeeJSON = new String();
	
	EmployeeService eService = new EmployeeService();
	List<Employee> employeeArray = new ArrayList<>();

	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
ObjectMapper om = new ObjectMapper();

		
		//just an api to get employees record with a manager account
		
		
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		//http://localhost:8080/project-one/api/employees?username=something&password=1234
		

	
           

	//	String uri = request.getRequestURI().substring(request.getContextPath().length());
		
		 String parameterName;
		 
		 
		 
		if( request.getParameterNames().hasMoreElements()) {
           parameterName = (String) request.getParameterNames().nextElement();}
		else {
			parameterName = "none";
		}
	       
		System.out.println("printing eid"  + parameterName);
		
		
          switch (parameterName) {

          case "eid" :
        	  if (request.getParameter("eid") != "" && request.getParameter("eid").matches("^\\d+$")) {
  			

        		
        		  
        		  
      			Employee e = eService.getById(Integer.parseInt(request.getParameter("eid")));
      			
      			System.out.println("printing e from edelegate object "+ e.toString());
      	
      		
      			
      			if (e.getId() == 0) {

      				
      				employeeJSON = "No employee by the given username exists.";
      			//	response.setStatus(404);
      			} else {
      				
      				employeeArray.clear();
      				employeeArray.add(e);
      				            //  om.writeValue(e, Employee.class);
      			
      				        		
      				
      			} 
      		} else {
      			
      			employeeJSON = om.writeValueAsString("please enter user name");
      			
      		}	  
        		  
        		  
        		  
          		  
 
		
		
	
		
          }
		
          PrintWriter pw = response.getWriter();
          pw.write(om.writeValueAsString(employeeArray));
  		//pw.write(employeeJSON);
  		pw.close();
  	
		
	

}
	

	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		int departmentId = Integer.parseInt(request.getParameter("department"));
		
		Employee e = new Employee();
//		e.setName(name);
		
//		Department d = new Department();
//		d.setId(departmentId);
//		e.setDepartment(d);
		
		
		
		int numCreated = eService.create(e);
		
		
		response.sendRedirect("../employees");
	}

}