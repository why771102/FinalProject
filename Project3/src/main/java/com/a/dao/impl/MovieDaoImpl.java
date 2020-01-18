package com.a.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.MovieDao;
import com.a.model.GenreBean;
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
	
	//新增電影進資料庫ok
	@Override
	public void addmovie(MovieBean movie) {
		Session session =factory.getCurrentSession();
		System.out.println(movie.getGenre());
		GenreBean gb = getGenreBeanById(movie.getGenre());
		movie.setGenreBean(gb);
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
	
    //取出movieBean 然後再存進RunningBean(這個不用了)
//	@Override
//	public List<RunningBean> putMovieBeanInRunBean(List<RunningBean> RunList) {
//		Session session =factory.getCurrentSession();
//		List<RunningBean> RB_List =new ArrayList<>();
//		
//		for(RunningBean rb: RunList) {
//		
//		MovieBean mb =null;
//		mb =session.get(MovieBean.class,  rb.getMovieID());
//		rb.setMovie(mb);
//		
//		RB_List.add(rb);
//		}
//		
//		return RB_List;
//		
//	}
	
	
	
	
	//拿一個movieID 取movieBean ok
	@Override
	public MovieBean getMovieBeanById(int movieID) {
		MovieBean mb =null;
		Session session =factory.getCurrentSession();
		mb =session.get(MovieBean.class,  movieID);
		return mb;
	}
	
    //改變movieSatus (未上映 上映 下檔) //ok
	//setParameter 裡面的型態 要跟你要查詢的欄位型態一樣
	@Override
	public boolean updateMovieStatus(int movieID, int status) {
		String hql ="update MovieBean set status =:changeStauts where movieID =:ID";
		Session session =factory.getCurrentSession();
		int n = session.createQuery(hql).setParameter("changeStauts", status)
				                        .setParameter("ID", movieID)
				                        .executeUpdate();
		if(n==0) {
			return false;
		}

		return true;
	}

	@Override
	public GenreBean getGenreBeanById(Integer genreID) {
		Session session =factory.getCurrentSession();
		GenreBean gb =session.get(GenreBean.class,  genreID);
		return gb;
	}

//	@Override
//	public List<HallOrderBean> getHallOrder(LocalDate today) {
//		Session session = factory.getCurrentSession();
//      List<HallOrderBean> hb_list = new ArrayList<>();
//      String hql ="from HallOrderBean where release like ':day' ";	
//	    //String startTime = (release.format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+"%";    
//	hb_list=session.createQuery(hql).setParameter("date", today)                            
//                                  .getResultList();	
	
	
//		return hb_list;
//	}

}
