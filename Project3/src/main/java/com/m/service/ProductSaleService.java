package com.m.service;

import java.time.LocalDate;
import java.util.List;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.model.ProductSaleBean;

public interface ProductSaleService {
	public List<LocalDate> getFoodDates();
	public List<LocalDate> getPeripheralDates();
	//新增cate下拉式選單
	public String getCategoryNames();
	
	//show all peripheral orders
	public List<SCOrdersBean> getPeripheralSCOrders(String orderDateA, String orderDateB);
	public List<ProductsBean> getPeripheralPB();
	public List<ProductSaleBean> getPeripheralOutput(List<ProductsBean> pbList, List<SCOrdersBean> scbList);	
//	public List<ProductSaleBean> showPeripheralOrders(String orderDateA, String orderDateB);
	//4, 5, 4+5
	public List<ShowTimeHistoryBean> getMovieDate(String playStartTimeA, String playStartTimeB);
	public List<MOrderDetailBean> getMODBList();
	public List<ProductsBean> getFoodPB4();
	public List<ProductsBean> getFoodPB5();
	public List<ProductsBean> getAllFoodPB();
	public List<ProductSaleBean> showFoodOutput(List<ShowTimeHistoryBean> sthbList, List<MOrderDetailBean> modbList,
			List<ProductsBean> pbList);
	
	//根據產品名稱進入單日資訊
	public List<LocalDate> showEachDate(String sDate, String eDate);
	public List<ProductSaleBean> getByDateOutput(List<LocalDate> datesList, String pName);
	
	
	// 6, 7, 8.. (DBT: SCOrderDetail(QTY), mOrderDetail(price, discount?), SCOrders(total))
//	public List<ProductSaleBean> showPeripheralOrder(String categoryName, String orderDateA, String orderDateB);
//	//6+7+8..
//	public List<ProductSaleBean> showPeriperalOrders(String categoryNameA, String categoryNameB, String orderDateA, String orderDateB);
	
	//使用上面方法後要加這個方法才能輸出
//	public List<String> getDistinctProductNames();
//	public List<ProductSaleBean> getProductSaleOutput(List<ProductSaleBean> psbList);

	//根據產品名稱進入單日資訊
//	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB);
//	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB);
	
	//使用單日資訊需要加入這個方法才能輸出
//	public List<LocalDate> showEachDate(String sDate, String eDate);
//	public List<ProductSaleBean> getFoodSaleByDateOutput(List<LocalDate> datesList, String productName);
//	public List<ProductSaleBean> getPeripheralSaleByDateOutput(List<LocalDate> datesList, String productName);
}