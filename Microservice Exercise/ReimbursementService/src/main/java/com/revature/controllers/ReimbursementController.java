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
		reimbursements.add(new Reimbursement(1,2, 500));
		reimbursements.add(new Reimbursement(2,3, 350));
		reimbursements.add(new Reimbursement(3,1, 50));
		reimbursements.add(new Reimbursement(4,6, 250));
		reimbursements.add(new Reimbursement(5,1, 120));
		reimbursements.add(new Reimbursement(6,5, 75));
		reimbursements.add(new Reimbursement(7,2, 400));
		reimbursements.add(new Reimbursement(8,4, 175));
		reimbursements.add(new Reimbursement(9,5, 200));
	}

	@GetMapping
	public List<Reimbursement> getAllReimbursementss(){
		log.info("getting all Reimbursements");
		return reimbursements;
	}
	
	@GetMapping("/{ReimId}")
	public Reimbursement getReimbursementById(@PathVariable("ReimId") Integer ReimId) {
		log.info("getting reimbursement by id: " + ReimId);
		for(Reimbursement r: reimbursements) {
			if(ReimId == r.getReimId()) {
				return r;
			}
		}
		return null;
	}
	
	@GetMapping("/Employee/{EmpId}")
	public List<Reimbursement> getReimbursementsByEmpId(@PathVariable("EmpId") Integer EmpId){
		return reimbursements.stream().filter(reim -> reim.getEmpId()==EmpId)
				.collect(Collectors.toList());
	}

}
