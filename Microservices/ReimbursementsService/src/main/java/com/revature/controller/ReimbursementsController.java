package com.revature.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Reimbursements;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementsController {
	private List<Reimbursements> reims = new ArrayList<>();
	private Logger log = Logger.getLogger(ReimbursementsController.class);

	public ReimbursementsController() {
		super();
		reims.add(new Reimbursements(1,1,345.31));
		reims.add(new Reimbursements(1,2,567.32));
		reims.add(new Reimbursements(1,3,23.12));
		reims.add(new Reimbursements(1,2,12.09));
		reims.add(new Reimbursements(1,3,420.67));
		reims.add(new Reimbursements(1,1,243.56));
		reims.add(new Reimbursements(1,2,89.90));
		reims.add(new Reimbursements(1,3,123.45));
		reims.add(new Reimbursements(1,1,567.89));
		reims.add(new Reimbursements(1,1,876.54));
		reims.add(new Reimbursements(1,2,23.56));
	}

	@GetMapping
	public List<Reimbursements> getAllReims(){
		log.info("getting all Reimbursements");
		return reims;
	}

	@GetMapping("/{reimId}")
	public Reimbursements getReimsById(@PathVariable("reimId") Integer reimId) {
		log.info("getting reimbursements by id: " + reimId);
		for(Reimbursements r: reims) {
			if(reimId == r.getReimId()) {
				return r;
			}
		}
		return null;
	}
	@GetMapping("/customer/{customerId}")
	public List<Reimbursements> getReimsByEmpId(@PathVariable("empId") Integer empId){
		return reims.stream().filter(reim -> reim.getEmpId()==empId)
				.collect(Collectors.toList());
	}



}
