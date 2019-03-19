package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.imp.UserDaoImp;
import com.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Views/Login.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userdao = new UserDaoImp();
		List<User> users = userdao.getUsers();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		for(int i = 0; i < users.size(); ++i)
		{
			if (users.get(i).getUsername().equals(username) || users.get(i).getEmail().equals(username))
			{
				if (users.get(i).getPassword().equals(password))
				{
					session.setAttribute("id", users.get(i).getId());
					session.setAttribute("username", username);
					session.setAttribute("firstname", users.get(i).getFirstName());
					session.setAttribute("lastname", users.get(i).getLastName());
					session.setAttribute("email", users.get(i).getEmail());
					session.setAttribute("title", users.get(i).getTitle());
					response.sendRedirect("dashboard");
					return;
				}
			}
		}

		session.setAttribute("error", "Invalid username or password");
		response.sendRedirect("login");
	}
}
