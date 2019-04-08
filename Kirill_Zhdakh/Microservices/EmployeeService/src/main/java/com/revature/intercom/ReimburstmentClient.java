package com.revature.intercom;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Reimburstment;

@FeignClient(name="reimburstment-service", fallback=ReimburstmentClientFallback.class)
public interface ReimburstmentClient {
	@GetMapping("reimburstments/employees/{employeeId}")
	public List<Reimburstment> getReimburstmentsByEmployeeId(@PathVariable("employeeId") Integer employeeId); 
}
