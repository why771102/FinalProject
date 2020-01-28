package com.m.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l.model.MOrderBean;
import com.m.dao.TicketSaleEarnDao;
import com.m.service.TicketSaleEarnService;

@Service
public class TicketSaleEarnServiceImpl implements TicketSaleEarnService {

	TicketSaleEarnDao dao;

	@Autowired
	public void setDao(TicketSaleEarnDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public List<MOrderBean> saveTicketInfoToDB() {
		return dao.saveTicketInfoToDB();
	}

}
