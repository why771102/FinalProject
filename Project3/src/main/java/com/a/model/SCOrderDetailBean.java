package com.a.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.l.model.ProductsBean;


@Entity
@Table(name = "SCOrderDetail" )
public class SCOrderDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer orderno;
//	Integer unitPrice;
//	Integer discount;
	Integer quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sCOrderID")
	private SCOrdersBean SCOrdersBean;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productID")
	private ProductsBean productsBean;
	
	@Transient
	private Integer SCOrderID;
	
	@Transient
	private Integer productID;
	
	public SCOrderDetailBean() {}

	public SCOrderDetailBean(Integer quantity, Integer sCOrderID,
			Integer productID) {
//		this.unitPrice = unitPrice;
//		this.discount = discount;
		this.quantity = quantity;
		this.SCOrderID = sCOrderID;
		this.productID = productID;
	}

	public SCOrderDetailBean(Integer orderno, Integer quantity,
			SCOrdersBean sCOrdersBean, ProductsBean productsBean) {
		this.orderno = orderno;
//		this.unitPrice = unitPrice;
//		this.discount = discount;
		this.quantity = quantity;
		this.SCOrdersBean = sCOrdersBean;
		this.productsBean = productsBean;
	}

	public Integer getOrderno() {
		return orderno;
	}

	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}

//	public Integer getUnitPrice() {
//		return unitPrice;
//	}
//
//	public void setUnitPrice(Integer unitPrice) {
//		this.unitPrice = unitPrice;
//	}
//
//	public Integer getDiscount() {
//		return discount;
//	}
//
//	public void setDiscount(Integer discount) {
//		discount = discount;
//	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public SCOrdersBean getSCOrdersBean() {
		return SCOrdersBean;
	}

	public void setSCOrdersBean(SCOrdersBean sCOrdersBean) {
		SCOrdersBean = sCOrdersBean;
	}

	public ProductsBean getProductsBean() {
		return productsBean;
	}

	public void setProductsBean(ProductsBean productsBean) {
		this.productsBean = productsBean;
	}

	public Integer getSCOrderID() {
		return SCOrderID;
	}

	public void setSCOrderID(Integer sCOrderID) {
		SCOrderID = sCOrderID;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	
	
}
