package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		System.out.println("Service method called with a "+request.getMethod()+" request");
		PrintWriter pw = response.getWriter();
		pw.print("Hello World");
		pw.close();
	}
	
	public void init(ServletConfig config) {
		System.out.println("Init method was called");
	}
	
	public void destroy() {
		System.out.println("Destroy method called");
	}
	
}
