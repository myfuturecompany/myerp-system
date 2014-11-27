package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the stock_transaction database table.
 * 
 */
@Entity
@Table(name="stock_transaction")
@NamedQuery(name="StockTransaction.findAll", query="SELECT s FROM StockTransaction s")
public class StockTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="available_qty")
	private BigDecimal availableQty;

	@Column(name="invoice_no")
	private String invoiceNo;

	@Column(name="invoice_type")
	private String invoiceType;

	@Column(name="trans_qty")
	private BigDecimal transQty;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_date")
	private Date transactionDate;

	//bi-directional many-to-one association to ItemMaster
	@ManyToOne
	@JoinColumn(name="item")
	private ItemMaster itemMaster;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetail userDetail;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="location_id")
	private LocationMaster locationMaster;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	public StockTransaction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAvailableQty() {
		return this.availableQty;
	}

	public void setAvailableQty(BigDecimal availableQty) {
		this.availableQty = availableQty;
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

	public BigDecimal getTransQty() {
		return this.transQty;
	}

	public void setTransQty(BigDecimal transQty) {
		this.transQty = transQty;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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

}