package dao;

import java.util.List;

import models.Reimbursements;

public interface ReimbursementsDao {
	List<Reimbursements> getReims();
	public int createReims(Reimbursements reim);
	public int updateReims(Reimbursements reim);
	public int deleteReims(int id);
	public Reimbursements getReimById(int id);
}
