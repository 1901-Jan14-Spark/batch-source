package dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Account;
import util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{


	public List<Account> getAccounts() {
		String sql = "Select * from Account";
		List<Account> accounts = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while (rs.next()) {
				int accID = rs.getInt("A_ID");
				int name = rs.getInt("A_TYPE");
				BigDecimal balance = rs.getBigDecimal("A_BALANCE");
				accounts.add(new Account(accID, name, balance));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return accounts;
	}
	@Override
	public Account getAccountByID(int id) {
		String sql = "SELECT * FROM Account WHERE A_ID = ?";
		Account a = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int aid = rs.getInt("A_ID");
				int type = rs.getInt("A_TYPE");
				BigDecimal balance = rs.getBigDecimal("A_BALANCE");
				a = new Account(aid, type, balance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return a;
	}

	@Override
	public int updateAccountBalance(Account a) {
		String sql = "Update account set A_BALANCE = ? where A_Id = ?";
		int accUpdated = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setBigDecimal(1, a.getBalance());
			ps.setInt(2, a.getId());
			accUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return accUpdated;
	}


	@Override
	public Account createAccount(Account a) {
		String sql = "{call CREATEACCOUNT(?)}";
		Account temp = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				CallableStatement cs = con.prepareCall(sql)) {
			cs.setInt(1, a.getType());
			cs.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return temp;
	}
	
	public int getAccSeq() {
		String sql = "SELECT Last_number from user_sequences where sequence_name = 'SQ_ACCOUNT_PK'";
		int result = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)) {
			
			while (rs.next()) {
				result = rs.getInt("Last_Number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}
}
