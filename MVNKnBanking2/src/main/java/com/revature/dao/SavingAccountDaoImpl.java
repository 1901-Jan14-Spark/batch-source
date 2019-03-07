package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;


import com.revature.model.SavingAccount;
import com.revature.util.ConnectionUtil;

public class SavingAccountDaoImpl implements SavingAccountDao {

	private static Logger log = Logger.getRootLogger();
	
	@Override
	public List<SavingAccount> getCAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SavingAccount getSAccountById(long id) {
		String sql = "SELECT SAVINGACCOUNT_NUM, SAVINGACCOUNT_BALANCE"
				+ " FROM SAVINGACCOUNT"
			+ " WHERE SAVINGACCOUNT_NUM = ?" ;
		
		SavingAccount sa = null;
		
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();
		PreparedStatement statement = con.prepareStatement(sql)	) {
			
		statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				log.info("Got Account");
				long temp_SAccountNum = rs.getLong("SAVINGACCOUNT_NUM");
				double temp_Sbalance = rs.getDouble("SAVINGACCOUNT_BALANCE");
				sa = new SavingAccount(temp_SAccountNum, temp_Sbalance);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sa;
	}

	@Override
	public int createSAccount(SavingAccount sobj) {
		String sql = "INSERT INTO SAVINGACCOUNT VALUES(?,?)";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement statement = con.prepareStatement(sql)){
			
			statement.setLong(1, sobj.getSavingAcocuntNum());
			statement.setDouble(2, sobj.getSaveBalance());
			
			statement.executeUpdate();		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		return 0;
	}

	@Override
	public int updateCAccount(SavingAccount sa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCAccount(SavingAccount sa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSAccountDeposit(SavingAccount sa, double transAmount) {
		
		String sql = "{call SAVINGACCOUNT_TRANSACTION(?,?)}";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile();
			CallableStatement cs = con.prepareCall(sql)){
			cs.setLong(1, sa.getSavingAcocuntNum());
			cs.setDouble(2, transAmount);
			cs.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return 0;

	}

}
