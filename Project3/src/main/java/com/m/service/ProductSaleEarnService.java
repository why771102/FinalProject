package com.m.service;

import java.util.List;

import com.a.model.SCOrdersBean;
import com.l.model.MOrderBean;

public interface ProductSaleEarnService {
	public List<MOrderBean> saveFoodInfoToDB();
	public List<SCOrdersBean> savePheriperalDB();
}
