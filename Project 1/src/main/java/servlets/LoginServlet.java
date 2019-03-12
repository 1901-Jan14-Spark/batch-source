package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import services.LoginService;

public class LoginServlet extends HttpServlet {

	static ObjectMapper om = new ObjectMapper();
	LoginService loginService = new LoginService();
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		RequestDispatcher rd = request.getRequestDispatcher("index.html");
//		rd.forward(request, response);
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String checkedInput = loginService.confirmLogin(email, password);
		request.setAttribute("message", checkedInput);
		
		PrintWriter pw = response.getWriter();
		if(checkedInput.matches("nullEmail") || checkedInput.matches("incorrect")) {
			RequestDispatcher reqD = request.getRequestDispatcher("index.html");
			reqD.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("managerhome.html");
			rd.forward(request, response);
		}
	}
	
}
