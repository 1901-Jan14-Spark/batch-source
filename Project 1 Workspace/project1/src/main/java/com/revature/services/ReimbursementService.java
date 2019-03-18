package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

public class ReimbursementService implements CrudService<Reimbursement>{

	ReimbursementDao rd = new ReimbursementDaoImpl();
	
	@Override
	public List<Reimbursement> getAll() {
		return null;
	}
	
	@Override
	public Reimbursement getById(int id) {
		return rd.getReimbursementById(id);
		
	}
	
	public List<Reimbursement> getPendingReimbursementsByEmpId(int id) {
		return rd.getPendingReimbursementsByEmpId(id);
	}
	
	public List<Reimbursement> getResolvedReimbursementsByEmpId(int id) {
		return rd.getResolvedReimbursementsByEmpId(id);
	}
	
	public List<Reimbursement> getPendingReimbursements() {
		return rd.getPendingReimbursements();
	}
	
	public List<Reimbursement> getResolvedReimbursements() {
		return rd.getResolvedReimbursements();
	}
	
	public List<Reimbursement> getReimbursementsByEmpId(int id) {
		return rd.getReimbursementsByEmpId(id);
	}

	@Override
	public int create(Reimbursement reimbursement) {
		return rd.createReimbursement(reimbursement);
	}

	@Override
	public int update(Reimbursement reimbursement) {
		return rd.updateReimbursement(reimbursement);
	}

	@Override
	public int deleteById(int id) {
		return rd.deleteReimbursement(id);
	}
}
