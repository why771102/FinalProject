package com.m.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.m.dao.ProductSaleDao;
import com.m.model.ProductSaleBean;
import com.m.service.ProductEarnService;
import com.m.service.ProductSaleService;

@Service
public class ProductEarnServiceImpl implements ProductEarnService {

	ProductSaleDao dao;
	ProductSaleService service;
	
	@Autowired
	public void setDao(ProductSaleDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional
	@Override
	public List<ProductSaleBean> getProductSaleOutput(List<String> productNamesList, List<ProductSaleBean> psbList) {
		List<ProductSaleBean> PSBList = new ArrayList<>();
		List<String> productNames = new ArrayList<>();

		for (String productName : productNamesList) {
			productNames.add(productName);
		}

		for (String productName : productNames) {
			Integer unitPrice = 0;
			Double discount = 0.0;
			Integer qty = 0;
			Integer cost = 0;
			Integer earn = 0;
			Integer productSubtotal = 0;
			Integer earnSubtotal = 0;
			
			for (ProductSaleBean psb : psbList) {
				//如果產品名稱相同就存
				if(productName.equals(psb.getProductName())) {
					qty = qty + psb.getQty();
					unitPrice = psb.getUnitPrice();
					discount = psb.getDiscount();
					cost = psb.getCost();
//					productSubtotal = productSubtotal + (unitPrice*discount*qty);
					psbList.remove(psb);
				}
				earn = unitPrice - cost;
				earnSubtotal = earnSubtotal + (earn*qty);
			}
			ProductSaleBean psb = new ProductSaleBean(productName, qty, unitPrice, cost, 
					earn, productSubtotal, earnSubtotal);
			PSBList.add(psb);
		}
		return PSBList;
	}
	

	@Transactional
	@Override
	public List<LocalDate> showEachDate(String sDate, String eDate) {
		List<LocalDate> datesList = service.showEachDate(sDate, eDate);
		return datesList;
	}


	@Override
	public List<ProductSaleBean> showAllFoodOrders(String playStartTimeA, String playStartTimeB) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductSaleBean> getPeripheralOrders(String orderDateA, String orderDateB) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductSaleBean> showFoodOrder(String categoryName, String playStartTimeA, String playStartTimeB) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductSaleBean> showFoodOrders(String categoryNameA, String categoryNameB, String playStartTimeA,
			String playStartTimeB) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductSaleBean> showPeripheralOrder(String categoryName, String orderDateA, String orderDateB) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductSaleBean> showPeriperalOrders(String categoryNameA, String categoryNameB, String orderDateA,
			String orderDateB) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> getDistinctProductNames() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductSaleBean> getFoodEarnByDateOutput(List<LocalDate> datesList, String productName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductSaleBean> getPeripheralEarnByDateOutput(List<LocalDate> datesList, String productName) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
