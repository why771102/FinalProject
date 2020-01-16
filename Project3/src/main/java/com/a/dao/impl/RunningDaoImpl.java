package com.a.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
import com.p.model.HallOrderBean;

@Repository
public class RunningDaoImpl implements RunningDao {
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	//新增runBean進DB ok
	@Override
	public void addrunning(RunningBean run) {
		Session session =factory.getCurrentSession();
		session.save(run);

	}
    //尋找從今天開始一個月後要上映的電影(好像可以把需帶入的參數刪掉)//ok
	@SuppressWarnings("unchecked")
	@Override
	public List<RunningBean> getComingSoonMovie() {
		List<RunningBean>rbList =new ArrayList<RunningBean>(); 
		String hql ="from RunningBean where  release >= :startdate and release <= :endate   ";
		Session session =factory.getCurrentSession();
		
		String startTime = (((LocalDate.now().plusDays(1)).toString())+" "+"00:00:00"); 
		String endTime = (((LocalDate.now().plusDays(30)).toString())+" "+"23:59:59");
		System.out.println(startTime);
		System.out.println(endTime);
		rbList=session.createQuery(hql).setParameter("endate", endTime)
                                       .setParameter("startdate", startTime)
                                       .getResultList();
		
		return rbList;
	}
	 //尋找排片所需 今天可以上映的電影 (//只要輸入一個時間LocalDate.now().plusDay(1) //ok
	@Override
	public List<RunningBean> getAllOnMoive(LocalDate day) {
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
  //找今天日期首映的電影 //ok
	@Override
	public List<RunningBean> getReleaseRunnigBean(LocalDate release) {
		String hql ="from RunningBean where  release BETWEEN :stDate AND :edDate  ";
		Session session =factory.getCurrentSession();
		String startTime = (release.toString())+" "+"00:00:00"; 
		String endTime = (release.toString())+" "+"23:59:59"; 
	
		List<RunningBean>rbList =new ArrayList<RunningBean>(); 
		rbList=session.createQuery(hql).setParameter("stDate", startTime)
				                        .setParameter("edDate", endTime)   
                                       .getResultList();
		return rbList;
	}
	
//	public List<HallOrderBean> getHallOrder(LocalDate today) {
//		Session session = factory.getCurrentSession();
//      List<HallOrderBean> hb_list = new ArrayList<>();
//      String hql ="from HallOrderBean where startTime BETWEEN :stDate AND :edDate ";	
//      String startTime = (today.toString())+" "+"00:00:00"; 
//		String endTime = (today.toString())+" "+"23:59:59"; 
//	  hb_list = session.createQuery(hql).setParameter("stDate", startTime)
//                                        .setParameter("edDate", endTime)                            
//                                        .getResultList();	
//		return hb_list;
//	}
	
	 //拿出某段時間內日期的所有電影  ok
	@Override
	public List<RunningBean> getAllOnMoive(LocalDate release, LocalDate expectedOffDate) {
		List<RunningBean>rbList =new ArrayList<RunningBean>(); 
		String hql ="from RunningBean where  release <=  :endate  and expectedOffDate >=  :startdate ";
		
		String startTime = (expectedOffDate.toString()); 
		String endTime = (release.toString()); 
		Session session =factory.getCurrentSession();
		
		rbList=session.createQuery(hql).setParameter("endate", endTime)
                                       .setParameter("startdate", startTime)
                                       .getResultList();
//		rbList=session.createQuery(hql).getResultList();
		
		return rbList;

	}

	//輸入movieID 拿到全部orderBean //ok
	@Override
	public List<RunningBean> getnRunningBeanByMovieID(int movieID){
		String hql ="from RunningBean where  movieID = :ID ";
		Session session =factory.getCurrentSession();
		List<RunningBean>rb_list =new ArrayList<RunningBean>(); 
		rb_list=session.createQuery(hql).setParameter("ID", movieID) .getResultList();
	
		 
		 return rb_list;
	}
	//拿預計下檔日去show table 把 show list 取出 (取最後一個showBean 出來(裡面的runningBean),playStartTime.plus片長)
	//ok
	@Override
	public boolean updateOffDate(RunningBean rb , LocalDateTime OffDate) {
		String hql ="update RunningBean set offDate =:changeOffDate where runID =:ID";
		Session session =factory.getCurrentSession();
		LocalDate date =OffDate.toLocalDate();
		LocalTime time =(OffDate.truncatedTo(ChronoUnit.SECONDS)).toLocalTime();
		String SOffDate = (date.toString()+" "+time.toString()); 
		int n = session.createQuery(hql).setParameter("changeOffDate", SOffDate)
				                        .setParameter("ID", rb.getRunID())
				                        .executeUpdate();
		if(n==0) {
			return false;
		}

		return true;
	}
	//每次排完一天就加1 //ok
	@Override
	public boolean updateOnDate(RunningBean rb , int day) {
		String hql ="update RunningBean set onDate =:changeOnDate where runID =:ID";
		Session session =factory.getCurrentSession();
		int n = session.createQuery(hql).setParameter("changeOnDate",(rb.getOnDate()+1))
				       .setParameter("ID", rb.getRunID())
				       .executeUpdate();
		if(n==0) {
			return false;
		}
		
		return true;
	}
	

}
