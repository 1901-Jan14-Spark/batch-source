package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DirectoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -588534795962645466L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("Views/Directory.html").forward(request,response);
	}

}
