package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.bank.Account;
import com.revature.bank.Member;
import com.revature.util.ConnectionUtil;

public class MemberDaoImplementation implements MemberDao {
	
	AccountDao ad = new AccountDaoImplementation();

	@Override
	public Member getMemberByAccountNumber(String accountNumber) {
		
		String Sql = "SELECT * FROM MEMBER_ACCOUNT WHERE ACCOUNT_NUMBER = ?";
		Member m = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(Sql)){
			
			ps.setString(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String memberAccountNumber = rs.getString("ACCOUNT_NUMBER");
				String firstName = rs.getString("USER_FIRSTNAME");
				String lastName = rs.getString("USER_LASTNAME");
				String username = rs.getString("USER_USERNAME");
				String email = rs.getString("USER_EMAIL");
				String password = rs.getString("USER_PASSWORD");
				m = new Member(memberAccountNumber, firstName, lastName, username, email, password, new Account(memberAccountNumber));
				
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return m;
	}

	@Override
	public int addNewMember(Member m) {
		int membersCreated = 0;
		String sql = "INSERT INTO MEMBER_ACCOUNT ("
				+ "ACCOUNT_NUMBER, "
				+ "USER_FIRSTNAME, "
				+ "USER_LASTNAME, "
				+ "USER_USERNAME, "
				+ "USER_PASSWORD, "
				+ "USER_EMAIL) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
		
				ps.setString(1, m.getAccountNumber());
				ps.setString(2,  m.getFirstName());
				ps.setString(3,  m.getLastName());
				ps.setString(4,  m.getUserName());
				ps.setString(5, m.getPassword());
				ps.setString(6,  m.getEmail());
				membersCreated = ps.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return membersCreated;
	}

	@Override
	public int updateMemberInfo(Member m) {
		int membersUpdated = 0;
		String sql = "UPDATE MEMBER_ACCOUNT "
				+ "SET USER_FIRSTNAME = ?, USER_LASTNAME = ?, USER_USERNAME = ?, USER_PASSWORD = ?, USER_EMAIL = ? "
				+ "WHERE ACCOUNT_NUMBER = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, m.getFirstName());
			ps.setString(2,  m.getLastName());
			ps.setString(3,  m.getUserName());
			ps.setString(4, m.getPassword());
			ps.setString(5,  m.getEmail());
			ps.setString(6, m.getAccountNumber());
			membersUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membersUpdated;
	}

	@Override
	public int deleteMember(String accountNumber) {
		int membersDeleted = 0;
		
		String sql = "DELETE FROM MEMBER_ACCOUNT "
				+ "WHERE ACCOUNT_NUMBER = ?";
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1,  accountNumber);
			membersDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membersDeleted;
	}

}
