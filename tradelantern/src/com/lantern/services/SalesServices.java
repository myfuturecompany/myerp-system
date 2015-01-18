package com.lantern.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;

import com.lantern.beans.SellSummary;
import com.lantern.beans.SellTransaction;
import com.lantern.beans.StatusMaster;
import com.lantern.impls.FindImpl;
import com.lantern.impls.SaveImpl;
import com.lantern.utils.Status.SELL;


public class SalesServices {

	public String findItemList(){

		FindImpl impl = new FindImpl();
		List<Object[]> itemList = impl.findItemList();

		JSONArray arr = new JSONArray(itemList);
		return arr.toString();

	}

	public String findInvoiceNumber(){

		int location = 2 ; 

		FindImpl impl = new FindImpl();
		Object maxInvoice = impl.findMaxSellNumberByLocation(location);

		if(maxInvoice == null){
			Date date = new Date();
			SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
			return "S"+dt.format(date)+"L"+location+"-0";
		}
		return maxInvoice.toString().split("-")[0] + "-"+ (Integer.parseInt(maxInvoice.toString().split("-")[1]) + 1);
	}
	
	
	
	public String saveSell(String[][] Sell , String[] summary , String invoiceNumber){
		
		Date date = new Date();
		
		FindImpl findImpl = new FindImpl();
		SaveImpl saveImpl = new SaveImpl();
		
		StatusMaster status = findImpl.findStatusById(SELL.ACTIVE.getId());
		
		
		SellSummary sellSummary = new SellSummary();
		sellSummary.setInvoiceNo(invoiceNumber);
		sellSummary.setInvoiceType("Sell");
		sellSummary.setTotalParticular( Integer.parseInt(summary[0]));
		sellSummary.setTotalPriceBeforeDisc(new BigDecimal(summary[1]));
		sellSummary.setTotalPriceAfterDisc(new BigDecimal(summary[3]));
		
		sellSummary.setTransactionDate(date);
		sellSummary.setStatusMaster( status );
		
		sellSummary.setLocationMaster(findImpl.findLocationById(2));
		
		saveImpl.save(sellSummary);
		
		SellTransaction transaction = null;
		for (int i = 0; i < Sell.length; i++) {
			transaction = new SellTransaction();
			
			transaction.setId(invoiceNumber+"_"+UUID.randomUUID().toString().substring(1, 6));
			
			transaction.setItemMaster( findImpl.findItemByCodeAndName(Sell[i][0], Sell[i][1]) );
			transaction.setSellQty(  new BigDecimal(Sell[i][2]) );
			transaction.setUnitPrice( new BigDecimal(Sell[i][4]) );
			transaction.setNetPrice( new BigDecimal(Sell[i][5]) );
			
			transaction.setTransactionDate(date);
			transaction.setStatusMaster( status );
			
			transaction.setSellSummary(findImpl.findSellSummartByInvoiceAndDate(invoiceNumber, date) );
			
			saveImpl.save(transaction);
			transaction = null;
		}
		
		
		sellSummary = null;
		return null;
	}
	
	
}
