package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.imp.UserDaoImp;
import com.model.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		UserDao userdao = new UserDaoImp();
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setTitle(request.getParameter("title"));
		if("Manager".equals(user.getTitle()))
			user.setReportsTo(null);
		else
			user.setReportsTo((Integer)request.getSession().getAttribute("id"));
		userdao.createUser(user);
		response.sendRedirect("dashboard");
	}
}
