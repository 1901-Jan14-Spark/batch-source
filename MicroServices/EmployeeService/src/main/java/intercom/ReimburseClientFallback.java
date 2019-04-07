package intercom;

import java.util.List;

import org.springframework.stereotype.Component;

import models.Reimbursement;

@Component 
public class ReimburseClientFallback implements ReimburseClient {

	@Override
	public List<Reimbursement> getReimbursementByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
