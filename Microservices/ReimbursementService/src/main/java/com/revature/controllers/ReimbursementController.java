package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Reimbursement;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementController {

	private Logger log = Logger.getLogger(ReimbursementController.class);
	
	private List<Reimbursement> reimbursements = new ArrayList<>();

	public ReimbursementController() {
		reimbursements.add(new Reimbursement(1, 1, 250.00));
		reimbursements.add(new Reimbursement(2, 1, 21.03));
		reimbursements.add(new Reimbursement(3, 1, 100.00));
		reimbursements.add(new Reimbursement(4, 2, 325.65));
		reimbursements.add(new Reimbursement(5, 2, 404.25));
		reimbursements.add(new Reimbursement(6, 3, 83.00));
		reimbursements.add(new Reimbursement(7, 3, 500.75));
		reimbursements.add(new Reimbursement(8, 3, 66.73));
		reimbursements.add(new Reimbursement(9, 3, 202.00));
		reimbursements.add(new Reimbursement(10, 3, 112.36));
		reimbursements.add(new Reimbursement(11, 4, 700.00));
		reimbursements.add(new Reimbursement(12, 5, 58.00));
		reimbursements.add(new Reimbursement(13, 5, 603.23));
		reimbursements.add(new Reimbursement(14, 5, 10.00));
		reimbursements.add(new Reimbursement(15, 5, 890.34));
	}
	
	public List<Reimbursement> getAllReimbursements() {
		log.info("getting all reimbursements");
		return reimbursements;
	}
	
	@GetMapping("/{reimbursementId}")
	public Reimbursement getReimbursementById(@PathVariable("reimbursementId") int reimbursementId) {
		log.info("getting reimbursement by id: " + reimbursementId);
		for(Reimbursement rb: reimbursements) {
			if(reimbursementId == rb.getReimbursementId()) {
				return rb;
			}
		}
		return null;
	}
	
	@GetMapping("/employee/{employeeId}")
	public List<Reimbursement> getReimbursementsByEmployeeId(@PathVariable("employeeId") Integer employeeId) {
		return reimbursements.stream().filter(reim -> reim.getEmployeeId() == employeeId)
				.collect(Collectors.toList());
	}
}
