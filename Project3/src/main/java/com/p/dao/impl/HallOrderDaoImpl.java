package com.p.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.model.HallBean;
import com.p.dao.HallOrderDao;
import com.p.model.HallOrderBean;
import com.p.model.HallOrderStatusBean;

@Repository
public class HallOrderDaoImpl implements HallOrderDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	

	@Override
	public HallOrderBean hallOrderApply(HallOrderBean Hob) {
		Session session = factory.getCurrentSession();
		String orderDate = Hob.getOrderDate();
		String startTime = Hob.getStartTime();
		String endTime = Hob.getEndTime();
		String newStartTime = orderDate + " " + startTime;
		String newEndTime = orderDate + " " + endTime;
		Hob.setStartTime(newStartTime);
		Hob.setEndTime(newEndTime);
        //以上為處裡起訖時間
		session.save(Hob);
		return null;
	}
	
	//用戶自行查詢包廳狀況，用MemberID去找
	@Override
	public List<HallOrderBean> hallOrderMQuery(Integer MemberID) {
		String hql = "From HallOrderBean h Where h.memberID = :memberID";
		Session session = factory.getCurrentSession();
		List<HallOrderBean> list = new ArrayList<>();
		session.createQuery(hql).setParameter("memberID", MemberID).getResultList();
		return list;
	}

	//後臺功能，讓員工可查詢一段時間內的包廳申請
	@Override
	public List<HallOrderBean> hallOrderEQuery() {
		String hql = "From HallOrderBean";
		Session session = factory.getCurrentSession();
		List<HallOrderBean> list = new ArrayList<>();
		session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public HallOrderBean hallOrderStatusChange(HallOrderBean hob) {
		//其實就是update資料庫內的資料
		String hql = "update HallOrderBean h set h.hallOrderStatusNo = hallOrderStatusNo "
				+ "where h.hallOrderNo = hallOrderNo";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("h.hallOrderStatusNo",hob.getHob().getHallOrderStatusNo())
								.setParameter("h.hallOrderNo", hob.getHallOrderNo())
								.executeUpdate();
		return null;
	}

	@Override
	public HallOrderBean payStatusChange(HallOrderBean hob) {
		//其實就是update資料庫內的資料  payStatusNo
		String hql = "update HallOrderBean h set h.payStatusNo = payStatusNo "
				+ "where h.hallOrderNo = hallOrderNo";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("h.payStatusNo",hob.getPsb().getPayStatusNO())
								.setParameter("h.hallOrderNo", hob.getHallOrderNo())
								.executeUpdate();
		return null;
	}

	//用於產生下拉式選單
	@Override
	public List<String> getAllhallID() {
		String hql = "Select h.hallID From HallBean h";
		Session session = factory.getCurrentSession();
		List<String> list = session.createQuery(hql).getResultList();
		return list;
	}
	
	//用hallOrderStatusNo來取HallOrderStatusBean
	@Override
	public HallOrderStatusBean gethallOrderStatusBean(Integer hallOrderStatusNo) {
		HallOrderStatusBean Hob = null;
		Session session = factory.getCurrentSession();
		Hob = session.get(HallOrderStatusBean.class, hallOrderStatusNo);
		return Hob;
	}
	
	@Override
	public List<HallOrderStatusBean> getHallOrderStatusList(){
		String hql = "from HallOrderStatusBean";
		Session session = factory.getCurrentSession();
		List<HallOrderStatusBean> list = session.createQuery(hql).getResultList();
		return list;
	}

}
