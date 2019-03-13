package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class ReimbursementService implements CrudService<Reimbursement> {

	ReimbursementDao rebursDao = new ReimbursementDaoImpl();
	
	@Override
	public List<Reimbursement> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Reimbursement obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Reimbursement obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int validation(Reimbursement obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
