package com.revature.intercom;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.models.Reimbursements;

@Component
public class ReimsEmpFallback implements ReimbursementsClient{

	@Override
	public List<Reimbursements> getReimsByEmpId(Integer empId) {
		return null;
	}

}
