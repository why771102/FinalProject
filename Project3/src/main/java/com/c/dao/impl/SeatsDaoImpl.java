package com.c.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.dao.SeatsDao;
import com.c.model.SeatsBean;

@Repository
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
