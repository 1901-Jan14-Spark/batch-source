package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import services.LoginService;

public class LoginServlet extends HttpServlet {

	static ObjectMapper om = new ObjectMapper();
	LoginService loginService = new LoginService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("index.html").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
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
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect("WelcomeManager");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect("WelcomeEmployee");
			}		
		}
	}
	
}
