package com.revature.temp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.im.EmployeeDaoImpl;



public class Login extends HttpServlet {

	
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
		
		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		System.out.println("priting username" + " password " +userName + password);
		
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
	//	System.out.println(edi.findUser(userName));
		
		
		
		
		if ( userName.contains("Jimmy") &&  password.contains("password") ) {
			
			
			
			  
			req.getRequestDispatcher("success").forward(req, res);
		}
		else {
			
			req.getRequestDispatcher("failed").forward(req, res);
		}
		
		
	}
	
	
	
}
