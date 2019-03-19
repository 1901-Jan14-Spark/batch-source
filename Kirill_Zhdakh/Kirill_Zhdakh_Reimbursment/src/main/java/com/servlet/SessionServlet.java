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
			
			if (session.getAttribute("id") != null)
				pw.write("\"id\": \"" + session.getAttribute("id") + "\",");
			else
				pw.write("\"id\": null ,");
			
			if (session.getAttribute("error") != null)
				pw.write("\"error\": \"" + session.getAttribute("error") + "\",");
			else
				pw.write("\"error\": null ,");
			
			if (session.getAttribute("firstname") != null)
				pw.write("\"firstname\": \"" + session.getAttribute("firstname") + "\",");
			else
				pw.write("\"firstname\": null ,");
			
			if (session.getAttribute("lastname") != null)
				pw.write("\"lastname\": \"" + session.getAttribute("lastname") + "\",");
			else
				pw.write("\"lastname\": null ,");
			
			if (session.getAttribute("title") != null)
				pw.write("\"title\": \"" + session.getAttribute("title") + "\",");
			else
				pw.write("\"title\": null ,");
			
			if (session.getAttribute("email") != null)
				pw.write("\"email\": \"" + session.getAttribute("email") + "\"}");
			else
				pw.write("\"email\": null }");
		}
		pw.close();
	}

}
