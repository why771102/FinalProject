package com.a.service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.dao.MovieDao;
import com.a.dao.RunningDao;
import com.a.dao.ShowTimeHistoryDao;
import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.test.ShowtimeBean;
import com.p.model.HallOrderBean;
import com.z.dao.EmpDao;


@Service
public class movieServiceImpl implements MovieService {
	MovieDao MDao;
	RunningDao RDao;
	ShowTimeHistoryDao   SDao;
	
	
	
	@Autowired
	public void setDao(MovieDao MDao) {
		this.MDao = MDao;
	}
	
	@Autowired
	public void setDao(RunningDao RDao) {
		this.RDao = RDao;
	}
	
	@Autowired
	public void setDao(ShowTimeHistoryDao SDao) {
		this.SDao = SDao;
	}

	
	@Transactional
	@Override
	public void addmovie(MovieBean movie) {
		MDao.addmovie(movie);
		
	}

	@Transactional
	@Override
	public void addrunning(RunningBean run) {
	    RDao.addrunning(run);
		
	}

	@Transactional
	@Override
	public List<RunningBean> getComingSoonMovie() {
		
		return RDao.getComingSoonMovie();
	}




	@Transactional
	@Override
	public HallOrderBean getHallOrder(Timestamp date) {
		// TODO Auto-generated method stub
		return null;
	}


	


	@Transactional
	@Override
	public boolean updateMovieStatus(int movieID, int status) {
		// TODO Auto-generated method stub
		return MDao.updateMovieStatus(movieID, status);
	}

	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryBean(RunningBean rb ) {
		// TODO Auto-generated method stub
		return SDao.getShowTimeHistoryBean(rb) ;
	}
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getshowMovie(LocalDate day){
		return SDao.getshowMovie(day) ;
	}

	
	@Transactional
	@Override
	public void addShowTimeHistory(ShowTimeHistoryBean show) {
		SDao.addShowTimeHistory(show);
		
	}
	@Transactional
	@Override
	public List<RunningBean> getAllOnMoive(LocalDate day) {
		// TODO Auto-generated method stub
		return RDao.getAllOnMoive(day);
	}
	@Transactional
	@Override
	public List<RunningBean> getAllOnMoive(LocalDate release, LocalDate expectedOffDate){
		return RDao.getAllOnMoive(release,expectedOffDate);
	}
	
	@Transactional
	@Override
	public List<RunningBean> getReleaseRunnigBean(LocalDate release) {
		// TODO Auto-generated method stub
		return RDao.getReleaseRunnigBean(release);
	}
	@Transactional
	@Override
	public MovieBean getMovieBeanById(int movieID) {
		return MDao.getMovieBeanById(movieID);
	}
	@Transactional
	@Override
	public List<RunningBean> getnRunningBeanByMovieID(int movieID){
		return RDao.getnRunningBeanByMovieID(movieID);
	}
	@Transactional
	@Override
	public boolean updateOnDate(RunningBean rb, int day) {
		return RDao.updateOnDate(rb, day);
	}
	@Transactional
	@Override
	public boolean updateOffDate(RunningBean rb, LocalDateTime OffDate) {
		return RDao.updateOffDate(rb, OffDate);
	}
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getRunBeanLastSTHB(RunningBean rb, String exOffDay, String release){
		
		return SDao.getRunBeanLastSTHB(rb, exOffDay, release);
	
	}
	

	@Override
	public List<RunningBean> sortListbyPT(List<RunningBean> Allrb) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<ShowTimeHistoryBean> createShowTime(List<ShowtimeBean> showtime) {
		// TODO Auto-generated method stub
		return null;
	}


	//確認MOVIE status = 0
		@Override
		public List<RunningBean> checkStatusComingSoon(List<RunningBean> RunList) {
			
			return null;
		}

		
		@Override
		public List<RunningBean> shouldOnRunningBean(List<RunningBean> rb) {
			
			return null;
		}


		@Override
		public List<RunningBean> checkMovieDateCanOn(List<RunningBean> rb) {
			// TODO Auto-generated method stub
			return null;
		}

	@Override
	public List<RunningBean> removeReleaseMovie(List<RunningBean> AllRunList, List<RunningBean> RRunList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
