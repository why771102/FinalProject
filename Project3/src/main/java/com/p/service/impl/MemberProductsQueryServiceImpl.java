package com.p.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.TicketBean;
import com.p.dao.HallOrderDao;
import com.p.dao.MemberProductsQueryDao;
import com.p.model.HallOrderBean;
import com.p.service.MemberProductsQueryService;

public class MemberProductsQueryServiceImpl implements MemberProductsQueryService {
	
	MemberProductsQueryDao dao;
	
	@Autowired
	public void setDao(MemberProductsQueryDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<MOrderBean> getMOrderBeanByMemberID(Integer memberID) {
		return dao.getMOrderBeanByMemberID(memberID);
	}
	
	@Transactional
	@Override
	public MOrderDetailBean getListMOrderDetailBeanByOrdersID(Integer ordersID) {
		return dao.getListMOrderDetailBeanByOrdersID(ordersID);
	}

	@Transactional
	@Override
	public List<MOrderDetailBean> checkMOrder(Integer memberID) {
		List<MOrderBean> list = dao.getMOrderBeanByMemberID(memberID);
		List<MOrderDetailBean> mdb_list = new ArrayList<>();
		for(MOrderBean mob:list) {
			Integer ordersID = mob.getOrdersID();
			MOrderDetailBean mdb = dao.getListMOrderDetailBeanByOrdersID(ordersID);
			mdb_list.add(mdb);
		}
		return mdb_list;
	}

	@Override
	public TicketBean getTicketBeanByOrdersID(Integer ordersID) {
		return dao.getTicketBeanByOrdersID(ordersID);
	}

	@Override
	public List<TicketBean> checkTicket(Integer memberID) {
		List<MOrderBean> list = dao.getMOrderBeanByMemberID(memberID);
		List<TicketBean> tb_list = new ArrayList<>();
		for(MOrderBean mob:list) {
			Integer ordersID = mob.getOrdersID();
			TicketBean tb = dao.getTicketBeanByOrdersID(ordersID);
			tb_list.add(tb);
		}
		return tb_list;
	}

}
