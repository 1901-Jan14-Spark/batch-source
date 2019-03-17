package delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewsDelegate {
	
	
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRequestURI().substring(request.getContextPath().length()+1);
		switch(address) {
		case "employees":
			request.getRequestDispatcher("/static/views/EmployeesView.html").forward(request, response);
			break;
		case "reimbursements":
			request.getRequestDispatcher("/static/views/ReimbursementsView.html").forward(request, response);
			break;
		case "login":
			request.getRequestDispatcher("/static/Login.html").forward(request, response);
		default:
			response.sendError(404,"Static Resource Not Found");
		}
	}

}