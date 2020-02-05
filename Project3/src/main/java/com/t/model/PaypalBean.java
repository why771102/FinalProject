package com.t.model;

import java.io.Serializable;

public class PaypalBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String product;
	String subtotal;
	String shipping;
	String tax;
	String total;
	
	public PaypalBean(String product,String subtotal,String shipping,String tax,String total) {
		this.product = product;
		this.subtotal = subtotal;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
	}
	
	public PaypalBean() {
		
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
