package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao{

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				int rId = rs.getInt("REQUEST_ID");
				r.setR_id(rId);
				
				int eId = rs.getInt("EMPLOYEE_ID");
				r.setE_id(eId);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String status = rs.getString("STATUS");
				r.setStatus(status);
				
				String rType = rs.getString("RE_TYPE");
				r.setR_Type(rType);
				
				Date dateSubmitted = rs.getDate("DATE_SUBMITTED");
				r.setSubmitted(dateSubmitted);
				
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				r.setResolved(dateResolved);
				
				int mId = rs.getInt("MANAGER_ID");
				r.setM_id(mId);
				
				reimbursements.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		String sql = "SELECT * FROM REIMBURSEMENT WHERE REQUEST_ID = ?";
		Reimbursement r = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rId = rs.getInt("REQUEST_ID");				
				int eId = rs.getInt("EMPLOYEE_ID");				
				double amount = rs.getDouble("AMOUNT");				
				String status = rs.getString("STATUS");				
				String rType = rs.getString("RE_TYPE");				
				Date dateSubmitted = rs.getDate("DATE_SUBMITTED");			
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				int mId = rs.getInt("MANAGER_ID");
				
				r = new Reimbursement(rId, eId, amount, status, rType, dateSubmitted, dateResolved, mId);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public int createReimbursement(Reimbursement r) {
		int reimbursementsCreated = 0;
		String sql = "INSERT INTO REIMBURSEMENT (REQUEST_ID, EMPLOYEE_ID, AMOUNT, STATUS, RE_TYPE, DATE_SUBMITTED, DATE_RESOLVED, MANAGER_ID) VALUES (?,?,?,?,?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, r.getR_id());
			ps.setInt(2, r.getE_id());
			ps.setDouble(3, r.getAmount());
			ps.setString(4, r.getStatus());
			ps.setString(5, r.getR_Type());
			ps.setDate(6, r.getSubmitted());
			ps.setDate(7, r.getResolved());
			ps.setInt(8, r.getM_id());
			
			reimbursementsCreated = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursementsCreated;
	}

	@Override
	public int updateReimbursement(Reimbursement r) {
		int reimbursementsUpdated = 0;
		String sql = "UPDATE REIMBURSEMENT "
				+ "SET REQUEST_ID = ?,"
				+ "EMPLOYEE_ID = ?,"
				+ "AMOUNT = ?,"
				+ "STATUS = ?,"
				+ "RE_TYPE = ?,"
				+ "DATE_SUBMITTED = ?"
				+ "DATE_RESOLVED = ?,"
				+ "MANAGER_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, r.getR_id());
			ps.setInt(2, r.getE_id());
			ps.setDouble(3, r.getAmount());
			ps.setString(4, r.getStatus());
			ps.setString(5, r.getR_Type());
			ps.setDate(6, r.getSubmitted());
			ps.setDate(7, r.getResolved());
			ps.setInt(8, r.getM_id());
			
			reimbursementsUpdated = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursementsUpdated;
	}

	@Override
	public int deleteReimbursement(int id) {
		int rowsDeleted = 0;
		
		String sql = "DELETE FROM REIMBURSEMENTS WHERE REQUEST_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	@Override
	public List<Reimbursement> getPendingReimbursementsByEmpId(int id) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS = 'PENDING' AND EMPLOYEE_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				int rId = rs.getInt("REQUEST_ID");
				r.setR_id(rId);
				
				int eId = rs.getInt("EMPLOYEE_ID");
				r.setE_id(eId);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String status = rs.getString("STATUS");
				r.setStatus(status);
				
				String rType = rs.getString("RE_TYPE");
				r.setR_Type(rType);
				
				Date dateSubmitted = rs.getDate("DATE_SUBMITTED");
				r.setSubmitted(dateSubmitted);
				
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				r.setResolved(dateResolved);
				
				int mId = rs.getInt("MANAGER_ID");
				r.setM_id(mId);
				
				reimbursements.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getResolvedReimbursementsByEmpId(int id) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS NOT STATUS = 'PENDING' AND EMPLOYEE_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				int rId = rs.getInt("REQUEST_ID");
				r.setR_id(rId);
				
				int eId = rs.getInt("EMPLOYEE_ID");
				r.setE_id(eId);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String status = rs.getString("STATUS");
				r.setStatus(status);
				
				String rType = rs.getString("RE_TYPE");
				r.setR_Type(rType);
				
				Date dateSubmitted = rs.getDate("DATE_SUBMITTED");
				r.setSubmitted(dateSubmitted);
				
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				r.setResolved(dateResolved);
				
				int mId = rs.getInt("MANAGER_ID");
				r.setM_id(mId);
				
				reimbursements.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getPendingReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS = 'PENDING'";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				int rId = rs.getInt("REQUEST_ID");
				r.setR_id(rId);
				
				int eId = rs.getInt("EMPLOYEE_ID");
				r.setE_id(eId);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String status = rs.getString("STATUS");
				r.setStatus(status);
				
				String rType = rs.getString("RE_TYPE");
				r.setR_Type(rType);
				
				Date dateSubmitted = rs.getDate("DATE_SUBMITTED");
				r.setSubmitted(dateSubmitted);
				
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				r.setResolved(dateResolved);
				
				int mId = rs.getInt("MANAGER_ID");
				r.setM_id(mId);
				
				reimbursements.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getResolvedReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE STATUS NOT STATUS = 'PENDING'";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				int rId = rs.getInt("REQUEST_ID");
				r.setR_id(rId);
				
				int eId = rs.getInt("EMPLOYEE_ID");
				r.setE_id(eId);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String status = rs.getString("STATUS");
				r.setStatus(status);
				
				String rType = rs.getString("RE_TYPE");
				r.setR_Type(rType);
				
				Date dateSubmitted = rs.getDate("DATE_SUBMITTED");
				r.setSubmitted(dateSubmitted);
				
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				r.setResolved(dateResolved);
				
				int mId = rs.getInt("MANAGER_ID");
				r.setM_id(mId);
				
				reimbursements.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementsByEmpId(int id) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				int rId = rs.getInt("REQUEST_ID");
				r.setR_id(rId);
				
				int eId = rs.getInt("EMPLOYEE_ID");
				r.setE_id(eId);
				
				double amount = rs.getDouble("AMOUNT");
				r.setAmount(amount);
				
				String status = rs.getString("STATUS");
				r.setStatus(status);
				
				String rType = rs.getString("RE_TYPE");
				r.setR_Type(rType);
				
				Date dateSubmitted = rs.getDate("DATE_SUBMITTED");
				r.setSubmitted(dateSubmitted);
				
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				r.setResolved(dateResolved);
				
				int mId = rs.getInt("MANAGER_ID");
				r.setM_id(mId);
				
				reimbursements.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	
}
