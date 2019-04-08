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
		reimbursements.add(new Reimbursement(1, 1, 500.00));
		reimbursements.add(new Reimbursement(2, 1, 100.23));
		reimbursements.add(new Reimbursement(3, 3, 98.56));
		reimbursements.add(new Reimbursement(4, 2, 498.15));
		reimbursements.add(new Reimbursement(5, 3, 9.69));
		reimbursements.add(new Reimbursement(6, 2, 789.12));
	}
	
	@GetMapping
	public List<Reimbursement> getAllReimbursements(){
		log.info("getting all reimbursements");
		return reimbursements;
	}
	
	@GetMapping("/{reimbursementId}")
	public Reimbursement getReimbursementById(@PathVariable("reimbursementId") Integer reimbursementId) {
		log.info("getting reimbursement by id: " + reimbursementId);
		for(Reimbursement r: reimbursements) {
			if(reimbursementId == r.getReimbursementId()) {
				return r;
			}
		}
		return null;
	}
	
	@GetMapping("/employee/{employeeId}")
	public List<Reimbursement> getReimbursementsByEmployeeId(@PathVariable("employeeId") Integer employeeId){
		return reimbursements.stream().filter(reim -> reim.getEmployeeId()==employeeId)
				.collect(Collectors.toList());
	}
}
