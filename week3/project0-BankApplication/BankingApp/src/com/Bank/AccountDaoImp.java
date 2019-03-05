package com.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImp implements AccountDAO {

	@Override
	public void saveAccount(User user) {
		// TODO Auto-generated method stub

		String sql = " update account set checking = ?, saving = ? where id = ?";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			System.out.println("printing from adi" + user.getAccount().getChecking() + " " + user.getID());

			ps.setDouble(1, user.getAccount().getChecking());
			ps.setDouble(2, user.getAccount().getSaving());
			ps.setDouble(3, user.getID());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return departmentsUpdated;

	}

	@Override
	public void updateAccount(ArrayList<User> updateArray) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Account> retrieveUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAccountList(ArrayList<Account> accountListT) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub

		return null;
	}

	public static void setAccountDetailforObject(User user, int id) {

		String sql = "select * from account where id = ?";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				double checking = rs.getDouble("CHECKING");
				user.getAccount().setChecking(checking);
				double saving = rs.getDouble("SAVING");
				user.getAccount().setSaving(saving);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Account createAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
