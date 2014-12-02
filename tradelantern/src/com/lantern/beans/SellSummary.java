package com.lantern.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sell_summary database table.
 * 
 */
public class SellSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	private String invoiceNo;

	private String invoiceType;

	private int totalParticular;

	private BigDecimal totalPriceAfterDisc;

	private BigDecimal totalPriceBeforeDisc;

	private Date transactionDate;

	private CustomerMaster customerMaster;

	private LocationMaster locationMaster;

	private StatusMaster statusMaster1;

	private StatusMaster statusMaster2;

	private UserDetail userDetail;

	private List<SellTransaction> sellTransactions;

	public SellSummary() {
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public int getTotalParticular() {
		return this.totalParticular;
	}

	public void setTotalParticular(int totalParticular) {
		this.totalParticular = totalParticular;
	}

	public BigDecimal getTotalPriceAfterDisc() {
		return this.totalPriceAfterDisc;
	}

	public void setTotalPriceAfterDisc(BigDecimal totalPriceAfterDisc) {
		this.totalPriceAfterDisc = totalPriceAfterDisc;
	}

	public BigDecimal getTotalPriceBeforeDisc() {
		return this.totalPriceBeforeDisc;
	}

	public void setTotalPriceBeforeDisc(BigDecimal totalPriceBeforeDisc) {
		this.totalPriceBeforeDisc = totalPriceBeforeDisc;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public CustomerMaster getCustomerMaster() {
		return this.customerMaster;
	}

	public void setCustomerMaster(CustomerMaster customerMaster) {
		this.customerMaster = customerMaster;
	}

	public LocationMaster getLocationMaster() {
		return this.locationMaster;
	}

	public void setLocationMaster(LocationMaster locationMaster) {
		this.locationMaster = locationMaster;
	}

	public StatusMaster getStatusMaster1() {
		return this.statusMaster1;
	}

	public void setStatusMaster1(StatusMaster statusMaster1) {
		this.statusMaster1 = statusMaster1;
	}

	public StatusMaster getStatusMaster2() {
		return this.statusMaster2;
	}

	public void setStatusMaster2(StatusMaster statusMaster2) {
		this.statusMaster2 = statusMaster2;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<SellTransaction> getSellTransactions() {
		return this.sellTransactions;
	}

	public void setSellTransactions(List<SellTransaction> sellTransactions) {
		this.sellTransactions = sellTransactions;
	}

	public SellTransaction addSellTransaction(SellTransaction sellTransaction) {
		getSellTransactions().add(sellTransaction);
		sellTransaction.setSellSummary(this);

		return sellTransaction;
	}

	public SellTransaction removeSellTransaction(SellTransaction sellTransaction) {
		getSellTransactions().remove(sellTransaction);
		sellTransaction.setSellSummary(null);

		return sellTransaction;
	}

}