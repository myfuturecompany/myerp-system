package com.lantern.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the st_summary database table.
 * 
 */
public class StSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	private String invoiceNo;

	private int totalParticular;

	private Date transactionDate;

	private LocationMaster locationMaster1;

	private StatusMaster statusMaster;

	private LocationMaster locationMaster2;

	private UserDetail userDetail;

	private List<StTransaction> stTransactions;

	public StSummary() {
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getTotalParticular() {
		return this.totalParticular;
	}

	public void setTotalParticular(int totalParticular) {
		this.totalParticular = totalParticular;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocationMaster getLocationMaster1() {
		return this.locationMaster1;
	}

	public void setLocationMaster1(LocationMaster locationMaster1) {
		this.locationMaster1 = locationMaster1;
	}

	public StatusMaster getStatusMaster() {
		return this.statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}

	public LocationMaster getLocationMaster2() {
		return this.locationMaster2;
	}

	public void setLocationMaster2(LocationMaster locationMaster2) {
		this.locationMaster2 = locationMaster2;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<StTransaction> getStTransactions() {
		return this.stTransactions;
	}

	public void setStTransactions(List<StTransaction> stTransactions) {
		this.stTransactions = stTransactions;
	}

	public StTransaction addStTransaction(StTransaction stTransaction) {
		getStTransactions().add(stTransaction);
		stTransaction.setStSummary(this);

		return stTransaction;
	}

	public StTransaction removeStTransaction(StTransaction stTransaction) {
		getStTransactions().remove(stTransaction);
		stTransaction.setStSummary(null);

		return stTransaction;
	}

}