package com.a.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.MovieDao;
import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.p.model.HallOrderBean;
@Repository
public class MovieDaoImpl implements MovieDao {
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//新增電影進資料庫
	@Override
	public void addmovie(MovieBean movie) {
		Session session =factory.getCurrentSession();
		session.save(movie);
		

	}
//
//	@Override
//	public List<MovieBean> getmovie(List<RunningBean> RunList) {
//		Session session =factory.getCurrentSession();
//		List<MovieBean> list =new ArrayList<>();
//		
//		for(RunningBean rb: RunList) {
//		
//		MovieBean mb =null;
//		mb =session.get(MovieBean.class,  movieID);
//		list.add(mb);
//		}
//		
//		return list;
//		
//	}
	
    //取出movieBean 然後再存進RunningBean
	@Override
	public List<RunningBean> putMovieBeanInRunBean(List<RunningBean> RunList) {
		Session session =factory.getCurrentSession();
		List<RunningBean> RB_List =new ArrayList<>();
		
		for(RunningBean rb: RunList) {
		
		MovieBean mb =null;
		mb =session.get(MovieBean.class,  rb.getMovieID());
		rb.setMovie(mb);
		
		RB_List.add(rb);
		}
		
		return RB_List;
		
	}
	
	
	
	
	//拿一個movieID 取movieBean
	@Override
	public MovieBean getMovieBeanById(int movieID) {
		MovieBean mb =null;
		Session session =factory.getCurrentSession();
		mb =session.get(MovieBean.class,  movieID);
		return mb;
	}
	
    //改變movieSatus (未上映 上映 下檔)
	@Override
	public boolean updateMovieStatus(int movieID, int status) {
		String hql ="update movies set status =:changeStauts where movieID =:ID";
		Session session =factory.getCurrentSession();
		int n = session.createQuery(hql).setParameter("changeStauts", status)
				                        .setParameter("ID", movieID)
				                        .executeUpdate();
		if(n==0) {
			return false;
		}

		return true;
	}

//	@Override
//	public HallOrderBean getHallOrder(Timestamp date) {
//		Session session = factory.getCurrentSession();
//		return null;
//	}

}
