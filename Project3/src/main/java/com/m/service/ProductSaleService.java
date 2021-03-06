package com.m.service;

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

public interface ProductSaleService {
	//新增cate下拉式選單
	public String getCategoryNames();
	public List<ProductSaleEarnBean> getAllProductInfo(String sDate, String eDate);
	public List<ProductSaleEarnBean> getAllFoodInfo(String sDate, String eDate);
	public List<ProductSaleEarnBean> getFoodInfo4(String sDate, String eDate);
	public List<ProductSaleEarnBean> getFoodInfo5(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo6(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo7(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo8(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo9(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo10(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo11(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo12(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo13(String sDate, String eDate);
	
	public List<ProductSaleEarnBean> getInfoByDate(Integer productID, String sDate, String eDate);
	public String getPname(Integer productID);
	public List<LocalDate> getFoodDates(); //cate要
	//==============================================================================	
	//show all peripheral orders
	public List<SCOrdersBean> getPeripheralSCOrders(String orderDateA, String orderDateB);
	public List<ProductsBean> getPeripheralPB();
	public List<ProductSaleBean> getPeripheralOutput(List<ProductsBean> pbList, List<SCOrdersBean> scbList);	
	
	//根據產品名稱進入單日資訊
	public List<LocalDate> showEachDate(String sDate, String eDate);
}