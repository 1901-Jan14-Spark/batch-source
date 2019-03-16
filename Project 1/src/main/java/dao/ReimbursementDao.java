package dao;

import java.util.List;

import models.Reimbursements;

public interface ReimbursementDao {

	public List<Reimbursements> getReimbursements();
	public int resolveReimbursementsById(Reimbursements reimb);
	public List<Reimbursements> getReimbByEmpId(int id);
	
}
