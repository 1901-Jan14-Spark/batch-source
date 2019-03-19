package com.revature.dao;

import java.util.List;

import com.revature.company.Reimbursement;

public interface ReimbursementDao {
	
	public List<Reimbursement> getRefunds();
	public Reimbursement getRefundById(int id);
	public Reimbursement getRefundByEmployeeId(int id);
	public int addNewReimbursement(Reimbursement rb);
	public int updateReimbursementStatus(Reimbursement rb);
}
