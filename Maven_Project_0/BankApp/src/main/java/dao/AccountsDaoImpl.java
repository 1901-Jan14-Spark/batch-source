package dao;

import java.sql.CallableStatement;
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
		String sql = "SELECT * FROM ACCOUNTS";
		List<Accounts> accounts = new ArrayList<>();
		try(Connection con = ConnectionUtil.sysVar();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int accNum = rs.getInt("ACC_NUM");
				int memNum = rs.getInt("MEM_NUM");
				String accType = rs.getString("ACC_TYPE");
				double balance = rs.getDouble("BALANCE");
				accounts.add(new Accounts(accNum, memNum, accType, balance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Accounts getAccountByID(int id) {
		String sql = "SELECT * FROM ACCOUNTS WHERE MEM_NUM = ?";
		Accounts a = null;
		try(Connection con = ConnectionUtil.sysVar();
			PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int accNum = rs.getInt("ACC_NUM");
				int memNum = rs.getInt("MEM_NUM");
				String accType = rs.getString("ACC_TYPE");
				double balance = rs.getDouble("BALANCE");
				a = new Accounts(accNum, memNum, accType, balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int deleteAccount(int id) {
		String sql = "DELETE FROM ACCOUNTS WHERE MEM_NUM =?";
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
	
	@Override
	public int createAccount(Accounts a) {
		String sql = "INSERT INTO ACCOUNTS VALUES(null,?,?,?)";
		int clientsCreated = 0;
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, a.getMemNum());
			ps.setString(2, a.getAccType());
			ps.setDouble(3, a.getBalance());
			clientsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsCreated;
	}

	@Override
	public void deposit(int a, double deposit) {
		String sql = "{call DEPOSIT(?,?)}";
		try(Connection con = ConnectionUtil.sysVar();
				CallableStatement cs = con.prepareCall(sql);){
			cs.setInt(1, a);
			cs.setDouble(2, deposit);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(int a, double withdraw) {
		String sql = "{call WITHDRAW(?,?)}";
		try(Connection con = ConnectionUtil.sysVar();
				CallableStatement cs = con.prepareCall(sql);){
			cs.setInt(1, a);
			cs.setDouble(2, withdraw);
			cs.execute();
		} catch (SQLException e) {
//			e.printStackTrace();
		}
	}

	@Override
	public Accounts getBalance(int id) {
		String sql = "SELECT BALANCE FROM ACCOUNTS WHERE MEM_NUM = ?";
		Accounts a = null;
		try(Connection con = ConnectionUtil.sysVar();
			PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				double balance = rs.getDouble("BALANCE");
				a = new Accounts(balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}


}
