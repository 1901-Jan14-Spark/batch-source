package dao;

import java.sql.Connection;
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
		String sql = "SELECT E_ID, AMOUNT, R_DES, STATUS, RESOLVED_BY FROM REQUESTS";
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				ReqObj ro = new ReqObj();
				
				//TODO finish request dao, eId and resolvedBy are employee objects to store employee and manager
				//store employee object by id to find full info later
				ro.seteId(new EmpObj(rs.getInt("E_ID")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
