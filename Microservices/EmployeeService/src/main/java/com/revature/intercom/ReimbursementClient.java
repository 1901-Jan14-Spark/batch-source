package com.revature.intercom;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Reimbursements;

@FeignClient(name="reimbursement-service", fallback=ReimbursementClientFallback.class)
public interface ReimbursementClient {

	@GetMapping("reimbursements/employee/{id}")
	public List<Reimbursements> getReimbursementsById(@PathVariable("id")Integer id);
}
