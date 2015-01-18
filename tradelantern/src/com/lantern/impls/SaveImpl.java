package com.lantern.impls;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lantern.utils.HibernateUtils;



public class SaveImpl {

	public static String SUCCESS = "SUCCESS";
	public static String FAILURE = "FAILURE";

	public String save(Object obj){

		Session session = null;

		try {

			if(obj == null){
				return "NULL VALUE NOT ACCEPTED";
			}

			session = HibernateUtils.getSessionFactory().openSession();

			Transaction tx = session.beginTransaction();
			session.save(obj);

			System.out.println( obj.getClass().getSimpleName()+" Object saved successfully.....!!");
			tx.commit();


			return SUCCESS;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( session != null)
				session.close();
		}

		return FAILURE;
	}


	public String update(Object obj){

		Session session = null;

		try {

			if(obj == null){
				return "NULL VALUE NOT ACCEPTED";
			}

			session = HibernateUtils.getSessionFactory().openSession();

			Transaction tx = session.beginTransaction();

			session.update(obj);

			System.out.println( obj.getClass().getSimpleName()+" Object updated successfully.....!!");
			tx.commit();

			return SUCCESS;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( session != null)
				session.close();
		}

		return FAILURE;
	}
	
	public String executeSP(String spName , Object[] params){

		Session session = null;

		try {

			if(spName == null || params == null){
				return "NULL VALUE NOT ACCEPTED";
			}

			session = HibernateUtils.getSessionFactory().openSession();

			Query query = session.createSQLQuery(spName);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
			
			query.executeUpdate();

			return SUCCESS;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( session != null)
				session.close();
		}

		return FAILURE;
	}
	
	
	
}
