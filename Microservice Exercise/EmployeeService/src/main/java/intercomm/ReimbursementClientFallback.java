package intercomm;



import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.models.Reimbursement;

@Component
public class ReimbursementClientFallback implements ReimburesementClient{

	@Override
	public List<Reimbursement> getReimbursmentByEmpId(Integer EmpId) {
		// TODO Auto-generated method stub
		return null;
	}

}
