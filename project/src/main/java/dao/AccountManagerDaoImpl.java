package dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.AccountHolder;
import util.ConnectionUtil;

public class AccountManagerDaoImpl implements AccountManagerDao {
	
	static AccountDaoImpl adi = new AccountDaoImpl();
	
	public List<Account> getAccountsAssociated(AccountHolder ah) {
		String sql = "Select A_ID, A_TYPE, A_Balance from AccountManager natural join account Where H_ID = ?";
		List<Account> accounts = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1,ah.getId());
			ResultSet rs = ps.executeQuery();
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
	public void assignAccount(Account a, AccountHolder ah) {
		String sql = "{call ASSIGNACCOUNT(?,?)}";
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				CallableStatement cs = con.prepareCall(sql)) {
			cs.setInt(1, a.getId());
			cs.setInt(2, ah.getId());
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public int deleteAssignedAccount(Account a, AccountHolder ah) {
		String sql = "DELETE FROM ACCOUNTMANAGER where A_Id = ? AND H_Id =?";
		int delAssign = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, a.getId());
			ps.setInt(2, ah.getId());
			delAssign = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return delAssign;
	}

}
