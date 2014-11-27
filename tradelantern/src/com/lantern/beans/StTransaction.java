package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the st_transaction database table.
 * 
 */
@Entity
@Table(name="st_transaction")
@NamedQuery(name="StTransaction.findAll", query="SELECT s FROM StTransaction s")
public class StTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="st_qty")
	private BigDecimal stQty;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_date")
	private Date transactionDate;

	//bi-directional many-to-one association to StSummary
	@ManyToOne
	@JoinColumn(name="invoice_no")
	private StSummary stSummary;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetail userDetail;

	//bi-directional many-to-one association to ItemMaster
	@ManyToOne
	@JoinColumn(name="item")
	private ItemMaster itemMaster;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	public StTransaction() {
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