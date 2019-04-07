package com.revature.intercom;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Reimbursement;

@FeignClient(name="account-service", fallback=ReimburseClientFallback.class)
public interface ReimburseClient {
	
	@GetMapping("reimbursements/employee/{employeeId}")
	public List<Reimbursement> getReimbursementsByEmpId(@PathVariable("employeeId")Integer employeeId);
}
