package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if( session!=null) 
		{
			if (session.getAttribute("username")!=null)
				pw.write("{\"username\":\""+session.getAttribute("username")+"\",");
			else
				pw.write("{\"username\": null,");
			if (session.getAttribute("error") != null)
				pw.write("\"error\": \"" + session.getAttribute("error") + "\"}");
			else
				pw.write("\"error\": null }");
		}
		pw.close();
	}

}
