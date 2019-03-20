package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDelegate {

    public SessionDelegate() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void viewSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if( session!=null && session.getAttribute("email")!=null) {
			pw.write("{\"email\":\""+session.getAttribute("email")+"\",");
			pw.write("\"fname\":\""+session.getAttribute("fname")+"\",");
			pw.write("\"lname\":\""+session.getAttribute("lname")+"\"}");
		} else {
			pw.write("{\"username\": null }");
		}
		pw.close();
	}


}