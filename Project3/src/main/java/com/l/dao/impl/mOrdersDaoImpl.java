package com.l.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;


import com.l.dao.mOrdersDao;
import com.l.model.MOrderBean;

import com.z.model.EmpBean;


@Repository
public class mOrdersDaoImpl implements mOrdersDao{
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//查詢排片ID之電影ID
	@Override
	@SuppressWarnings("unchecked")	
	public List<RunningBean> getRunbyID(){
			String hql="FROM RunningBean";
			Session session=factory.getCurrentSession();;
			List<RunningBean> list=new ArrayList<>();
			list=session.createQuery(hql).getResultList();
			
			return list;
			}
	//查詢電影ID之電影名字
	@Override
	@SuppressWarnings("unchecked")	
	public List<MovieBean> getMovieName() {
				String hql="from MovieBean ";
				Session session=factory.getCurrentSession();;
				List<MovieBean> list=new ArrayList<>();
				list=session.createQuery(hql).getResultList();
				return list;
	}
	
	//查詢所有場次ID
	@Override
	public List<String> getAllShowTimeID() {
			String hql="Select Distinct playStartTime from showTimeID";
			Session session=factory.getCurrentSession();
			List<String> list=new ArrayList<>();
			list=session.createQuery(hql).getResultList();
			return list;
		}
	
	
	//用runID查詢播放日期時間
	@Override
	@SuppressWarnings("unchecked")	
	public List<ShowTimeHistoryBean> getShowTimebyID(Integer runID){
			String hql="from showTimeHistoryBean sthb where sthb.runID=:runID";
			Session session=factory.getCurrentSession();
			List<ShowTimeHistoryBean> list=new ArrayList<>();
			list= session.createQuery(hql).setParameter("showTimeID", runID).getResultList();
			return list;
	}
		//新增訂單
		public void addMOrder(MOrderBean mob) {
			
		}
		//修改訂單之員工ID原本null
		public List<EmpBean> updateEmpbyID(EmpBean eb){
			return null;
		}
		//修改票狀態、領票時間
		public MOrderBean updateTicket(MOrderBean mob) {
			return null;
		}

	

		
}
