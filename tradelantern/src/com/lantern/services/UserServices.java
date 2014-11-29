package com.lantern.services;

import com.lantern.beans.UserDetail;
import com.lantern.impls.SaveImpl;

public class UserServices {

	public String saveUser(UserDetail user){
		
		SaveImpl impl = new SaveImpl();
		String result = impl.save(user);
		
		return result;
	}
	
	public String updateUser(UserDetail user){
		
		SaveImpl impl = new SaveImpl();
		String result = impl.update(user);
		
		return result;
	}
	
	
	
	
	
}
