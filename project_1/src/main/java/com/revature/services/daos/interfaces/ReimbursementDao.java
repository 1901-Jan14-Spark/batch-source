package com.revature.services.daos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {

	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getReimbursementsFromEmployeeId(int id);
	public Reimbursement getReimbursementById(int id);
	public int createReimbursement(Reimbursement r) throws SQLException, IOException;
	public int updateReimbursement(Reimbursement r);

}
