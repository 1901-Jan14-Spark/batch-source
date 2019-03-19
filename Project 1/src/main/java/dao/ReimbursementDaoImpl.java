package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Reimbursements;
import util.DBConnection;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursements> getReimbursements() {
		List<Reimbursements> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENTS";
		
		try (Connection con = DBConnection.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while (rs.next()) {
				int reimbId = rs.getInt("R_ID");
				int empId = rs.getInt("EMP_ID");
				String content = rs.getString("CONTENT");
				int reimbursementAmount = rs.getInt("AmountRequested");
				int isResolved = rs.getInt("Resolved");
				String resolvedMess = rs.getString("ResolvedMessage");
				String mngResolved = rs.getString("MngResolved");
				reimbursements.add(new Reimbursements(reimbId, empId, content, reimbursementAmount, isResolved, resolvedMess, mngResolved));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbursements;
	}

	@Override
	public int resolveReimbursementsById(Reimbursements reim) {
		int yay = 0;
		if (reim.getIsResolved() == 1) {
			String sql = "UPDATE REIMBURSEMENTS SET RESOLVED = 1, RESOLVEDMESSAGE = 'Approved', MNGRESOLVED = ? WHERE REIMBURSEMENTS.R_ID = ?";
			try (Connection con = DBConnection.getConnection();
					PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setString(1, reim.getMngResolved());
				ps.setInt(2, reim.getReimbursementId());
				yay = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return yay;	
		} else {
			String sql = "UPDATE REIMBURSEMENTS SET RESOLVED = 2, RESOLVEDMESSAGE = 'Rejected', MNGRESOLVED = ? WHERE REIMBURSEMENTS.R_ID = ?";
			try (Connection con = DBConnection.getConnection();
					PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setString(1, reim.getMngResolved());
				ps.setInt(2, reim.getReimbursementId());
				yay = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return yay;	
		}	

	}

	@Override
	public List<Reimbursements> getReimbByEmpId(int id) {
		List<Reimbursements> reimbById = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMP_ID = ?";
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			ps.setInt(1, id);

			while (rs.next()) {
				int reimbId = rs.getInt("R_ID");
				int empId = rs.getInt("EMP_ID");
				String content = rs.getString("CONTENT");
				int reimbursementAmount = rs.getInt("AmountRequested");
				int isResolved = rs.getInt("Resolved");
				String resolvedMess = rs.getString("ResolvedMessage");
				String mngResolved = rs.getString("MngResolved");
				reimbById.add(new Reimbursements(reimbId, empId, content, reimbursementAmount, isResolved, resolvedMess, mngResolved));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createReimbursement(Reimbursements reimb) {
		String sql = "INSERT INTO REIMBURSEMENTS (emp_id, content, AmountRequested) VALUES (?, ?, ?)";
		int numbCreated = 0;
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, reimb.getEmp_id());
			ps.setString(2, reimb.getContent());
			ps.setInt(3, reimb.getReimbursementAmount());
			numbCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numbCreated;
	}
	
	

}
