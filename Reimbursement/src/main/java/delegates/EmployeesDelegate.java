package delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Employees;
import services.EmployeesService;

public class EmployeesDelegate {
EmployeesService es = new EmployeesService();

public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
	List<Employees> allEmps = es.getAll();
	List<Employees> empSearch = new ArrayList<>();
	
	String empId = request.getParameter("id");
	String firstname = request.getParameter("first");
	String lastname = request.getParameter("last");
	String managerStat = request.getParameter("isMana");
	
	if (empId != null && empId.matches("^\\d+$")) {
		empSearch.add(es.getEmployeesById(Integer.parseInt(empId)));
	} else if (firstname != null && lastname != null) {
		for (Employees e : allEmps) {
			if (e.getFirst().contains(firstname) && e.getLast().contains(lastname)) {
				empSearch.add(e);
			} else if(managerStat != null && managerStat.matches(("^\\d+$"))){
				empSearch.add(es.getEmployeesByIsMana(Integer.parseInt(managerStat)));
			}else {
			empSearch = allEmps;
		}

		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		pw.write(om.writeValueAsString(empSearch));
		pw.close();
	}
}



}

public void createEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String requestBody = request.getReader().readLine();
	
	ObjectMapper om = new ObjectMapper();
	Employees newEmp = om.readValue(requestBody, Employees.class);
	
	int empCreated = es.createEmployee(newEmp);
	if(empCreated ==1) {
		response.setStatus(201);
	}else {
		response.setStatus(400);
	}
}

public void updateEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String requestBody = request.getReader().readLine();
	
	ObjectMapper om = new ObjectMapper();
	Employees updatedEmp = om.readValue(requestBody, Employees.class);
	
	int empUpdate = es.updateEmployee(updatedEmp);
	if(empUpdate ==1) {
		response.setStatus(201);
	}else {
		response.setStatus(400);
	}
}


	
}
