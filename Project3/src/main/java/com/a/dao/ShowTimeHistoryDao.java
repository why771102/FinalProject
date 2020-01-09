package com.a.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;

public interface ShowTimeHistoryDao {
	//將確認的檔期存下
		public void addShowTimeHistory(ShowTimeHistoryBean show);
		// 從showtime 拿這個星期電影 可以考慮只拿ID?
		
		
		List<ShowTimeHistoryBean> getShowTimeHistoryBean(List<RunningBean> Orb);
		
		//這個星期的電影嗎?
		List<ShowTimeHistoryBean> getshowMovie(LocalDateTime playStartTime);
}
