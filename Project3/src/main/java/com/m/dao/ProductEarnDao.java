package com.m.dao;

public interface ProductEarnDao {
	
	//DBT:Products => productID, productName, category(4食物/5純周邊), cost
	
	//	同PS方法: public Integer getCategory(Integer productID);
	
	public Integer getProductCost(Integer productID);
	
	//同PS方法
	//DBT: OrderDetails => productID, unitPrice, quantity, discount
	
}
