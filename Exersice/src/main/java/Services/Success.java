package Services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Success extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		boolean pass = (boolean)request.getAttribute("pass");
		if(pass) {
		PrintWriter pw = response.getWriter();
		pw.write("<p> You did it</p>"+pass);
		}
		else{
			PrintWriter pw = response.getWriter();
			pw.write("<p> Inccorect. Try agian");
			pw.write("<p><a href=\"Login.html\" >Back</a></p>");
		}
	}

}
