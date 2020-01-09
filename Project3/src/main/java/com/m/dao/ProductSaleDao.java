package com.m.dao;

import java.sql.Timestamp;
import java.util.List;

import org.json.JSONArray;

import com.l.model.ProductsBean;
import com.l.model.mOrderDetailBean;

public interface ProductSaleDao {
	
	//DBT:products => productID, productName, category(4套票(飲食), 5飲食, 6~線上商城)
	public List<ProductsBean> getProductsInfo(Integer category, String orderDate);
//	public Integer getProductID(Integer category);
//	public String getProductName(Integer ProductID);
	
	//DBT: showTimeHistory => showTimeID, playStartTime
	public Timestamp getPlayStartTime(Integer showTimeID);
	
	//DBT: products & mOrderDetail, products & SCOrderDetail (PID)
	public List<String> getProductsName(String orderDate);
//	public List<String> getPeripheralsName(Timestamp orderDate);
	
	//DBT: mOrderDetail => productID, unitPrice, quantity, discount
	//subtotal: 4+5
	//subtotal: 6 (DBT: SCOrderDetail(QTY), mOrderDetail(price, discount?), SCOrders(total))
//	public List<mOrderDetailBean> showProductOrder(Integer productID, String orderDate);
	public JSONArray showProductOrder(String orderDate);
	public List<mOrderDetailBean> showProductOrder(Integer category, String orderDate);
	//	public mOrderDetailBean showProductOrder1(Integer productID);
	
	//DBT: SCOrderDetail => SCOrderID, productID, quantity
//	public List<SCOrderDetailBean> getPeripheralsOD(Integer productID);
	
	//DBT: SCOrders => orderDate(timestamp), total
//	public SCOrdersBean getPeripheralsOrder(Integer SCOrderID);
	
}
