package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> getAllUsers() {
		Session s = HibernateUtil.getSession();
		List<User> users = s.createCriteria(User.class).list();
		s.close();
		return users;
	}

	@Override
	public User getUserById(int id) {
		Session s = HibernateUtil.getSession();
//		User u = (User) s.load(User.class, id);
//		System.out.println(u);
		User u = (User) s.get(User.class, id);
		s.close();
		return u;
	}

	@Override
	public User createUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
