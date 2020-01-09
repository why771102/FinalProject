package com.c.service.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.model.ShowTimeHistoryBean;
import com.c.dao.ReservedSeatsDao;
import com.c.model.SeatsBean;
import com.c.service.ReservedSeatsService;

@Service
public class ReservedSeatsServiceImpl implements ReservedSeatsService {

	ReservedSeatsDao dao;
	
	@Autowired
	public void setDao(ReservedSeatsDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public void insertSeats() {
		dao.insertSeats();
		
	}

	@Transactional
	@Override
	public void reserveSeat(Integer showTimeID, String seatID) {
		dao.reserveSeat(showTimeID, seatID);
		
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

	@Transactional
	@Override
	public void cancelReservedSeat(Integer showTimeID, String seatID) {
		dao.cancelReservedSeat(showTimeID, seatID);
	}

	@Transactional
	@Override
	public List<SeatsBean> getAllSeats(Integer showTimeID, Date date) {
		return dao.getAllSeats(showTimeID, date);
	}

}
