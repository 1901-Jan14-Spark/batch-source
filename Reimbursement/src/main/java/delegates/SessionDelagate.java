package delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDelagate {

	public SessionDelagate() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if( session!=null && session.getAttribute("username")!=null) {
			pw.write("{\"username\":\""+session.getAttribute("username")+"\"}");
		} else {
			pw.write("{\"username\": null }");
		}
		pw.close();
	}


}