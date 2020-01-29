package com.l.dao.impl;


import java.time.LocalDate;
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
import com.l.model.ProductsBean;
import com.z.model.EmpBean;


@Repository
public class mOrdersDaoImpl implements mOrdersDao{
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	//查詢所有runID時間在現在時間和expectedOffDate之間之電影ID
		@Override
		public List<RunningBean> getAllOnMoive(LocalDate day){
			List<RunningBean>rbList =new ArrayList<RunningBean>(); 
			String hql ="from RunningBean where  release <= :endTime  and expectedOffDate >= :startTime ";
			String startTime = (day.toString())+" "+"00:00:00"; 
			String endTime = (day.toString())+" "+"23:59:59"; 
			Session session =factory.getCurrentSession();
			rbList=session.createQuery(hql).setParameter("endTime", endTime)
	                                       .setParameter("startTime", startTime)
	                                       .getResultList();
			
			return rbList;
		}
		
		//用runID查出exOffDay和release
		@Override
		public RunningBean getDayAndRelease(Integer runID){
			Session session = factory.getCurrentSession();
			RunningBean rb = session.get(RunningBean.class, runID);
			return rb;
		}
		
		
		//用runID查playStartTime
		@Override
		public List<ShowTimeHistoryBean> getplayStartTime(Integer runID,String dateTime,String exOffDay){
			String hql="from ShowTimeHistoryBean where playStartTime <= :enddate  and playStartTime >= :startdate and runID = :runID";
			String startTime = dateTime; 
			List<ShowTimeHistoryBean> list=new ArrayList<>();
			Session session=factory.getCurrentSession();
			list=session.createQuery(hql).setParameter("enddate", exOffDay)
										.setParameter("startdate", startTime)
										.setParameter("runID", runID).getResultList();
			System.out.println(exOffDay);
			System.out.println(startTime);
			return list;
		}
		
		//用StartTimeID查	單筆
		@Override
		public Object getStartTimeByID(Integer showTimeId) {
		Session session =factory.getCurrentSession();
		ShowTimeHistoryBean sthb=session.get(ShowTimeHistoryBean.class, showTimeId);
			return sthb;
		}
	
	
	
		//新增訂單
		public void addMOrder(MOrderBean mob) {
			Session session =factory.getCurrentSession();
			session.save(mob);
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
