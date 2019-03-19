package project_1_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import daos.EmployeeDaoImp;
import daos.Request;

/**
 * Servlet implementation class EmployeesRequestApiServlet
 */
public class EmployeesRequestApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesRequestApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		String requestJSON;
		EmployeeDaoImp mngReq = new EmployeeDaoImp();
		String user= (String) request.getSession().getAttribute("username");
		
		List<Request> requests = mngReq.getRequestById(user);
		requestJSON = om.writeValueAsString(requests);
		PrintWriter pw = response.getWriter();
		pw.flush();
		pw.write(requestJSON);
		pw.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
