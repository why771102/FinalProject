package com.l.model;

import java.io.Serializable;
import java.sql.Blob;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@Column(columnDefinition="NVARCHAR(MAX)")
	String productDescription;
	@JsonIgnore
	Blob productImage;
	String fileName;
	
	
	public ProductsBean() {}
	

	public ProductsBean(Integer productID, String productName, Integer categoryID,
			Integer unitPrice, Integer unitStock, Integer cost, String productDescription, Blob productImage) {
		this.productID = productID;
		this.productName = productName;
		this.CategoryID = categoryID;
		this.unitPrice = unitPrice;
		this.unitStock = unitStock;
		this.cost = cost;
		this.productDescription = productDescription;
		this.productImage = productImage;
	}

	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getProductDescription() {
		return productDescription;
	}



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}



	public Blob getProductImage() {
		return productImage;
	}



	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
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