package com.lantern.impls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveImpl {
	public void save(Object obj){

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(obj);
		System.out.println( obj.getClass().getSimpleName()+" osbject saved successfully.....!!");
		tx.commit();
		
		session.close();
		factory.close();
	}
}
