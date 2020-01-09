package com.a.dao;

import java.sql.Timestamp;
import java.util.List;

import com.a.model.RunningBean;

public interface RunningDao {
	// 加電影合約 進DB
		public void addrunning(RunningBean run);
		// 從run 取電影ID
		public List<RunningBean> getComingSoonMovie(Timestamp release);

		// 拿runID 取出movieID 可以考慮只拿ID?
		public List<RunningBean> getrunning(int runID);
		
		// 抓上映日早於排片當天 ,下檔晚於排片當天的run table 所有可以列入排片的片子
		public List<RunningBean> getAllOnMoive(Timestamp release, Timestamp expectedOffDate);
		// 拿電影ID 取出名稱等電影基本資料 getmovie (主要需要movieStatus runningTime)
}
