package com.m.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.m.dao.ProductSaleDao;

public class ProductSaleDaoImpl implements ProductSaleDao {

	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
}
