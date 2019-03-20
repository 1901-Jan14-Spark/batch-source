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
			if (fn == "") {
				fn = request.getSession().getAttribute("firstName").toString();
			}
		String ln = request.getParameter("empLNInp");
			if (ln == "") {
				ln = request.getSession().getAttribute("lastName").toString();
			}
		String email = request.getParameter("empEmailInp");
//		if (email == "") {
//			email = request.getSession().getAttribute("email").toString();
//			request.getSession().setAttribute("email", email);
//			System.out.println(email);
//		} 
		
		if (email != "" ) {
			request.getSession().setAttribute("email", request.getParameter("empEmailInp"));
		} else {
			email = request.getSession().getAttribute("email").toString();
		}
		
		String pass = request.getParameter("empPassInp");
		if (pass == "") {
			pass = (String) request.getSession().getAttribute("password");
		}
		
		String idNum = request.getParameter("empFormId");
		System.out.println(idNum);
		
		int employeeId = (int) request.getSession().getAttribute("id");
		String reports = request.getParameter("empReports");
		int reportsTo = (int) (request.getSession().getAttribute("reportsTo"));
		
		Employee emp = new Employee(employeeId, fn, ln, email, pass, reportsTo);
		employeesUpdated = empService.updateEmployeeInfo(emp);
		
		if(employeesUpdated == 1) {
			response.setStatus(201);
			System.out.println("Woot");
		} else {
			response.setStatus(400);
		}
	}
}
