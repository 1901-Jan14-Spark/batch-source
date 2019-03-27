package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Account;
import com.revature.util.HibernateUtil;

public class AccountDaoImpl implements AccountDao{

	@Override
	public List<Account> getAllAccounts() {
		Session s = HibernateUtil.getSession();
		List<Account> accounts = s.createQuery("from Account").list();
		s.close();
		return accounts;
	}

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account createAccount(Account account) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(account);
		tx.commit();
		s.close();
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

}
