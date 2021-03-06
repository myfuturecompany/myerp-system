package com.lantern.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the purchase_transaction database table.
 * 
 */
public class PurchaseTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private PurchaseSummary invoiceNumber;
	
	private BigDecimal netPrice;

	private BigDecimal purchaseQty;

	private Date transactionDate;

	private BigDecimal unitPrice;

	private StatusMaster statusMaster;

	private ItemMaster itemMaster;

	private UserDetail userDetail;

	public PurchaseTransaction() {
	}

	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public PurchaseSummary getInvoiceNumber() {
		return invoiceNumber;
	}



	public void setInvoiceNumber(PurchaseSummary invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}



	public BigDecimal getNetPrice() {
		return this.netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public BigDecimal getPurchaseQty() {
		return this.purchaseQty;
	}

	public void setPurchaseQty(BigDecimal purchaseQty) {
		this.purchaseQty = purchaseQty;
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

	

	public ItemMaster getItemMaster() {
		return this.itemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}