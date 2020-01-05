package com.c.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.c.dao.SeatsDao;
import com.c.model.SeatsBean;

public class SeatsDaoImpl implements SeatsDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void insertSeats(List<SeatsBean> list) {
		Session session = factory.getCurrentSession();
		for (SeatsBean sb : list) {
			session.save(sb);
		}
	}

	@Override
	public void insertNumberofSeats() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SeatsBean> createSeatingTable() {
		
		return null;
	}

}
