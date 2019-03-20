package com.revature.dao.im;

import java.sql.Connection;
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

	@Override
	public List<Reimbursement> getReimbursements() {
List<Reimbursement> reimbursements = new ArrayList<>();
		
		String sql = "SELECT * FROM EXPENSE";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while (rs.next()) {
				Reimbursement r = new Reimbursement(); 
				
				int reimbursementId = rs.getInt("EXP_ID");
				r.setId(reimbursementId);

				String email = rs.getString("EMAIL");
				r.setEmail(email);
				
				int price = rs.getInt("PRICE");
				r.setPrice(price);
				
				
				String status = rs.getString("STATUS");
				r.setStatus(status);
				
				String resolvedby = rs.getString("RESOLVEDBY");
				r.setResolvedby(resolvedby);
				
				reimbursements.add(r);
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
		Reimbursement r = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int expId = rs.getInt("EXP_ID");
				String name = rs.getString("EMAIL");
				int price = rs.getInt("PRICE");
				String status = rs.getString("STATUS");
				String resolvedby = rs.getString("RESOLVEDBY");
				r = new Reimbursement(expId, name, price, status, resolvedby);
			}
			
		} catch (SQLException x) {
			x.printStackTrace();
		}
		
		return r;
	}

	@Override
	public int createReimbursement(Reimbursement r) {
		int expCreated = 0;
		String sql = "INSERT INTO EXPENSE (EMAIL, PRICE, STATUS, RESOLVEDBY) VALUES (?,?,?,?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, r.getEmail());
			ps.setInt(2, r.getPrice());
			ps.setString(3, r.getStatus());
			ps.setString(4, r.getResolvedby());
			expCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expCreated;
	}

	@Override
	public int updateReimbursement(Reimbursement r) {
		int expUpdated = 0;
		String sql = "UPDATE EXPENSE "
				+ "SET STATUS = ?, "
				+ "RESOLVEDBY = ? "
				+ "WHERE EXP_ID = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, r.getStatus());
			ps.setString(2, r.getResolvedby());
			ps.setInt(3, r.getId());
			expUpdated = ps.executeUpdate();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return expUpdated;
	}

	@Override
	public int deleteReimbursementById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reimbursement getReimbursementByEmail(String email) {
		String sql = "SELECT * FROM EXPENSE WHERE EMAIL = ?";
		Reimbursement r = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int expId = rs.getInt("EXP_ID");
				String name = rs.getString("EMAIL");
				int price = rs.getInt("PRICE");
				String status = rs.getString("STATUS");
				String resolvedby = rs.getString("RESOVLEDBY");
				r = new Reimbursement(expId, name, price, status, resolvedby);
			}
			
		} catch (SQLException x) {
			x.printStackTrace();
		}
		
		return r;
	}
	

}
