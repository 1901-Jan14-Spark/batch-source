package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private static SessionFactory getSessionFactory(String filename) {
		if(sessionFactory == null || sessionFactory.isClosed()) {
			Configuration c = new Configuration().configure(filename);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			sessionFactory = c.buildSessionFactory(sr);
		}
		return sessionFactory;
	}
	
	public static Session getSession() {
		return getSessionFactory("hibernate.cfg.xml").openSession();
	}
	
	// we won't need this in our daos, just to terminate the application
	public static void closeSessionFactory() {
		sessionFactory.close();
	}

}
