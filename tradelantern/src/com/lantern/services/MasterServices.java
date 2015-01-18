package com.lantern.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.json.JSONArray;

import com.lantern.beans.CustomerMaster;
import com.lantern.beans.ItemMaster;
import com.lantern.beans.LocationMaster;
import com.lantern.beans.RoleMaster;
import com.lantern.impls.FindImpl;
import com.lantern.impls.SaveImpl;
import com.lantern.utils.Status.ITEM;
import com.lantern.utils.Status.LOCATION;

public class MasterServices {


	public String findAllRoles(){
		FindImpl impl = new FindImpl();	
		List<RoleMaster> roles = impl.findAllRoles();

		return null;
	}
	
	public String findRoleById(int id){
		FindImpl impl = new FindImpl();	
		RoleMaster role = impl.findRoleById(id);

		return null;
	}

	public String saveNewRole(RoleMaster role){
		SaveImpl impl = new SaveImpl();

		String result = impl.save(role);
		return result;
	}

	public String updateRole(RoleMaster role){
		SaveImpl impl = new SaveImpl();

		String result = impl.update(role);
		return result;
	}

	public String findAllCustomers(){
		FindImpl impl = new FindImpl();	
		List<CustomerMaster> customers = impl.findAllCustomers();
		
		JSONArray customerList = new JSONArray();
		
		for ( CustomerMaster customer : customers) {
			JSONArray cust = new JSONArray();
			
			cust.put( customer.getId() );
			cust.put( customer.getCustomerName());
			cust.put( customer.getContactNumber() );
			cust.put( customer.getEmail() );
			cust.put( customer.getAddress() );
			cust.put( customer.getStatusMaster().getName() );
			customerList.put(cust);
			
		}
		
		return customerList.toString();
		
	}

	public String findCustomerById(int id){
		FindImpl impl = new FindImpl();	
		CustomerMaster customer = impl.findCustomerById(id);

		return null;
	}

	public String saveNewCustomer(CustomerMaster customer){
		SaveImpl impl = new SaveImpl();

		String result = impl.save(customer);
		return result;
	}

	public String updateCustomer(CustomerMaster customer){
		SaveImpl impl = new SaveImpl();

		String result = impl.update(customer);
		return result;
	}



	public String findAllItems(){
		FindImpl impl = new FindImpl();	
		List<ItemMaster> items = impl.findAllItems();

		
		JSONArray itemList = new JSONArray();
		
		for ( ItemMaster item : items) {
			JSONArray itm = new JSONArray();
			
			itm.put( item.getId() );
			itm.put( item.getBarcode() );
			itm.put( item.getItemCode() );
			itm.put( item.getItemName() );
			itm.put( item.getUom() );
			itm.put( item.getStatusMaster().getName() );
			itemList.put(itm);
			
		}
		
		return itemList.toString();
	}

	public String findItemById(int id){
		FindImpl impl = new FindImpl();	
		ItemMaster item = impl.findItemById(id);

		return null;
	}

	public String saveNewItem(ItemMaster item){
		try {
			SaveImpl impl = new SaveImpl();

			Object[] params = {"TEST" ,  "ITS WORKING"};
			impl.executeSP("SOMETHING", params);
			
			
			item.setBarcode( item.getItemName().substring(0, 1) + new Date().getTime() + item.getItemCode().charAt(0));
			item.setStatusMaster( ITEM.ACTIVE.getStatus() );
			
			String result = impl.save(item);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String updateItem(ItemMaster item){
		SaveImpl impl = new SaveImpl();

		String result = impl.update(item);
		return result;
	}

	public String findAllLocation(){
		FindImpl impl = new FindImpl();	
		List<LocationMaster> locations = impl.findAllLocation();

		
		JSONArray locList = new JSONArray();
		
		for ( LocationMaster location : locations) {
			JSONArray loc = new JSONArray();
			
			loc.put( location.getId() );
			loc.put( location.getSystemId() );
			loc.put( location.getLocationName() );
			loc.put( location.getAddress() );
			loc.put( location.getCity() );
			loc.put( location.getState() );
			loc.put( location.getCountry() );
			loc.put( location.getZip() );
			loc.put( location.getStatusMaster().getName() );
			locList.put(loc);
			
		}
		
		
		return locList.toString();
	}

	public String findLocationById(int id){
		FindImpl impl = new FindImpl();	
		LocationMaster location = impl.findLocationById(id);

		return null;
	}

	public String saveNewLocation(LocationMaster location){
		try {
			SaveImpl saveImpl = new SaveImpl();
			location.setStatusMaster( LOCATION.ACTIVE.getStatus() );
			String result = saveImpl.save(location);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String updateLocation(LocationMaster location){
		SaveImpl impl = new SaveImpl();

		String result = impl.update(location);
		return result;
	}
	
	

}
