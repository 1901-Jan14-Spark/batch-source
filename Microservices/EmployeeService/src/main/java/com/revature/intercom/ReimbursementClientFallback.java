package com.revature.intercom;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.models.Reimbursements;

@Component
public class ReimbursementClientFallback implements ReimbursementClient {

	@Override
	public List<Reimbursements> getReimbursementsById(Integer id) {
		return null;
	}

}
