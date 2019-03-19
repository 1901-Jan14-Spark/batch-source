package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public interface ReimbursementDao {
	public List<Reimbursement> getReimbursements();
	public Reimbursement getRById(int id);
	public List<Reimbursement> getRFromEmployee(Employee emp);
	public List<Reimbursement> getRWaiting();
	public List<Reimbursement> getRApproved();
	public Reimbursement getReimbursement(Reimbursement r);
	public int createReimbursement(Reimbursement r);
	public int resolveReimbursementsById(Reimbursement r);
}
