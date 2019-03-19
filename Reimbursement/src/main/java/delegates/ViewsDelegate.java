package delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewsDelegate {
	LoginDelegate ld = new LoginDelegate();
	
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
			if("GET".contentEquals(request.getMethod())) {
			ld.doGet(request, response);
			}else if("POST".contentEquals(request.getMethod())) {
				ld.doPost(request, response);
			}else {
				response.sendError(403,"login only supports get and post");
			}
//		request.getRequestDispatcher("/static/Login.html").forward(request, response);
		break;
		default:
			response.sendError(404,"Static Resource Not Found");
		}
	}

}