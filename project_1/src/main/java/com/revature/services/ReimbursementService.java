package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.daos.implementations.ReimbursementDaoImplementation;
import com.revature.services.daos.interfaces.ReimbursementDao;

public class ReimbursementService {

	private ReimbursementDao rd = new ReimbursementDaoImplementation();
	static Logger log = Logger.getRootLogger();

	public boolean createReimbursement(Employee e, Reimbursement r) throws SQLException, IOException {
		r.setEmployee_id(e.getId());
		int query = rd.createReimbursement(r);
		return query > 0 ? true : false;
	}

	public boolean updateReimbursement(Reimbursement r) {
		Reimbursement temp = this.getReimbursementById(r.getId());
		if(null == temp) {
			return false;
		}
		if( temp.getState() > 0){
			log.error("Reimbursement already solved - unable to updateReimbursement().");
			return false;
		}
		if(r.getAmount() == 0) {
			r.setAmount(temp.getAmount());
		}
		if(r.getTitle() == null){
			r.setTitle(temp.getTitle());
		}
		if(r.getDescription() == null) {
			r.setDescription(temp.getDescription());
		}
		if(r.getImage() == null) {
			r.setImage(temp.getImage());
		}
		
		int query = rd.updateReimbursement(r);
		return query > 0 ? true : false;
	}
	
	public List<Reimbursement> getAssociatedReimbursements(int id) {
		return rd.getReimbursementsFromEmployeeId(id);
	}

	public List<Reimbursement> getReimbursements() {
		return rd.getReimbursements();
	}

	public List<Reimbursement> getSolvedReimbursements() {
		List<Reimbursement> reimbursements = rd.getReimbursements();
		List<Reimbursement> solvedReimbursements = new ArrayList<>();
		for (Reimbursement r : reimbursements) {
			if (r.getState() > 0) {
				solvedReimbursements.add(r);
			}
		}
		return solvedReimbursements;
	}

	public List<Reimbursement> getUnresolvedReimbursements() {
		List<Reimbursement> reimbursements = rd.getReimbursements();
		List<Reimbursement> unresolvedReimbursements = new ArrayList<>();
		for (Reimbursement r : reimbursements) {
			if (r.getState() == 0) {
				unresolvedReimbursements.add(r);
			}
		}
		return unresolvedReimbursements;
	}

	public Reimbursement getAssociatedReimbursementById(Employee e, int r_id) {
		Reimbursement temp = rd.getReimbursementById(r_id);
		if (e.getId() == temp.getEmployee_id()) {
			return temp;
		} else {
			log.error("ReimbursementService - UnassociatedEmployee " + e.getId() + "attempted to access reimbursement id= "
					+ r_id);
			return null;
		}
	}

	public Reimbursement getReimbursementById(int r_id) {
		Reimbursement temp = rd.getReimbursementById(r_id);
		return temp;
	}
	
	public boolean authorizeReimbursementById(int man_id, int r_id) {
		Reimbursement r = this.getReimbursementById(r_id);
		if(r.getState() > 0) {
			log.error("ReimbursementService - reimbursement was already resolved.");
			return false;
		}else if(man_id == r.getEmployee_id()){
			log.error("ReimbursementService - Cannot resolve personal requests.");
			return false;
		}
		r.setState(2);
		r.setManager_id(man_id);
		int query = rd.updateReimbursement(r);
		return query > 0 ? true : false;
	}
	
	public boolean rejectReimbursementById(int man_id, int r_id) {
		Reimbursement r = this.getReimbursementById(r_id);
		if(r.getState() > 0) {
			log.error("ReimbursementService - reimbursement was already resolved.");
			return false;
		}else if(man_id == r.getEmployee_id()){
			log.error("ReimbursementService - Cannot resolve personal requests.");
			return false;
		}
		r.setState(3);
		r.setManager_id(man_id);
		int query = rd.updateReimbursement(r);
		return query > 0 ? true : false;
	}
	
	public boolean cancelReimbursementById(int r_id) {
		Reimbursement r = this.getReimbursementById(r_id);
		if(r.getState() > 0) {
			log.error("ReimbursementService - reimbursement was already resolved.");
			return false;
		}
		r.setState(1);
		int query = rd.updateReimbursement(r);
		return query > 0 ? true : false;
	}
}
