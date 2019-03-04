package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.BankingAccount;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{
	
	BankingAccountDao bad = new BankingAccountDaoImpl();
	
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		
		String sql = "SELECT * FROM USERS_TABLE";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				User u = new User();
				
				int userId = rs.getInt("USER_ID");
				u.setId(userId);
				
				String userName = rs.getString("USER_NAME");
				u.setUserName(userName);
				
				String password = rs.getString("USER_PW");
				u.setPassword(password);
				
				int accountId = rs.getInt("ACCOUNT_ID");
				u.setAccount(new BankingAccount(accountId));
				
				users.add(u);
			}
			
			List<BankingAccount> accounts = bad.getBankingAccount();
			
			for(User u: users) {
				int accountId = u.getAccount().getAccountId();
				if(accountId!=0) {
					for(BankingAccount a: accounts) {
						if(accountId == a.getAccountId()) {
							u.setAccount(a);
						}
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
