package com.m.dao;

import java.time.LocalDate;
import java.util.List;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.model.ProductSaleBean;
import com.m.model.ProductSaleEarnBean;

public interface ProductSaleDao {
	public List<LocalDate> getFoodDates();
	public List<MOrderBean> getFoodSCOrder(LocalDate date);
	public List<MOrderDetailBean> getFoodSCODs(List<MOrderBean> moList);
	public List<ProductSaleEarnBean> getFoodPBs(List<MOrderDetailBean> modbList);
	public List<ProductSaleEarnBean> savePSEB1();
	public Boolean savePSEB(List<ProductSaleEarnBean> psebList);
	
	public List<LocalDate> getPeripheralDates();
	public List<SCOrdersBean> getPeripheralSCOrder(LocalDate orderDate);
	public List<SCOrderDetailBean> getPeripheralSCODs(List<SCOrdersBean> scbList);
	public List<ProductSaleEarnBean> getPeripheralPBs(List<SCOrderDetailBean> scodList);
	//get categoryNames as select option
	public String getCategoryNames();
	//show all food orders
//	public List<ProductSaleBean> showAllProductOrders(String playStartTimeA, String playStartTimeB);
	//show all peripheral orders
	public List<SCOrdersBean> getPeripheralSCOrders(String orderDateA, String orderDateB);
	public List<ProductsBean> getPeripheralPB();
	public List<ProductSaleBean> getPeripheralSCOD(List<ProductsBean> pbList, List<SCOrdersBean> scbList);
//	public List<ProductSaleBean> getPeripheralOrders(String orderDateA, String orderDateB);
	//4, 5, 4+5
	public List<ShowTimeHistoryBean> getMovieDate(String playStartTimeA, String playStartTimeB);
	public List<MOrderDetailBean> getMODBList();
	public List<ProductsBean> getFoodPB4();
	public List<ProductsBean> getFoodPB5();
	public List<ProductsBean> getAllFoodPB();
	public List<ProductSaleBean> showFoodOutput(List<ShowTimeHistoryBean> sthbList, List<MOrderDetailBean> modbList,
			List<ProductsBean> pbList);
	//取得相對應的CID判斷
	public Integer getCategory(String pName);
	
	
	// 6, 7, 8.. (DBT: SCOrderDetail(QTY), mOrderDetail(price, discount?), SCOrders(total))
//	public List<ProductSaleBean> showPeripheralOrder(String categoryName, String orderDateA, String orderDateB);

//	//6+7+8..
//	public List<ProductSaleBean> showPeriperalOrders(String categoryNameA, String categoryNameB, String orderDateA, String orderDateB);
	
//	public List<String> getDistinctProductNames();
	
	//根據產品名稱進入單日資訊
//	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB);
//	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB);
	
	//DBT:products => productID, productName, category(4套票(飲食), 5飲食, 6~線上商城)
	//DBT: showTimeHistory => showTimeID, playStartTime
	//DBT: products & mOrderDetail, products & SCOrderDetail (PID)
	//DBT: mOrderDetail => productID, unitPrice, quantity, discount
	//DBT: SCOrderDetail => SCOrderID, productID, quantity, unitPrice, discount
	//DBT: SCOrders => orderDate(String), total
}
