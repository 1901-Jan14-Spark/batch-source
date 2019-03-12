package com.revature.servlet.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Department;
import com.revature.service.DepartmentService;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DepartmentService dService = new DepartmentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		
		String idStr = request.getParameter("id");
		String nameStr = request.getParameter("name");
		String budgetStr = request.getParameter("monthlyBudget");
		System.out.println(idStr);
		System.out.println(nameStr);
		System.out.println(budgetStr);
		
		String departmentJSON;
		
		if(idStr!=null && idStr!="") {
			
			int id = Integer.parseInt(idStr);
			Department d = dService.getById(id);
			
			if(d == null) {
				departmentJSON = "No department was found";
			} else {
				departmentJSON = om.writeValueAsString(d);
			}
		}
		
		else {
			List<Department> departments = dService.getAll();
			departmentJSON = om.writeValueAsString(departments);
		}
		
		PrintWriter pw = response.getWriter();
		pw.write(departmentJSON);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		String requestBodyText = request.getReader().readLine();
		System.out.println(requestBodyText);
		
		Department newDpt = om.readValue(requestBodyText, Department.class);
		System.out.println(newDpt);
		
		int departmentsCreated= dService.create(newDpt);
		if(departmentsCreated == 1) {
			response.setStatus(201);
		}else {
			response.setStatus(400);
		}
	}

}
