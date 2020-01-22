package com.m.dao;

import java.util.List;

import com.a.model.SCOrdersBean;
import com.l.model.MOrderBean;

public interface ProductSaleEarnDao {
	
	public List<MOrderBean> saveFoodInfoToDB();
	public List<SCOrdersBean> savePheriperalDB();
}
