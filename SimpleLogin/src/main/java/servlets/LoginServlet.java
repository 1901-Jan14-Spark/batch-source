package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.LoginServices;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 4118563311878631458L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("doGet Method Invoked");
		RequestDispatcher rs = request.getRequestDispatcher("Login.html");
		rs.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean validate = LoginServices.validate(username, password);
		
	
			request.setAttribute("validate", validate);
			RequestDispatcher rd = request.getRequestDispatcher("validate");
			rd.forward(request, response);
		
	}
	
}
