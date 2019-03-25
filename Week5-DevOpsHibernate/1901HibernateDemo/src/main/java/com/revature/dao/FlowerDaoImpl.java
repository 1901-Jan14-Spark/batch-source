package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Flower;
import com.revature.util.HibernateUtil;

public class FlowerDaoImpl implements FlowerDao{


	@Override
	public Integer insertFlower(Flower c) {
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
	public List<Flower> selectAllFlower() {
		Session session = HibernateUtil.getSession();
		List<Flower> flowers = null;
		
		try {
			flowers = session.createQuery("From Flower").list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return flowers;
	}

	@Override
	public Flower selectFlowerById(Integer id) {
		Session session = HibernateUtil.getSession();
		Flower flower = null; //this object is transient
		try {
			flower = (Flower)session.get(Flower.class, id); // here the
			//object is persistent
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close(); //here the object is detached
		}
		return flower;
	}
	@Override
	public void updateFlower(Flower change) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Flower flower = null;
		
		try {
			tx = session.beginTransaction();
			flower = (Flower)session.get(Flower.class, change.getId());
			if(change.getPetals() != null) {
				flower.setPetals(change.getPetals());
			}		
			session.save(flower);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();			
		}finally {
			session.close();
		}
		
	}
}
