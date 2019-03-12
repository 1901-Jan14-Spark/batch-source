package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Employee;
import services.EmployeeService;

public class EmployeeServlet extends HttpServlet {

//	private static final long serialVersionUID = 1L;
//	
//	static ObjectMapper om = new ObjectMapper();
//	EmployeeService empService = new EmployeeService();
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		System.out.println("doGet request handler method invoked in ManagerServlet");
//		
//		List<Employee> ourEmployees = empService.getEmployees();
//		PrintWriter pw = response.getWriter();
//		String employeeJSON = om.writeValueAsString(ourEmployees);
//		
//		pw.print(employeeJSON);
//	}
}
