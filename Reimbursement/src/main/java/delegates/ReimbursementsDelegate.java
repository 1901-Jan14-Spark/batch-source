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
		
		String reimId = request.getParameter("id");
		String name = request.getParameter("name");
		String requester = request.getParameter("requester");
		String status = request.getParameter("status");
		String resolved_By = request.getParameter("resolvedBy");
		
		if (reimId != null && reimId.matches("^\\d+$")) {
			reimSearch.add(reimServ.getReimById(Integer.parseInt(reimId)));
		} else if (name != null) {
			for (Reimbursements r : allReims) {
				if (r.getReim_name().contains(name)) {
					reimSearch.add(r);
				} else if(status != null) {
					for(Reimbursements stat: allReims) {
						if(stat.getReimStatus().contains("status")) {
							reimSearch.add(stat);
						}else if(resolved_By != null) {
							reimSearch.add(reimServ.getReimByRequester(Integer.parseInt(requester)));
							}else {
								reimSearch = allReims;
						}
					}
				}

			ObjectMapper om = new ObjectMapper();
			PrintWriter pw = response.getWriter();
			pw.write(om.writeValueAsString(reimSearch));
			pw.close();
			}
		}
		
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
		String requestBody = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		Reimbursements updatedReim = om.readValue(requestBody, Reimbursements.class);
		
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
