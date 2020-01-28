package com.m.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.l.model.CategoriesBean;
import com.l.model.ProductsBean;

@Entity
@Table(name="productSaleEarn")
public class ProductSaleEarnBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer No;
	
	String orderDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productID")
	private ProductsBean productsBean;
	Integer qtyTotal;
	Integer price; //每天單價是浮動的要存,有時候會有折扣
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryID")
	private CategoriesBean categoriesBean;
	
	public ProductSaleEarnBean() {}
	
	public ProductSaleEarnBean(String orderDate, ProductsBean productsBean, Integer qtyTotal, Integer price, CategoriesBean categoriesBean) {
		this.orderDate = orderDate;
		this.productsBean = productsBean;
		this.qtyTotal = qtyTotal;
		this.price = price;
		this.categoriesBean = categoriesBean;
	}

	@Transient
	Integer subtotal;
	@Transient
	String productName;
	@Transient
	Integer cost;
	@Transient
	Integer earn;
	@Transient
	Integer earnSubtotal;
	
	public ProductSaleEarnBean(String productName, Integer price, Integer qtyTotal, Integer cost, 
			Integer earn, Integer subtotal, Integer earnSubtotal) {
		this.productName = productName;
		this.qtyTotal = qtyTotal;
		this.price = price;
		this.subtotal = subtotal;
		this.cost = cost;
		this.earn = earn;
		this.earnSubtotal = earnSubtotal;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getEarn() {
		return earn;
	}

	public void setEarn(Integer earn) {
		this.earn = earn;
	}

	public Integer getEarnSubtotal() {
		return earnSubtotal;
	}

	public void setEarnSubtotal(Integer earnSubtotal) {
		this.earnSubtotal = earnSubtotal;
	}

	public CategoriesBean getCategoriesBean() {
		return categoriesBean;
	}

	public void setCategoriesBean(CategoriesBean categoriesBean) {
		this.categoriesBean = categoriesBean;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public ProductsBean getProductsBean() {
		return productsBean;
	}

	public void setProductsBean(ProductsBean productsBean) {
		this.productsBean = productsBean;
	}

	public Integer getQtyTotal() {
		return qtyTotal;
	}

	public void setQtyTotal(Integer qtyTotal) {
		this.qtyTotal = qtyTotal;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
