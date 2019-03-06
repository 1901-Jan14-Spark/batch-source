package com.revature.dao;

import com.revature.models.User;

public interface UserDao {

		public User getUserById(int id);
		public int createUser(User u);
		public int updateUser(User u);
		public int deleteUser(int id);

}

