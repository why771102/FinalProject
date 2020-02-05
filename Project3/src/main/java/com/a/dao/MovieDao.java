package com.a.dao;

import java.util.List;
import java.util.Map;

import com.a.model.GenreBean;
import com.a.model.MovieBean;
import com.a.model.MovieRatingBean;
import com.a.model.MovieStatusBean;
import com.a.model.RunningBean;

public interface MovieDao {

	// 加電影進 DB
	public void addmovie(MovieBean movie);


	// 拿電影ID 取出名稱等電影基本資料 (order by expectedProfit)
//	public List<MovieBean> getMovie(List<RunningBean> RunList);


	// 更改電影狀態
	public boolean updateMovieStatus(MovieBean movie, int status);

	// 取出這星期有沒有被包場
//	public HallOrderBean getHallOrder(Timestamp date);

//拿電影ID 取一個 MovieBean
	MovieBean getMovieBeanById(int movieID);

	GenreBean getGenreBeanById(Integer genreID);


	MovieRatingBean getMovieRatingBeanById(Integer movieRatingID);


	MovieStatusBean getMovieStatusBeanById(Integer movieStatusID);


	long getRecordCounts(int count);


	int getTotalPages(int count);


	


	Map<Integer, MovieBean> getPageBooks(int pageNo, List<RunningBean> run);


	boolean updatePT_value(MovieBean movie, double PT);
	
	// 拿電影ID 取出movieBean 塞進 runningBean(select 出來就有不用取)




//	//排片過程
//	public ShowTimeHistoryBean createShowTime(List<ShowtimeBean> showtime);

	

}
