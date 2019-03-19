package delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Employee;
import services.EmployeeService;

public class EmployeeDelegate {

	EmployeeService empService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		String employeeJSON;
		
		List<Employee> employees = empService.getEmployeesList();
		
		employeeJSON = om.writeValueAsString(employees);
		
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
		pw.close();
	}
	
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Hi Im in update");
		int employeesUpdated;
		String fn = request.getParameter("empFNInp");
		String ln = request.getParameter("empLNInp");
		String email = request.getParameter("empEmailInp");
		if (email == "") {
			email = request.getSession().getAttribute("email").toString();
			System.out.println(email);
		}
		String pass = request.getParameter("empPassInp");
		String idNum = request.getParameter("empFormId");
		System.out.println(idNum);
		int employeeId = Integer.parseInt(idNum);
		String reports = request.getParameter("empReports");
		int reportsTo = Integer.parseInt(reports);
		
		if(pass == "") {
			Employee emp = new Employee(employeeId, fn, ln, email, reportsTo);
			employeesUpdated = empService.updateEmployeeInfo(emp);
		} else {
			Employee emp = new Employee(employeeId, fn, ln, email, pass, reportsTo);
			employeesUpdated = empService.updateEmployeeInfo(emp);
		}
		
		if(employeesUpdated == 1) {
			response.setStatus(201);
			System.out.println("Woot");
		} else {
			response.setStatus(400);
		}
	}
}
