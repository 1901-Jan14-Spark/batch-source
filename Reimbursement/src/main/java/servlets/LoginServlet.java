package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = -8766153369545932598L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("doGet Method Invoked");
		RequestDispatcher rs = request.getRequestDispatcher("Login.html");
		rs.forward(request, response);
	}
}
