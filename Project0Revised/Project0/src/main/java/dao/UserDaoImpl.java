package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.UserObj;
import util.ConnectionUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public UserObj getUserAndPass(String userName) {
		String sql = "SELECT USER_NAME, USER_PASS FROM BANK_USER WHERE USER_NAME = ?";
		UserObj uo = new UserObj();
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			String uName = rs.getString("USER_NAME");
			uo.setUsername(uName);
			String pass = rs.getString("USER_PASS");
			uo.setPassword(pass);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uo;
	}
	
	@Override
	public UserObj getUserBalance(String userName) {
		String sql = "SELECT BALANCE FROM BANK_USER WHERE USER_NAME = ?";
		UserObj uo = new UserObj();
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			double balance = rs.getDouble("BALANCE");
			uo.setBalance(balance);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uo;
	}

	@Override
	public boolean createUser(UserObj newUser) {
		int usersCreated = 0;
		String sql = "INSERT INTO BANK_USER (USER_NAME, USER_PASS, BALANCE) VALUES (?,?,0)";
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, newUser.getUsername());
			ps.setString(2, newUser.getPassword());
			usersCreated = ps.executeUpdate();
			
			if(usersCreated > 0)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<UserObj> getUsersList() {
		List<UserObj> userNames = new ArrayList<>();
		String sql = "SELECT USER_NAME FROM BANK_USER";
		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				UserObj uo = new UserObj();
				String uName = rs.getString("USER_NAME");
				uo.setUsername(uName);
				userNames.add(uo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userNames;
	}
	
}
