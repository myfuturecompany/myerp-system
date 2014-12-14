package com.lantern.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory = null;

	public static SessionFactory getSessionFactory(){
		if(factory == null){
			try{
				factory = new Configuration().configure().buildSessionFactory();
			}catch (Exception ex) { 
				ex.printStackTrace();
			}
		}
		return factory;
	}
}
