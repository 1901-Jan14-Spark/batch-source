package com.Bank;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {

	public List<User> getusers();

	public int createUser(User user);

}
