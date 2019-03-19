package com.revature.DAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.util.Connections;

public class RequestDAO_Impl implements RequestDAO{

	@Override
	public int createRequest(Request r) {
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIM_ID=(SELECT MAX(REIM_ID) FROM REIMBURSEMENTS)";
		
		int id=0;
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			id = rs.getInt("REIM_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			id=0;
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		id++;
		
		
		int departmentsCreated = 0;
		 sql = "INSERT INTO REIMBURSEMENTS (REIM_ID, EMP_NAME, CATEGORY, COST, MERCHANT, PURCHASE_DATE, APP_BY, DEN_BY) VALUES (?,?,?,?,?,?,?,?)";
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ps.setString(2, r.getEmpName());
			ps.setString(3, r.getCategory());
			ps.setInt(4, r.getCost());
			ps.setString(5, r.getMerchant());
			ps.setString(6, r.getPurchaseDate());
			ps.setInt(7, r.getApprovedBy());
			ps.setInt(8, r.getDeniedBy());
			
			departmentsCreated = ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return departmentsCreated;
	}

	@Override
	public List<Request> getActiveRequests() {
		List<Request> requests = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE APP_BY=0 AND DEN_BY=0";
		Request req = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("REIM_ID");
				System.out.println(Id);
				String empName= rs.getString("EMP_NAME");
				String category=rs.getString("CATEGORY");
				int cost = rs.getInt("COST");
				String merchant = rs.getString("MERCHANT");
				String purchaseDate = rs.getString("PURCHASE_DATE");

				int approvedBy = rs.getInt("APP_BY");
				int deniedBy = rs.getInt("DEN_BY");
				
				
				
				req = new Request(Id, empName, category, cost, merchant, purchaseDate, approvedBy, deniedBy);
				requests.add(req);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("threw exception");
		}catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IO exception");
		}
		
		return requests;

		
	}

	

	@Override
	public void approveRequest(int ReimId, int EmpId) {
		List<Request> requests = new ArrayList<>();
		String sql = "UPDATE REIMBURSEMENTS SET APP_BY= ? WHERE REIM_ID = ?";
		Request req = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, EmpId);
			ps.setInt(2, ReimId);
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("threw exception");
		}catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IO exception");
		}
		
		
	}

	@Override
	public void denyRequest(int ReimId, int EmpId) {
		List<Request> requests = new ArrayList<>();
		String sql = "UPDATE REIMBURSEMENTS SET DEN_BY= ? WHERE REIM_ID = ?";
		Request req = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, EmpId);
			ps.setInt(2, ReimId);
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("threw exception");
		}catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IO exception");
		}
		
	}

	@Override
	public List<Request> getActiveRequest(String name) {
		List<Request> requests = new ArrayList<>();
		
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMP_NAME=? AND APP_BY=0 AND DEN_BY=0";
		Request req = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, name);
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("REIM_ID");
				System.out.println(Id);
				String empName= rs.getString("EMP_NAME");
				String category=rs.getString("CATEGORY");
				int cost = rs.getInt("COST");
				String merchant = rs.getString("MERCHANT");
				String purchaseDate = rs.getString("PURCHASE_DATE");

				int approvedBy = rs.getInt("APP_BY");
				int deniedBy = rs.getInt("DEN_BY");
				System.out.println("Request" + category);
				
				
				req = new Request(Id, empName, category, cost, merchant, purchaseDate, approvedBy, deniedBy);
				requests.add(req);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("threw exception");
		}catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IO exception");
		}
		
		return requests;

	}

	@Override
	public List<Request> getResolvedRequest(String name) {
List<Request> requests = new ArrayList<>();
		
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMP_NAME=? AND (APP_BY!=0 OR DEN_BY!=0)";
		Request req = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, name);
			
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("REIM_ID");
				System.out.println(Id);
				String empName= rs.getString("EMP_NAME");
				String category=rs.getString("CATEGORY");
				int cost = rs.getInt("COST");
				String merchant = rs.getString("MERCHANT");
				String purchaseDate = rs.getString("PURCHASE_DATE");

				int approvedBy = rs.getInt("APP_BY");
				int deniedBy = rs.getInt("DEN_BY");
				System.out.println("Request" + category);
				
				
				req = new Request(Id, empName, category, cost, merchant, purchaseDate, approvedBy, deniedBy);
				requests.add(req);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("threw exception");
		}catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IO exception");
		}
		
		return requests;

	}

}
