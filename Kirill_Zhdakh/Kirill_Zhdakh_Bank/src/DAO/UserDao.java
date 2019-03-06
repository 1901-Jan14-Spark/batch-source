package DAO;

import java.util.List;

import Classes.User;

public interface UserDao {
	public List<User> getUsers();
	public boolean createUser(User u);
	public boolean updateUser(User u);
	public int deleteUser(int id);
	public boolean updateTransactionDate(User u);
}
