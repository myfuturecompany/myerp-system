package com.lantern.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

public class ItemPurchaseObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String itemCode;

	private String itemName;

	private String quantity;

	private String uom;

	private String purchasePrice;
	
	private String defaultPrice;

	private String netPrice;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(String defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

	public String getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(String netPrice) {
		this.netPrice = netPrice;
	}
	
	
}