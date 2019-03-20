package com.revature.dao.im;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	List<Reimbursement> rlist = new  ArrayList<> () ;
	Reimbursement rem ;
	
	

	public List<Reimbursement> getReimbursement() {
		
                
	//	String sql = "select * from employee where firstname = ? ";
		String sql = "select * from REIMBURSEMENT_APPROVER";

		try (Connection con = ConnectionUtil.getConnection(); Statement  s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			
			//ps.setString(1, username);
			//ResultSet rs = ps.executeQuery();
			 rlist.clear();
			while (rs.next()) {
				rem = new Reimbursement();
				int rId = rs.getInt("RID");
				rem.setrID(rId);
				int eid = rs.getInt("EID");
				rem.setEid(eid);
				String description = rs.getString("DESCRIPTION_");
				rem.setDescription(description);
				BigDecimal amount = rs.getBigDecimal("AMOUNT");
				rem.setAmount(amount);
				Date submittedDate =  rs.getDate("SUBMITTED_DATE");
		        rem.setSubmittedDate(submittedDate);
				int approvalStatus = rs.getInt("APPROVAL_STATUS");
				 rem.setApprovalStatus(approvalStatus);
				
				String fname = rs.getString("FIRSTNAME");
				String approver = fname +" " + rs.getString("LASTNAME");
				rem.setApprover(approver);
				Blob receipts = rs.getBlob("RECEIPTS");
				rem.setReceipts(receipts);
				Date lastActivity = rs.getDate("LAST_ACTIVITY");
				rem.setLastActivity(lastActivity);
				 
				  
				  
		       rlist.add(rem);
		    
		      
		     
           
			// AccountDaoImp.setAccountDetailforObject(user, userId);

				//

			}
			//AccountDaoImp.setAccountDetailforObject(user, user.getID());
			
		
			     
		       return rlist;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}


	public void updateReimbursement (Reimbursement obj) {
		
		
		
	
		
String sql = "UPDATE Reimbursement SET RID = ?, EID = ?, DESCRIPTION_ = ?, AMOUNT = ?, SUBMITTED_DATE = ?, APPROVAL_STATUS = ?, APPROVER = ?, RECEIPTS = ?, LAST_ACTIVITY = ? "
		+ "WHERE RID = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, obj.getrID());
			ps.setInt(2, obj.getEid());
			ps.setString(3,obj.getDescription());
			ps.setBigDecimal(4,obj.getAmount());
			ps.setDate(5, obj.getSubmittedDate());
			ps.setInt(6, obj.getApprovalStatus());
			ps.setString(7, obj.getApprover());
			ps.setBlob(8, obj.getReceipts());
			ps.setDate(9, obj.getLastActivity());
			ps.setInt(10, obj.getrID());
			
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	public List<Reimbursement> getReimbursementbyEID (int eid){

		
		List<Reimbursement> pendingRlist = new  ArrayList<> () ;
		
		if( rlist.size() == 0) {
			System.out.println("FROM ReimbursementDaoImpl: Queried Data base");
			getReimbursement();
			
		}
		
		
		for(Reimbursement r: rlist) {
			
		
			if(r.getEid()== eid) {
				pendingRlist.add(r);
			}
			
			
		}
		

	
          return pendingRlist;
	
	}

	
	
	public List<Reimbursement> getReimbursementbyStatus (int statuscode) {
		
		List<Reimbursement> pendingRlist = new  ArrayList<> () ;
		
		if( rlist.size() == 0) {
			System.out.println("FROM ReimbursementDaoImpl: Queried Data base");
			getReimbursement();
			
		}
		
		
		for(Reimbursement r: rlist) {
			
		
			if(r.getApprovalStatus() == statuscode) {
				pendingRlist.add(r);
			}
			
			
		}
		

	
          return pendingRlist;
	}



	public void createReimbursement (Reimbursement obj) {
		int x= 0;
		//refresh cache and count
		getReimbursement();
		for (Reimbursement l : rlist) {
			if (x < l.getrID()) {
				x = l.getrID() ;
				x = x+1;
			}
			
			
		}
		System.out.println("orinting int " + x);


		
String sql = "INSERT INTO REIMBURSEMENT (RID, EID, DESCRIPTION_, AMOUNT, SUBMITTED_DATE, APPROVAL_STATUS, APPROVER, LAST_ACTIVITY) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, x);
			ps.setInt(2, obj.getEid());
			ps.setString(3,obj.getDescription());
			ps.setBigDecimal(4,obj.getAmount());
			ps.setDate(5, obj.getSubmittedDate());
			ps.setInt(6, obj.getApprovalStatus());
			ps.setString(7, obj.getApprover());
			//ps.setBlob(8, obj.getReceipts());
			ps.setDate(8, obj.getLastActivity());
			//ps.setInt(9, obj.getrID());
			
			ps.executeQuery();
			getReimbursement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
