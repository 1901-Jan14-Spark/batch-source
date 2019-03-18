package com.revature.services.daos.implementations;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.services.daos.interfaces.ReimbursementDao;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDaoImplementation implements ReimbursementDao {

	static Logger log = Logger.getRootLogger();

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENTS";

		try (Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {

			while (rs.next()) {

				int r_id = rs.getInt("R_ID");
				int e_id = rs.getInt("E_ID");
				double r_amount = rs.getDouble("R_AMOUNT");
				int r_state = rs.getInt("R_STATE");
				Timestamp r_date = rs.getTimestamp("r_date");
				String title = rs.getString("R_TITLE");
				String description = rs.getString("R_Description");
				Blob r_image = rs.getBlob("r_Image");
				int m_id = rs.getInt("m_id");

				reimbursements.add(
						new Reimbursement(r_id, e_id, r_amount, r_state, r_date, title, description, r_image, m_id));
			}
		} catch (SQLException e) {
			log.error("SQLException - unable to getReimbursements()");
			e.printStackTrace();
		} catch (IOException e1) {
			log.error("IOException - unable to getReimbursements()");
			e1.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementsFromEmployeeId(int id) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE E_ID = ?";

		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int r_id = rs.getInt("R_ID");
				int e_id = rs.getInt("E_ID");
				double r_amount = rs.getDouble("R_AMOUNT");
				int r_state = rs.getInt("R_STATE");
				Timestamp r_date = rs.getTimestamp("r_date");
				String title = rs.getString("R_TITLE");
				String description = rs.getString("R_Description");
				Blob r_image = rs.getBlob("r_Image");
				int m_id = rs.getInt("m_id");

				reimbursements.add(
						new Reimbursement(r_id, e_id, r_amount, r_state, r_date, title, description, r_image, m_id));
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getReimbursementsFromEmployee(), Employee: " + id);
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getReimbursementsFromEmployee(), Employee: " + id);
			e2.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE R_ID = ?";
		Reimbursement reimbursement = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int r_id = rs.getInt("R_ID");
				int e_id = rs.getInt("E_ID");
				double r_amount = rs.getDouble("R_AMOUNT");
				int r_state = rs.getInt("R_STATE");
				Timestamp r_date = rs.getTimestamp("r_date");
				String title = rs.getString("R_TITLE");
				String description = rs.getString("R_Description");
				Blob r_image = rs.getBlob("r_Image");
				int m_id = rs.getInt("m_id");

				reimbursement = new Reimbursement(r_id, e_id, r_amount, r_state, r_date, title, description, r_image,
						m_id);
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getReimbursement(), id= " + id);
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getReimbursement(), id= " + id);
			e2.printStackTrace();
		}
		return reimbursement;
	}

	@Override
	public int createReimbursement(Reimbursement r) throws SQLException, IOException {
		String sql = "Insert into REIMBURSEMENTS (E_ID, R_AMOUNT, R_TITLE, R_DESCRIPTION, R_IMAGE) VALUES (?,?,?,?,?)";
		int reimbursementCreated = 0;
		Connection con = ConnectionUtil.getConnectionFromFile();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, r.getEmployee_id());
		ps.setDouble(2, r.getAmount());
		ps.setString(3, r.getTitle());
		ps.setString(4, r.getDescription());
		ps.setBlob(5, r.getImage());
		reimbursementCreated = ps.executeUpdate();

		ps.close();
		con.close();
		return reimbursementCreated;
	}

	@Override
	public int updateReimbursement(Reimbursement r) {
//		Reimbursement temp = this.getReimbursementById(r.getId());
//		if(temp.getHash() != r.getHash()) {
//			log.error("IOException - unable to updateReimbursement(), current reimbursement to be updated does not match with records.");
//			return 0;
//		}

		String sql = "UPDATE REIMBURSEMENTS " + "SET " + "R_AMOUNT = ?, " + "R_STATE = ?, " + "R_TITLE = ?, "
				+ "R_DESCRIPTION = ?, " + "R_IMAGE = ?, " + "M_ID = ? " + "WHERE R_ID = ?";
		int updated = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setDouble(1, r.getAmount());
			ps.setInt(2, r.getState());
			ps.setString(3, r.getTitle());
			ps.setString(4, r.getDescription());
			ps.setBlob(5, r.getImage());
			if (r.getManager_id() != 0) {
				ps.setInt(6, r.getManager_id());
			} else {
				ps.setNull(6, java.sql.Types.INTEGER);
			}
			ps.setInt(7, r.getId());

			updated = ps.executeUpdate();
		} catch (SQLException e1) {
			log.error("SQLException - unable to updateReimbursement(): " + r);
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to updateReimbursement(): " + r);
			e2.printStackTrace();
		}
		return updated;
	}

}
