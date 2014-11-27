package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sell_summary database table.
 * 
 */
@Entity
@Table(name="sell_summary")
@NamedQuery(name="SellSummary.findAll", query="SELECT s FROM SellSummary s")
public class SellSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="invoice_no")
	private String invoiceNo;

	@Column(name="invoice_type")
	private String invoiceType;

	@Column(name="total_particular")
	private int totalParticular;

	@Column(name="total_price_after_disc")
	private BigDecimal totalPriceAfterDisc;

	@Column(name="total_price_before_disc")
	private BigDecimal totalPriceBeforeDisc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_date")
	private Date transactionDate;

	//bi-directional many-to-one association to CustomerMaster
	@ManyToOne
	@JoinColumn(name="customer_id")
	private CustomerMaster customerMaster;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="location_id")
	private LocationMaster locationMaster;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster1;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster2;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetail userDetail;

	//bi-directional many-to-one association to SellTransaction
	@OneToMany(mappedBy="sellSummary")
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