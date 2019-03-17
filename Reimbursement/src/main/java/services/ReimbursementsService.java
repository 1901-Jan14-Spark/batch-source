package services;

import java.util.List;

import dao.ReimbursementsDao;
import dao.ReimbursementsDaoImpl;
import models.Reimbursements;

public class ReimbursementsService implements ReimbursementsDao{

	ReimbursementsDao reimImpl = new ReimbursementsDaoImpl();
		
	@Override
	public List<Reimbursements> getReims() {
		return reimImpl.getReims();
	}

	@Override
	public int createReims(Reimbursements reim) {
		return reimImpl.createReims(reim);
	}

	@Override
	public int updateReims(Reimbursements reim) {
		return reimImpl.updateReims(reim);
	}

	@Override
	public int deleteReims(int id) {
		return reimImpl.deleteReims(id);
	}

	@Override
	public Reimbursements getReimById(int id) {
		return reimImpl.getReimById(id);
	}

	public Reimbursements getReimByRequester(int requestee) {
		return reimImpl.getReimByRequester(requestee);
	}

	

}
