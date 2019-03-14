package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
	
	public List<Reimbursement> getReimbursements();
	public Reimbursement getReimbursementById(int id);
	public int createReimbursement(Reimbursement r);
	public int updateReimbursement(Reimbursement r);
	public int deleteReimbursement(int id);
	public List<Reimbursement> getPendingReimbursementsByEmpId(int id);
	public List<Reimbursement> getResolvedReimbursementsByEmpId(int id);
	public List<Reimbursement> getPendingReimbursements();
	public List<Reimbursement> getResolvedReimbursements();
	public List<Reimbursement> getReimbursementsByEmpId(int id);
}
