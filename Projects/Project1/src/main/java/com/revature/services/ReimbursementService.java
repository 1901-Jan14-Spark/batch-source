package com.revature.services;

import java.util.List;

import com.revature.company.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.imp.ReimbursementDaoImpl;

public class ReimbursementService {
	
	ReimbursementDao rbDao = new ReimbursementDaoImpl();
	
	public List<Reimbursement> getAll(){
		return rbDao.getRefunds();
	}
	
	public List<Reimbursement> getEmployeesReimbursements(int id){
		return rbDao.getAllRefundsForEmployee(id);
	}
	
	public Reimbursement getById(int id) {
		return rbDao.getRefundById(id);
	}

	public Reimbursement getEmpReimbursement(int id) {
		return rbDao.getRefundByEmployeeId(id);
	}	
	
	public int newRequest(Reimbursement rb) {
		return rbDao.addNewReimbursement(rb);
	}
	
	public int updateRequest(Reimbursement rb) {
		return rbDao.updateReimbursementStatus(rb);
	}
	
	public int approveRequest(Reimbursement rb) {
		return rbDao.approveReimbursement(rb);
	}
	
	public int denyRequest(Reimbursement rb) {
		return rbDao.denyReimbursement(rb);
	}
	
	
}
