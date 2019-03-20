package com.revature.dao;

import java.util.List;

import com.revature.company.Reimbursement;

public interface ReimbursementDao {
	
	public List<Reimbursement> getRefunds();
	public List<Reimbursement> getAllRefundsForEmployee(int id);
	public Reimbursement getRefundById(int id);
	public Reimbursement getRefundByEmployeeId(int id);
	public int addNewReimbursement(Reimbursement rb);
	public int updateReimbursementStatus(Reimbursement rb);
	public int approveReimbursement(Reimbursement rb);
	public int denyReimbursement(Reimbursement rb);
}
