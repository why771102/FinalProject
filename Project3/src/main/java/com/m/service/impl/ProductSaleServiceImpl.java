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
	public List<ProductSaleBean> showAllFoodOrders(String playStartTimeA, String playStartTimeB) {
		return dao.showAllFoodOrders(playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showPeripheralOrders(String orderDateA, String orderDateB) {
		return dao.showPeripheralOrders(orderDateA, orderDateB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showFoodOrder(Integer category, String playStartTimeA, String playStartTimeB) {
		return dao.showFoodOrder(category, playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showFoodOrders(Integer categoryA, Integer categoryB, String playStartTimeA,
			String playStartTimeB) {
		return dao.showFoodOrders(categoryA, categoryB, playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showPeripheralOrder(Integer category, String orderDateA, String orderDateB) {
		return dao.showPeripheralOrder(category, orderDateA, orderDateB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showPeripheralOrders(Integer categoryA, Integer categoryB, String orderDateA,
			String orderDateB) {
		return dao.showPeriperalOrders(categoryA, categoryB, orderDateA, orderDateB);
	}

	@Transactional
	@Override
	public List<String> getDistinctProductNames() {
		List<String> productNamesList = dao.getDistinctProductNames();
		return productNamesList;
	}

	@Transactional
	@Override
	public List<ProductSaleBean> getProductSaleOutput(List<String> productNamesList, List<ProductSaleBean> psbList) {
		List<ProductSaleBean> getPSBList = new ArrayList<>();
		List<String> productNames = new ArrayList<>();

		for (String productName : productNamesList) {
			productNames.add(productName);
		}

		for (String productName : productNames) {
			Integer unitPrice = 0;
			Double discount = 0.0;
			Integer qty = 0;
			Double productSubtotal = 0.0;
			
			for (ProductSaleBean psb : psbList) {
				//如果產品名稱相同就存
				if(productName.equals(psb.getProductName())) {
					qty = qty + psb.getQty();
					unitPrice = psb.getUnitPrice();
					discount = psb.getDiscount();
					productSubtotal = productSubtotal + unitPrice*discount*qty;
					psbList.remove(psb);
				}
			}
			ProductSaleBean psb = new ProductSaleBean();
		}
		return getPSBList;
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
		return dao.showEachDate(sDate, eDate);
	}

}
