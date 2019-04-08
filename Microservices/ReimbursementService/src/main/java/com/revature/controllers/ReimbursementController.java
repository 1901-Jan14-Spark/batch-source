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
	private List <Reimbursement> reimbursements = new ArrayList<>();
	
	public ReimbursementController() {
		
		reimbursements.add(new Reimbursement(1, 1, 65.00));
		reimbursements.add(new Reimbursement(2, 1, 750.00));
		reimbursements.add(new Reimbursement(3, 2, 18.00));
		reimbursements.add(new Reimbursement(3, 3, 16.00));
		
	}
	
	@GetMapping
	public List<Reimbursement> getAllReimbursements(){
		log.info("getting all of the reimbursements");
		return reimbursements;
	}
	
	@GetMapping("/{reimbursementId}")
	public Reimbursement getReimbursementById(@PathVariable("reimbursementId") Integer reimbursementId) {
		log.info("getting all of the reimbursements based of reimbursement id:" + reimbursementId);
		for (Reimbursement r : reimbursements) {
			if(reimbursementId == r.getReimbursementId()) {
				return r;
			}
		}
		return null;
	}
	
	@GetMapping("/employee/{employeeid}")
	public List<Reimbursement> getReimbursementsByEmployeeId(@PathVariable("employeeId") Integer employeeId){
		return reimbursements.stream().filter(reim -> reim.getEmployeeId()==employeeId)
				.collect(Collectors.toList());
	}

}
