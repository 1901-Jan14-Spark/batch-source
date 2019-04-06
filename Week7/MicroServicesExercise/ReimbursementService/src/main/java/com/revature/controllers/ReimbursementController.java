package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Reimbursement;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementController {
	private List<Reimbursement> reimbursements = new ArrayList<>();
	
	public ReimbursementController() {
		reimbursements.add(new Reimbursement(1, 1, 32.45));
		reimbursements.add(new Reimbursement(2, 1, 3.50));
		reimbursements.add(new Reimbursement(3, 2, 22.83));
		reimbursements.add(new Reimbursement(4, 3, 87.39));
	}
	
	@GetMapping
	public List<Reimbursement> getAllReimbursements(){
		return reimbursements;
	}
	
	@GetMapping("/{rId}")
	public Reimbursement getReimbursementById(@PathVariable("rId")Integer rId) {
		Reimbursement reimburse = reimbursements.stream().filter(r -> r.getrId()==rId).findFirst().get();
		return reimburse;
	}
	
	@GetMapping("/employee/{empId}")
	public List<Reimbursement> getReimbursementsByEmpId(@PathVariable("empId")Integer empId){
		return reimbursements.stream().filter(emp -> emp.getEmpId()==empId).collect(Collectors.toList());
	}
}