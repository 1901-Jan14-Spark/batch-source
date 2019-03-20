package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.im.EmployeeDaoImpl;
import com.revature.dao.im.ReimbursementDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;

public class EmployeeDelegate {

	EmployeeService eService = new EmployeeService();

	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();

//		String idStr = request.getParameter("id");
//		System.out.println(idStr);

		String employeeJSON;

//		if (idStr != null && idStr != "") {
//			int id = Integer.parseInt(idStr);
//			Employee e = eService.getById(id);
//			if (e == null) {
//				employeeJSON = "No employee with provided id was found";
//				employeeJSON = "";
//				response.setStatus(404);
//			} else {
//				employeeJSON = om.writeValueAsString(e);
//			}
//		} else {
			// get all of our employees from our service layer
			List<Employee> employees = eService.getAll();

			// convert the array list of employees to json
			employeeJSON = om.writeValueAsString(employees);
		//}

		// print my json to the response body of my http response
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
		pw.close();
	}
	
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String inputname = request.getParameter("email");
		String pass= request.getParameter("password");
		String pass2 = request.getParameter("password2");
		
		String rEmail = (String) request.getSession().getAttribute("email");
		
		Employee e = new Employee();
		EmployeeDao eDao = new EmployeeDaoImpl();
		
		Reimbursement r = new Reimbursement();
		ReimbursementDao rDao = new ReimbursementDaoImpl();
		
		r = rDao.getReimbursementByEmail(rEmail);
		e = eDao.getEmployeeByEmail((String) request.getSession().getAttribute("email"));
		
		if(e == null) {
			System.out.println("null user");
			response.sendRedirect("profile");
		} else {
			e.setEmail(inputname);
			e.setPass(pass);
			System.out.println(e);
			
			eService.update(e);
			if(e.getReportsto() == 0) {
				response.sendRedirect("manager");
			} else {
				response.sendRedirect("employee");
			}
			
		}
		
		
	}
//	
//	
//	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String name = request.getParameter("email");
//		String pass= request.getParameter("pass");
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");
//		int reportsto = Integer.parseInt(request.getParameter("reportsto"));
//		
//		Employee e = new Employee();
//		e.setEmail(name);
//		e.setPass(pass);
//		e.setFname(fname);
//		e.setLname(lname);
//		e.setReportsto(reportsto);
//		
//		System.out.println(e);
//		
//		int numCreated = eService.create(e);
//		System.out.println(numCreated +"1");
//		
//		response.sendRedirect("../employees");
//	}
}
