package com.revature.servlets.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.utility.User;


public class ManagerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ManagerProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rq;
		if (!User.isNull()) {
			rq = request.getRequestDispatcher("Views/Manager/ManagerProfile.html");
		} else {
			rq = request.getRequestDispatcher("Views/Login.html");
		}
		rq.forward(request, response);
	}

}
