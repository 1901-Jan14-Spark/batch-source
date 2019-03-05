package com.Bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDAO {

	Account AC = new Account();

	@Override
	public List<User> getusers() {
		// TODO Auto-generated method stub

		List<User> users = new ArrayList<>();

		String sql = "SELECT * FROM USER_";

		try (Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {

			while (rs.next()) {
				User u = new User();

				int userId = rs.getInt("ID");
				u.setID(userId);

				String firstName = rs.getString("FIRSTNAME");
				u.setFirstName(firstName);

				String lastName = rs.getString("LASTNAME");
				u.setLastName(lastName);

				String password = rs.getString("PASSWORD");
				u.setPassword(password);

				String username = rs.getString("USERNAME");
				u.setUsername(username);

				users.add(u);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;

	}

	public User findUser(String userName) {

		User user = new User();

		String sql = "select * from user_ where username = ? ";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("ID");
				user.setID(userId);
				String firstName = rs.getString("FIRSTNAME");
				user.setFirstName(firstName);
				String lastName = rs.getString("LASTNAME");
				user.setLastName(lastName);
				String password = rs.getString("PASSWORD");
				user.setPassword(password);
				String username = rs.getString("USERNAME");
				user.setUsername(username);

				// AccountDaoImp.setAccountDetailforObject(user, userId);

				//

			}
			AccountDaoImp.setAccountDetailforObject(user, user.getID());
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public int createUser(User user) {

		// int departmentsCreated = 0;

		System.out.println("printing user" + user);

		try (Connection con = ConnectionUtil.getConnection();

				CallableStatement stmt = con.prepareCall("{call createUser(?,?,?,?,?)}");) {
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getPassword());

			stmt.registerOutParameter(5, java.sql.Types.DOUBLE);
			stmt.executeUpdate();

			// get current id
			int currentId = stmt.getInt(5) - 1;
			// set the id for the user
			user.setID(currentId);
			return currentId;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

}
