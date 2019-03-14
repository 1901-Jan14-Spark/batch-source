package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EHomeServlet
 */
public class EHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EHomeServlet() {
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
			//check userId is employee
			if("1".equals(id)) {
				RequestDispatcher rd = request.getRequestDispatcher("eHome.html");
				rd.forward(request, response);
			}
		}
		else {
			response.sendError(401, "You are not authorized to view this page.");
		}
	}
}
