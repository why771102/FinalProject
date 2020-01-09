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
