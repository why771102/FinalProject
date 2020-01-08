package com.m.dao;

import java.sql.Timestamp;
import java.util.List;
import com.l.model.ProductsBean;
import com.l.model.mOrderDetailBean;

public interface ProductSaleDao {
	
	//DBT:products => productID, productName, category(4套票(飲食), 5飲食, 6線上商城?)
	public List<ProductsBean> getProductsInfo(Integer category);
//	public Integer getProductID(Integer category);
//	public String getProductName(Integer ProductID);
	
	//DBT: products & mOrderDetail, products & SCOrderDetail (PID)
	public List<String> getProductsName(Timestamp orderDate);
//	public List<String> getPeripheralsName(Timestamp orderDate);
	
	//DBT: mOrderDetail => productID, unitPrice, quantity, discount
	//subtotal: 4+5
	//subtotal: 6 (DBT: SCOrderDetail(QTY), mOrderDetail(price, discount?), SCOrders(total))
	public List<mOrderDetailBean> showProductOrder(Integer productID, Timestamp orderDate);
	//	public mOrderDetailBean showProductOrder1(Integer productID);
	
	//周邊是6開始嗎?
	//discount是int??
	
	//DBT: SCOrderDetail => SCOrderID, productID, quantity
//	public List<SCOrderDetailBean> getPeripheralsOD(Integer productID);
	
	//DBT: SCOrders => orderDate(timestamp), total
//	public SCOrdersBean getPeripheralsOrder(Integer SCOrderID);
	
}
