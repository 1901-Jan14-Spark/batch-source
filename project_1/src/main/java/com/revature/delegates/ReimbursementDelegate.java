package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;
import com.revature.utils.InputValidator;

public class ReimbursementDelegate {

	ReimbursementService rService = new ReimbursementService();
	EmployeeService eService = new EmployeeService();
	static Logger log = Logger.getRootLogger();

	public void getsReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();

		String idStr = request.getParameter("id");

		String ReimbursementJSON;

		if (idStr != null && idStr != "") {
			int id = Integer.parseInt(idStr);
			Reimbursement r = rService.getReimbursementById(id);
			if (r == null) {
				ReimbursementJSON = "";
				response.setStatus(404);
			} else {
				ReimbursementJSON = om.writeValueAsString(r);
			}
		} else {
			List<Reimbursement> Reimbursements = rService.getReimbursements();

			ReimbursementJSON = om.writeValueAsString(Reimbursements);
		}
		PrintWriter pw = response.getWriter();
		pw.write(ReimbursementJSON);
		pw.close();
	}

	public void createsReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();

		ObjectMapper om = new ObjectMapper();
		Reimbursement r = om.readValue(requestBodyText, Reimbursement.class);

		if (!InputValidator.validateId(((Integer) r.getEmployee_id()).toString())) {
			response.sendError(400, "Invalid Employee id: " + r.getEmployee_id());
			return;
		}
		Employee e = eService.getEmployeeById(r.getEmployee_id());
		if (e == null) {
			response.sendError(400, "Employee not found: " + r.getEmployee_id());
			return;
		}
		if (!InputValidator.validateAmount(((Double) r.getAmount()).toString())) {
			response.sendError(400, "Invalid amount: " + r.getAmount());
			return;
		}
		if (!InputValidator.validateTitle(r.getTitle())) {
			response.sendError(400, "Invalid title: " + r.getTitle());
			return;
		}
		if (!InputValidator.validateDescription(r.getDescription())) {
			if (r.getDescription() != null) {
				response.sendError(400, "Invalid description: " + r.getDescription());
				return;
			}
		}

		try {
			if (rService.createReimbursement(e, r)) {
				response.setStatus(201);
				System.out.println("Reimbursement was created: " + r);
			}
		} catch (SQLIntegrityConstraintViolationException e1) {
			log.error("SQLException - Reimbursement already present.");
			response.sendError(400, "Reimbursement already present.");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	public void updatesReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestBodyText = request.getReader().readLine();

		ObjectMapper om = new ObjectMapper();
		Reimbursement r = om.readValue(requestBodyText, Reimbursement.class);

		if (!InputValidator.validateId(((Integer) r.getEmployee_id()).toString())) {
			response.sendError(400, "Invalid Employee id: " + r.getEmployee_id());
			return;
		}
		Employee e = eService.getEmployeeById(r.getEmployee_id());
		if (e == null) {
			response.sendError(400, "Employee not found: " + r.getEmployee_id());
			return;
		}
		if (!InputValidator.validateAmount(((Double) r.getAmount()).toString())) {
			if (r.getAmount() != 0) {
				response.sendError(400, "Invalid amount: " + r.getAmount());
			}
			return;
		}
		if (!InputValidator.validateTitle(r.getTitle())) {
			if (r.getTitle() != null) {
				response.sendError(400, "Invalid title: " + r.getTitle());
			}
			return;
		}
		if (!InputValidator.validateDescription(r.getDescription())) {
			if (r.getDescription() != null) {
				response.sendError(400, "Invalid description: " + r.getDescription());
				return;
			}
		}

		System.out.println(r);
		if (rService.updateReimbursement(r)) {
			response.setStatus(201);
			System.out.println("Reimbursement was updated: " + r);
		}else {
			response.sendError(400, "Invalid description: " + r.getDescription());
			System.out.println("Unable to update reimbursement.");
		}

	}
}
