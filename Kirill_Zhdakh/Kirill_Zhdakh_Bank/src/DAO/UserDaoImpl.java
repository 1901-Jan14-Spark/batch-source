package DAO;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.User;
import Util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM USER_TABLE";
		try(Connection c = ConnectionUtil.getConnectionFromFile();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql))
		{
			while(rs.next())
			{
				userList.add(new User(rs.getString("USER_FIRSTNAME"), rs.getString("USER_LASTNAME"), rs.getString("USER_USERNAME"), rs.getString("USER_PASSWORD"), rs.getFloat("USER_CHECKING"), rs.getFloat("USER_SAVING")));			
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public boolean createUser(User u) {
		String sql = "INSERT INTO USER_TABLE (USER_FIRSTNAME,"
					+"USER_LASTNAME,USER_USERNAME,USER_PASSWORD)"
					+" VALUES (?,?,?,?)";
		
		try(Connection c = ConnectionUtil.getConnectionFromFile();
			PreparedStatement ps = c.prepareStatement(sql))
		{		
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
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
	public boolean updateUser(User u) {
		String sql = "UPDATE USER_TABLE"
					+" SET USER_CHECKING = ?,"
					+" USER_SAVING = ?"
					+" WHERE USER_USERNAME = ?";
		try(Connection c = ConnectionUtil.getConnectionFromFile();
			PreparedStatement ps = c.prepareStatement(sql))
		{
			ps.setFloat(1, u.getCheckingBalance());
			ps.setFloat(2, u.getSavingBalance());
			ps.setString(3, u.getUsername());
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
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateTransactionDate(User u) {
		String sql = "CALL UPDATE_TIME(?)";
		try (Connection c = ConnectionUtil.getConnectionFromFile();
			 CallableStatement cs = c.prepareCall(sql))
		{
			cs.setString(1, u.getUsername());
			cs.execute();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
