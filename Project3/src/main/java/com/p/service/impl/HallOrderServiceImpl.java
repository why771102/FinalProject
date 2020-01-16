package com.p.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.c.model.HallBean;
import com.p.dao.HallOrderDao;
import com.p.dao.MemberDao;
import com.p.model.HallOrderBean;
import com.p.model.HallOrderStatusBean;
import com.p.model.PayStatusBean;
import com.p.service.HallOrderService;

@Service
public class HallOrderServiceImpl implements HallOrderService {
	
	HallOrderDao dao;
	
	@Autowired
	public void setDao(HallOrderDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public HallOrderBean hallOrderApply(HallOrderBean Hob) {
		return dao.hallOrderApply(Hob);
	}

	@Transactional
	@Override
	public List<HallOrderBean> hallOrderMQuery(Integer MemberID) {
		return dao.hallOrderMQuery(MemberID);
	}

	@Transactional
	@Override
	public List<HallOrderBean> hallOrderEQuery() {
		return dao.hallOrderEQuery();
	}

	@Transactional
	@Override
	public HallOrderBean hallOrderStatusChange(HallOrderBean hob) {
		return dao.hallOrderStatusChange(hob);
	}

	@Transactional
	@Override
	public HallOrderBean payStatusChange(HallOrderBean hob) {
		return dao.payStatusChange(hob);
	}
	
	@Transactional
	@Override
	public List<String> getAllhallID() {
		return dao.getAllhallID();
	}

	@Transactional
	@Override
	public List<PayStatusBean> getPayStatusList() {
		return dao.getPayStatusList();
	}

	@Transactional
	@Override
	public List<HallOrderStatusBean> getHallOrderStatusList() {
		return dao.getHallOrderStatusList();
	}

	@Override
	public List<HallOrderBean> getHallOrder(LocalDate today) {
		return dao.getHallOrder(today);
	}

}
