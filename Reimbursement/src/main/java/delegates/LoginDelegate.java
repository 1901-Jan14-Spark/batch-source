package delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Employees;
import services.EmployeesService;

public class LoginDelegate {
	EmployeesService es = new EmployeesService();

	public LoginDelegate() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/static/Login.html").forward(request, response);
		System.out.println("GOT TO LOGIN");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SENDING");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println(user);
		System.out.println(pass);

		Employees Employee = es.getEmployeeByUser(user, pass);
		
		HttpSession session = request.getSession();
		
		
		if(Employee != null && (user.equals(Employee.getUsername()) && pass.equals(Employee.getPassword()) && Employee.IsMana()==1)) {
			session.setAttribute("username", user);
			response.sendRedirect("static/Manager.html");
		} else if(Employee != null && (user.equals(Employee.getUsername()) && pass.equals(Employee.getPassword()) && Employee.IsMana()==0)){
			session.setAttribute("username", user);
			response.sendRedirect("static/Employees.html");
		}else {
			response.sendRedirect("./login");	
		}
	}

}