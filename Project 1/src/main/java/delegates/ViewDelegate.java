package delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewDelegate {
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRequestURI().substring(request.getContextPath().length()+1);
		System.out.println(address);
		
		if ("api/employees".equals(address)) {
			address = "employeeLogin";
		}
		
		if(request.getSession().getAttribute("email") == null && "managerLogin".equals(address) || request.getSession().getAttribute("email") == null && "employeeLogin".equals(address) ) {
			System.out.println("are we checking the right session?!?");
			address = "login";
			response.sendRedirect("http://localhost:9393/Project1/login");
			return;
		}
		
		if("managerLogin".equals(address) || "employeeLogin".equals(address)) {
			if(request.getSession().getAttribute("email") == null) {
				address = "login";
				response.sendRedirect("http://localhost:9393/Project1/login");
				return;
			}
		}
		
		switch(address) {
		case "login":
			System.out.println("is this working");
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
