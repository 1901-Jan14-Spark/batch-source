package project_1_1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.EmployeeDao;
import daos.EmployeeDaoImp;
import utilities.ConnetionSrc;

public class EmployeeLoginServlet extends HttpServlet implements Runnable{
	
	EmployeeDao emp = new EmployeeDaoImp();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//HttpSession session = request.getSession();
		if(emp.getEmployeeCredentials().containsKey(username)&&emp.getEmployeeCredentials().get(username).equals(password)) {
			
			response.sendRedirect("EmpHome");
			System.out.println("contaains");
			System.out.println();
			
			
		}else{
			System.out.println("Not a thing");
			System.out.println(emp.getEmployeeCredentials());
			response.sendRedirect("eLogin");
		}
		
		
		//System.out.println(username +" " +password);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
