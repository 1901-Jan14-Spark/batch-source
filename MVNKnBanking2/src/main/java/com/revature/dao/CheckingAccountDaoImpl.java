package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.CheckingAccount;
import com.revature.util.ConnectionUtil;

public class CheckingAccountDaoImpl implements CheckingAccountDao {
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public List<CheckingAccount> getCAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckingAccount getCAccountById(long id) {
		String sql = "SELECT CHECKACCOUNT_NUM, CHECKACCOUNT_BALANCE"
				+ " FROM CHECKINGACCOUNT"
			+ " WHERE CHECKACCOUNT_NUM = ?" ;
		
		CheckingAccount ca = null;
		
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();
		PreparedStatement statement = con.prepareStatement(sql)	) {
			
		statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				log.info("Got Account");
				long temp_CAccountNum = rs.getLong("CHECKACCOUNT_NUM");
				double temp_Cbalance = rs.getDouble("CHECKACCOUNT_BALANCE");
				ca = new CheckingAccount(temp_CAccountNum, temp_Cbalance);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ca;
	}

	@Override
	public int createCAccount(CheckingAccount cobj) {
		String sql = "INSERT INTO CHECKINGACCOUNT VALUES(?,?)";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement statement = con.prepareStatement(sql)){
			
			statement.setLong(1, cobj.getCheckAcocuntNum());
			statement.setDouble(2, cobj.getCheckBalance());
			
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
	public int deleteCAccount(CheckingAccount ca) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCAccountDeposit(CheckingAccount ca, double transAmount) {
		
		String sql = "{call ACCOUNT_TRANSACTION(?,?)}";
		
		
		try(Connection con = ConnectionUtil.getConnectionFromFile();
			CallableStatement cs = con.prepareCall(sql)){
			
			cs.setLong(1, ca.getCheckAcocuntNum());
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

	@Override
	public int updateCAccountWithdraw(CheckingAccount ca) {
		// TODO Auto-generated method stub
		return 0;
	}

}
