package com.lantern.impls;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lantern.beans.CustomerMaster;
import com.lantern.beans.ItemMaster;
import com.lantern.beans.LocationMaster;
import com.lantern.beans.RoleMaster;

public class FindImpl {

	private SessionFactory factory = null;
	private Session session = null;
	private Configuration cfg  = null;

	
	public List findAllObject(Class obj ) {

		try {
			openConnection();
			Criteria criteria = session.createCriteria(obj);
			List list = criteria.list();
			return list;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return null;
	}

	public List<RoleMaster> findAllRoles() {

		try {
			openConnection();
			Criteria criteria = session.createCriteria(RoleMaster.class);
			List<RoleMaster> list = criteria.list();
			return list;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return null;

	}

	public RoleMaster findRoleById(int id) {
		
		try {
			openConnection();
			session.beginTransaction();
			RoleMaster role = (RoleMaster) session.get(RoleMaster.class, id);
			return role;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	public List<CustomerMaster> findAllCustomers() {
		try {
			openConnection();
			Criteria criteria = session.createCriteria(CustomerMaster.class);
			List<CustomerMaster> list = criteria.list();
			return list;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return null;
	}

	public CustomerMaster findCustomerById(int id) {
		try {
			openConnection();
			session.beginTransaction();
			CustomerMaster customer = (CustomerMaster) session.get(CustomerMaster.class, id);
			return customer;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	public List<ItemMaster> findAllItems() {
		try {
			openConnection();
			Criteria criteria = session.createCriteria(ItemMaster.class);
			List<ItemMaster> list = criteria.list();
			return list;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return null;
	}

	public ItemMaster findItemById(int id) {
		try {
			openConnection();
			session.beginTransaction();
			ItemMaster item = (ItemMaster) session.get(ItemMaster.class, id);
			return item;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	public List<LocationMaster> findAllLocation() {
		try {
			openConnection();
			Criteria criteria = session.createCriteria(LocationMaster.class);
			List<LocationMaster> list = criteria.list();
			return list;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return null;
	}

	public LocationMaster findLocationById(int id) {
		try {
			openConnection();
			session.beginTransaction();
			LocationMaster location = (LocationMaster) session.get(LocationMaster.class, id);
			return location;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}
	
	private void openConnection(){
		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		factory = cfg.buildSessionFactory();
		session = factory.openSession();
	}

	private void closeConnection(){
		if(session != null)
			session.close();
		if(factory != null)
			factory.close();
	}

}
