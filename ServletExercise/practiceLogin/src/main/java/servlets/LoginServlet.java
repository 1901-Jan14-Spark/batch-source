package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.LoginService;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	LoginService ls = new LoginService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("uName");
		String pass = request.getParameter("pass");
		//System.out.println("Name: "+name+", "+"pass: "+pass);
		boolean accept = ls.verify(name, pass);
		PrintWriter pw = response.getWriter();
		pw.write("<p><h1>Login: "+accept+"</h1></p>");
		pw.write("<p><a href=\"login.html\">Login Page</a></p>");
		pw.close();
	}
}
