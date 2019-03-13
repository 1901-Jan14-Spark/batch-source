package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Department;
import com.revature.service.DepartmentService;

/*
 * handle the Department's crud operations
 * 
 */
public class DepartmentDelegate {

	DepartmentService dService = new DepartmentService();

	public void getDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Department> allDepartments = dService.getAll();
		List<Department> departmentQuery = new ArrayList<>();

		String idParam = request.getParameter("id");
		String nameParam = request.getParameter("name");
		String maxSalParam = request.getParameter("maxSal");
		String minSalParam = request.getParameter("minSal");
		if (idParam != null && idParam.matches("^\\d+$")) {
			departmentQuery.add(dService.getById(Integer.parseInt(idParam)));
		} else if (nameParam != null) {
			for (Department d : allDepartments) {
				if (d.getName().contains(nameParam)) {
					departmentQuery.add(d);
				}
			}
		} else if ((maxSalParam != null && maxSalParam.matches("^\\d+$"))
				|| (minSalParam != null && minSalParam.matches("^\\d+$"))) {
			if (maxSalParam != null && minSalParam != null) {
				int minSal = Integer.parseInt(minSalParam);
				int maxSal = Integer.parseInt(maxSalParam);
				for (Department d : allDepartments) {
					if (d.getMonthlyBudget() > minSal && d.getMonthlyBudget() < maxSal) {
						departmentQuery.add(d);
					}
				}
			} else if (maxSalParam != null) {
				int maxSal = Integer.parseInt(maxSalParam);
				for (Department d : allDepartments) {
					if (d.getMonthlyBudget() < maxSal) {
						departmentQuery.add(d);
					}
				}
			} else if (minSalParam != null) {
				int minSal = Integer.parseInt(minSalParam);
				for (Department d : allDepartments) {
					if (d.getMonthlyBudget() > minSal) {
						departmentQuery.add(d);
					}
				}
			}
		} else {
			departmentQuery = allDepartments;
		}

		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		pw.write(om.writeValueAsString(departmentQuery));
		pw.close();
	}

	public void createDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get request body
		String requestBodyText = request.getReader().readLine();
		System.out.println(requestBodyText);

		// map body to object
		ObjectMapper om = new ObjectMapper();
		Department newDpt = om.readValue(requestBodyText, Department.class);
		System.out.println(newDpt);

		// call service method to add our new department to our list
		int departmentsCreated = dService.create(newDpt);
		if (departmentsCreated == 1) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}

	}

}
