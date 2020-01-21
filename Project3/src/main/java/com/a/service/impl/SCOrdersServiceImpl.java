package com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.dao.SCOrdersDao;
import com.a.model.SCOrdersBean;
import com.a.service.SCOrdersService;
import com.p.model.MemberBean;

@Service
public class SCOrdersServiceImpl implements SCOrdersService {

	SCOrdersDao scodao;
	
	@Autowired
	public void setDao(SCOrdersDao scodao) {
		this.scodao = scodao;
	}
	
	@Transactional
	@Override
	public void insertOrder(SCOrdersBean scob) {
		scodao.insertOrder(scob);

	}

	@Transactional
	@Override
	public MemberBean getMemberBeanById(Integer memberID) {
		return scodao.getMemberBeanById(memberID);
	}

	@Transactional
	@Override
	public SCOrdersBean getOrder(Integer SCOrderID) {
		return scodao.getOrder(SCOrderID);
	}
	@Transactional
	@Override
	public List<SCOrdersBean> getMemberOrders(String memberID, Integer paymentStatus) {
		
		return scodao.getMemberOrders(memberID, paymentStatus);
	}
	@Transactional
	@Override
	public boolean updateStatus(SCOrdersBean ob) {
		return scodao.updateStatus(ob);
	}

}
