package com.a.dao;

import java.sql.Timestamp;
import java.util.List;

import com.a.model.ShowTimeHistoryBean;

public interface ShowtimeHistory {
	//將確認的檔期存下
		public void addShowTimeHistory(ShowTimeHistoryBean show);
		// 從showtime 拿這個星期電影 可以考慮只拿ID?
		public List<ShowTimeHistoryBean> getshowMovie(Timestamp playStartTime);
}
