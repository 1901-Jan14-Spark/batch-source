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
	
	public FrontController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println();
		System.out.println("Get request to front controller");
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());
		System.out.println();
		
		if(request.getRequestURI().substring(request.getContextPath().length()).startsWith("/static/")) {
			super.doGet(request, response);
		} else {
			rh.process(request, response);
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	

}