package com.l.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="products")
public class ProductsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer productID;    
	@NotNull
	@Column(nullable=false, columnDefinition = "NVARCHAR(40)")
	String productName;
	@NotNull
	@Column(nullable=false, columnDefinition="TINYINT")
	Integer category;
	@NotNull
	@Column(nullable=false)
	Integer unitPrice;
	@NotNull
	@Column(nullable=false)
	Integer unitStock;
	@NotNull
	@Column(nullable=false)
	Integer cost;

	public ProductsBean() {}
	public ProductsBean(Integer productID,String productName,Integer category,Integer unitPrice,Integer unitStock,Integer cost) {
		this.productID=productID;
		this.productName=productName;
		this.category=category;
		this.unitPrice=unitPrice;
		this.unitStock=0;
		this.cost=cost;
	}
	
	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getUnitStock() {
		return unitStock;
	}

	public void setUnitStock(Integer unitStock) {
		this.unitStock = unitStock;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

}