package dao;

import java.sql.Connection;
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
				int mngResolved = rs.getInt("MngResolved");
				reimbursements.add(new Reimbursements(reimbId, empId, content, reimbursementAmount, isResolved, resolvedMess, mngResolved));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbursements;
	}

}
