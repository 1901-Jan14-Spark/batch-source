package com.revature.intercom;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Reimbursements;

@FeignClient(name="reims-service", fallback=ReimsEmpFallback.class)
public interface ReimbursementsClient {

	@GetMapping("reims/employee/{empId}")
	public List<Reimbursements> getReimsByEmpId(@PathVariable("empId") Integer empId);
}
