package com.m.model;

import java.io.Serializable;

public class ProductSaleBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ProductSaleBean() {}
	
	String productName;
	Integer unitPrice;
	Integer qty;
	Double discount;
	Integer cost;

	public ProductSaleBean(Integer unitPrice, Integer qty, Double discount, Integer cost) {
		this.unitPrice = unitPrice;
		this.qty = qty;
		this.discount = discount;
		this.cost = cost;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}	
}
