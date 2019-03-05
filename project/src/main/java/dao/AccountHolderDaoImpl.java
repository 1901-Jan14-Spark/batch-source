package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.AccountHolder;
import util.ConnectionUtil;

public class AccountHolderDaoImpl implements AccountHolderDao{

	@Override
	public AccountHolder getAccountHolderByUsername(String username) {
		String sql = "SELECT * FROM AccountHolder WHERE H_USERNAME = ?";
		AccountHolder ah = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int hid = rs.getInt("H_ID");
				String password = rs.getString("H_PASSWORD");
				String fname = rs.getString("H_FIRSTNAME");
				String lname = rs.getString("H_LASTNAME");
				int temploggedIn = rs.getInt("H_LOGGEDIN");
				boolean loggedIn;
				if(temploggedIn == 0) {
					loggedIn = true;
				}else {
					loggedIn = false;
				}
				ah = new AccountHolder(hid, username, password, fname, lname, loggedIn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ah;
	}

	@Override
	public void createAccountHolder(AccountHolder ah) {
		String sql = "{call CREATEACCOUNTHOLDER(?,?,?,?,?)}";
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				CallableStatement cs = con.prepareCall(sql)) {
			cs.setString(1, ah.getUsername());
			cs.setString(2, ah.getPassword());
			cs.setString(3, ah.getFirstname());
			cs.setString(4, ah.getLastname());
			int islogged;
			if (ah.isLoggedIn()) {
				islogged = 0;
			}else {
				islogged = 1;
			}
			cs.setInt(5, islogged);
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
	public int updateAccountHolderLogin(AccountHolder ah) {
		String sql = "Update accountholder set h_loggedin = ? where H_Id = ?";
		int accUpdated = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			int tempLogged;
			if(ah.isLoggedIn()) {
				System.out.println(ah);
				System.out.println("Setting to Logged Out");
				tempLogged = 1;
			}else {
				System.out.println(ah);
				System.out.println("Setting to Logged in");
				tempLogged = 0;
			}
			ps.setInt(1, tempLogged);
			ps.setInt(2, ah.getId());
			accUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return accUpdated;
	}

	@Override
	public int deleteAccountHolder(AccountHolder ah) {
		// TODO Auto-generated method stub
		return 0;
	}

}
