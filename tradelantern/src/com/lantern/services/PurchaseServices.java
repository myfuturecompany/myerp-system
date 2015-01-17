package com.lantern.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;

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
		
		saveImpl.save(purchaseSummary);
		
		PurchaseTransaction transaction = null;
		for (int i = 0; i < purchase.length; i++) {
			transaction = new PurchaseTransaction();
			transaction.setItemMaster( findImpl.findItemByCodeAndName(purchase[i][0], purchase[i][1]) );
			transaction.setPurchaseQty(  new BigDecimal(purchase[i][2]) );
			transaction.setUnitPrice( new BigDecimal(purchase[i][4]) );
			transaction.setNetPrice( new BigDecimal(purchase[i][5]) );
			
			transaction.setTransactionDate(date);
			transaction.setStatusMaster( status );
			
			transaction.setInvoiceNumber(invoiceNumber);
			
			transaction.setPurchaseSummary( findImpl.findPurchaseSummartByInvoiceAndDate(invoiceNumber, date) );
			
			saveImpl.save(transaction);
			transaction = null;
		}
		
		
		purchaseSummary = null;
		return null;
	}
	
	
}
