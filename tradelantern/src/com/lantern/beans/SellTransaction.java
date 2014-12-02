package com.lantern.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the sell_transaction database table.
 * 
 */
public class SellTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private BigDecimal netPrice;

	private BigDecimal sellQty;

	private Date transactionDate;

	private BigDecimal unitPrice;

	private StatusMaster statusMaster;

	private SellSummary sellSummary;

	private ItemMaster itemMaster;

	private LocationMaster locationMaster;

	private UserDetail userDetail;

	public SellTransaction() {
	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public BigDecimal getNetPrice() {
		return this.netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public BigDecimal getSellQty() {
		return this.sellQty;
	}

	public void setSellQty(BigDecimal sellQty) {
		this.sellQty = sellQty;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public StatusMaster getStatusMaster() {
		return this.statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}

	public SellSummary getSellSummary() {
		return this.sellSummary;
	}

	public void setSellSummary(SellSummary sellSummary) {
		this.sellSummary = sellSummary;
	}

	public ItemMaster getItemMaster() {
		return this.itemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}

	public LocationMaster getLocationMaster() {
		return this.locationMaster;
	}

	public void setLocationMaster(LocationMaster locationMaster) {
		this.locationMaster = locationMaster;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}