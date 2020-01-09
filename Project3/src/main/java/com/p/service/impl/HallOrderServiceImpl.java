package com.p.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p.dao.HallOrderDao;
import com.p.dao.MemberDao;
import com.p.model.HallOrderBean;
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

}
