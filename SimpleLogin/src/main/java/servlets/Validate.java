package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validate extends HttpServlet{
	private static final long serialVersionUID = -1712542589174450934L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		boolean validate = (boolean) request.getAttribute("validate");
		PrintWriter pw = response.getWriter();
		
		if(validate == true) {
			pw.write("Successfully Logged In");
		}else {
			pw.write("<p> LOGIN FAILED </p>");
			pw.write("<p><a href=\"Login.html\" >Login Again!</a></p>");
		}
		
	}
	}
