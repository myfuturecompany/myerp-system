package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the purchase_transaction database table.
 * 
 */
@Entity
@Table(name="purchase_transaction")
@NamedQuery(name="PurchaseTransaction.findAll", query="SELECT p FROM PurchaseTransaction p")
public class PurchaseTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="net_price")
	private BigDecimal netPrice;

	@Column(name="purchase_qty")
	private BigDecimal purchaseQty;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_date")
	private Date transactionDate;

	@Column(name="unit_price")
	private BigDecimal unitPrice;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to PurchaseSummary
	@ManyToOne
	@JoinColumn(name="invoice_no")
	private PurchaseSummary purchaseSummary;

	//bi-directional many-to-one association to ItemMaster
	@ManyToOne
	@JoinColumn(name="item")
	private ItemMaster itemMaster;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetail userDetail;

	public PurchaseTransaction() {
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

	public PurchaseSummary getPurchaseSummary() {
		return this.purchaseSummary;
	}

	public void setPurchaseSummary(PurchaseSummary purchaseSummary) {
		this.purchaseSummary = purchaseSummary;
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