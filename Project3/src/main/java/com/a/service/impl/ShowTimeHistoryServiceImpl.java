package com.a.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.dao.ShowTimeHistoryDao;
import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.service.ShowTimeHistoryService;

@Service
public class ShowTimeHistoryServiceImpl implements ShowTimeHistoryService {

	ShowTimeHistoryDao dao;
	
	@Autowired
	public void setDao(ShowTimeHistoryDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public void addShowTimeHistory(ShowTimeHistoryBean show) {
		dao.addShowTimeHistory(show);

	}
	
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryBean(RunningBean rb) {
		return dao.getShowTimeHistoryBean(rb);
	}

	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getshowMovie(LocalDate day) {
		
		return dao.getshowMovie(day);
	}

	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getRunBeanLastSTHB(RunningBean rb, String exOffDay, String release) {
		
		return dao.getRunBeanLastSTHB(rb, exOffDay, release);
	}

	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getRunBeanLastSTHB(String startdate) {
		// TODO Auto-generated method stub
		return dao.getRunBeanLastSTHB(startdate);
	}

//	@Transactional
//	@Override
//	public List<ShowTimeHistoryBean> getRunBeanLastSTHB(String exOffDay, String release) {
//		// TODO Auto-generated method stub
//		return dao.getRunBeanLastSTHB(exOffDay, release);
//	}

	@Transactional
	@Override
	public int getShowTimeIdByTime(String playStartTime) {
		// TODO Auto-generated method stub
		return dao.getShowTimeIdByTime(playStartTime);
	}

	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getshowMovie(LocalDate day, String hallID) {
		// TODO Auto-generated method stub
		return dao.getshowMovie(day, hallID);
	}

	@Transactional
	@Override
	public boolean updateShowTimeHistoryBean(ShowTimeHistoryBean sthb) {
		// TODO Auto-generated method stub
		return dao.updateShowTimeHistoryBean(sthb);
	}

	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryByDate(String endDay, String startDay, String hallID) {
		// TODO Auto-generated method stub
		return dao.getShowTimeHistoryByDate(endDay, startDay, hallID);
	}

	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryByTime(String endDay, String startDay) {
		// TODO Auto-generated method stub
		return dao.getShowTimeHistoryByTime(endDay, startDay);
	}

	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getshowMovieByDayAndHallID(LocalDate day, String hallID) {
		// TODO Auto-generated method stub
		return dao.getshowMovieByDayAndHallID(day, hallID);
	}

	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryListByRunIDAndTime(String runID, String exOffDay,
			String release) {

		return dao.getShowTimeHistoryListByRunIDAndTime(runID, exOffDay, release);
	}
	
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getDistinctMovieID(LocalDateTime startDay) {
		
		return dao.getDistinctMovieID(startDay);
	}
	
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getAWeekShowTimeHistoryBean(LocalDateTime starttime) {
		
		return dao.getAWeekShowTimeHistoryBean(starttime);
	}



}
