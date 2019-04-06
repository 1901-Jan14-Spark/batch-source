package com.revature.intercom;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Reimbursement;

@FeignClient(name="reimbursement-service", fallback=ReimburseClientFallback.class)
public interface ReimburseClient {
	
	@GetMapping("reimbursements/employee/{empId}")
	public List<Reimbursement> getReimbursementsByEmpId(@PathVariable("empId")Integer empId);
}