package com.m.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.a.model.SCOrdersBean;
import com.l.model.MOrderBean;
import com.m.dao.ProductSaleEarnDao;
import com.m.service.ProductSaleEarnService;

@Service
public class ProductSaleEarnServiceImpl implements ProductSaleEarnService {
	
	ProductSaleEarnDao dao;

	@Autowired
	public void setDao(ProductSaleEarnDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public List<MOrderBean> saveFoodInfoToDB() {	
		return dao.saveFoodInfoToDB();
	}
	
	@Transactional
	@Override
	public List<SCOrdersBean> savePheriperalDB() {
		return dao.savePheriperalDB();
	}

}
