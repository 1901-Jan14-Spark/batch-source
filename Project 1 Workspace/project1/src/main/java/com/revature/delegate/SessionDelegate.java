package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDelegate {
	public void session(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if (session != null && session.getAttribute("id") != null) {
			pw.write("{\"id\":\""+session.getAttribute("id")+"\"}");
		} else {
			pw.write("{\"id\": null }");
		}
		pw.close();
	}
}
