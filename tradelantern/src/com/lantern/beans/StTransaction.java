package com.lantern.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the st_transaction database table.
 * 
 */
public class StTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private BigDecimal stQty;

	private Date transactionDate;

	private StSummary stSummary;

	private UserDetail userDetail;

	private ItemMaster itemMaster;

	private StatusMaster statusMaster;

	public StTransaction() {
	}

	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public BigDecimal getStQty() {
		return this.stQty;
	}

	public void setStQty(BigDecimal stQty) {
		this.stQty = stQty;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public StSummary getStSummary() {
		return this.stSummary;
	}

	public void setStSummary(StSummary stSummary) {
		this.stSummary = stSummary;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public ItemMaster getItemMaster() {
		return this.itemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}

	public StatusMaster getStatusMaster() {
		return this.statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}

}