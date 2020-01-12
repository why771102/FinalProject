package com.a.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.RunningDao;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;

@Repository
public class RunningDaoImpl implements RunningDao {
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void addrunning(RunningBean run) {
		Session session =factory.getCurrentSession();
		session.save(run);

	}
    //尋找從今天開始一個月後要上映的電影(好像可以把需帶入的參數刪掉)
	@SuppressWarnings("unchecked")
	@Override
	public List<RunningBean> getComingSoonMovie() {
		List<RunningBean>rbList =new ArrayList<RunningBean>(); 
		String hql ="from running where  release <= :enddate  and release >= :startdate ";
		Session session =factory.getCurrentSession();
		String startTime = (LocalDate.now().plusWeeks(1).format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+" "+"00:00:00"; 
		String endTime = (LocalDate.now().plusWeeks(4).format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+" "+"23:59:59"; 
		rbList=session.createQuery(hql).setParameter("endate", endTime)
                                       .setParameter("startdate", startTime)
                                       .getResultList();
		
		return rbList;
	}
	 //尋找排片所需 今天要上映的電影 (//只要輸入一個時間LocalDate.now().plusDay(1)
	@Override
	public List<RunningBean> getAllOnMoive(LocalDate day) {
		List<RunningBean>rbList =new ArrayList<RunningBean>(); 
		String hql ="from running where  release <= :endTime  and expectedOffDate >= :startTime ";
		String startTime = (day.format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+" "+"00:00:00"; 
		String endTime = (day.format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+" "+"23:59:59"; 
		Session session =factory.getCurrentSession();
		rbList=session.createQuery(hql).setParameter("endate", endTime)
                                       .setParameter("startdate", startTime)
                                       .getResultList();
		
		return rbList;
	}
  //找今天日期要上映的電影
	@Override
	public List<RunningBean> getReleaseRunnigBean(LocalDate release) {
		String hql ="from running where release like ':day' ";
		Session session =factory.getCurrentSession();
		String startTime = (release.format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+"%"; 
		List<RunningBean>rbList =new ArrayList<RunningBean>(); 
		rbList=session.createQuery(hql).setParameter("date", startTime)                            
                                       .getResultList();
		return rbList;
	}
	 //拿出某段時間內日期的電影
	@Override
	public List<RunningBean> getAllOnMoive(LocalDate release, LocalDate expectedOffDate) {
		List<RunningBean>rbList =new ArrayList<RunningBean>(); 
		String hql ="from running where  release <= :endTime  and expectedOffDate >= :startTime ";
		String startTime = (expectedOffDate.format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+" "+"00:00:00"; 
		String endTime = (release.format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+" "+"23:59:59"; 
		Session session =factory.getCurrentSession();
		rbList=session.createQuery(hql).setParameter("endate", endTime)
                                       .setParameter("startdate", startTime)
                                       .getResultList();
		
		return rbList;

	}
	//把 ShowTimeHistoryBean 的 runID 放進去拿出 runningBean
	@Override
	public List<ShowTimeHistoryBean> putRunBeanInShowTimeHistoryBean(List<ShowTimeHistoryBean> STHBList) {
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		
		for(ShowTimeHistoryBean sthb: STHBList) {
		
		RunningBean rb =null;
		rb =session.get(RunningBean.class,  sthb.getRunID());
		sthb.setRun(rb);
		
		STHB_List.add(sthb);
		}
		
		return STHB_List;
		
	}

}
