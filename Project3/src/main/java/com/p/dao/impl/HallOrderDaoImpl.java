package com.p.dao.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.model.HallBean;
import com.p.dao.HallOrderDao;
import com.p.model.HallOrderBean;
import com.p.model.HallOrderStatusBean;
import com.p.model.MemberBean;
import com.p.model.PayStatusBean;

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
		HallBean hb = getHallByHallID(Hob.getHallID());
		Hob.setHb(hb);
		//以上為存取廳別代碼
		MemberBean mb = getMemberByMemberID(Hob.getMemberID());
		Hob.setMb(mb);
		//以上為存取memeberID
		
		HallOrderStatusBean hosb = gethallOrderStatusBean(Hob.getHallOrderStatusNo()) ;
		Hob.setHob(hosb);
		//以上為存取預設包廳狀態
		PayStatusBean psb = getPayStatusByPSNo(Hob.getPayStatusNo());
		Hob.setPsb(psb);
		//以上為存取預設包廳付款狀態
		
		session.save(Hob);
		return null;
	}
	
	//用包廳申請編號取得包廳資料
	@Override
	public HallOrderBean hallOrderQueryForMail(Integer hallOrderNo) {
		String hql = "From HallOrderBean Where hallOrderNo = :hallOrderNo";
		Session session = factory.getCurrentSession();
		HallOrderBean hob = new HallOrderBean();
		hob = (HallOrderBean) session.createQuery(hql).setParameter("hallOrderNo", hallOrderNo).getSingleResult();
		return hob;
	}
	
	//用戶自行查詢包廳狀況，用MemberID去找
	@SuppressWarnings("unchecked")
	@Override
	public List<HallOrderBean> hallOrderMQuery(Integer MemberID) {
		String hql = "From HallOrderBean Where memberID = :memberID";
		Session session = factory.getCurrentSession();
		List<HallOrderBean> list = new ArrayList<>();
		
		list = session.createQuery(hql).setParameter("memberID", MemberID).getResultList();
		return list;
	}

	//後臺功能，讓員工可查詢所有的包廳申請
	@SuppressWarnings("unchecked")
	@Override
	public List<HallOrderBean> hallOrderEQuery() {
		String hql = "From HallOrderBean";
		Session session = factory.getCurrentSession();
		List<HallOrderBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public HallOrderBean hallOrderStatusChange(HallOrderBean hob) {
		//其實就是update資料庫內的資料  hallOrderStatusNo
//		String hql = "update HallOrderBean h set h.hallOrderStatusNo = :hallOrderStatusNo "
//				+ "where h.hallOrderNo = :hallOrderNo";
		
		Session session = factory.getCurrentSession();
		HallBean hb = getHallByHallID(hob.getHallID());
		MemberBean mb = getMemberByMemberID(hob.getMemberID());
		HallOrderStatusBean hosb = gethallOrderStatusBean(hob.getHallOrderStatusNo());
		hob.setHb(hb);
		hob.setHob(hosb);
		hob.setMb(mb);
		session.saveOrUpdate(hob);
//		System.out.println(hosb.getHallOrderStatus());
//		session.createQuery(hql).setParameter("hallOrderStatusNo",hosb)
//								.setParameter("hallOrderNo", hob.getHallOrderNo())
//								.executeUpdate();
		return null;
	}

	@Override
	public HallOrderBean payStatusChange(HallOrderBean hob) {
		//其實就是update資料庫內的資料  payStatusNo
//		String hql = "update HallOrderBean h set h.payStatusNo = :payStatusNo "
//				+ "where h.hallOrderNo = :hallOrderNo";
		Session session = factory.getCurrentSession();
		HallBean hb = getHallByHallID(hob.getHallID());
		MemberBean mb = getMemberByMemberID(hob.getMemberID());
		PayStatusBean psb = getPayStatusByPSNo(hob.getPayStatusNo());
		hob.setHb(hb);
		hob.setPsb(psb);
		hob.setMb(mb);
		session.saveOrUpdate(hob);
//		session.createQuery(hql).setParameter("h.payStatusNo",hob.getPayStatusNo())
//								.setParameter("h.hallOrderNo", hob.getHallOrderNo())
//								.executeUpdate();
		return null;
	}

	//用於產生hall的下拉式選單
	@Override
	public List<String> getAllhallID() {
		String hql = "Select h.hallID From HallBean h";
		Session session = factory.getCurrentSession();
		List<String> list = session.createQuery(hql).getResultList();
		return list;
	}
	
	@Override
	public HallBean getHallByHallID(String hallID){
		Session session = factory.getCurrentSession();
		HallBean hb = session.get(HallBean.class,hallID);
		return hb;
	}
	
	
	//用hallOrderStatusNo來取HallOrderStatusBean
	@Override
	public HallOrderStatusBean gethallOrderStatusBean(Integer hallOrderStatusNo) {
		HallOrderStatusBean Hob = null;
		Session session = factory.getCurrentSession();
		Hob = session.get(HallOrderStatusBean.class, hallOrderStatusNo);
		return Hob;
	}
	
	//創造兩個Bean的list
	
	@Override
	public List<HallOrderStatusBean> getHallOrderStatusList(){
		String hql = "from HallOrderStatusBean";
		Session session = factory.getCurrentSession();
		List<HallOrderStatusBean> list = session.createQuery(hql).getResultList();
		return list;
	}
	
	@Override
	public List<PayStatusBean> getPayStatusList(){
		String hql = "from PayStatusBean";
		Session session = factory.getCurrentSession();
		List<PayStatusBean> list = session.createQuery(hql).getResultList();
		return list;
	}

	//把memberID存進DB會用到的方法
	@Override
	public MemberBean getMemberByMemberID(Integer memberID) {
		Session session = factory.getCurrentSession();
		MemberBean mb = session.get(MemberBean.class, memberID);
		return mb;
	}

	//把付款狀態存進DB會用到的方法
	@Override
	public PayStatusBean getPayStatusByPSNo(Integer payStatusNo) {
		Session session = factory.getCurrentSession();
		PayStatusBean pb = session.get(PayStatusBean.class, payStatusNo);
		return pb;
	}
	//下面這個是Ally取包廳時間的方法
	@Override
	public List<HallOrderBean> getHallOrder(LocalDate today) {
		Session session = factory.getCurrentSession();
      List<HallOrderBean> hb_list = new ArrayList<>();
      String hql ="from HallOrderBean where startTime BETWEEN :stDate AND :edDate ";	
      String startTime = (today.toString())+" "+"00:00:00"; 
		String endTime = (today.toString())+" "+"23:59:59"; 
	  hb_list = session.createQuery(hql).setParameter("stDate", startTime)
                                        .setParameter("edDate", endTime)                            
                                        .getResultList();	
		return hb_list;
	}


}
