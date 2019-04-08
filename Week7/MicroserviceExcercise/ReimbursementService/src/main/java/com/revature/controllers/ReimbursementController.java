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
		reimbursements.add(new Reimbursement(1,1,false,"pending",750.30));
		reimbursements.add(new Reimbursement(2,1,false,"pending",100.30));
		reimbursements.add(new Reimbursement(3,1,false,"pending",23.87));
		reimbursements.add(new Reimbursement(4,2,false,"pending",98.45));
		reimbursements.add(new Reimbursement(5,2,false,"pending",1200.45));
		reimbursements.add(new Reimbursement(6,3,false,"pending",75.90));
		reimbursements.add(new Reimbursement(7,3,false,"pending",3400.43));
		reimbursements.add(new Reimbursement(8,3,false,"pending",427.32));
	}

	@GetMapping
	public List<Reimbursement> getAllreimbursements(){
		log.info("getting all reimbursements");
		return reimbursements;
	}
	
	@GetMapping("/{reimbursementId}")
	public Reimbursement getreimbursementById(@PathVariable("reimbursementId") Integer reimbursementId) {
		log.info("getting reimbursement by id: " + reimbursementId);
		for(Reimbursement a: reimbursements) {
			if(reimbursementId == a.getReimbursementId()) {
				return a;
			}
		}
		return null;
	}
	
	@GetMapping("/employee/{employeeId}")
	public List<Reimbursement> getreimbursementsByemployeeId(@PathVariable("employeeId") Integer employeeId){
		return reimbursements.stream().filter(reim -> reim.getEmployeeId()==employeeId)
				.collect(Collectors.toList());
	}
	
}
