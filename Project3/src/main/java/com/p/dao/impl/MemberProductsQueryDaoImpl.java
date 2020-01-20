package com.p.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.HallBean;
import com.c.model.SeatsBean;
import com.l.model.CategoriesBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.l.model.TicketBean;
import com.p.dao.MemberProductsQueryDao;
import com.p.model.HallOrderBean;
import com.p.model.MemberBean;

public class MemberProductsQueryDaoImpl implements MemberProductsQueryDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<MOrderBean> getMOrderBeanByMemberID(Integer memberID) {
		String hql = "From MOrderBean Where memberID = :memberID";
		Session session = factory.getCurrentSession();
		List<MOrderBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("memberID", memberID).getResultList();
		return list;
	}

	@Override
	public MOrderDetailBean getListMOrderDetailBeanByOrdersID(Integer ordersID) {
		String hql = "From MOrderDetailBean where ordersID = :ordersID";
		Session session = factory.getCurrentSession();
		MOrderDetailBean mdb = (MOrderDetailBean) session.createQuery(hql)
														 .setParameter("ordersID", ordersID).getSingleResult();
		return mdb;
	}
	
	//從票抓座位
	@Override
	public TicketBean getTicketBeanByOrdersID(Integer ordersID) {
		String hql = "From TicketBean where ordersID = :ordersID";
		Session session = factory.getCurrentSession();
		TicketBean tb = (TicketBean) session.createQuery(hql)
											.setParameter("ordersID", ordersID).getSingleResult();
		return null;
	}


}
