package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="available_qty")
	private BigDecimal availableQty;

	@Column(name="location_id")
	private int locationId;

	@Column(name="lower_range")
	private BigDecimal lowerRange;

	@Column(name="purchase_price")
	private BigDecimal purchasePrice;

	@Column(name="sell_price")
	private BigDecimal sellPrice;

	//bi-directional many-to-one association to StatusMaster
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster statusMaster;

	//bi-directional many-to-one association to ItemMaster
	@ManyToOne
	@JoinColumn(name="item")
	private ItemMaster itemMaster;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="item")
	private LocationMaster locationMaster;

	public Stock() {
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

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public BigDecimal getLowerRange() {
		return this.lowerRange;
	}

	public void setLowerRange(BigDecimal lowerRange) {
		this.lowerRange = lowerRange;
	}

	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public StatusMaster getStatusMaster() {
		return this.statusMaster;
	}

	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
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

}