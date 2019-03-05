package dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.Transaction;
import util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public void createTransaction(Account a, BigDecimal amount, String description) {
		String sql = "{call CREATETRANSACTION(?,?,?)}";
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				CallableStatement cs = con.prepareCall(sql)) {
			cs.setInt(1, a.getId());
			cs.setBigDecimal(2, amount);
			cs.setString(3, description);
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
	public int deleteTransaction(Transaction t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transaction> getTransactionForAccount(Account a) {
		String sql = "Select * from Transaction Where A_ID = ?";
		List<Transaction> transactions = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1,a.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int tID = rs.getInt("T_ID");
				int aID = rs.getInt("A_ID");
				Timestamp time = rs.getTimestamp("T_DATE");
				BigDecimal amount = rs.getBigDecimal("T_Amount");
				String description = rs.getString("T_DESCRIPTION");
				transactions.add(new Transaction(tID, aID, amount, time, description));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return transactions;
	}

}
