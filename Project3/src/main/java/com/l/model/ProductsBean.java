package com.l.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.a.model.MovieBean;
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
	
//	Integer category;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="category")
//	private CategoriesBean CategoriesBean;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryID")
	private CategoriesBean categoriesBean;
	@Transient
	Integer CategoryID;
	
	
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
	public ProductsBean(Integer productID,String productName,CategoriesBean categoriesBean,Integer unitPrice,Integer unitStock,Integer cost) {
		this.productID=productID;
		this.productName=productName;
		this.categoriesBean=categoriesBean;
		this.unitPrice=unitPrice;
		this.unitStock=unitStock;
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

	public CategoriesBean getCategoriesBean() {
		return categoriesBean;
	}
	public void setCategoriesBean(CategoriesBean categoriesBean) {
		this.categoriesBean = categoriesBean;
	}
	
	public Integer getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(Integer categoryID) {
		CategoryID = categoryID;
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