package com.lantern.services;

import java.util.List;

import com.lantern.beans.CustomerMaster;
import com.lantern.beans.ItemMaster;
import com.lantern.beans.LocationMaster;
import com.lantern.beans.RoleMaster;
import com.lantern.impls.FindImpl;
import com.lantern.impls.SaveImpl;

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

		return null;
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

		return null;
	}

	public String findItemById(int id){
		FindImpl impl = new FindImpl();	
		ItemMaster item = impl.findItemById(id);

		return null;
	}

	public String saveNewItem(ItemMaster item){
		SaveImpl impl = new SaveImpl();

		String result = impl.save(item);
		return result;
	}

	public String updateItem(ItemMaster item){
		SaveImpl impl = new SaveImpl();

		String result = impl.update(item);
		return result;
	}

	public String findAllLocation(){
		FindImpl impl = new FindImpl();	
		List<LocationMaster> locations = impl.findAllLocation();

		return null;
	}

	public String findLocationById(int id){
		FindImpl impl = new FindImpl();	
		LocationMaster location = impl.findLocationById(id);

		return null;
	}

	public String saveNewLocation(LocationMaster location){
		SaveImpl impl = new SaveImpl();

		String result = impl.save(location);
		return result;
	}

	public String updateLocation(LocationMaster location){
		SaveImpl impl = new SaveImpl();

		String result = impl.update(location);
		return result;
	}

}
