package intercom;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import models.Reimbursement;

@FeignClient(name="reimburement-service", fallback= ReimburseClientFallback.class)
public interface ReimburseClient {

	@GetMapping("reimbursements/employee/{employeeId}")
	public List<Reimbursement> getReimbursementByEmployeeId(@PathVariable("employeeId")Integer employeeId);
	
	
	
}
