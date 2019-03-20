package com.revature.delagate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;

public class EmployeeDelegate {
	
	private static EmployeeDaoJdbc edj = new EmployeeDaoJdbc();
	public static List<Employee> eList = edj.getAllEmployees();
	
	public void validateLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String password = request.getParameter("password");
		String email =  request.getParameter("email");
		Employee e = new Employee();
		e.setEmail(email);
		if(eList.contains(e)) {
			e = eList.get(eList.indexOf(e));
		}else {
			e = null;
		}
		if(e!=null && password.equals(e.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("eId", e.geteID());
			session.setAttribute("isManager", e.isManager());
			session.setAttribute("email", e.getEmail());
			response.sendRedirect("home");
		}
		else {
			String results = "<p> Email/password invalid!<p>";
			request.setAttribute("results", results);
			request.getRequestDispatcher("localhost:8080/reimbursement-app/static/Views/login.html").forward(request, response);		
		}
	}
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendError(401);	
		}
		else {
			ObjectMapper om = new ObjectMapper();
			PrintWriter pw = response.getWriter();
			if(session.getAttribute("isManager").equals(true)) {
				pw.write(om.writeValueAsString(eList));
			}else {
				Employee temp = new Employee();
				temp.setEmail((String) session.getAttribute("email"));
				temp = eList.get(eList.indexOf(temp));
				pw.write(om.writeValueAsString(temp));
			}
			pw.close();
			response.setStatus(200);
		}
	}
	public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);
		if(session==null) {
			response.sendError(401);	
		}
		else {
			Employee etemp = new Employee();
			etemp.setEmail((String) session.getAttribute("email")); etemp.seteID( (int) session.getAttribute("eId"));
			etemp = eList.get(eList.indexOf(etemp));
			etemp.setfName(request.getParameter("fName")); etemp.setlName(request.getParameter("lName"));
			etemp.setPassword(request.getParameter("password")); etemp.setPhone(request.getParameter("phone"));
			edj.updateEmployee(etemp);
			response.setStatus(200);
		}
	}
}
