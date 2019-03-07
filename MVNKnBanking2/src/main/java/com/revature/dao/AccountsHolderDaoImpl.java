package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.AccountsHolder;
import com.revature.util.ConnectionUtil;

public class AccountsHolderDaoImpl implements AccountsHolderDao {
	
	private static Logger log = Logger.getRootLogger();
	static CheckingAccountDaoImpl cdao = new CheckingAccountDaoImpl();
	static SavingAccountDaoImpl sdao = new SavingAccountDaoImpl();
	
	
	@Override
	public List<AccountsHolder> getUsers() {
		
		List<AccountsHolder> holders = new ArrayList<>();
				
		String sql ="SELECT * FROM ACCOUNTHOLDER";
		try(Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while (rs.next()) {
				AccountsHolder a = new AccountsHolder();
				
				String username = rs.getString("USERNAME");
				a.setUsername(username);
				String pass = rs.getString("USER_PASSWORD");
				a.setUserpass(pass);
				Long CheckingNum = rs.getLong("CHECKACCOUNT_NUM");
				a.setCheckAcocuntNum(CheckingNum);
				Long SavingNum = rs.getLong("SAVINGACCOUNT_NUM");
				a.setSavingAcocuntNum(SavingNum);
				
				holders.add(a);
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return holders;
	}

	@Override
	public AccountsHolder validate(String id, String Pass) {
		String sql = "SELECT USERNAME, accountsholder.checkaccount_num, checkingaccount.checkaccount_balance, accountsholder.savingaccount_num, savingaccount.savingaccount_balance "
				+ "FROM accountsholder "
				+ "INNER JOIN SAVINGACCOUNT ON ACCOUNTSHOLDER.SAVINGACCOUNT_NUM=SAVINGACCOUNT.SAVINGACCOUNT_NUM "
				+ "INNER JOIN CHECKINGACCOUNT ON ACCOUNTSHOLDER.CHECKACCOUNT_NUM=CHECKINGACCOUNT.CHECKACCOUNT_NUM "
				+ "where username = ? and user_password = ?";
		
		AccountsHolder a = null; 
		
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement statement = con.prepareStatement(sql)	) {
		    
				statement.setString(1, id);
				statement.setString(2, Pass);
				
				ResultSet rs = statement.executeQuery();
				
				rs.next();
					
					String username = rs.getString("username");
					long cNum = rs.getLong("checkaccount_num");
					long sNum = rs.getLong("savingaccount_num");

					
					
					a = new AccountsHolder(username, cNum, sNum);
					a.setUsername(username);
					a.setCaObject(cdao.getCAccountById(cNum));
					a.setSaObject(sdao.getSAccountById(sNum));
					
					log.info(a);
					log.info("You Logged In!");
				
				
				
//				int rowsInserted = statement.executeUpdate();
//				if (rowsInserted > 0) {
//					
//				   log.info("You Logged in!");
//				} else {
//					log.info("You Logged in!");
//				}
			     
			} catch (SQLException | IOException ex) {
			    ex.printStackTrace();
			}
			return a;
	}

	@Override
	public boolean createUser(AccountsHolder aU) {
		
		String sql = "INSERT INTO ACCOUNTSHOLDER (USERNAME,"
				+"USER_PASSWORD, CHECKACCOUNT_NUM, SAVINGACCOUNT_NUM)"
				+" VALUES (?,?,?,?)";
	
	try(Connection c = ConnectionUtil.getConnectionFromFile();
		PreparedStatement ps = c.prepareStatement(sql))
	{		
		ps.setString(1, aU.getUsername());
		ps.setString(2, aU.getUserpass());
		ps.setLong(3, aU.getCheckAcocuntNum());
		ps.setLong(4, aU.getSavingAcocuntNum());
		ps.executeUpdate();
		
		return true;
	} 
	catch (IOException e)
	{
		e.printStackTrace();
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return false;
	}


	@Override
	public AccountsHolder getUserById(String id, String Pass) {
	
		String sql = "SELECT ACCOUNTSHOLDER FROM ACCOUNTSHOLDER WHERE USERNAME = ? and USER_PASS = ?";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery(sql);){
			
			while(rs.next()) {
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int updateUser(AccountsHolder a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(AccountsHolder a) {
		// TODO Auto-generated method stub
		return 0;
	}

}
