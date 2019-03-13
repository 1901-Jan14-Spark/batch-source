package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.EmpObj;
import util.ConnectionUtil;

public class EmpDaoImpl implements EmpDao{

	@Override
	public EmpObj getIdAndPass(int userId) {
		String sql = "SELECT E_ID, E_PASS FROM EMPLOYEES WHERE E_ID = ?";
		EmpObj eo = new EmpObj();
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("E_ID");
				eo.seteId(id);
				String pass = rs.getString("E_PASS");
				eo.setePass(pass);
			}
			else {
				eo.seteId(0);
				eo.setePass("");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eo;
	}
	
}
