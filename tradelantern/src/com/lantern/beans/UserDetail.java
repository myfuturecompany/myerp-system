package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_details database table.
 * 
 */
@Entity
@Table(name="user_details")
@NamedQuery(name="UserDetail.findAll", query="SELECT u FROM UserDetail u")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Column(name="contact_no")
	private String contactNo;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	private String email;

	@Column(name="location_cd")
	private String locationCd;

	private String name;

	private int role;

	private int status;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	//bi-directional many-to-one association to PurchaseSummary
	@OneToMany(mappedBy="userDetail")
	private List<PurchaseSummary> purchaseSummaries;

	//bi-directional many-to-one association to PurchaseTransaction
	@OneToMany(mappedBy="userDetail")
	private List<PurchaseTransaction> purchaseTransactions;

	//bi-directional many-to-one association to SellSummary
	@OneToMany(mappedBy="userDetail")
	private List<SellSummary> sellSummaries;

	//bi-directional many-to-one association to SellTransaction
	@OneToMany(mappedBy="userDetail")
	private List<SellTransaction> sellTransactions;

	//bi-directional many-to-one association to StSummary
	@OneToMany(mappedBy="userDetail")
	private List<StSummary> stSummaries;

	//bi-directional many-to-one association to StTransaction
	@OneToMany(mappedBy="userDetail")
	private List<StTransaction> stTransactions;

	//bi-directional many-to-one association to StockTransaction
	@OneToMany(mappedBy="userDetail")
	private List<StockTransaction> stockTransactions;

	public UserDetail() {
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

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocationCd() {
		return this.locationCd;
	}

	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<PurchaseSummary> getPurchaseSummaries() {
		return this.purchaseSummaries;
	}

	public void setPurchaseSummaries(List<PurchaseSummary> purchaseSummaries) {
		this.purchaseSummaries = purchaseSummaries;
	}

	public PurchaseSummary addPurchaseSummary(PurchaseSummary purchaseSummary) {
		getPurchaseSummaries().add(purchaseSummary);
		purchaseSummary.setUserDetail(this);

		return purchaseSummary;
	}

	public PurchaseSummary removePurchaseSummary(PurchaseSummary purchaseSummary) {
		getPurchaseSummaries().remove(purchaseSummary);
		purchaseSummary.setUserDetail(null);

		return purchaseSummary;
	}

	public List<PurchaseTransaction> getPurchaseTransactions() {
		return this.purchaseTransactions;
	}

	public void setPurchaseTransactions(List<PurchaseTransaction> purchaseTransactions) {
		this.purchaseTransactions = purchaseTransactions;
	}

	public PurchaseTransaction addPurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		getPurchaseTransactions().add(purchaseTransaction);
		purchaseTransaction.setUserDetail(this);

		return purchaseTransaction;
	}

	public PurchaseTransaction removePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		getPurchaseTransactions().remove(purchaseTransaction);
		purchaseTransaction.setUserDetail(null);

		return purchaseTransaction;
	}

	public List<SellSummary> getSellSummaries() {
		return this.sellSummaries;
	}

	public void setSellSummaries(List<SellSummary> sellSummaries) {
		this.sellSummaries = sellSummaries;
	}

	public SellSummary addSellSummary(SellSummary sellSummary) {
		getSellSummaries().add(sellSummary);
		sellSummary.setUserDetail(this);

		return sellSummary;
	}

	public SellSummary removeSellSummary(SellSummary sellSummary) {
		getSellSummaries().remove(sellSummary);
		sellSummary.setUserDetail(null);

		return sellSummary;
	}

	public List<SellTransaction> getSellTransactions() {
		return this.sellTransactions;
	}

	public void setSellTransactions(List<SellTransaction> sellTransactions) {
		this.sellTransactions = sellTransactions;
	}

	public SellTransaction addSellTransaction(SellTransaction sellTransaction) {
		getSellTransactions().add(sellTransaction);
		sellTransaction.setUserDetail(this);

		return sellTransaction;
	}

	public SellTransaction removeSellTransaction(SellTransaction sellTransaction) {
		getSellTransactions().remove(sellTransaction);
		sellTransaction.setUserDetail(null);

		return sellTransaction;
	}

	public List<StSummary> getStSummaries() {
		return this.stSummaries;
	}

	public void setStSummaries(List<StSummary> stSummaries) {
		this.stSummaries = stSummaries;
	}

	public StSummary addStSummary(StSummary stSummary) {
		getStSummaries().add(stSummary);
		stSummary.setUserDetail(this);

		return stSummary;
	}

	public StSummary removeStSummary(StSummary stSummary) {
		getStSummaries().remove(stSummary);
		stSummary.setUserDetail(null);

		return stSummary;
	}

	public List<StTransaction> getStTransactions() {
		return this.stTransactions;
	}

	public void setStTransactions(List<StTransaction> stTransactions) {
		this.stTransactions = stTransactions;
	}

	public StTransaction addStTransaction(StTransaction stTransaction) {
		getStTransactions().add(stTransaction);
		stTransaction.setUserDetail(this);

		return stTransaction;
	}

	public StTransaction removeStTransaction(StTransaction stTransaction) {
		getStTransactions().remove(stTransaction);
		stTransaction.setUserDetail(null);

		return stTransaction;
	}

	public List<StockTransaction> getStockTransactions() {
		return this.stockTransactions;
	}

	public void setStockTransactions(List<StockTransaction> stockTransactions) {
		this.stockTransactions = stockTransactions;
	}

	public StockTransaction addStockTransaction(StockTransaction stockTransaction) {
		getStockTransactions().add(stockTransaction);
		stockTransaction.setUserDetail(this);

		return stockTransaction;
	}

	public StockTransaction removeStockTransaction(StockTransaction stockTransaction) {
		getStockTransactions().remove(stockTransaction);
		stockTransaction.setUserDetail(null);

		return stockTransaction;
	}

}