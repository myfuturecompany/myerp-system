package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the purchase_summary database table.
 * 
 */
@Entity
@Table(name="purchase_summary")
@NamedQuery(name="PurchaseSummary.findAll", query="SELECT p FROM PurchaseSummary p")
public class PurchaseSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="invoice_no")
	private String invoiceNo;

	@Column(name="invoice_type")
	private String invoiceType;

	@Column(name="total_particulars")
	private int totalParticulars;

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
	@JoinColumn(name="location_cd")
	private LocationMaster locationMaster;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetail userDetail;

	//bi-directional many-to-one association to PurchaseTransaction
	@OneToMany(mappedBy="purchaseSummary")
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