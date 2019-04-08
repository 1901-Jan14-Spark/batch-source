package com.revature.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Reimbursement;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementController {

		private Logger log = Logger.getLogger(ReimbursementController.class);
		
		private List<Reimbursement> reimbursements = new ArrayList<>();
		
		public ReimbursementController() {
			reimbursements.add(new Reimbursement(1, 2, 10));
			reimbursements.add(new Reimbursement(2, 1, 10.10));
			reimbursements.add(new Reimbursement(3, 1, 20.20));
			reimbursements.add(new Reimbursement(4, 3, 30.30));
			reimbursements.add(new Reimbursement(5, 2, 20.22));
			reimbursements.add(new Reimbursement(6, 1, 11.11));
			reimbursements.add(new Reimbursement(7, 3, 33.33));
			reimbursements.add(new Reimbursement(8, 3, 33.30));
			reimbursements.add(new Reimbursement(9, 2, 2.2));
		}
		
		@GetMapping
		public ResponseEntity<List<Reimbursement>> getAllReimbursements(){
			log.info("Retrieving all reimbursements");
			return new ResponseEntity<>(reimbursements, HttpStatus.OK);
		}
		
		@GetMapping("/{reimbursementId}")
		public ResponseEntity<Reimbursement> getReimbursementById(@PathVariable("reimbursementId") Integer reimbursementId) {
			log.info("Returning reimbursement: " + reimbursementId + ".");
			for(Reimbursement r : reimbursements) {
				if(r.getReimbursementId().equals(reimbursementId)) {
					return new ResponseEntity<>(r, HttpStatus.OK);
				}
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		@GetMapping("/employee/{employeeId}")
		public List<Reimbursement> getAccountsByEmployeeId(@PathVariable("employeeId") Integer employeeId){
			return reimbursements.stream().filter(reimb -> reimb.getEmployeeId() == employeeId).collect(Collectors.toList());
		}
} 