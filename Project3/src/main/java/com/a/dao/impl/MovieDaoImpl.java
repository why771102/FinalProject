package com.a.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.MovieDao;
import com.a.model.GenreBean;
import com.a.model.MovieBean;
import com.a.model.MovieRatingBean;
import com.a.model.MovieStatusBean;
import com.a.model.RunningBean;
import com.p.model.HallOrderBean;
@Repository
public class MovieDaoImpl implements MovieDao {
	SessionFactory factory;
	public static final int recordsPerPage = 8;
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
		System.out.println((movie.getStatus()));
		System.out.println((movie.getMovieRating()));
		MovieStatusBean msb = getMovieStatusBeanById(movie.getStatus());
		MovieRatingBean mrb  = getMovieRatingBeanById (movie.getMovieRating());
		movie.setGenreBean(gb);
		movie.setMovieStatusBean(msb);
		movie.setMovieRatingBean(mrb);
		session.save(movie);
		

	}
	
	//改變PT職
	@Override
	public boolean updatePT_value(MovieBean movie, double PT) {
		String hql ="update MovieBean set expectedProfit =:changePT where movieID =:ID";
		Session session =factory.getCurrentSession();
		String []s=String.valueOf(PT).split("."); 

		int n = session.createQuery(hql).setParameter("changePT", (int)PT)
				                        .setParameter("ID", movie.getMovieID())
				                        .executeUpdate();
		System.out.println("--------------------------------------n :" +n);
		
		if(n==0) {
			return false;
			}else {
					return true;
				}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public long getRecordCounts(int count) {
//		long count = 0; // 必須使用 long 型態
//        String hql = "SELECT count(*) FROM BookBean";
//        Session session = factory.getCurrentSession();
//        List<Long> list = session.createQuery(hql).getResultList();
//        if (list.size() > 0) {
//            count = list.get(0);
//        }
        return count;
	}
	
		// 計算販售的商品總共有幾頁
	@Override
	public int getTotalPages(int count) {
		// 注意下一列敘述的每一個型態轉換
	Integer	totalPages = (int) (Math.ceil(getRecordCounts(count) / (double) recordsPerPage));
		return totalPages;
	}
	
	// 查詢某一頁的商品(書籍)資料，執行本方法前，一定要先設定實例變數pageNo的初值
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, MovieBean> getPageBooks(int pageNo,List<RunningBean> run) {
		Map<Integer, MovieBean> map = new HashMap<>();
		
//		List<MovieBean> list = new ArrayList<MovieBean>();
////        String hql = "FROM MovieBean";
////        Session session = factory.getCurrentSession();
//
//        int startRecordNo = (pageNo - 1) * recordsPerPage;
//        
//          for(RunningBean rb:run) {
//        	  list.add(rb.getMovie());
//          }
//        
////        list = session.createQuery(hql)
////                      .setFirstResult(startRecordNo)
////                      .setMaxResults(recordsPerPage)
////                      .getResultList();
//        for(int i=startRecordNo;i<recordsPerPage;i++) {
//        	map.put(list.get(i).getMovieID(), list.get(i));
//        }
      
		return map;
	}
	
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
	public boolean updateMovieStatus(MovieBean movie, int status) {
		String hql ="update MovieBean set movieStatus =:changeStauts where movieID =:ID";
		MovieStatusBean msb = getMovieStatusBeanById(status);
		Session session =factory.getCurrentSession();
		movie.setMovieStatusBean(msb);
	
		int n = session.createQuery(hql).setParameter("changeStauts", status)
				                        .setParameter("ID", movie.getMovieID())
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
	
	@Override
	public MovieRatingBean getMovieRatingBeanById(Integer movieRatingID) {
		Session session =factory.getCurrentSession();
		MovieRatingBean mrb =session.get(MovieRatingBean.class,  movieRatingID);
		return mrb;
	}
	
	@Override
	public MovieStatusBean getMovieStatusBeanById(Integer movieStatusID) {
		Session session =factory.getCurrentSession();
		 MovieStatusBean msb =session.get(MovieStatusBean.class,  movieStatusID);
		return msb;
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
