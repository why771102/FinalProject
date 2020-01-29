package com.m.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m.dao.TicketEarnDao;
import com.m.dao.TicketSaleDao;
import com.m.model.TicketSaleEarnBean;
import com.m.service.TicketEarnService;

@Service
public class TicketEarnServiceImpl implements TicketEarnService {

	TicketEarnDao dao;
	TicketSaleDao tDao;
	
	@Autowired
	public void setDao(TicketEarnDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	public void settDao(TicketSaleDao tDao) {
		this.tDao = tDao;
	}
	
	@Transactional
	@Override
	public String getGenre() {
		return tDao.getGenre();
	}
	
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo(String sDate, String eDate) {
		return dao.getTicketEarnInfo(sDate, eDate);
	}

	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo0(String sDate, String eDate) {
		return dao.getTicketEarnInfo0(sDate, eDate);
	}

	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo1(String sDate, String eDate) {
		return dao.getTicketEarnInfo1(sDate, eDate);
	}

	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo2(String sDate, String eDate) {
		return dao.getTicketEarnInfo2(sDate, eDate);
	}

	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo3(String sDate, String eDate) {
		return dao.getTicketEarnInfo3(sDate, eDate);
	}

	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo4(String sDate, String eDate) {
		return dao.getTicketEarnInfo4(sDate, eDate);
	}

}