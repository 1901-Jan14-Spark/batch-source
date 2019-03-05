package dao;

import java.util.List;

import model.UserObj;

public interface UserDao {
	public UserObj getUserAndPass(String userName);
	public UserObj getUserBalance(String username);
	public boolean createUser(UserObj newUser);
	public List<UserObj> getUsersList();
}
