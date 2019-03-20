package com.revature.delagate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDaoJdbc;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public class ReimbursementDelegate {
	private static ReimbursementDaoJdbc rdj = new ReimbursementDaoJdbc();
	public static List<Reimbursement> rList = rdj.getAllReimbursements();
	public void getReimbursement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);
		if(session==null) {
			response.sendError(401);	
		}
		else {
			ObjectMapper om = new ObjectMapper();
			PrintWriter pw = response.getWriter();
			if(session.getAttribute("isManager").equals(true)) {
				pw.write(om.writeValueAsString(rList));
			}else {
				Employee temp = new Employee();
				temp.setEmail((String) session.getAttribute("email"));
				temp = EmployeeDelegate.eList.get(EmployeeDelegate.eList.indexOf(temp)); //The things I do for efficiency...
				pw.write(om.writeValueAsString(temp));
			}
			pw.close();
		}
	}
	public void	createReimbursement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("isManager").equals(true)) {
			response.sendError(401);
		}
		Employee tempe = new Employee();
		tempe.seteID((int) session.getAttribute("eId"));
		Reimbursement rtemp = new Reimbursement();
		rtemp.setEmployee(tempe);
		rtemp.setAmount((double) request.getAttribute("amount"));
		rtemp.setReqCom((String) request.getAttribute("reqCom"));
		rtemp.setDecDate(new Date());
		rtemp.settOption((String) request.getAttribute("tOption"));
		rdj.createReimbursement(rtemp);
		response.setStatus(201);
		rList = rdj.getAllReimbursements();
	}
	public void	updateReimbursement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}

}
