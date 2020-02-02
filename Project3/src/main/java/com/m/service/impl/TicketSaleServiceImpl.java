package com.m.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.model.ShowTimeHistoryBean;
import com.m.dao.TicketSaleDao;
import com.m.model.TicketSaleEarnBean;
import com.m.service.TicketSaleService;

@Service
public class TicketSaleServiceImpl implements TicketSaleService {

	TicketSaleDao dao;
	TicketSaleService service;

	@Autowired
	public void setDao(TicketSaleDao dao) {
		this.dao = dao;
	}

	@Autowired
	public void setService(TicketSaleService service) {
		this.service = service;
	}

	@Transactional
	@Override
	public String getGenre() {
		return dao.getGenre();
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo(String sDate, String eDate) {
		return dao.getTicketSaleInfo(sDate, eDate);
	}
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String sDate, String eDate) {
		return dao.getDetail(movieID, sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo0(String sDate, String eDate) {
		return dao.getTicketSaleInfo0(sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo1(String sDate, String eDate) {
		return dao.getTicketSaleInfo1(sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo2(String sDate, String eDate) {
		return dao.getTicketSaleInfo2(sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo3(String sDate, String eDate) {
		return dao.getTicketSaleInfo3(sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo4(String sDate, String eDate) {
		return dao.getTicketSaleInfo4(sDate, eDate);
	}
	@Transactional
	@Override
	public String getMovieTitle(Integer movieID) {
		return dao.getMovieTitle(movieID);
	}
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String date) {
		return dao.getDetail(movieID, date);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfoByDate(Integer movieID, String sDate, String eDate) {
		return dao.getTicketSaleInfoByDate(movieID, sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getWithinDate(String date, Integer movieID) {
		return dao.getWithinDate(date, movieID);
	}
}
