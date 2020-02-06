package com.c.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.dao.HallDao;
import com.c.model.HallBean;
import com.c.model.HallStatusBean;
import com.z.model.EmpBean;

@Repository
public class HallDaoImpl implements HallDao{
	SessionFactory factory;
	String selected = "";
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	//用廳名稱去抓資料傳回hallbean就可以用hb.get...()去抓取其他所需的資料
	@Override
	public HallBean getHall(String hallID) {
//		String hql = "FROM HallBean WHERE hallID = :hallID";
		Session session = factory.getCurrentSession();
		HallBean hb = session.get(HallBean.class, hallID);
//		System.out.println(hb.getHallStatusBean().getHallStatusID());
//		HallBean hb = (HallBean) session.createQuery(hql).setParameter("hallID", hallID).getSingleResult();
		return hb;
	}
	//測試成功

//	@Override
//	public Integer getNumberOfSeats(Integer hallID) {
//		Session session = factory.getCurrentSession();
//		HallBean hb = session.get(HallBean.class, hallID);
//		Integer seats = hb.getNoOfSeats();
//		return seats;
//	}

	
	//抓取多筆的廳資料 顯示在頁面上 for management purposes?
	@SuppressWarnings("unchecked")
	@Override
	public List<HallBean> getAllHalls(Integer status) {
		List<HallBean> list = new ArrayList<>();
		String hql = "FROM HallBean WHERE hallStatus= :hbs";
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql)
				.setParameter("hbs", status)
				.getResultList();
		return list;
	}
	
	@Override
	public HallStatusBean getHallStatusById(Integer hallStatusID) {
		Session session = factory.getCurrentSession();
		HallStatusBean hsb = session.get(HallStatusBean.class, hallStatusID);
		return hsb;
	}

//	@Override
//	public Integer getPrice(Integer hallID) {
//		Session session = factory.getCurrentSession();
//		HallBean hb = session.get(HallBean.class, hallID);
//		Integer price = hb.getPrice();
//		return price;
//	}

	//更新廳的狀態 可能整修或被包廳
	@Override
	public void updateStatus(Integer hallId, Integer status) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE HallBean SET hallStatus = :hallStatus WHERE hallID = :hallID";
		HallStatusBean hsb = getHallStatusById(status);
		session.createQuery(hql).setParameter("hallStatus", hsb)
								.setParameter("hallID", hallId).executeUpdate();
	}

	//新增廳
	@Override
	public void insertHall(HallBean hb) {
		Session session = factory.getCurrentSession();
		HallStatusBean hsb = getHallStatusById(hb.getHallStatus());
		hb.setHallStatusBean(hsb);
		session.save(hb);
	}

	@Override
	public void updateHall(HallBean hb) {
		Session session = factory.getCurrentSession();
		HallStatusBean hsb = getHallStatusById(hb.getHallStatus());
		hb.setHallStatusBean(hsb);
		session.saveOrUpdate(hb);
	}

	@Override
	public void updateHallRC(String hallID, Integer colNum, Integer rowNum, Integer noOfSeats) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE HallBean SET colNum = :colNum, rowNum = :rowNum, noOfSeats = :noOfSeats WHERE hallID = :hallID";
		session.createQuery(hql).setParameter("colNum", colNum)
								.setParameter("rowNum", rowNum)
								.setParameter("hallID", hallID)
								.setParameter("noOfSeats", noOfSeats).executeUpdate();
		
	}
	
	@Override
	public String getAllHallTags() {
		String ans = "";
        List<String> list = getAllHall();
        ans += "<SELECT id='hallID' onchange='showSeats()'>";
        ans += "<option value='' selected='' disabled=''>請選擇</option>";
        for (String hallID : list) {
            if (hallID.equals(selected)) {
                ans += "<option value='" + hallID + "' selected>" + hallID + "</option>";
            } else {
                ans += "<option value='" + hallID + "'>" + hallID + "</option>";
            }
        }
        ans += "</SELECT>";
        return ans;
	}

	@Override
	public List<String> getAllHall() {
		String hql = "SELECT DISTINCT hallID FROM HallBean";
        Session session = factory.getCurrentSession();
        List<String> list = null;
        list = session.createQuery(hql).getResultList();
        return list;
	}

	@Override
	public String getHallStatus(String hallID) {
		String button = "";
		HallBean hb = getHall(hallID);
		
		Integer status = hb.getHallStatusBean().getHallStatusID();
		if(status == 0) {
			button += "<button class=\"checkout-button btn btn-round btn-danger\" id=\"updateHallStatus\" onclick='updateHallStatus()' value='1'\">關閉廳&raquo;</button>";
		}else {
			button += "<button class=\"checkout-button btn btn-round btn-danger\" id=\"updateHallStatus\" onclick='updateHallStatus()' value='0'\">開放廳&raquo;</button>";
		}
		return button;
	}

}
