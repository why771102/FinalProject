package com.a.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.dao.MovieDao;
import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.test.ShowtimeBean;
import com.p.model.HallOrderBean;
import com.z.dao.EmpDao;


//@Service
public class movieServiceImpl implements MovieService {
	MovieDao dao;
	
	
	@Autowired
	public void setDao(MovieDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public void addmovie(MovieBean movie) {
		// TODO Auto-generated method stub
		

	}
	@Transactional
	@Override
	public void addrunning(RunningBean run) {
		// TODO Auto-generated method stub

	}
	@Transactional
	@Override
	public List<RunningBean> getComingSoonMovie(Timestamp release) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<MovieBean> getmovie(int movieID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getshowMovie(Timestamp playStartTime) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<RunningBean> getrunning(int runID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public boolean updateMovieStatus(int movieID, int status) {
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	@Override
	public HallOrderBean getHallOrder(Timestamp date) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<RunningBean> getAllOnMoive(Timestamp release, Timestamp expectedOffDate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public ShowTimeHistoryBean createShowTime(List<ShowtimeBean> showtime) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public void addShowTimeHistory(ShowTimeHistoryBean show) {
		// TODO Auto-generated method stub

	}

}
