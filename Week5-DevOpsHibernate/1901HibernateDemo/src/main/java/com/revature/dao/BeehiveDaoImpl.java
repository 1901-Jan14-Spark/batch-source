package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Beehive;
import com.revature.util.HibernateUtil;

public class BeehiveDaoImpl implements BeehiveDao{
	@Override
	public Integer insertBeehive(Beehive c) {
		Session session = HibernateUtil.getSession(); //connect to db
		Transaction tx = null;
		Integer id = null;
		
		try {
			tx = session.beginTransaction(); //open the transaction block
			id = (Integer) session.save(c); //this is where the object becomes
			//								persistent
			tx.commit(); // finalize the insert
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
		return id;
	}

	@Override
	public List<Beehive> selectAllBeehives() {
		Session session = HibernateUtil.getSession();
		List<Beehive> beehives = null;
		
		try {
			beehives = session.createQuery("From Beehive").list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return beehives;
	}

	@Override
	public Beehive selectBeehiveById(Integer id) {
		Session session = HibernateUtil.getSession();
		Beehive beehive = null; //this object is transient
		try {
			beehive = (Beehive)session.get(Beehive.class, id); // here the
			//object is persistent
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close(); //here the object is detached
		}
		return beehive;
	}
	@Override
	public void updateBeehive(Beehive change) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Beehive beehive = null;
		
		try {
			tx = session.beginTransaction();
			beehive = (Beehive)session.get(Beehive.class, change.getId());
			if(change.getHoney() != null) {
				beehive.setHoney(change.getHoney());
			}		
			session.save(beehive);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();			
		}finally {
			session.close();
		}
		
	}
}
