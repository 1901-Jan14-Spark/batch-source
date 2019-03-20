package delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Employee;
import services.LoginService;

public class LoginDelegate {

	LoginService loginService = new LoginService();
	
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String email = request.getParameter("email");
	System.out.println(email);
	String password = request.getParameter("password");
	System.out.println("pass: "+password);
	Employee attemptedEmp = loginService.confirmLogin(email, password);
//	request.setAttribute("message", checkedInput);
	
	PrintWriter pw = response.getWriter();
	if(attemptedEmp == null || attemptedEmp.getEmail() == "incorrect" ) {
		response.sendRedirect("login");
	} else {
		if(attemptedEmp.getReportsTo() == 0) {
			System.out.println("checkedInput " +attemptedEmp.getEmail());
//			HttpSession error = request.getSession();
//			error.invalidate();
			HttpSession newSession = request.getSession();
			newSession.setAttribute("email", attemptedEmp.getEmail());
			newSession.setAttribute("firstName", attemptedEmp.getFirstName());
			newSession.setAttribute("lastName", attemptedEmp.getLastName());
			newSession.setAttribute("id", attemptedEmp.getId());
			newSession.setAttribute("password", attemptedEmp.getPassword());
			newSession.setAttribute("reportsTo", attemptedEmp.getReportsTo());
			response.sendRedirect("http://localhost:9393/Project1/managerLogin");
		} else {
			System.out.println("checkedInput " +attemptedEmp.getEmail());
//			HttpSession error = request.getSession();
//			error.invalidate();
			HttpSession newSession = request.getSession();
			newSession.setAttribute("email", attemptedEmp.getEmail());
			newSession.setAttribute("firstName", attemptedEmp.getFirstName());
			newSession.setAttribute("lastName", attemptedEmp.getLastName());
			newSession.setAttribute("id", attemptedEmp.getId());
			newSession.setAttribute("password", attemptedEmp.getPassword());
			newSession.setAttribute("reportsTo", attemptedEmp.getReportsTo());
			response.sendRedirect("http://localhost:9393/Project1/employeeLogin");
		}		
	}
	}
}
