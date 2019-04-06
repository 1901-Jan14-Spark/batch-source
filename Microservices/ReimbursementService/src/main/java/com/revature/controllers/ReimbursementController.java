package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Reimbursements;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementController {

	private List<Reimbursements> reimbs = new ArrayList<>();
	
	public ReimbursementController() {
		super();
		reimbs.add(new Reimbursements(1, 1, 20.20));
		reimbs.add(new Reimbursements(2, 2, 100.71));
		reimbs.add(new Reimbursements(3, 3, 03.71));
		reimbs.add(new Reimbursements(4, 4, 10.10));
		reimbs.add(new Reimbursements(3, 5, 91.17));
	}
	
	@GetMapping
	public List<Reimbursements> getAllReimbs(){
		return reimbs;
	}
	
	@GetMapping("/{reimbId}")
	public Reimbursements getReimbById(@PathVariable("reimbId")Integer reimbId) {
		for(Reimbursements r : reimbs) {
			if(reimbId == r.getReimbId()) {
				return r;
			}
		}
		return null;
	}
	
	@GetMapping("/employee/{id}")
	public List<Reimbursements> getReimbByEmpId(@PathVariable("id")Integer id) {
		return reimbs.stream().filter(acct -> acct.getEmployeeId()==id).collect(Collectors.toList());
	}
}
