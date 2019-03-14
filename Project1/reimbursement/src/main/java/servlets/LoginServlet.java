package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.LoginService;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	LoginService ls = new LoginService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{		
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String inputId = request.getParameter("userId");
		//ensure user inputs ints
		int id = ls.validIdInput(inputId);
		String pass = request.getParameter("password");
		
		//verify credentials are valid and differentiate between employee and manager id
		int accept = ls.verify(id, pass);
		if(accept == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			response.sendRedirect("eHome");
		}
		else if(accept == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			response.sendRedirect("mHome");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}
}
