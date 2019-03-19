package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.EmpDao;
import dao.EmpDaoImpl;
import model.EmpObj;

/**
 * Servlet implementation class CurrEmpServlet
 */
public class CurrEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EmpDao ed = new EmpDaoImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		HttpSession session = request.getSession(false);
		
		String idStr = session.getAttribute("userId").toString();
		String employeeJSON = "";
		
		if(!("".equals(idStr))) {
			int id = Integer.parseInt(idStr);
			EmpObj employee = ed.getEmpById(id);
			employeeJSON = om.writeValueAsString(employee);
		}
		
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
