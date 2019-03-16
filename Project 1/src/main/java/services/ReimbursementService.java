package services;

import java.util.List;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import models.Reimbursements;

public class ReimbursementService {
	
	ReimbursementDao reimbDao = new ReimbursementDaoImpl();
	
	public List<Reimbursements> getReimbursements() {
		return reimbDao.getReimbursements();
	}
	
	public int resolveReimbursements(Reimbursements reimb) {
		return reimbDao.resolveReimbursementsById(reimb);
	}
		
}
