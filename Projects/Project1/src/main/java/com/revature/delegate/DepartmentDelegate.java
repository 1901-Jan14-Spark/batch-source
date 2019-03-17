package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.company.Department;
import com.revature.services.DepartmentService;

public class DepartmentDelegate {
	
	private DepartmentService dService = new DepartmentService();
	
	public void getDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ObjectMapper om = new ObjectMapper();
		
		String idStr = request.getParameter("deptId");
		
		String departmentJSON;
		
		if(idStr != null && idStr != "") {
			int id = Integer.parseInt(idStr);
			Department d = dService.getById(id);
			if (d == null) {
				
			}
		}
		
	}

}
