package com.m.dao;

public interface ProductSaleDao {
	
	//DBT:Products => productID, productName, category(4食物 & 5純周邊)
	
	public Integer getProductID(Integer category);
	
	public String getProductName(Integer ProductID);
	
	//DBT: OrderDetails => productID, unitPrice, quantity, discount
	public List<ProductBean> showProductOrder(Integer productID);
}
