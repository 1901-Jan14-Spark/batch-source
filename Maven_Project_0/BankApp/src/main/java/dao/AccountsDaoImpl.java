package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Accounts;
import util.ConnectionUtil;

public class AccountsDaoImpl implements AccountsDao{

	@Override
	public List<Accounts> getAccounts() {
		List<Accounts> accounts = new ArrayList<>();
		String sql = "SELECT * FROM ACCOUNTS";
		try(Connection con = ConnectionUtil.sysVar();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int accNum = rs.getInt("ACC_NUM");
				String accName = rs.getString("ACC_TYPE");
				double balance = rs.getInt("BALANCE");
				accounts.add(new Accounts(accNum, accName, balance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Accounts getAccountByID(int id) {
		Accounts a = null;
		String sql = "SELECT * FROM ACCOUNTS WHERE ACC_NUM = ?";
		try(Connection con = ConnectionUtil.sysVar(); 
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int accNum = rs.getInt("ACC_NUM");
				String accType = rs.getString("ACC_TYPE");
				double balance = rs.getDouble("BALANCE");
				a = new Accounts(accNum, accType, balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
		
	}




	@Override
	public int updateAccount(Accounts a) {
		String sql = "UPDATE ACCOUNTS SET BALANCE =? WHERE ACC_NUM = ?";
		int balanceUpdate = 0;
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getAccNum());
			balanceUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return balanceUpdate;
	}

	@Override
	public int deleteAccount(int id) {
		String sql = "DELETE FROM ACCOUNTS WHERE ACC_NUM =?";
		int rowsDeleted = 0;
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

}
