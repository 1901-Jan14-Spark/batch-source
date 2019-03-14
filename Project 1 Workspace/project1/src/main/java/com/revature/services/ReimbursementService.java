package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

public class ReimbursementService implements CrudService<Reimbursement>{

	ReimbursementDao rd = new ReimbursementDaoImpl();
	
	@Override
	public List<Reimbursement> getAll(HttpServletRequest request) {
		return null;
	}

	@Override
	public Reimbursement getById(int id) {
		return rd.getReimbursementById(id);
		
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
