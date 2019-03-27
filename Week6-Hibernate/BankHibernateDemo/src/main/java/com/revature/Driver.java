package com.revature;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
//		Session s = HibernateUtil.getSession();
//		
//		s.close();
		
		UserDao userDao = new UserDaoImpl();
//		User u1 = new User(200,"johndoe","johnspass");
//		userDao.createUser(u1);
		
//		User u2 = new User(201,"janedoe","janespass");
//		userDao.createUser(u2);
		
		List<User> users = userDao.getAllUsers();
		for(User u: users) {
			System.out.println(u);
		}
		
//		System.out.println(userDao.getUserById(201));
		
//		AccountDao accountDao = new AccountDaoImpl();
//		Account a1 = new Account(10005, 400, AccountType.SAVINGS);
//		Account a2 = new Account(10006, 800, AccountType.CHECKING);
//		Account a3 = new Account(10007, 650, AccountType.SAVINGS);
//		Account a4 = new Account(10008, 200, AccountType.CHECKING);
		
		// this throws an exception because there is no user in the db with id of 54
//		Account a5 = new Account(10009, 200, AccountType.CHECKING, new User(54));
//		accountDao.createAccount(a1);
//		accountDao.createAccount(a2);
//		accountDao.createAccount(a3);
//		accountDao.createAccount(a4);
//		accountDao.createAccount(a5);
		
//		User u1 = new User(200,"johndoe","johnspass", a1, a2, a3);
//		userDao.createUser(u1);
//		
//		User u2 = new User(201,"janedoe","janespass", a4, a3);
//		userDao.createUser(u2);
		
		
		HibernateUtil.closeSessionFactory();

	}

}
