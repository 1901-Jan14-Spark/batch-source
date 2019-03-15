package project_1_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import daos.Employee;
import daos.EmployeeDaoImp;

/**
 * Servlet implementation class ManagersEmployeeServlet
 */
public class ManagersEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private EmployeeDaoImp mangServ = new EmployeeDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagersEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		String managersJSON;
		List<Employee> employees = mangServ.getManagersEmployee("ctarney2");
		managersJSON = om.writeValueAsString(employees);
		PrintWriter pw = response.getWriter();
		//System.out.println(employees);
		pw.write(managersJSON);
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
