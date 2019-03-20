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
//	System.out.println(allEmps);
	String empId = request.getParameter("id");
//	String firstname = request.getParameter("first");
//	String lastname = request.getParameter("last");
	
	if (empId != null && empId.matches("^\\d+$")) {
		empSearch.add(es.getEmployeesById(Integer.parseInt(empId)));
	}else{
		empSearch = allEmps;

	}
	String empJSON;
	ObjectMapper om = new ObjectMapper();
	empJSON = om.writeValueAsString(empSearch);
	
	
	  
//	for(int i = 0; i < allEmps.size(); i++) {
//		System.out.println(allEmps.get(i).toString());
//	}
//	System.out.println(empJSON);

	PrintWriter pw = response.getWriter();
	pw.write(empJSON);
	pw.close();
	
//	if (empId != null && empId.matches("^\\d+$")) {
//		empSearch.add(es.getEmployeesById(Integer.parseInt(empId)));
//		System.out.println("check1");
//	} else if (firstname != null && lastname != null) {
//		for (Employees e : allEmps) {
//			if (e.getFirst().contains(firstname) && e.getLast().contains(lastname)) {
//				empSearch.add(e);
//				System.out.println("check2");
//			} else if(managerStat != null && managerStat.matches(("^\\d+$"))){
//				empSearch.add(es.getEmployeesByIsMana(Integer.parseInt(managerStat)));
//				System.out.println("check3");
//
//			}else {
//			empSearch = allEmps;		System.out.println("check4");
//
//		}
//	}
//}



}

public void createEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String requestBody = request.getReader().readLine();
	
	ObjectMapper om = new ObjectMapper();
	Employees newEmp = om.readValue(requestBody, Employees.class);
	
	int empCreated = es.createEmployee(newEmp);
	if(empCreated ==1) {
		
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
