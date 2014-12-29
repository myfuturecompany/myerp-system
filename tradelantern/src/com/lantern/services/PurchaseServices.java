package com.lantern.services;

import java.text.SimpleDateFormat;
import java.util.Date;
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

	public String findInvoiceNumber(){

		int location = 0 ; 

		FindImpl impl = new FindImpl();
		Object maxInvoice = impl.findMaxPurchaseNumberByLocation(location);

		if(maxInvoice == null){
			Date date = new Date();
			SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
			return "P"+dt.format(date)+"L"+location+"-0";
		}
		return maxInvoice.toString().split("-")[0] +  (Integer.parseInt(maxInvoice.toString().split("-")[0]) + 1);
	}
}
