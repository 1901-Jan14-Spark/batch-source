package delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutDelegate {

	public LogoutDelegate() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached Logout");
		HttpSession session = request.getSession(false);
		if(session !=null) {
			session.invalidate();
		}
		response.sendRedirect("http://localhost:8080/Reimbursement/login");
	}
}
