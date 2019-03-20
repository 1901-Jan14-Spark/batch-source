package com.revature.service;

import java.util.List;


import com.revature.dao.ReimbursementDao;
import com.revature.dao.im.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class ReimbursementService {

	ReimbursementDao reimDao = new ReimbursementDaoImpl();
	
	
	public List<Reimbursement> getAll() {
		return reimDao.getReimbursements();
	}

	
	public Reimbursement getById(int id) {
		return reimDao.getReimbursementById(id);
	}
	
	public Reimbursement getByEmail(String email) {
		return reimDao.getReimbursementByEmail(email);
	}

	
	public int create(Reimbursement r) {
		return reimDao.createReimbursement(r);
	}

	
	public int update(Reimbursement r) {
		return reimDao.updateReimbursement(r);
	}

	
	public int deleteById(int id) {
		return reimDao.deleteReimbursementById(id);
	}
}
