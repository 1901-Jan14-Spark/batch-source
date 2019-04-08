package com.revature.intercom;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.models.Reimbursement;

@Component
public class ReimbursementClientFallback implements ReimbursementClient{

	public List<Reimbursement> getReimbursementByEmployeeId(Integer employeeId) {
		@GetMapping
		public List<Reimbursement> getReimbursementByEmployeeId(@PathVariable("employeeId") Integer employeeId);
	}

	
}
