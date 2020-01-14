package com.m.model;

import java.io.Serializable;

public class ProductSaleBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ProductSaleBean() {}
	
	String productName;
	Integer unitPrice;
	//加總的數量
	Integer qty;
	//折扣是用來qty*unitPrice* discount計算總金額的
	Double discount;
	Integer cost;
	Double productSubtotal;
	
	public ProductSaleBean(String productName, Integer unitPrice, Integer qty, Double productSubtotal) {
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.qty = qty;
		this.productSubtotal = productSubtotal;
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
	
	public Double getProductSubtotal() {
		return productSubtotal;
	}
	public void setProductSubtotal(Double productSubtotal) {
		this.productSubtotal = productSubtotal;
	}
}
