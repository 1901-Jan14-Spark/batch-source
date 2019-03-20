package com.revature.service;

import java.util.List;

import com.revature.dao.im.ReimbursementDaoImpl;
import com.revature.model.Reimbursement;

public class ReimbursementService implements  CrudService<Reimbursement> {
	ReimbursementDaoImpl rd =  new ReimbursementDaoImpl();
	   
	
	@Override
	public List<Reimbursement> getAll() {
		// TODO Auto-generated method stub
		return rd.getReimbursement();
		
	}
	public List<Reimbursement> getReimbursementStatus(int statuscode) {
		// TODO Auto-generated method stub
		return rd.getReimbursementbyStatus(statuscode);
		
	}
	public List<Reimbursement> getReimbursementStatus() {
		// TODO Auto-generated method stub
		return rd.getReimbursement();
		
	}
	
	
	

	public  List<Reimbursement>  getByEId(int id) {
		return rd.getReimbursementbyEID(id);
		
	}

	@Override
	public int create(Reimbursement obj) {
		rd.createReimbursement(obj);
		return 0;
	}

	@Override
	public int update(Reimbursement obj) {
		rd.updateReimbursement(obj);
		
		return 0;
	}
	public int insert(Reimbursement obj) {
		
		//rd.updateReimbursementById();
		return 0;
	}
	
	
	
	
	
	

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
