package project_1_1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.EmployeeDaoImp;

/**
 * Servlet implementation class UpdateRequestServlet
 */
public class UpdateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       EmployeeDaoImp reqUp = new EmployeeDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		String reason = request.getParameter("reason");
		double amount = Double.parseDouble(request.getParameter("amount"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String dateApproved = dtf.format(now);
		
		reqUp.updateRequest(id, status, reason, amount, dateApproved);
		response.sendRedirect("MngHome");
	}

}
