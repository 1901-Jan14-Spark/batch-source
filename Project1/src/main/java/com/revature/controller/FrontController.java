package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.revature.services.LoginService;

public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 1L;
	
	RequestHelper rh = new RequestHelper();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		if(request.getRequestURI().substring(request.getContextPath().length()).startsWith("/static/")) {
			super.doGet(request, response);
		} else {
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			rh.process(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	

}
