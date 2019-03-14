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
}
