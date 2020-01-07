package com.m.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.m.dao.TicketSaleDao;

public class TicketSaleDaoImpl implements TicketSaleDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
