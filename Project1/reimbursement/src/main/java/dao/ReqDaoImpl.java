package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.EmpObj;
import model.ReqObj;
import util.ConnectionUtil;

public class ReqDaoImpl implements ReqDao{

	EmpDao ed = new EmpDaoImpl();
	
	@Override
	public List<ReqObj> getAllReq() {
		List<ReqObj> requests = new ArrayList<>();
		String sql = "SELECT R.R_ID, E.E_NAME, E.EMAIL, R.R_DES, R.AMOUNT, R.STATUS, R.RESOLVED_BY\r\n" + 
				"FROM EMPLOYEES E\r\n" + 
				"FULL JOIN REQUESTS R\r\n" + 
				"ON E.E_ID = R.E_ID\r\n" + 
				"WHERE E.E_ID < 20000";
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				ReqObj ro = new ReqObj();
				
				//store employee object by id to find full employee info later
				ro.setrId(rs.getInt("R_ID"));
				ro.seteName(rs.getString("E_NAME"));
				ro.setEmail(rs.getString("EMAIL"));
				ro.setDesc(rs.getString("R_DES"));
				ro.setAmount(rs.getDouble("AMOUNT"));
				//convert status number to human readable status 
				int statusNum = rs.getInt("STATUS");
				String status = convStat(statusNum);
				ro.setStatus(status);
				//store employee object by id to find full manager info later
				ro.setResolvedBy(new EmpObj(rs.getInt("RESOLVED_BY")));
				
				requests.add(ro);
			}
			
			//call database to get info on all managers
			List<EmpObj> managers = ed.getOnlyMan();
			for(ReqObj r : requests) {
				int resolvedBy = r.getResolvedBy().geteId();
				if(resolvedBy != 0) {
					for(EmpObj m : managers) {
						if(resolvedBy == m.geteId()) {
							r.setResolvedBy(m);
						}
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requests;
	}
	
	@Override
	public List<ReqObj> getReqById(int id) {
		List<ReqObj> requests = new ArrayList<>();
		String sql = "SELECT R.R_ID, E.E_NAME, E.EMAIL, R.R_DES, R.AMOUNT, R.STATUS, R.RESOLVED_BY\r\n" + 
				"FROM EMPLOYEES E\r\n" + 
				"FULL JOIN REQUESTS R\r\n" + 
				"ON E.E_ID = R.E_ID\r\n" + 
				"WHERE E.E_ID = ?";
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ReqObj ro = new ReqObj();
				
				//store employee object by id to find full employee info later
				ro.setrId(rs.getInt("R_ID"));
				ro.seteName(rs.getString("E_NAME"));
				ro.setEmail(rs.getString("EMAIL"));
				ro.setDesc(rs.getString("R_DES"));
				ro.setAmount(rs.getDouble("AMOUNT"));
				//convert status number to human readable status 
				int statusNum = rs.getInt("STATUS");
				String status = convStat(statusNum);
				ro.setStatus(status);
				//store employee object by id to find full manager info later
				ro.setResolvedBy(new EmpObj(rs.getInt("RESOLVED_BY")));
				
				requests.add(ro);
			}
			
			//call database to get info on all managers
			List<EmpObj> managers = ed.getOnlyMan();
			for(ReqObj r : requests) {
				int resolvedBy = r.getResolvedBy().geteId();
				if(resolvedBy != 0) {
					for(EmpObj m : managers) {
						if(resolvedBy == m.geteId()) {
							r.setResolvedBy(m);
						}
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requests;
	}
	
	@Override
	public boolean addReq(int empId, ReqObj request) {
		int reqAdded = 0;
		String sql = "INSERT INTO REQUESTS (E_ID, AMOUNT, R_DES, STATUS) VALUES (?, ?, ?, 1)";
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, empId);
			ps.setDouble(2, request.getAmount());
			ps.setString(3, request.getDesc());
			reqAdded = ps.executeUpdate();
			
			if(reqAdded > 0)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateReq(int mId, ReqObj reqAns) {
		int reqUpdated = 0;
		String sql = "UPDATE REQUESTS SET STATUS = ?, RESOLVED_BY = ? WHERE R_ID = ?";
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			int status = encodeStat(reqAns.getStatus());
			ps.setInt(1, status);
			ps.setInt(2, mId);
			ps.setInt(3, reqAns.getrId());
			reqUpdated = ps.executeUpdate();
			
			if(reqUpdated > 0)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//method returns human readable status based on status number
	public static String convStat(int statusNum) {
		String outputStat = "";
		switch(statusNum) {
		case 1:
			outputStat = "Pending";
			break;
		case 2:
			outputStat = "Approved";
			break;
		case 3:
			outputStat = "Rejected";
			break;
		default:
			outputStat = "";
		}
		return outputStat;
	}

	//encodes status string to its' representational number
	public static int encodeStat(String statStr) {
		int statusNum = 0;
		switch(statStr) {
		case "Approve":
			statusNum = 2;
			break;
		case "Reject":
			statusNum = 3;
			break;
		default:
			statusNum = 0;
		}
		return statusNum;
	}
}
