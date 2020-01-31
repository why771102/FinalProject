package com.l.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.a.model.ShowTimeHistoryBean;
import com.p.model.MemberBean;
import com.sun.istack.NotNull;
import com.z.model.EmpBean;

@Entity
@IdClass(com.l.model.MorderID.class)
@Table(name="mOrderDetail")
public class MOrderDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	Integer ordersID; 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ordersID")
	private MOrderBean mOrderBean;
	@Transient
	Integer ordersID;
	
	
	//	Integer productID;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productID")
	private ProductsBean productsBean;
	@Transient
	Integer productID;
	
	@NotNull
	@Column(nullable=false)
	Integer sellUnitPrice;
	@NotNull
	@Column(nullable=false, columnDefinition = "REAL")
	Double discount;
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
	

	
//	
//	public Integer getProductID() {
//		return productID;
//	}
//	public void setProductID(Integer productID) {
//		this.productID = productID;
//	}

	public MOrderDetailBean() {}
	public MOrderDetailBean(MOrderBean mOrderBean,ProductsBean productsBean,Integer sellUnitPrice,Double discount,Integer quantity) {
		this.mOrderBean=mOrderBean;
		this.productsBean=productsBean;
		this.sellUnitPrice=sellUnitPrice;
		this.discount=discount;
		this.quantity=quantity;
		
	}
	
	public MOrderBean getmOrderBean() {
		return mOrderBean;
	}
	public void setmOrderBean(MOrderBean mOrderBean) {
		this.mOrderBean = mOrderBean;
	}
	public Integer getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(Integer ordersID) {
		this.ordersID = ordersID;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public ProductsBean getProductsBean() {
		return productsBean;
	}
	public void setProductsBean(ProductsBean productsBean) {
		this.productsBean = productsBean;
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
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	

}