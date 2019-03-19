package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class MHomeServlet
 */
public class MHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MHomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			//get the first number of userId
			String id = session.getAttribute("userId").toString().substring(0, 1);
			//check userId is manager
			if("2".equals(id)) {
				RequestDispatcher rd = request.getRequestDispatcher("mHome.html");
				rd.forward(request, response);
			}
			else {
				response.sendError(403, "You are not authorized to view this page.");
			}
		}
		else {
			response.sendError(403, "You are not authorized to view this page.");
		}
	}
	
	//TODO replace with updating requests table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("newName");
		String email = request.getParameter("newEmail");
		String password = request.getParameter("newPassword");
		//TODO update request method here
		doGet(request, response);
	}
}
