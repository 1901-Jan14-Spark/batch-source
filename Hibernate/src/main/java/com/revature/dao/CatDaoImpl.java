package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Cat;
import com.revature.utl.HibernateUtil;

public class CatDaoImpl implements CatDao {

	@Override
	public Integer insertCat(Cat c) {
		//connecting to DB is done here
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try {
			//Begins a unit of work and returns the associated Transaction object 
			tx = session.beginTransaction();
			//object becomes persistent here
			id = (Integer) session.save(c);
			//finalize
			tx.commit();
			
			
		} catch (HibernateException e) {
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
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cats;
	}

	@Override
	public Cat selectCatById(Integer id) {
		Session session = HibernateUtil.getSession();
		Cat cat = null; //this object is transient
		
		try {
			//Hibernate has get method, to get class and id
			cat = ((Cat) session.get(Cat.class, id));
			//object is persistent
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close(); // object is detached
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
				cat.setColor(change.getColor());
			}
			session.save(cat);
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
