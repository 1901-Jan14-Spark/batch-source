package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.utils.InputValidator;

public class EmployeeDelegate {

	static Logger log = Logger.getRootLogger();
	private EmployeeService eService = new EmployeeService();

	public void getsEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();

		String idStr = request.getParameter("id");

		String employeeJSON;

		if (idStr != null && idStr != "") {
			int id = Integer.parseInt(idStr);
			Employee e = eService.getEmployeeById(id);
			if (e == null) {
				employeeJSON = "";
				response.setStatus(404);
			} else {
				employeeJSON = om.writeValueAsString(e);
			}
		} else {
			List<Employee> employees = eService.getEmployees();

			employeeJSON = om.writeValueAsString(employees);
		}
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
		pw.close();
	}

	public void createsEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");

		if (InputValidator.validateEmail(email)) {
			try {
				if (eService.createEmployee(email)) {
					response.setStatus(201);
					System.out.println("Employee was created: " + email);
				}
			} catch (SQLIntegrityConstraintViolationException e) {
				log.error("SQLException - Employee already present.");
				response.sendError(400, "Employee already present: " + email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendError(400, "Invalid email: " + email);
		}
	}

	public void updatesEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();

		ObjectMapper om = new ObjectMapper();
		Employee temp = om.readValue(requestBodyText, Employee.class);
		

		if (!InputValidator.validateId(((Integer)temp.getId()).toString())) {
			response.sendError(400, "Invalid id: " + temp.getId());
			return;
		}
		if (!InputValidator.validateEmail(temp.getEmail())) {
			if (temp.getEmail() != null) {
				response.sendError(400, "Invalid email: " + temp.getEmail());
				return;
			}
		}
		if (!InputValidator.validatePassword(temp.getPassword())) {
			if (temp.getPassword() != null) {
				response.sendError(400, "Invalid password: " + temp.getPassword());
				return;
			}
		}
		if (!InputValidator.validateName(temp.getFirstname())) {
			if (temp.getFirstname() != null) {
				response.sendError(400, "Invalid firstname: " + temp.getFirstname());
				return;
			}
		}
		if (!InputValidator.validateName(temp.getLastname())) {
			if (temp.getLastname() != null) {
				response.sendError(400, "Invalid lastname: " + temp.getLastname());
				return;
			}
		}
		
		if (eService.updateEmployeeInformation(temp)) {
			response.setStatus(200);
			System.out.println("Employee successfully updated.");
		} else {
			response.setStatus(400);
			System.out.println("Unable to update employee.");
		}

	}
}
