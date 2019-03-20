package com.revature.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.company.Reimbursement;
import com.revature.dao.ReimbursementDao;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getRefunds() {
		List<Reimbursement> refunds = new ArrayList<>();
		
		String sql = "SELECT * FROM RBREQUEST";
		
		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while (rs.next()) {
				int refundId = rs.getInt("RB_ID");
				int empId = rs.getInt("EMP_ID");
				double amount = rs.getDouble("RB_AMOUNT");
				String status = rs.getString("STATUS");
				Timestamp reqDate = rs.getTimestamp("SUB_DATE");
				Timestamp approvalDate = rs.getTimestamp("APP_DATE");
				boolean approved;
				if(status.equalsIgnoreCase("approved")) {
					approved = true;
				} else {
					approved = false;
				}
				refunds.add(new Reimbursement(refundId, empId, amount, approved, reqDate, approvalDate));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return refunds;
	}
	
	@Override
	public List<Reimbursement> getAllRefundsForEmployee(int id) {
List<Reimbursement> refunds = new ArrayList<>();
		
		String sql = "SELECT * FROM RBREQUEST WHERE EMP_ID = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int refundId = rs.getInt("RB_ID");
					int empId = rs.getInt("EMP_ID");
					double amount = rs.getDouble("RB_AMOUNT");
					String status = rs.getString("STATUS");
					Timestamp reqDate = rs.getTimestamp("SUB_DATE");
					Timestamp approvalDate = rs.getTimestamp("APP_DATE");
					boolean approved;
					if(status.equalsIgnoreCase("approved")) {
						approved = true;
					} else {
						approved = false;
					}
					refunds.add(new Reimbursement(refundId, empId, amount, approved, reqDate, approvalDate));		
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return refunds;
	}

	@Override
	public Reimbursement getRefundById(int id) {
		String sql = "SELECT * FROM RBREQUEST WHERE RB_ID = ?";
		Reimbursement rb = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int refundId = rs.getInt("RB_ID");
					int empId = rs.getInt("EMP_ID");
					double amount = rs.getDouble("RB_AMOUNT");
					String status = rs.getString("STATUS");
					Timestamp reqDate = rs.getTimestamp("SUB_DATE");
					Timestamp approvalDate = rs.getTimestamp("APP_DATE");
					boolean approved;
					if(status.equalsIgnoreCase("approved")) {
						approved = true;
					} else {
						approved = false;
					}
					rb = new Reimbursement(refundId, empId, amount, approved, reqDate, approvalDate);		
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rb;
	}

	@Override
	public Reimbursement getRefundByEmployeeId(int id) {
		String sql = "SELECT * FROM RBREQUEST WHERE EMP_ID = ?";
		Reimbursement rb = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int refundId = rs.getInt("RB_ID");
					int empId = rs.getInt("EMP_ID");
					double amount = rs.getDouble("RB_AMOUNT");
					String status = rs.getString("STATUS");
					Timestamp reqDate = rs.getTimestamp("SUB_DATE");
					Timestamp approvalDate = rs.getTimestamp("APP_DATE");
					boolean approved;
					if(status.equalsIgnoreCase("approved")) {
						approved = true;
					} else {
						approved = false;
					}
					rb = new Reimbursement(refundId, empId, amount, approved, reqDate, approvalDate);		
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rb;
	}

	@Override
	public int addNewReimbursement(Reimbursement rb) {
		int requestCreated = 0;
		String sql = "INSERT INTO RBREQUEST ("
				+ "RB_ID, "
				+ "EMP_ID, "
				+ "RB_AMOUNT, "
				+ "STATUS, "
				+ "SUB_DATE, "
				+ "APP_DATE) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, rb.getReimbursementId());
			ps.setInt(2, rb.getReimbursementId());
			ps.setDouble(3, rb.getAmount());
			ps.setBoolean(4, rb.isApproved());
			ps.setTimestamp(5, rb.getRequestDate());
			ps.setTimestamp(6, rb.getApprovalDate());
			requestCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return requestCreated;
	}

	@Override
	public int updateReimbursementStatus(Reimbursement rb) {
		int requestUpdated = 0;
		String sql = "UPDATE RBREQUEST "
				+ "SET "
				+ "EMP_ID = ?, RB_AMOUNT = ?, STATUS = ?, SUB_DATE = ?, APP_DATE = ? "
				+ "WHERE RB_ID = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, rb.getReimbursementId());
			ps.setDouble(2, rb.getAmount());
			ps.setBoolean(3, rb.isApproved());
			ps.setTimestamp(4, rb.getRequestDate());
			ps.setTimestamp(5, rb.getApprovalDate());
			ps.setInt(6, rb.getReimbursementId());
			requestUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return requestUpdated;
	}

	@Override
	public int approveReimbursement(Reimbursement rb) {
		int requestApproved = 0;
		String sql = "UPDATE RBREQUEST "
				+ "SET "
				+ "STATUS = ? "
				+ "WHERE RB_ID = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, "Approved");
			ps.setInt(2, rb.getReimbursementId());
			requestApproved = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return requestApproved;
	}

	@Override
	public int denyReimbursement(Reimbursement rb) {
		int requestDenied = 0;
		String sql = "UPDATE RBREQUEST "
				+ "SET "
				+ "STATUS = ? "
				+ "WHERE RB_ID = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, "Approved");
			ps.setInt(2, rb.getReimbursementId());
			requestDenied = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return requestDenied;
	}
}
