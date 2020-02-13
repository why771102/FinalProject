package com.p.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.TicketBean;
import com.p.dao.MemberProductsQueryDao;
import com.p.service.MemberProductsQueryService;

@Service
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
	public List<MOrderDetailBean> getListMOrderDetailBeanByOrdersID(Integer ordersID) {
		return dao.getListMOrderDetailBeanByOrdersID(ordersID);
	}

	@Transactional
	@Override
	public List<MOrderDetailBean> checkMOrder(Integer memberID) {
		List<MOrderBean> list = dao.getMOrderBeanByMemberID(memberID);
		List<MOrderDetailBean> mdb_list = new ArrayList<>();
		for(MOrderBean mob:list) {
			Integer ordersID = mob.getOrdersID();
			List<MOrderDetailBean> mdb = dao.getListMOrderDetailBeanByOrdersID(ordersID);
			mdb_list.addAll(mdb);
		}
		return mdb_list;
	}

	@Transactional
	@Override
	public TicketBean getTicketBeanByOrdersID(Integer ordersID) {
		return dao.getTicketBeanByOrdersID(ordersID);
	}

	@Transactional
	@Override
	public List<TicketBean> checkTicket(Integer memberID) {
		List<MOrderBean> list = dao.getMOrderBeanByMemberID(memberID);
        List<TicketBean> tb_list = null;
		//		List<TicketBean> tb_list = new ArrayList<>();
		for(MOrderBean mob:list) {
			Integer ordersID = mob.getOrdersID();
			System.out.println("看這邊" + ordersID);
			tb_list = dao.getTicketBeanByOrdersID2(ordersID);
//			tb_list.add(tb);
		}
		return tb_list;
		
//		List<MOrderBean> list = dao.getMOrderBeanByMemberID(memberID);
//		List<TicketBean> tb_list = new ArrayList<>();
//		for(MOrderBean mob:list) {
//			Integer ordersID = mob.getOrdersID();
//			System.out.println("看這邊" + ordersID);
//			TicketBean tb = dao.getTicketBeanByOrdersID(ordersID);
//			tb_list.add(tb);
//		}
//		return tb_list;
	}

	@Transactional
	@Override
	public List<TicketBean> getTicketBeanByOrdersID2(Integer ordersID) {
		return dao.getTicketBeanByOrdersID2(ordersID);
	}

}
