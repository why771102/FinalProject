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

import com.l.model.ProductsBean;

@Entity
//@IdClass(com.m.model.ProductSaleEarnID.class)
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
	
	public ProductSaleEarnBean() {}

	
	
	public ProductSaleEarnBean(String orderDate, ProductsBean productsBean, Integer qtyTotal, Integer price) {
		this.orderDate = orderDate;
		this.productsBean = productsBean;
		this.qtyTotal = qtyTotal;
		this.price = price;
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
