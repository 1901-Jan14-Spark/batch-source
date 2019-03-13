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

public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static ObjectMapper om = new ObjectMapper();
	LoginService loginService = new LoginService();
	
    public ManagerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logged in as: "+request.getSession().getAttribute("email"));
		if (request.getSession().getAttribute("email") == null) {
			request.getSession().invalidate();
			response.sendRedirect("login");
		} else {
			request.getRequestDispatcher("managerhome.html").forward(request, response);
		}
	}


}
