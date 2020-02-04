package com.a.dao;

import java.time.LocalDate;
import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;

public interface ShowTimeHistoryDao {
	//將確認的檔期存下
		public void addShowTimeHistory(ShowTimeHistoryBean show);
		// 從showtime 拿這個星期電影 可以考慮只拿ID?
		
		// 把orderList 換成 showTime List
		List<ShowTimeHistoryBean> getShowTimeHistoryBean(RunningBean rb );
		
		 //拿某一天的全部的show
		List<ShowTimeHistoryBean> getshowMovie(LocalDate day);

		//拿指定orderID的上映日到下檔日全部的show
		List<ShowTimeHistoryBean> getRunBeanLastSTHB(RunningBean rb, String exOffDay, String release);

		List<ShowTimeHistoryBean>  getRunBeanLastSTHB(String startdate);

//		List<ShowTimeHistoryBean> getRunBeanLastSTHB(String exOffDay, String release);

		int getShowTimeIdByTime(String playStartTime);

		List<ShowTimeHistoryBean> getshowMovie(LocalDate day, String hallID);

		boolean updateShowTimeHistoryBean(ShowTimeHistoryBean sthb);

		List<ShowTimeHistoryBean> getShowTimeHistoryByDate(String endDay, String startDay, String hallID);

		List<ShowTimeHistoryBean> getShowTimeHistoryByTime(String endDay, String startDay);

		List<ShowTimeHistoryBean> getshowMovieByDayAndHallID(LocalDate day, String hallID);

		List<ShowTimeHistoryBean> getShowTimeHistoryListByRunIDAndTime(String runID, String exOffDay, String release);
		
		List<MovieBean> getDistinctMovieID(String endDay, String startDay);
}
