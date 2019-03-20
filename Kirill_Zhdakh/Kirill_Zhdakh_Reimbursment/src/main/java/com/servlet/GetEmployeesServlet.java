package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.imp.UserDaoImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.User;

public class GetEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userdao = new UserDaoImp();
		List<User> users = userdao.getUsers();
		ObjectMapper om = new ObjectMapper();
		
		String userJSON = om.writeValueAsString(users);
		PrintWriter pw = response.getWriter();
		pw.print(userJSON);
		pw.close();
	}
}
