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

import com.l.model.ProductsBean;


@Entity
@Table(name = "SCOrderDetail" )
public class SCOrderDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	Integer quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SCOrderID")
	private SCOrdersBean scorders;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="prductID")
	private ProductsBean prducts;
	
	public SCOrderDetailBean() {}
	
	
	
	public SCOrderDetailBean(Integer quantity, SCOrdersBean scorders, ProductsBean prducts) {
		super();
		this.quantity = quantity;
		this.scorders = scorders;
		this.prducts = prducts;
	}



	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public SCOrdersBean getScorders() {
		return scorders;
	}
	public void setScorders(SCOrdersBean scorders) {
		this.scorders = scorders;
	}
	public ProductsBean getPrducts() {
		return prducts;
	}
	public void setPrducts(ProductsBean prducts) {
		this.prducts = prducts;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
