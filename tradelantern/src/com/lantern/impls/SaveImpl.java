package com.lantern.impls;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class SaveImpl {

	public static String SUCCESS = "SUCCESS";
	public static String FAILURE = "FAILURE";

	public String save(Object obj){

		SessionFactory factory = null;
		Session session = null;

		try {

			if(obj == null){
				return "NULL VALUE NOT ACCEPTED";
			}

			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");

			factory = cfg.buildSessionFactory();
			session = factory.openSession();

			Transaction tx = session.beginTransaction();
			session.save(obj);
			
			System.out.println( obj.getClass().getSimpleName()+" Object saved successfully.....!!");
			tx.commit();

			session.close();
			factory.close();
			
			return SUCCESS;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( session != null)
				session.close();
			if( factory != null)
				factory.close();
		}

		return FAILURE;
	}
	
	
	public String update(Object obj){

		SessionFactory factory = null;
		Session session = null;

		try {

			if(obj == null){
				return "NULL VALUE NOT ACCEPTED";
			}


			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");

			factory = cfg.buildSessionFactory();
			session = factory.openSession();

			Transaction tx = session.beginTransaction();
			
				session.update(obj);
			
			System.out.println( obj.getClass().getSimpleName()+" Object updated successfully.....!!");
			tx.commit();

			session.close();
			factory.close();
			
			return SUCCESS;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( session != null)
				session.close();
			if( factory != null)
				factory.close();
		}

		return FAILURE;
	}
}
