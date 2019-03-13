package delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDelegate {

	public void createSessionApi(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if (session != null && session.getAttribute("email") != null) {
			pw.write("{\"email\":\""+session.getAttribute("email")+"\"}");
		} else {
			pw.write("{\"email\": null }");
		}
		pw.close();
	}
}
