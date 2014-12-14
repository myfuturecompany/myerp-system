package com.lantern.impls;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.lantern.beans.CustomerMaster;
import com.lantern.beans.ItemMaster;
import com.lantern.beans.LocationMaster;
import com.lantern.beans.RoleMaster;
import com.lantern.beans.StatusMaster;
import com.lantern.utils.HibernateUtils;
import com.lantern.utils.Status.LOCATION;

public class FindImpl {

	private Session session = null;
	
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
			criteria.add(Restrictions.eq("statusMaster", LOCATION.ACTIVE.getStatus() ));
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
	
	public StatusMaster findStatusById(int id) {
		try {
			openConnection();
			session.beginTransaction();
			StatusMaster status = (StatusMaster) session.get(StatusMaster.class,id);
			return status;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}
	
	private void openConnection(){
		session = HibernateUtils.getSessionFactory().openSession();
	}

	private void closeConnection(){
		if(session != null)
			session.close();
	}

	public List<Object[]> findItemList() {
		try {
			
			openConnection();
			session.beginTransaction();
			Query query = session.createQuery("SELECT I.itemCode, I.itemName,  S.availableQty, I.uom , S.purchasePrice FROM ItemMaster I LEFT JOIN I.stocks S");
			List<Object[]> results = query.list();
			return results;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	

}
