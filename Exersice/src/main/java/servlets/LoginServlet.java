package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.LoginService;

public class LoginServlet extends HttpServlet{
	
	
	LoginService loginservice = new LoginService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+password);
		
	 	boolean pass = loginservice.evaluate(username,password);
		
		request.setAttribute("pass", pass);
		
		RequestDispatcher rd = request.getRequestDispatcher("success");
		rd.forward(request, response);
	}
	

	
}
