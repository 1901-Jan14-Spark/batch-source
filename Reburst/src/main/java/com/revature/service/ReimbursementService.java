package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class ReimbursementService {

	ReimbursementDao rDao = new ReimbursementDaoImpl();
	
	public List<Reimbursement> getReimbursements() {
		return rDao.getReimbursements();
	}


	public int validation(Reimbursement obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
