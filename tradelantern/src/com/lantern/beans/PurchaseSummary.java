package com.lantern.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PurchaseSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	private String invoiceNo;

	private String invoiceType;

	private int totalParticulars;

	private BigDecimal totalPriceAfterDisc;

	private BigDecimal totalPriceBeforeDisc;

	private Date transactionDate;

	private CustomerMaster customerMaster;

	private LocationMaster locationMaster;

	private StatusMaster statusMaster;

	private UserDetail userDetail;

	private List<PurchaseTransaction> purchaseTransactions;

	public PurchaseSummary() {
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

	public int getTotalParticulars() {
		return this.totalParticulars;
	}

	public void setTotalParticulars(int totalParticulars) {
		this.totalParticulars = totalParticulars;
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

	public StatusMaster getStatusMaster() {
		return this.statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<PurchaseTransaction> getPurchaseTransactions() {
		return this.purchaseTransactions;
	}

	public void setPurchaseTransactions(List<PurchaseTransaction> purchaseTransactions) {
		this.purchaseTransactions = purchaseTransactions;
	}

	public PurchaseTransaction addPurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		getPurchaseTransactions().add(purchaseTransaction);
		purchaseTransaction.setPurchaseSummary(this);

		return purchaseTransaction;
	}

	public PurchaseTransaction removePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		getPurchaseTransactions().remove(purchaseTransaction);
		purchaseTransaction.setPurchaseSummary(null);

		return purchaseTransaction;
	}

}