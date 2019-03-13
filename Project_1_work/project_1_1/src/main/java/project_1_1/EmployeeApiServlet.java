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
import utilities.EmployeeService;

/**
 * Servlet implementation class EmployeeApiServlet
 */
public class EmployeeApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeService empServ = new EmployeeService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		String employeeJSON;
		List<Employee> employees = empServ.getAll();
		System.out.println(employees);
		employeeJSON = om.writeValueAsString(employees);
		PrintWriter pw = response.getWriter();
		pw.write(employeeJSON);
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
