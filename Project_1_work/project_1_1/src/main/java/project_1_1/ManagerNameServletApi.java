package project_1_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import daos.EmployeeDao;
import daos.EmployeeDaoImp;

/**
 * Servlet implementation class ManagerNameServletApi
 */
public class ManagerNameServletApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmployeeDao mnger = new EmployeeDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerNameServletApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		String managerNameJSON;
		String user= (String) request.getSession().getAttribute("username");
		String name = mnger.getManagerName(user);
		
		managerNameJSON = om.writeValueAsString(name);
		PrintWriter pw = response.getWriter();
		pw.write(managerNameJSON);
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
