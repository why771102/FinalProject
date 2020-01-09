package com.c.service.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.dao.NumberOfSeatsDao;
import com.c.model.HallBean;
import com.c.model.NumberOfSeatsBean;
import com.c.service.NumberOfSeatsService;

@Service
public class NumberOfSeatsServiceImpl implements NumberOfSeatsService {

	NumberOfSeatsDao dao;
	
	@Autowired
	public void setDao(NumberOfSeatsDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public void insertNumberofSeats(NumberOfSeatsBean nosb) {
		dao.insertNumberofSeats(nosb);

	}

	@Transactional
	@Override
	public List<NumberOfSeatsBean> getNumberOfSeats(Date date) {
		return dao.getNumberOfSeats(date);
	}

	@Transactional
	@Override
	public HallBean getHallById(String hallID) {
		return dao.getHallById(hallID);
	}

}
