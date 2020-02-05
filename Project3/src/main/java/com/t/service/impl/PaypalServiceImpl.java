package com.t.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.t.dao.PaypalDao;
import com.t.service.PaypalService;

@Service
public class PaypalServiceImpl implements PaypalService{

	PaypalDao dao;
	
	@Transactional
	@Autowired
	public void setDao(PaypalDao dao) {
		this.dao = dao;
	}
}
