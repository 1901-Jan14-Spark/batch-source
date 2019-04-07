package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Reimbursement;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementController {
	private List<Reimbursement> reimbursements= new ArrayList<>();
	
	public ReimbursementController() {
		reimbursements.add(new Reimbursement(1,1,51.20));
		reimbursements.add(new Reimbursement(2,1,3.50));
		reimbursements.add(new Reimbursement(3,2,13.72));
		reimbursements.add(new Reimbursement(4,3,14.00));
		reimbursements.add(new Reimbursement(5,3,795.02));
		reimbursements.add(new Reimbursement(6,1,70.86));
		reimbursements.add(new Reimbursement(7,4,4.00));
		reimbursements.add(new Reimbursement(8,4,7.50));
		reimbursements.add(new Reimbursement(9,2,19.36));
	}
	
	@GetMapping
	public List<Reimbursement> getAllReimbursements(){
		return reimbursements;
		
	}
	
	
	@GetMapping("/{reimbursementId}")
	public Reimbursement getReimbursementById(@PathVariable("reimbursementId")Integer reimbursementId){
		Reimbursement reimbursement = reimbursements.stream().filter(reim -> reim.getReimbursementId()==reimbursementId).findFirst().get();
		return reimbursement;
	}
	
	@GetMapping("/employee/{employeeId}")
	public List<Reimbursement> getReimbursementsByEmpId(@PathVariable("employeeId")Integer employeeId){
		return reimbursements.stream().filter(emp -> emp.getEmployeeId()==employeeId).collect(Collectors.toList());
	}
	
}
