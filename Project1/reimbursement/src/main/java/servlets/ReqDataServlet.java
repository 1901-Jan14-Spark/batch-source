package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ReqDao;
import dao.ReqDaoImpl;
import model.ReqObj;

/**
 * Servlet implementation class ReqDataServlet
 */
public class ReqDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ReqDao rd = new ReqDaoImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqDataServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		HttpSession session = request.getSession(false);
		
		String idStr = session.getAttribute("userId").toString();
		String requestsJSON = "";
		
		if(!("".equals(idStr))) {
			int id = Integer.parseInt(idStr);
			
			if(id > 19999) {
				List<ReqObj> requests = rd.getAllReq();
				requestsJSON = om.writeValueAsString(requests);
			}
			else {
				List<ReqObj> requestsById = rd.getReqById(id);
				
				if(requestsById.size() == 0) {
					response.setStatus(404);
				}
				else {
					requestsJSON = om.writeValueAsString(requestsById);
				}
			}
		}
		
		PrintWriter pw = response.getWriter();
		pw.write(requestsJSON);
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
