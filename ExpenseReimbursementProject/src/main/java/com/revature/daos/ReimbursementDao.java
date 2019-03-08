package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public interface ReimbursementDao {

	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getReimbursementsFromEmployee(Employee e);
	public List<Reimbursement> getReimbursementsPending();
	public List<Reimbursement> getReimbursementsResolved();
	public Reimbursement getReimbursement(Reimbursement r);
	public int createReimbursement(Reimbursement r);
	//Can be used to authorized/decline Reimbursements
	public boolean updateReimbursement(Reimbursement r);
	
	//public Blob viewBlob(Reimbursement r);
	
	
	
}
