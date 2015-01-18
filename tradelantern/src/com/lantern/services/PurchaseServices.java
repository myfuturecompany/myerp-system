package com.lantern.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lantern.beans.LocationMaster;
import com.lantern.beans.PurchaseSummary;
import com.lantern.beans.PurchaseTransaction;
import com.lantern.beans.PurchaseSummary;
import com.lantern.beans.PurchaseTransaction;
import com.lantern.beans.StatusMaster;
import com.lantern.impls.FindImpl;
import com.lantern.impls.SaveImpl;
import com.lantern.utils.Status;
import com.lantern.utils.Status.PURCHASE;


public class PurchaseServices {

	public String findItemList(){

		FindImpl impl = new FindImpl();
		List<Object[]> itemList = impl.findItemList();

		JSONArray arr = new JSONArray(itemList);
		return arr.toString();

	}

	public String findInvoiceNumber(){

		int location = 2 ; 

		FindImpl impl = new FindImpl();
		Object maxInvoice = impl.findMaxPurchaseNumberByLocation(location);

		if(maxInvoice == null){
			Date date = new Date();
			SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
			return "P"+dt.format(date)+"L"+location+"-0";
		}
		return maxInvoice.toString().split("-")[0] + "-"+ (Integer.parseInt(maxInvoice.toString().split("-")[1]) + 1);
	}
	
	public String findPurchaseSummaryList(){

		JSONArray arr;
		try {
			FindImpl impl = new FindImpl();
			List<PurchaseSummary> sellList = impl.findPurchaseSummaryList();

			arr = new JSONArray();
			JSONObject object = null;
			for (PurchaseSummary summary : sellList) {
			
				object = new JSONObject();
				object.put("invoiceDate", summary.getTransactionDate());
				object.put("invoiceNumber", summary.getInvoiceNo());
				object.put("totalParticular", summary.getTotalParticulars());
				object.put("netPrice", summary.getTotalPriceBeforeDisc());
				object.put("discount", summary.getTotalPriceBeforeDisc().subtract(summary.getTotalPriceAfterDisc()) );
				object.put("totalSale", summary.getTotalPriceAfterDisc());
				object.put("actionBtn", "<button class='btn btn-sm btn-success' onclick=\"viewDetails('"+summary.getInvoiceNo()+"')\">Details</button>");
				arr.put(object);
				object = null;
			}
			
			sellList = null;
			
			return arr.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	public String findPurchaseTransactionListByInvoice(String invoiceNumber){

		JSONArray arr;
		try {
			FindImpl impl = new FindImpl();
			List<PurchaseTransaction> sellList = impl.findPurchaseTransactionListByInvoice(invoiceNumber);

			arr = new JSONArray();
			
			for (PurchaseTransaction trans : sellList) {
			
				JSONObject object = new JSONObject();
				object.put("itemName", trans.getItemMaster().getItemName() );
				object.put("quantity", trans.getPurchaseQty());
				object.put("uom", trans.getItemMaster().getUom());
				object.put("unitPrice", trans.getUnitPrice());
				object.put("netPrice", trans.getNetPrice() );
				arr.put(object);
			}
			
			sellList = null;
			return arr.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	public String savePurchase(String[][] purchase , String[] summary , String invoiceNumber){
		
		Date date = new Date();
		
		FindImpl findImpl = new FindImpl();
		SaveImpl saveImpl = new SaveImpl();
		
		StatusMaster status = findImpl.findStatusById(PURCHASE.ACTIVE.getId());
		
		
		PurchaseSummary purchaseSummary = new PurchaseSummary();
		purchaseSummary.setInvoiceNo(invoiceNumber);
		purchaseSummary.setInvoiceType("PURCHASE");
		purchaseSummary.setTotalParticulars( Integer.parseInt(summary[0]));
		purchaseSummary.setTotalPriceBeforeDisc(new BigDecimal(summary[1]));
		purchaseSummary.setTotalPriceAfterDisc(new BigDecimal(summary[3]));
		
		purchaseSummary.setTransactionDate(date);
		purchaseSummary.setStatusMaster( status );
		
		purchaseSummary.setLocationMaster(findImpl.findLocationById(2));
		
		saveImpl.save(purchaseSummary);
		
		PurchaseTransaction transaction = null;
		for (int i = 0; i < purchase.length; i++) {
			transaction = new PurchaseTransaction();
			
			transaction.setId(invoiceNumber+"_"+UUID.randomUUID().toString().substring(1, 6));
			
			transaction.setItemMaster( findImpl.findItemByCodeAndName(purchase[i][0], purchase[i][1]) );
			transaction.setPurchaseQty(  new BigDecimal(purchase[i][2]) );
			transaction.setUnitPrice( new BigDecimal(purchase[i][4]) );
			transaction.setNetPrice( new BigDecimal(purchase[i][5]) );
			
			transaction.setTransactionDate(date);
			transaction.setStatusMaster( status );
			
			transaction.setInvoiceNumber( findImpl.findPurchaseSummartByInvoiceAndDate(invoiceNumber, date) );
			
			saveImpl.save(transaction);
			transaction = null;
		}
		
		
		purchaseSummary = null;
		return null;
	}
	
	
}
