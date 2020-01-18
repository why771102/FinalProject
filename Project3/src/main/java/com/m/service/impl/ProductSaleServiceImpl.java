package com.m.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.m.dao.ProductSaleDao;
import com.m.model.ProductSaleBean;
import com.m.service.ProductSaleService;

@Service
public class ProductSaleServiceImpl implements ProductSaleService {

	ProductSaleDao dao;

	@Autowired
	public void setDao(ProductSaleDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public String getCategoryNames() {
		return dao.getCategoryNames();
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showAllProductOrders(String playStartTimeA, String playStartTimeB) {
		return dao.showAllProductOrders(playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showPeripheralOrders(String orderDateA, String orderDateB) {
		return dao.getPeripheralOrders(orderDateA, orderDateB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showFoodOrder(String categoryName, String playStartTimeA, String playStartTimeB) {
		return dao.showFoodOrder(categoryName, playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showFoodOrders(String playStartTimeA,
			String playStartTimeB) {
		return dao.showFoodOrders(playStartTimeA, playStartTimeB);
	}

//	@Transactional
//	@Override
//	public List<ProductSaleBean> showPeripheralOrder(String categoryName, String orderDateA, String orderDateB) {
//		return dao.showPeripheralOrder(categoryName, orderDateA, orderDateB);
//	}

//	@Transactional
//	@Override
//	public List<ProductSaleBean> showPeriperalOrders(String categoryNameA, String categoryNameB, String orderDateA,
//			String orderDateB) {
//		return dao.showPeriperalOrders(categoryNameA, categoryNameB, orderDateA, orderDateB);
//	}
	
	
	@Transactional
	@Override
	public List<String> getDistinctProductNames() {
		List<String> productNamesList = dao.getDistinctProductNames();
		return productNamesList;
	}

	@Transactional
	@Override
	public List<ProductSaleBean> getProductSaleOutput(List<ProductSaleBean> psbList) {
		List<ProductSaleBean> PSBList = new ArrayList<>();
		List<String> productNames = dao.getDistinctProductNames();

		for (String productName : productNames) {
			String saveProductName = null;
			Integer unitPrice = 0;
			Double discount = 0.0;
			Integer qty = 0;
			Double productSubtotal = 0.0;
			
			for (ProductSaleBean psb : psbList) {
				//如果產品名稱相同就存
				if(productName.equals(psb.getProductName())) {
					saveProductName = productName;
					qty = qty + psb.getQty();
					unitPrice = psb.getUnitPrice();
					discount = psb.getDiscount();
					productSubtotal = productSubtotal + unitPrice*discount*qty;
					psbList.remove(psb);
				}else {
					System.out.println("比對時,DB產品名稱&psb名稱不同");
				}
			}
			ProductSaleBean psb = new ProductSaleBean(saveProductName, unitPrice, qty, productSubtotal);
			PSBList.add(psb);
		}
		return PSBList;
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB) {
		return dao.showFoodOrderByTime(productName, playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB) {
		return dao.showPeripheralOrderByTime(productName, orderDateA, orderDateB);
	}

	@Transactional
	@Override
	public List<LocalDate> showEachDate(String sDate, String eDate) {
		LocalDate start = LocalDate.parse(sDate);
		LocalDate end = LocalDate.parse(eDate);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
		    totalDates.add(start);
		    start = start.plusDays(1);
		}
		return totalDates;
	}
	
	@Transactional
	@Override
	//showFoodSaleByDate
	public List<ProductSaleBean> getFoodSaleByDateOutput(List<LocalDate> datesList, String productName) {
		List<ProductSaleBean> PSBList = new ArrayList<>();
		
		for (LocalDate date : datesList) {
			PSBList = dao.showFoodOrderByTime(productName, date.toString(), date.toString());
		}
		return PSBList;
	}
	
	@Transactional
	@Override
	//showPeripheralSaleByDate
	public List<ProductSaleBean> getPeripheralSaleByDateOutput(List<LocalDate> datesList, String productName) {
		List<ProductSaleBean> PSBList = new ArrayList<>();
		
		for (LocalDate date : datesList) {
			PSBList = dao.showPeripheralOrderByTime(productName, date.toString(), date.toString());
		}
		return PSBList;
	}
}
