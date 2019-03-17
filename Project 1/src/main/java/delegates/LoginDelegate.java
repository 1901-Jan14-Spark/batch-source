package delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.LoginService;

public class LoginDelegate {

	LoginService loginService = new LoginService();
	
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String checkedInput = loginService.confirmLogin(email, password);
	request.setAttribute("message", checkedInput);
	System.out.println("checkedInput " +checkedInput);
	
	PrintWriter pw = response.getWriter();
	if("nullEmail".matches(checkedInput) || "incorrect".matches("checkedInput")) {
		response.sendRedirect("login");
	} else {
		if("manager".matches(checkedInput)) {
			System.out.println(checkedInput);
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("http://localhost:9393/Project1/managerLogin");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("http://localhost:9393/Project1/employeeLogin");
		}		
	}
	}
}
