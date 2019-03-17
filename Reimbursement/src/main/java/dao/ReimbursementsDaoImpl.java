package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Reimbursements;
import util.ConnectionUtil;

public class ReimbursementsDaoImpl implements ReimbursementsDao{

	@Override
	public List<Reimbursements> getReims() {
		List<Reimbursements> reims = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENTS";
		try(Connection con = ConnectionUtil.systemVar();
		Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int id = rs.getInt("REIM_ID");
				String name = rs.getString("REIM_NAME");
				int requester = rs.getInt("REQUESTER");
				double amount = rs.getDouble("AMOUNT");
				String status = rs.getString("STATUS");
				int resolvedBy = rs.getInt("RESOLVED_BY");
				reims.add(new Reimbursements(id,name,requester,amount,status,resolvedBy));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reims;
	}

	@Override
	public int createReims(Reimbursements reim) {
		String sql = "INSERT INTO REIMBURSEMENTS VALUES(null,?,?,?,Default,Default)";
		int reimsMade = 0;
		try(Connection con = ConnectionUtil.systemVar();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, reim.getReim_name());
			ps.setInt(2, reim.getRequester_Id());
			ps.setDouble(3, reim.getAmount());
			reimsMade = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimsMade;
	}

	@Override
	public int updateReims(Reimbursements reim) {
		String sql = "UPDATE REIMBURSEMENTS SET STATUS = ?, RESOLVED_BY =? WHERE REIM_ID = ?";
		int reimsUpdated = 0;
		try(Connection con = ConnectionUtil.systemVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, reim.getReimStatus());
			ps.setInt(2, reim.getResolvedId());
			ps.setInt(3, reim.getReim_id());
			reimsUpdated = ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return reimsUpdated;
	}

	@Override
	public int deleteReims(int id) {
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIM_ID = ?";
		int reimsDeleted = 0;
		try(Connection con = ConnectionUtil.systemVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			reimsDeleted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimsDeleted;
	}

	@Override
	public Reimbursements getReimById(int id) {
		Reimbursements reims = null;
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIM_ID = ?";
		try(Connection con = ConnectionUtil.systemVar(); 
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int reimId = rs.getInt("REIM_ID");
				String reimName = rs.getString("REIM_NAME");
				int requester = rs.getInt("REQUESTER");
				double amount = rs.getDouble("AMOUNT");
				String status = rs.getString("STATUS");
				String resolvedBy = rs.getString("RESOLVED_BY");

				reims = new Reimbursements(reimId, reimName, requester, amount,status,resolvedBy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reims;
		
	}

	@Override
	public Reimbursements getReimByRequester(int requestee) {
	Reimbursements reims = null;
	String sql = "SELECT * FROM REIMBURSEMENTS WHERE REQUESTER = ?";
	try(Connection con = ConnectionUtil.systemVar(); 
			PreparedStatement ps = con.prepareStatement(sql);){
		ps.setInt(1, requestee);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int reimId = rs.getInt("REIM_ID");
			String reimName = rs.getString("REIM_NAME");
			int requester = rs.getInt("REQUESTER");
			double amount = rs.getDouble("AMOUNT");
			String status = rs.getString("STATUS");
			String resolvedBy = rs.getString("RESOLVED_BY");

			reims = new Reimbursements(reimId, reimName, requester, amount,status,resolvedBy);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return reims;
	
}

	
}
