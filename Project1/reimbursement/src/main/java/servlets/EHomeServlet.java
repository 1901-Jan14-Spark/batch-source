package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmpDao;
import dao.EmpDaoImpl;
import services.NewReqService;

/**
 * Servlet implementation class EHomeServlet
 */
public class EHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmpDao ed = new EmpDaoImpl();
	NewReqService nrs = new NewReqService();
	
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
			else {
				response.sendError(403, "You are not authorized to view this page.");
			}
		}
		else {
			response.sendError(403, "You are not authorized to view this page.");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String idStr = session.getAttribute("userId").toString();
		int id = Integer.parseInt(idStr);
		
		String amountStr = request.getParameter("amount");
		double amount = Double.parseDouble(amountStr);
		
		String desc = request.getParameter("description");
		
		boolean success = nrs.createReq(id, amount, desc);
		
		if(success)
			doGet(request, response);
		
		else
			response.sendError(500, "Failed update");
	}
}
