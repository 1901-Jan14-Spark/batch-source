package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;
import com.revature.model.Manager;
import com.revature.model.User;

/**
 * Servlet implementation class ManagerInfoServlet
 */
public class ManagerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ((!User.isNull() && User.isManager())) {
			ManagerDao rd = new ManagerDaoImpl();
			ObjectMapper om = new ObjectMapper();
			PrintWriter pw = response.getWriter();
			Manager manager = rd.getManagerById(User.getUserId());
			String requestString = om.writeValueAsString(manager);
			requestString = "{\"manager\":" + requestString + "}";
			pw.print(requestString);
		} else {
			RequestDispatcher rq = request.getRequestDispatcher("Views/Login.html");
			rq.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
