package com.ServletExample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		
		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		System.out.println("priting username" + " password " +userName + password);
		
		
		
		if ( userName.contains("admin") &&  password.contains("password") ) {
			
			
			
			  
			req.getRequestDispatcher("success").forward(req, res);
		}
		else {
			
			req.getRequestDispatcher("failed").forward(req, res);
		}
		
		
	}
	
	
	
	
	
	
	
	
}
