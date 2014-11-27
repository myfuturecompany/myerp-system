package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location_master database table.
 * 
 */
@Entity
@Table(name="location_master")
@NamedQuery(name="LocationMaster.findAll", query="SELECT l FROM LocationMaster l")
public class LocationMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	private String city;

	private String country;

	@Column(name="location_name")
	private String locationName;

	private String state;

	@Column(name="system_id")
	private String systemId;

	private int zip;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to PurchaseSummary
	@OneToMany(mappedBy="locationMaster")
	private List<PurchaseSummary> purchaseSummaries;

	//bi-directional many-to-one association to SellSummary
	@OneToMany(mappedBy="locationMaster")
	private List<SellSummary> sellSummaries;

	//bi-directional many-to-one association to SellTransaction
	@OneToMany(mappedBy="locationMaster")
	private List<SellTransaction> sellTransactions;

	//bi-directional many-to-one association to StSummary
	@OneToMany(mappedBy="locationMaster1")
	private List<StSummary> stSummaries1;

	//bi-directional many-to-one association to StSummary
	@OneToMany(mappedBy="locationMaster2")
	private List<StSummary> stSummaries2;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="locationMaster")
	private List<Stock> stocks;

	//bi-directional many-to-one association to StockTransaction
	@OneToMany(mappedBy="locationMaster")
	private List<StockTransaction> stockTransactions;

	public LocationMaster() {
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSystemId() {
		return this.systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
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
		purchaseSummary.setLocationMaster(this);

		return purchaseSummary;
	}

	public PurchaseSummary removePurchaseSummary(PurchaseSummary purchaseSummary) {
		getPurchaseSummaries().remove(purchaseSummary);
		purchaseSummary.setLocationMaster(null);

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
		sellSummary.setLocationMaster(this);

		return sellSummary;
	}

	public SellSummary removeSellSummary(SellSummary sellSummary) {
		getSellSummaries().remove(sellSummary);
		sellSummary.setLocationMaster(null);

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
		sellTransaction.setLocationMaster(this);

		return sellTransaction;
	}

	public SellTransaction removeSellTransaction(SellTransaction sellTransaction) {
		getSellTransactions().remove(sellTransaction);
		sellTransaction.setLocationMaster(null);

		return sellTransaction;
	}

	public List<StSummary> getStSummaries1() {
		return this.stSummaries1;
	}

	public void setStSummaries1(List<StSummary> stSummaries1) {
		this.stSummaries1 = stSummaries1;
	}

	public StSummary addStSummaries1(StSummary stSummaries1) {
		getStSummaries1().add(stSummaries1);
		stSummaries1.setLocationMaster1(this);

		return stSummaries1;
	}

	public StSummary removeStSummaries1(StSummary stSummaries1) {
		getStSummaries1().remove(stSummaries1);
		stSummaries1.setLocationMaster1(null);

		return stSummaries1;
	}

	public List<StSummary> getStSummaries2() {
		return this.stSummaries2;
	}

	public void setStSummaries2(List<StSummary> stSummaries2) {
		this.stSummaries2 = stSummaries2;
	}

	public StSummary addStSummaries2(StSummary stSummaries2) {
		getStSummaries2().add(stSummaries2);
		stSummaries2.setLocationMaster2(this);

		return stSummaries2;
	}

	public StSummary removeStSummaries2(StSummary stSummaries2) {
		getStSummaries2().remove(stSummaries2);
		stSummaries2.setLocationMaster2(null);

		return stSummaries2;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setLocationMaster(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setLocationMaster(null);

		return stock;
	}

	public List<StockTransaction> getStockTransactions() {
		return this.stockTransactions;
	}

	public void setStockTransactions(List<StockTransaction> stockTransactions) {
		this.stockTransactions = stockTransactions;
	}

	public StockTransaction addStockTransaction(StockTransaction stockTransaction) {
		getStockTransactions().add(stockTransaction);
		stockTransaction.setLocationMaster(this);

		return stockTransaction;
	}

	public StockTransaction removeStockTransaction(StockTransaction stockTransaction) {
		getStockTransactions().remove(stockTransaction);
		stockTransaction.setLocationMaster(null);

		return stockTransaction;
	}

}