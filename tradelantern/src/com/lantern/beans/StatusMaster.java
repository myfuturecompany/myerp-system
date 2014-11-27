package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status_master database table.
 * 
 */
@Entity
@Table(name="status_master")
@NamedQuery(name="StatusMaster.findAll", query="SELECT s FROM StatusMaster s")
public class StatusMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	private String type;

	//bi-directional many-to-one association to CustomerMaster
	@OneToMany(mappedBy="statusMaster")
	private List<CustomerMaster> customerMasters;

	//bi-directional many-to-one association to ItemMaster
	@OneToMany(mappedBy="statusMaster")
	private List<ItemMaster> itemMasters;

	//bi-directional many-to-one association to LocationMaster
	@OneToMany(mappedBy="statusMaster")
	private List<LocationMaster> locationMasters;

	//bi-directional many-to-one association to MenuMaster
	@OneToMany(mappedBy="statusMaster")
	private List<MenuMaster> menuMasters;

	//bi-directional many-to-one association to PurchaseSummary
	@OneToMany(mappedBy="statusMaster")
	private List<PurchaseSummary> purchaseSummaries;

	//bi-directional many-to-one association to PurchaseTransaction
	@OneToMany(mappedBy="statusMaster")
	private List<PurchaseTransaction> purchaseTransactions;

	//bi-directional many-to-one association to RoleMaster
	@OneToMany(mappedBy="statusMaster")
	private List<RoleMaster> roleMasters;

	//bi-directional many-to-one association to SellSummary
	@OneToMany(mappedBy="statusMaster1")
	private List<SellSummary> sellSummaries1;

	//bi-directional many-to-one association to SellSummary
	@OneToMany(mappedBy="statusMaster2")
	private List<SellSummary> sellSummaries2;

	//bi-directional many-to-one association to SellTransaction
	@OneToMany(mappedBy="statusMaster")
	private List<SellTransaction> sellTransactions;

	//bi-directional many-to-one association to StSummary
	@OneToMany(mappedBy="statusMaster")
	private List<StSummary> stSummaries;

	//bi-directional many-to-one association to StTransaction
	@OneToMany(mappedBy="statusMaster")
	private List<StTransaction> stTransactions;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="statusMaster")
	private List<Stock> stocks;

	//bi-directional many-to-one association to StockTransaction
	@OneToMany(mappedBy="statusMaster")
	private List<StockTransaction> stockTransactions;

	public StatusMaster() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CustomerMaster> getCustomerMasters() {
		return this.customerMasters;
	}

	public void setCustomerMasters(List<CustomerMaster> customerMasters) {
		this.customerMasters = customerMasters;
	}

	public CustomerMaster addCustomerMaster(CustomerMaster customerMaster) {
		getCustomerMasters().add(customerMaster);
		customerMaster.setStatusMaster(this);

		return customerMaster;
	}

	public CustomerMaster removeCustomerMaster(CustomerMaster customerMaster) {
		getCustomerMasters().remove(customerMaster);
		customerMaster.setStatusMaster(null);

		return customerMaster;
	}

	public List<ItemMaster> getItemMasters() {
		return this.itemMasters;
	}

	public void setItemMasters(List<ItemMaster> itemMasters) {
		this.itemMasters = itemMasters;
	}

	public ItemMaster addItemMaster(ItemMaster itemMaster) {
		getItemMasters().add(itemMaster);
		itemMaster.setStatusMaster(this);

		return itemMaster;
	}

	public ItemMaster removeItemMaster(ItemMaster itemMaster) {
		getItemMasters().remove(itemMaster);
		itemMaster.setStatusMaster(null);

		return itemMaster;
	}

	public List<LocationMaster> getLocationMasters() {
		return this.locationMasters;
	}

	public void setLocationMasters(List<LocationMaster> locationMasters) {
		this.locationMasters = locationMasters;
	}

	public LocationMaster addLocationMaster(LocationMaster locationMaster) {
		getLocationMasters().add(locationMaster);
		locationMaster.setStatusMaster(this);

		return locationMaster;
	}

	public LocationMaster removeLocationMaster(LocationMaster locationMaster) {
		getLocationMasters().remove(locationMaster);
		locationMaster.setStatusMaster(null);

		return locationMaster;
	}

	public List<MenuMaster> getMenuMasters() {
		return this.menuMasters;
	}

	public void setMenuMasters(List<MenuMaster> menuMasters) {
		this.menuMasters = menuMasters;
	}

	public MenuMaster addMenuMaster(MenuMaster menuMaster) {
		getMenuMasters().add(menuMaster);
		menuMaster.setStatusMaster(this);

		return menuMaster;
	}

	public MenuMaster removeMenuMaster(MenuMaster menuMaster) {
		getMenuMasters().remove(menuMaster);
		menuMaster.setStatusMaster(null);

		return menuMaster;
	}

	public List<PurchaseSummary> getPurchaseSummaries() {
		return this.purchaseSummaries;
	}

	public void setPurchaseSummaries(List<PurchaseSummary> purchaseSummaries) {
		this.purchaseSummaries = purchaseSummaries;
	}

	public PurchaseSummary addPurchaseSummary(PurchaseSummary purchaseSummary) {
		getPurchaseSummaries().add(purchaseSummary);
		purchaseSummary.setStatusMaster(this);

		return purchaseSummary;
	}

	public PurchaseSummary removePurchaseSummary(PurchaseSummary purchaseSummary) {
		getPurchaseSummaries().remove(purchaseSummary);
		purchaseSummary.setStatusMaster(null);

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
		purchaseTransaction.setStatusMaster(this);

		return purchaseTransaction;
	}

	public PurchaseTransaction removePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		getPurchaseTransactions().remove(purchaseTransaction);
		purchaseTransaction.setStatusMaster(null);

		return purchaseTransaction;
	}

	public List<RoleMaster> getRoleMasters() {
		return this.roleMasters;
	}

	public void setRoleMasters(List<RoleMaster> roleMasters) {
		this.roleMasters = roleMasters;
	}

	public RoleMaster addRoleMaster(RoleMaster roleMaster) {
		getRoleMasters().add(roleMaster);
		roleMaster.setStatusMaster(this);

		return roleMaster;
	}

	public RoleMaster removeRoleMaster(RoleMaster roleMaster) {
		getRoleMasters().remove(roleMaster);
		roleMaster.setStatusMaster(null);

		return roleMaster;
	}

	public List<SellSummary> getSellSummaries1() {
		return this.sellSummaries1;
	}

	public void setSellSummaries1(List<SellSummary> sellSummaries1) {
		this.sellSummaries1 = sellSummaries1;
	}

	public SellSummary addSellSummaries1(SellSummary sellSummaries1) {
		getSellSummaries1().add(sellSummaries1);
		sellSummaries1.setStatusMaster1(this);

		return sellSummaries1;
	}

	public SellSummary removeSellSummaries1(SellSummary sellSummaries1) {
		getSellSummaries1().remove(sellSummaries1);
		sellSummaries1.setStatusMaster1(null);

		return sellSummaries1;
	}

	public List<SellSummary> getSellSummaries2() {
		return this.sellSummaries2;
	}

	public void setSellSummaries2(List<SellSummary> sellSummaries2) {
		this.sellSummaries2 = sellSummaries2;
	}

	public SellSummary addSellSummaries2(SellSummary sellSummaries2) {
		getSellSummaries2().add(sellSummaries2);
		sellSummaries2.setStatusMaster2(this);

		return sellSummaries2;
	}

	public SellSummary removeSellSummaries2(SellSummary sellSummaries2) {
		getSellSummaries2().remove(sellSummaries2);
		sellSummaries2.setStatusMaster2(null);

		return sellSummaries2;
	}

	public List<SellTransaction> getSellTransactions() {
		return this.sellTransactions;
	}

	public void setSellTransactions(List<SellTransaction> sellTransactions) {
		this.sellTransactions = sellTransactions;
	}

	public SellTransaction addSellTransaction(SellTransaction sellTransaction) {
		getSellTransactions().add(sellTransaction);
		sellTransaction.setStatusMaster(this);

		return sellTransaction;
	}

	public SellTransaction removeSellTransaction(SellTransaction sellTransaction) {
		getSellTransactions().remove(sellTransaction);
		sellTransaction.setStatusMaster(null);

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
		stSummary.setStatusMaster(this);

		return stSummary;
	}

	public StSummary removeStSummary(StSummary stSummary) {
		getStSummaries().remove(stSummary);
		stSummary.setStatusMaster(null);

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
		stTransaction.setStatusMaster(this);

		return stTransaction;
	}

	public StTransaction removeStTransaction(StTransaction stTransaction) {
		getStTransactions().remove(stTransaction);
		stTransaction.setStatusMaster(null);

		return stTransaction;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setStatusMaster(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setStatusMaster(null);

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
		stockTransaction.setStatusMaster(this);

		return stockTransaction;
	}

	public StockTransaction removeStockTransaction(StockTransaction stockTransaction) {
		getStockTransactions().remove(stockTransaction);
		stockTransaction.setStatusMaster(null);

		return stockTransaction;
	}

}