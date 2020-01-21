package com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.dao.SCOrderDetailsDao;
import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.service.SCOrderDetailsService;
import com.l.model.ProductsBean;

@Service
public class SCOrderDetailsServiceImpl implements SCOrderDetailsService {

	SCOrderDetailsDao scoddao;
	
	@Autowired
	public void setDao(SCOrderDetailsDao scoddao) {
		this.scoddao = scoddao;
	}
	
	@Transactional
	@Override
	public void insertOrderDetails(SCOrderDetailBean scodb) {
		scoddao.insertOrderDetails(scodb);

	}

	@Transactional
	@Override
	public SCOrdersBean getSCOrdersBeanByID(Integer SCOrderID) {
		return scoddao.getSCOrdersBeanByID(SCOrderID);
	}

	@Transactional
	@Override
	public ProductsBean getProductsBeanByID(Integer productID) {

		return scoddao.getProductsBeanByID(productID);
	}
	
	@Transactional
	@Override
	public List<SCOrderDetailBean> getOrderDetails(Integer SCOrderID) {

		return scoddao.getOrderDetails(SCOrderID);
	}

}
