package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getReimbursements() {
		
		
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try {
			Connection conn = ConnectionUtil.getConnectionFromFile(); 
			String sql = "SELECT * FROM REIMBURSEMENTS";
			PreparedStatement ps = conn.prepareStatement(sql);
		

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int rId = rs.getInt("REIMBURSEMENT_ID");	
				int rAmount = rs.getInt("REIMBURSEMENT_AMOUNT");
				int  rStatus = rs.getInt("REIMBURSEMENT_STATUS");
				String rDesc = rs.getString("REIMBURSEMENT_DESC");
				int rSC = rs.getInt("STATUS_CHANGER");
				int eId = rs.getInt("EMPLOYEE_ID");
				reimbursements.add(new Reimbursement(rId, rAmount, rStatus, rDesc, rSC, eId));
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbursements;
	}

	

	@Override
	public Reimbursement getRById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getRFromEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getRWaiting() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getRApproved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createR(double rAmount, String rDesc, int eId) {
		
		String sql = "INSERT INTO REIMBURSEMENTS (REIMBURSEMENT_AMOUNT, REIMBURSEMENT_DESC EMPLOYEE_ID) VALUES(?, ?, ?)";

		int rBoolean = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setDouble(1, rAmount);
			ps.setString(2, rDesc);
			ps.setInt(3, eId);
			rBoolean = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return rBoolean;
	}

	public int deleteR(Reimbursement r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateR(Reimbursement r) {
		// TODO Auto-generated method stub
		return false;
	}

}
