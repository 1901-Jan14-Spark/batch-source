package project_1_1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.EmployeeDaoImp;

/**
 * Servlet implementation class EmployeeReimbursmentServlet
 */
public class EmployeeReimbursmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeReimbursmentServlet() {
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
	
	String reason = request.getParameter("reason");	
	double cost = Double.parseDouble(request.getParameter("amount"));	
	EmployeeDaoImp tester = new EmployeeDaoImp();		
	String user = (String) request.getSession().getAttribute("username");
	 int id = tester.getEmployeeId(user);
	tester.postRequest(user, id, cost, reason);
	response.sendRedirect("EmpHome");
	
	
		//doGet(request, response);
	}

}
