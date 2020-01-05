package com.c.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.c.dao.SeatsDao;
import com.c.model.HallBean;
import com.c.model.SeatsBean;

public class SeatsDaoImpl implements SeatsDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	//將廳勾選好的位子加入seats table
	@Override
	public void insertSeats(SeatsBean sb){
		Session session = factory.getCurrentSession();
		session.save(sb);
		
	}

	@Override
	public void updateSeatStatus(Integer status, String seatId) {
		Session session = factory.getCurrentSession();
		SeatsBean sb = session.get(SeatsBean.class, seatId);
		sb.setSeatStatus(status);
		session.saveOrUpdate(sb);
	}

}
