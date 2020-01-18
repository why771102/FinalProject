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

import com.sun.istack.NotNull;

@Entity
@Table(name="mOrderDetail")
public class MOrderDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	Integer ordersID; 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ordersID")
	private MOrderBean ordersID;
//	Integer productID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productID")
	private ProductsBean productID;
	@NotNull
	@Column(nullable=false)
	Integer sellUnitPrice;
	@NotNull
	@Column(nullable=false, columnDefinition = "REAL")
	double discount;
	@NotNull
	@Column(nullable=false)
	Integer quantity;
	
	
//	public Integer getOrdersID() {
//		return ordersID;
//	}
//	public void setOrdersID(Integer ordersID) {
//		this.ordersID = ordersID;
//	}
//	
	
	public MOrderBean getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(MOrderBean ordersID) {
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
	public Integer getSellUnitPrice() {
		return sellUnitPrice;
	}
	public void setSellUnitPrice(Integer sellUnitPrice) {
		this.sellUnitPrice = sellUnitPrice;
	}
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	

}