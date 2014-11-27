package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer_master database table.
 * 
 */
@Entity
@Table(name="customer_master")
@NamedQuery(name="CustomerMaster.findAll", query="SELECT c FROM CustomerMaster c")
public class CustomerMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Column(name="contact_number")
	private String contactNumber;

	@Column(name="customer_name")
	private String customerName;

	private String email;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to PurchaseSummary
	@OneToMany(mappedBy="customerMaster")
	private List<PurchaseSummary> purchaseSummaries;

	//bi-directional many-to-one association to SellSummary
	@OneToMany(mappedBy="customerMaster")
	private List<SellSummary> sellSummaries;

	public CustomerMaster() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StatusMaster getStatusMaster() {
		return this.statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}

	public List<PurchaseSummary> getPurchaseSummaries() {
		return this.purchaseSummaries;
	}

	public void setPurchaseSummaries(List<PurchaseSummary> purchaseSummaries) {
		this.purchaseSummaries = purchaseSummaries;
	}

	public PurchaseSummary addPurchaseSummary(PurchaseSummary purchaseSummary) {
		getPurchaseSummaries().add(purchaseSummary);
		purchaseSummary.setCustomerMaster(this);

		return purchaseSummary;
	}

	public PurchaseSummary removePurchaseSummary(PurchaseSummary purchaseSummary) {
		getPurchaseSummaries().remove(purchaseSummary);
		purchaseSummary.setCustomerMaster(null);

		return purchaseSummary;
	}

	public List<SellSummary> getSellSummaries() {
		return this.sellSummaries;
	}

	public void setSellSummaries(List<SellSummary> sellSummaries) {
		this.sellSummaries = sellSummaries;
	}

	public SellSummary addSellSummary(SellSummary sellSummary) {
		getSellSummaries().add(sellSummary);
		sellSummary.setCustomerMaster(this);

		return sellSummary;
	}

	public SellSummary removeSellSummary(SellSummary sellSummary) {
		getSellSummaries().remove(sellSummary);
		sellSummary.setCustomerMaster(null);

		return sellSummary;
	}

}