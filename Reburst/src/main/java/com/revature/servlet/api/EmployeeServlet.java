package com.revature.servlet.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("email");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
//		System.out.println("Attempted login with user: "+ user +" and pass: "+pass);
		if("admin".equals(user) && "pass123".equals(pass)) {
			session.setAttribute("username", user);
			response.sendRedirect("profile");
		} else {
			response.sendRedirect("login");
		}
	}

}
