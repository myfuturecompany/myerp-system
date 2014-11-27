package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the sell_transaction database table.
 * 
 */
@Entity
@Table(name="sell_transaction")
@NamedQuery(name="SellTransaction.findAll", query="SELECT s FROM SellTransaction s")
public class SellTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="net_price")
	private BigDecimal netPrice;

	@Column(name="sell_qty")
	private BigDecimal sellQty;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_date")
	private Date transactionDate;

	@Column(name="unit_price")
	private BigDecimal unitPrice;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to SellSummary
	@ManyToOne
	@JoinColumn(name="invoice_no")
	private SellSummary sellSummary;

	//bi-directional many-to-one association to ItemMaster
	@ManyToOne
	@JoinColumn(name="item")
	private ItemMaster itemMaster;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="location_id")
	private LocationMaster locationMaster;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetail userDetail;

	public SellTransaction() {
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