package com.a.dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

		List<ShowTimeHistoryBean> getRunBeanLastSTHB(String exOffDay, String release);

		int getShowTimeIdByTime(String playStartTime);

		List<ShowTimeHistoryBean> getshowMovie(LocalDate day, String hallID);

		boolean updateShowTimeHistoryBean(ShowTimeHistoryBean sthb);

		List<ShowTimeHistoryBean> getShowTimeHistoryByDate(String endDay, String startDay);
}
