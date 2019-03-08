package com.revature.daoImplementations;

import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.daos.ReimbursementDao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

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
				String description = rs.getString("R_Description");
				Blob r_image = rs.getBlob("r_Image");
				int m_id = rs.getInt("m_id");

				reimbursements
						.add(new Reimbursement(r_id, e_id, r_amount, r_state, r_date, description, r_image, m_id));
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
	public List<Reimbursement> getReimbursementsFromEmployee(Employee e) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE E_ID = ?";

		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, e.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int r_id = rs.getInt("R_ID");
				int e_id = rs.getInt("E_ID");
				double r_amount = rs.getDouble("R_AMOUNT");
				int r_state = rs.getInt("R_STATE");
				Timestamp r_date = rs.getTimestamp("r_date");
				String description = rs.getString("R_Description");
				Blob r_image = rs.getBlob("r_Image");
				int m_id = rs.getInt("m_id");

				reimbursements
						.add(new Reimbursement(r_id, e_id, r_amount, r_state, r_date, description, r_image, m_id));
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getReimbursementsFromEmployee(), Employee: " + e.toString());
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getReimbursementsFromEmployee(), Employee: " + e.toString());
			e2.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementsPending() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE R_STATE = 0";

		try (Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {

			while (rs.next()) {

				int r_id = rs.getInt("R_ID");
				int e_id = rs.getInt("E_ID");
				double r_amount = rs.getDouble("R_AMOUNT");
				int r_state = rs.getInt("R_STATE");
				Timestamp r_date = rs.getTimestamp("r_date");
				String description = rs.getString("R_Description");
				Blob r_image = rs.getBlob("r_Image");
				int m_id = rs.getInt("m_id");

				reimbursements
						.add(new Reimbursement(r_id, e_id, r_amount, r_state, r_date, description, r_image, m_id));
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getReimbursementsPending()");
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getReimbursementsPending()");
			e2.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementsResolved() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE R_STATE > 1";

		try (Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {

			while (rs.next()) {

				int r_id = rs.getInt("R_ID");
				int e_id = rs.getInt("E_ID");
				double r_amount = rs.getDouble("R_AMOUNT");
				int r_state = rs.getInt("R_STATE");
				Timestamp r_date = rs.getTimestamp("r_date");
				String description = rs.getString("R_Description");
				Blob r_image = rs.getBlob("r_Image");
				int m_id = rs.getInt("m_id");

				reimbursements
						.add(new Reimbursement(r_id, e_id, r_amount, r_state, r_date, description, r_image, m_id));
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getReimbursementsResolved()");
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getReimbursementsResolved()");
			e2.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement getReimbursement(Reimbursement r) {
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE R_ID = ?";
		Reimbursement result = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, r.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int r_id = rs.getInt("R_ID");
				int e_id = rs.getInt("E_ID");
				double r_amount = rs.getDouble("R_AMOUNT");
				int r_state = rs.getInt("R_STATE");
				Timestamp r_date = rs.getTimestamp("r_date");
				String description = rs.getString("R_Description");
				Blob r_image = rs.getBlob("r_Image");
				int m_id = rs.getInt("m_id");

				result = new Reimbursement(r_id, e_id, r_amount, r_state, r_date, description, r_image, m_id);
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getReimbursement(), id= " + r.getId());
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getReimbursement(), id= " + r.getId());
			e2.printStackTrace();
		}
		return result;
	}

	@Override
	public int createReimbursement(Reimbursement r) {
		String sql = "Insert into REIMBURSEMENTS (E_ID, R_AMOUNT, R_DESCRIPTION, R_IMAGE) VALUES (?,?,?,?)";
		int reimbursementCreated = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, r.getEmployee_id());
			ps.setDouble(2, r.getAmount());
			ps.setString(3, r.getDescription());
			ps.setBlob(4, r.getImage());
			reimbursementCreated = ps.executeUpdate();
		} catch (SQLException e) {
			log.error("SQLException - unable to createReimbursement(), reimbursement: " + r.toString());
			e.printStackTrace();
		} catch (IOException e1) {
			log.error("IOException - unable to createReimbursement(), reimbursement: " + r.toString());
			e1.printStackTrace();
		}
		return reimbursementCreated;
	}

	@Override
	public boolean updateReimbursement(Reimbursement r) {
		String sql = "{call updateReimbursement(rid => ?, eid => ?, ramount => ?, rstate =>?, rdescription =>?, rimage => ?, mid => ?)}";
		try (Connection con = ConnectionUtil.getConnectionFromFile(); CallableStatement cs = con.prepareCall(sql)) {
			cs.setInt(1, r.getId());
			cs.setInt(2, r.getEmployee_id());
			cs.setDouble(3, r.getAmount());
			cs.setInt(4, r.getState());
			cs.setString(5, r.getDescription());
			cs.setBlob(6, r.getImage());
			if (r.getManager_id() == 0) {
				cs.setNull(7, 0);
			} else {
				cs.setInt(7, r.getManager_id());
			}
			cs.execute();
		} catch (SQLException e1) {
			log.error("SQLException - unable to updateReimbursement(): reimbursement: " + r.toString());
			e1.printStackTrace();
			return false;
		} catch (IOException e2) {
			log.error("IOException - unable to updateEmployee(): reimbursement: " + r.toString());
			return false;
		}
		return true;
	}
}
