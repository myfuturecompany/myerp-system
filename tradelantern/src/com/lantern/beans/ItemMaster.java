package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_master database table.
 * 
 */
@Entity
@Table(name="item_master")
@NamedQuery(name="ItemMaster.findAll", query="SELECT i FROM ItemMaster i")
public class ItemMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String barcode;

	@Column(name="item_code")
	private String itemCode;

	@Column(name="item_name")
	private String itemName;

	private String uom;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to PurchaseTransaction
	@OneToMany(mappedBy="itemMaster")
	private List<PurchaseTransaction> purchaseTransactions;

	//bi-directional many-to-one association to SellTransaction
	@OneToMany(mappedBy="itemMaster")
	private List<SellTransaction> sellTransactions;

	//bi-directional many-to-one association to StTransaction
	@OneToMany(mappedBy="itemMaster")
	private List<StTransaction> stTransactions;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="itemMaster")
	private List<Stock> stocks;

	//bi-directional many-to-one association to StockTransaction
	@OneToMany(mappedBy="itemMaster")
	private List<StockTransaction> stockTransactions;

	public ItemMaster() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public StatusMaster getStatusMaster() {
		return this.statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}

	public List<PurchaseTransaction> getPurchaseTransactions() {
		return this.purchaseTransactions;
	}

	public void setPurchaseTransactions(List<PurchaseTransaction> purchaseTransactions) {
		this.purchaseTransactions = purchaseTransactions;
	}

	public PurchaseTransaction addPurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		getPurchaseTransactions().add(purchaseTransaction);
		purchaseTransaction.setItemMaster(this);

		return purchaseTransaction;
	}

	public PurchaseTransaction removePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
		getPurchaseTransactions().remove(purchaseTransaction);
		purchaseTransaction.setItemMaster(null);

		return purchaseTransaction;
	}

	public List<SellTransaction> getSellTransactions() {
		return this.sellTransactions;
	}

	public void setSellTransactions(List<SellTransaction> sellTransactions) {
		this.sellTransactions = sellTransactions;
	}

	public SellTransaction addSellTransaction(SellTransaction sellTransaction) {
		getSellTransactions().add(sellTransaction);
		sellTransaction.setItemMaster(this);

		return sellTransaction;
	}

	public SellTransaction removeSellTransaction(SellTransaction sellTransaction) {
		getSellTransactions().remove(sellTransaction);
		sellTransaction.setItemMaster(null);

		return sellTransaction;
	}

	public List<StTransaction> getStTransactions() {
		return this.stTransactions;
	}

	public void setStTransactions(List<StTransaction> stTransactions) {
		this.stTransactions = stTransactions;
	}

	public StTransaction addStTransaction(StTransaction stTransaction) {
		getStTransactions().add(stTransaction);
		stTransaction.setItemMaster(this);

		return stTransaction;
	}

	public StTransaction removeStTransaction(StTransaction stTransaction) {
		getStTransactions().remove(stTransaction);
		stTransaction.setItemMaster(null);

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
		stock.setItemMaster(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setItemMaster(null);

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
		stockTransaction.setItemMaster(this);

		return stockTransaction;
	}

	public StockTransaction removeStockTransaction(StockTransaction stockTransaction) {
		getStockTransactions().remove(stockTransaction);
		stockTransaction.setItemMaster(null);

		return stockTransaction;
	}

}