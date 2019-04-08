package com.revature.intercom;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.model.Reimbursement;

@Component
public class ReimbursementClientFallback implements ReimbursementClient {

	@Override
	public List<Reimbursement> getReimbursementsByEmployeeId(Integer employeeId) {
		return null;
	}

}