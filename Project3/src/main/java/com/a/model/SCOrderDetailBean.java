package com.a.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	Integer quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SCOrderID")
	private SCOrdersBean SCOrdersBean;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="productID")
	private ProductsBean productsBean;
	
	@Transient
	private Integer SCOrderID;
	
	@Transient
	private Integer productsID;
	
	public SCOrderDetailBean() {}

	public SCOrderDetailBean(Integer quantity, Integer sCOrderID, Integer productsID) {
		this.quantity = quantity;
		this.SCOrderID = sCOrderID;
		this.productsID = productsID;
	}

	public SCOrderDetailBean(Integer quantity, SCOrdersBean SCOrdersBean, ProductsBean productsBean) {
		super();
		this.quantity = quantity;
		this.SCOrdersBean = SCOrdersBean;
		this.productsBean = productsBean;
	}

	public Integer getSCOrderID() {
		return SCOrderID;
	}

	public void setSCOrderID(Integer sCOrderID) {
		SCOrderID = sCOrderID;
	}

	public Integer getProductsID() {
		return productsID;
	}

	public void setProductsID(Integer productsID) {
		this.productsID = productsID;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public SCOrdersBean getScorders() {
		return SCOrdersBean;
	}
	public void setScorders(SCOrdersBean scorders) {
		this.SCOrdersBean = scorders;
	}
	public ProductsBean getPrducts() {
		return productsBean;
	}
	public void setPrducts(ProductsBean prducts) {
		this.productsBean = prducts;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
