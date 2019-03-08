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

	private static final long serialVersionUID = 1L;
	
	CatService catService = new CatService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		List<Cat> myCats = catService.getCats();
//		for(Cat c: myCats) {
//			System.out.println(c);
//		}
		
		ObjectMapper om = new ObjectMapper();
		String myCatsJSON = om.writeValueAsString(myCats);
		myCatsJSON = "{\"cats\":"+myCatsJSON+"}";
//		System.out.println(myCatsJSON);
		PrintWriter pw = response.getWriter();
		pw.print(myCatsJSON);
		pw.close();
		
	}

}
