package com.l.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetail")
public class mOrderDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	Integer ordersID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ordersID")
	private mOrderBean ordersID;
//	Integer productID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productID")
	private ProductsBean productID;
//	Integer unitPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="unitPrice")
	private ProductsBean unitPrice;
	Integer discount;
	Integer quantity;
	
	


	
//	public Integer getOrdersID() {
//		return ordersID;
//	}
//	public void setOrdersID(Integer ordersID) {
//		this.ordersID = ordersID;
//	}
//	
	
	public mOrderBean getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(mOrderBean ordersID) {
		this.ordersID = ordersID;
	}
	
//	
//	public Integer getProductID() {
//		return productID;
//	}
//	public void setProductID(Integer productID) {
//		this.productID = productID;
//	}
	public ProductsBean getProductID() {
		return productID;
	}
	public void setProductID(ProductsBean productID) {
		this.productID = productID;
	}
//	public Integer getUnitPrice() {
//		return unitPrice;
//	}
//	public void setUnitPrice(Integer unitPrice) {
//		this.unitPrice = unitPrice;
//	}
	
	public ProductsBean getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(ProductsBean unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	

}