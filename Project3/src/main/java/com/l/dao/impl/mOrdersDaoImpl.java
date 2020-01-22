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
	//查詢所有電影之狀態為1
	@Override
	public List<MovieBean> getMovieStatus1() {
				String hql="from MovieBean where movieStatus = 1";
				Session session=factory.getCurrentSession();
				List<MovieBean> list=new ArrayList<>();
				list=session.createQuery(hql).getResultList();
				return list;
			}
	
	//查詢播放時間
	@Override
	public List<RunningBean> getRunningsByMovieId(Integer movieId){
			String hql="from RunningBean where movieId = :movieId";
			List<RunningBean> list=new ArrayList<>();
			Session session=factory.getCurrentSession();
			list=session.createQuery(hql).setParameter(movieId, movieId).getResultList();
			return list;
		
	}
	
	//查詢播放時間
	@Override
	public List<ShowTimeHistoryBean> getplayStartTime(Integer runID){
		String hql="from ShowTimeHistoryBean where runID = :runID";
		List<ShowTimeHistoryBean> list=new ArrayList<>();
		Session session=factory.getCurrentSession();
		list=session.createQuery(hql).setParameter(runID, runID).getResultList();
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
