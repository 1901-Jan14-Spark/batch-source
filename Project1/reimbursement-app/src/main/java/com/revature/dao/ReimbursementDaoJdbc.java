package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoJdbc implements ReimbursementDao {

	@Override
	public List<Reimbursement> getAllReimbursementsByEId(int eId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReimbursement(Reimbursement re) {
		// TODO Auto-generated method stub
		String sql = "UPDATE REIMBURSEMENT SET RESCOM = NVL(?,RESCOM) , S_STATUS = NVL(?,S_STATUS), DEC_DATE = NVL(?,DEC_DATE), M_ID = NVL(?,M_ID), WHERE T_ID=?";
	
		
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, re.getResCom());
			ps.setString(2, re.getStatus());
			ps.setDate(3, (java.sql.Date) re.getDecDate());
			ps.setInt(4, re.getManager().geteID());
			ps.setInt(5, re.gettId());
			ps.executeQuery();
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void createReimbursement(Reimbursement re) {
		String sql = "INSERT INTO REIMBURSEMENT VALUES (TRANS_ID_SEQ.NEXTVAL,?,?, ?, NULL, ?,'PENDING', ?, NULL,NULL)";
		
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, re.getEmployee().geteID());
			ps.setString(2, re.gettOption());
			ps.setString(3, re.getReqCom());
			ps.setDouble(4, re.getAmount());
			ps.setDate(5, (java.sql.Date) re.getSubDate());
			
			ps.executeQuery();
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}


	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM REIMBURSEMENT";
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
						ResultSet rs = s.executeQuery(sql);){
			
			while (rs.next()) {
				int tId = rs.getInt("E_ID");
				int eID = rs.getInt("T_ID");
				String tOption = rs.getString("T_OPTION");
				String reqCom = rs.getString("REQCOM");
				String resCom = rs.getString("RESCOM");
				double rAmount = rs.getDouble("R_AMOUNT");
				String sStatus = rs.getString("S_STATUS");
				Date subDate = rs.getDate("SUB_DATE");
				Date decDate = rs.getDate("DEC_DATE");
				Integer mId = rs.getInt("M_ID");
				Employee employee = new Employee();
				employee.seteID(eID);
				Employee manager = new Employee();
				if(mId != null ) {
					manager.seteID(mId);
				}
				rList.add( new Reimbursement(tId,employee,tOption,reqCom,resCom,rAmount,sStatus, subDate,decDate, manager));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
	}
}
