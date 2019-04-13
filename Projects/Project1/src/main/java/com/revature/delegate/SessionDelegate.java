package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDelegate {
	public void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if( session!=null && session.getAttribute("firstname")!=null) {
			pw.write("{\"firstname\":\""+session.getAttribute("firstname")+"\"}");
		} else {
			pw.write("{\"firstname\": null }");
		}
		pw.close();
	}

}