package com.lantern.services;

import java.util.List;

import org.json.JSONArray;

import com.lantern.impls.FindImpl;


public class PurchaseServices {

	public String findItemList(){
		
		FindImpl impl = new FindImpl();
		List<Object[]> itemList = impl.findItemList();
		
		JSONArray arr = new JSONArray(itemList);
		return arr.toString();
		
	}
	
	
	
	
}
