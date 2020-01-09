package com.c.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.dao.SeatsDao;
import com.c.model.HallBean;
import com.c.model.SeatsBean;
import com.c.service.SeatsService;

@Service
public class SeatsServiceImpl implements SeatsService {

	SeatsDao dao;

	@Autowired
	public void setDao(SeatsDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public void insertSeats(SeatsBean sb) {
		dao.insertSeats(sb);

	}

	@Transactional
	@Override
	public HallBean getHallById(String hallID) {
		return dao.getHallById(hallID);
	}

	@Transactional
	@Override
	public void updateSeatStatus(Integer status, String seatID) {
		dao.updateSeatStatus(status, seatID);

	}

	@Transactional
	@Override
	public List<SeatsBean> getAllSeats(String hallID) {
		return dao.getAllSeats(hallID);
	}

}
