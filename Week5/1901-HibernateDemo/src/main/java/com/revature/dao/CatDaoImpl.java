package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Cat;
import com.revature.util.HibernateUtil;

public class CatDaoImpl implements CatDao {

	@Override
	public Integer insertCat(Cat c) {
		Session session = HibernateUtil.getSession();  //connect to DB
		Transaction tx = null;
		Integer id = null;
		
		try {
			tx = session.beginTransaction();  // open the transaction block
			id = (Integer) session.save(c);  // this is where the object becomes persistent
			tx.commit();   					// where we finalize the insert (committing);
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return id;
	}

	@Override
	public List<Cat> selectAllCats() {
		Session session = HibernateUtil.getSession();
		List<Cat> cats = null;
		
		try {
			cats = session.createQuery("From Cat").list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cats;
	}

	@Override
	public Cat selectCatById(Integer id) {
		Session session = HibernateUtil.getSession();
		Cat cat = null;  // this object is transient 
		
		try {
			cat = (Cat)session.get(Cat.class, id);   // here the object is persistent 
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();   // here the object is detached
		}
		return cat;
	}

	@Override
	public void updateCat(Cat change) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Cat cat = null;
		
		try {
			tx = session.beginTransaction();
			cat = (Cat) session.get(Cat.class, change.getId());
			if(change.getName() != null) {
				cat.setName(change.getName());
			}
			if(change.getColor() != null) {
				cat.setName(change.getColor());
			}
			session.save(cat);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
