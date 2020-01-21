package com.m.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.l.model.ProductsBean;

@Entity
@Table(name="productSaleEarn")
public class ProductSaleEarnBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	String orderDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productID")
	private ProductsBean productsBean;
	
	Integer qtyTotal;
	
	public ProductSaleEarnBean() {}

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
}
