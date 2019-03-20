package com.revature.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 1L;
    
	RequestHelper rh = new RequestHelper();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check the path to see if we should use the DefaultServlet's implementation to direct to a static request
//		System.out.println(request.getRequestURI().substring(request.getContextPath().length()));

	//	System.out.println(getServletContext().getInitParameter("myContextParam"));
	//	System.out.println(getServletConfig().getInitParameter("myConfigParam"));
		
	
		
		if(request.getRequestURI().substring(request.getContextPath().length()).startsWith("/static/")) {
			
			
			super.doGet(request, response);
		} else {
			//response.getWriter().append("Served at: ").append(request.getContextPath());	
			rh.processGet(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		rh.processPost(request, response);
	}

}
