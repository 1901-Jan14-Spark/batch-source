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
		reimbursements.add(new Reimbursement(1,1,880.30));
		reimbursements.add(new Reimbursement(2,1,990.30));
		reimbursements.add(new Reimbursement(3,1,775.87));
		reimbursements.add(new Reimbursement(4,2,897.45));
		reimbursements.add(new Reimbursement(5,2,123.45));
		reimbursements.add(new Reimbursement(6,3,1657.90));
	
	}

	@GetMapping
	public List<Reimbursement> getAllreimbursements(){
		log.info("getting all reimbursements");
		return reimbursements;
	}
	
	@GetMapping("/{reimbId}")
	public Reimbursement getreimbById(@PathVariable("reimbId") Integer reimbId) {
		log.info("getting reimb by id: " + reimbId);
		for(Reimbursement a: reimbursements) {
			if(reimbId == a.getReimbId()) {
				return a;
			}
		}
		return null;
	}
	
	@GetMapping("/employee/{employeeId}")
	public List<Reimbursement> getreimbursementsByemployeeId(@PathVariable("employeeId") Integer employeeId){
		return reimbursements.stream().filter(emp -> emp.getEmployeeId()==employeeId)
				.collect(Collectors.toList());
	}
	
}
