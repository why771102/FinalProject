package com.c.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.dao.HallDao;
import com.c.model.HallBean;
import com.c.service.HallService;

@Service
public class HallServiceImpl implements HallService {
	
	HallDao dao;
	
	@Autowired
	public void setDao(HallDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public HallBean getHall(String hallID) {
		return dao.getHall(hallID);
	}

	@Transactional
	@Override
	public List<HallBean> getAllHalls(Integer status) {
		return dao.getAllHalls(status);
	}

	@Transactional
	@Override
	public void updateStatus(Integer hallID, Integer status) {
		dao.updateStatus(hallID, status);
	}

	@Transactional
	@Override
	public void insertHall(HallBean hb) {
		dao.insertHall(hb);
	}

	@Transactional
	@Override
	public void updateHall(HallBean hb) {
		dao.updateHall(hb);
		
	}

	@Transactional
	@Override
	public void updateHallRC(String hallID, Integer colNum, Integer rowNum, Integer noOfSeats) {
		dao.updateHallRC(hallID, colNum, rowNum, noOfSeats);
	}
	
	@Transactional
	@Override
	public String getAllHallTags() {
		return dao.getAllHallTags();
	}
	
	@Transactional
	@Override
	public List<String> getAllHall() {
		return dao.getAllHall();
	}
	@Transactional
	@Override
	public String getHallStatus(String hallID) {
		return dao.getHallStatus(hallID);
	}

}
