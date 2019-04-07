package delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Reimbursements;
import services.ReimbursementsService;

public class ReimbursementsDelegate {
	ReimbursementsService reimServ = new ReimbursementsService();

	public void getReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Reimbursements> allReims = reimServ.getReims();
		List<Reimbursements> reimSearch = new ArrayList<>();

		String reimJSON;
		String reimId = request.getParameter("reim_id");
		String name = request.getParameter("reim_name");

		if (reimId != null && reimId.matches("^\\d+$")) {
			reimSearch.add(reimServ.getReimById(Integer.parseInt(reimId)));
		}else if (name!= null) {
			for(Reimbursements r: allReims) {
				if(r.getReim_name()  .contains(name)) {
					reimSearch.add(r);
				}
			}
		}else{
			reimSearch = allReims;

		}
		
		ObjectMapper om = new ObjectMapper();
		reimJSON = om.writeValueAsString(reimSearch);
		PrintWriter pw = response.getWriter();
		pw.write(reimJSON);
		pw.close();
	}

	public void CreateReims(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBody = request.getReader().readLine();

		ObjectMapper om = new ObjectMapper();
		Reimbursements newReim = om.readValue(requestBody, Reimbursements.class);

		int empCreated = reimServ.createReims(newReim);
		if(empCreated ==1) {
			response.setStatus(201);
		}else {
			response.setStatus(400);
		}
	}


	public void updateReims(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("got to PUt");
		String requestBody = request.getReader().readLine();
		String reimId = request.getParameter("reimId");
		String status = request.getParameter("status");
		String resolvedBy = request.getParameter("resolvedby");


		ObjectMapper om = new ObjectMapper();
		Reimbursements updatedReim = om.readValue(requestBody, Reimbursements.class);
		updatedReim.setReim_id(Integer.parseInt(reimId));
		updatedReim.setReimStatus(status);
		updatedReim.setResolvedId(Integer.parseInt(resolvedBy));
		int empUpdate = reimServ.updateReims(updatedReim);


		if(empUpdate ==1) {
			response.setStatus(201);
		}else {
			response.setStatus(400);
		}
	}

	//	public void deleteReims(HttpServletRequest request, HttpServletResponse response) throws IOException {
	//		String requestBody = request.getReader().readLine();
	//		
	//		ObjectMapper om = new ObjectMapper();
	//		Reimbursements deletedReim = om.readValue(requestBody, Reimbursements.class);
	//		
	//		int empUpdate = reimServ.deleteReims(deletedReim);
	//		if(empUpdate ==1) {
	//			response.setStatus(201);
	//		}else {
	//			response.setStatus(400);
	//		}
	//	}

}
