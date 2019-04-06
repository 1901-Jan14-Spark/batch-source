package com.revature.intercom;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.models.Reimbursement;

@Component
public class ReimburseClientFallback implements ReimburseClient{

	@Override
	public List<Reimbursement> getReimbursementsByEmpId(Integer empId) {
		return null;
	}

}
