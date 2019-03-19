package com.revature.dao;
import java.util.List;
import com.revature.model.Reimbursement;
public interface ReimbursementDao {
 public List<Reimbursement> getAllReimbursementsByEId(int eId);
 public void updateReimbursement(Reimbursement re);
 public void createReimbursement(Reimbursement re);
 public List<Reimbursement> getAllReimbursements();
 
}
