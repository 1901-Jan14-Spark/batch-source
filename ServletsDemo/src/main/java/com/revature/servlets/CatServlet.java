package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Cat;
import com.revature.services.CatService;

public class CatServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CatService cs = new CatService();
	static ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Cat> myCats = cs.getCats();
//		for (Cat c : myCats) {
//			System.out.println(c);
//		}
		
		String myCatsJSON = om.writeValueAsString(myCats);
		myCatsJSON = "{\"cats\":"+myCatsJSON+"}";
		System.out.println(myCatsJSON);
		PrintWriter pw = response.getWriter();
		pw.print(myCatsJSON);
	}
	

}
