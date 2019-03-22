package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Bee;
import com.revature.util.HibernateUtil;

public class BeeDaoImpl implements BeeDao{
	@Override
	public Integer insertBee(Bee c) {
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
	public List<Bee> selectAllBees() {
		Session session = HibernateUtil.getSession();
		List<Bee> bees = null;
		
		try {
			bees = session.createQuery("From Bee").list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return bees;
	}

	@Override
	public Bee selectBeeById(Integer id) {
		Session session = HibernateUtil.getSession();
		Bee bee = null; //this object is transient
		try {
			bee = (Bee)session.get(Bee.class, id); // here the
			//object is persistent
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close(); //here the object is detached
		}
		return bee;
	}
	@Override
	public void updateBee(Bee change) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Bee bee = null;
		
		try {
			tx = session.beginTransaction();
			bee = (Bee)session.get(Bee.class, change.getId());
			if(change.getAge() != null) {
				bee.setAge(change.getAge());
			}		
			session.save(bee);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();			
		}finally {
			session.close();
		}
		
	}
}
