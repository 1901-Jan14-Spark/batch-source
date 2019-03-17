package delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRequestURI().substring(request.getContextPath().length()+1);
		switch(address) {
		case "login":
			request.getRequestDispatcher("/static/Views/index.html").forward(request, response);
			return;
		case "managerLogin":
			request.getRequestDispatcher("/static/Views/managerhome.html").forward(request, response);
			return;
		case "employeeLogin":
			request.getRequestDispatcher("/static/Views/employeehome.html").forward(request, response);
			return;
		default:
			response.sendError(404, "Static Resource Not Found");
		}
	}
}
