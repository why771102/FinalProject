package com.c.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.model.ShowTimeHistoryBean;
import com.c.dao.SeatOrderDao;
import com.c.model.SeatOrderBean;
import com.c.model.SeatsBean;
import com.c.service.SeatOrderService;

@Service
public class SeatOrderServiceImpl implements SeatOrderService {

	SeatOrderDao dao;
	
	@Autowired
	public void setDao(SeatOrderDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public void insertSeatOrder(SeatOrderBean sob) {
		dao.insertSeatOrder(sob);

	}
	
	@Transactional
	@Override
	public SeatsBean getSeatsById(String seatID) {
		return dao.getSeatsById(seatID);
	}
	
	@Transactional
	@Override
	public ShowTimeHistoryBean getShowTimeById(Integer showTimeID) {
		return dao.getShowTimeById(showTimeID);
	}

}
