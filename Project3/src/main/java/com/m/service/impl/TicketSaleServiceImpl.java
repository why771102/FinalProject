package com.m.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.c.service.HallService;
import com.m.dao.TicketSaleDao;
import com.m.service.TicketSaleService;

@Service
public class TicketSaleServiceImpl implements TicketSaleService {

	TicketSaleDao dao;
	TicketSaleService service;
	
	@Autowired
	public void setDao(TicketSaleDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	public void setService(TicketSaleService service) {
		this.service = service;
	}
	
	@Transactional
	@Override
	public List<RunningBean> ShowMovieByRunTime() {
		return dao.ShowMovieByRunTime();
	}
	
	@Transactional
	@Override
	public List<RunningBean> CompareByTime(String sDate, String eDate) {
		List<RunningBean> getRBList = dao.ShowMovieByRunTime();
		List<RunningBean> RBList = new ArrayList<>();
		// if eod=od{ed-eod=0}, eif od>eod{od-ed>=0}, eif od<eod{od-ed>=0}
		LocalDate Sd = LocalDate.parse(sDate);
		LocalDate Ed = LocalDate.parse(eDate);

		for (RunningBean rb : getRBList) {
			// 去掉後面的秒數
			LocalDate Rd = LocalDateTime.parse(rb.getRelease()).toLocalDate();
			LocalDate Eod = LocalDateTime.parse(rb.getExpectedOffDate()).toLocalDate();
			LocalDate Od = LocalDateTime.parse(rb.getOffDate()).toLocalDate();

			long RdSdDays = ChronoUnit.DAYS.between(Rd, Sd);
			long EodOdDays = ChronoUnit.DAYS.between(Eod, Od);
			long EdOdDays = ChronoUnit.DAYS.between(Ed, Od);

			if (RdSdDays >= 0) {
				if (EodOdDays == 0) {
					// 取出資料
					RBList.add(rb);
				} else if (EodOdDays > 0) {
					if (EdOdDays > 0) {
						// 取出資料
						RBList.add(rb);
					} else {
						System.out.println("對比Od與Ed錯誤");
					}
				} else if (EodOdDays < 0) {
					if (EodOdDays < 0) {
						// 取出資料
						RBList.add(rb);
					} else {
						System.out.println("對比Od與Ed錯誤");
					}
				}
			} else {
				System.out.println("比對查詢日期與上映日期錯誤");
			}
		}
		return RBList;
	}
	
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getshowTimeHistory(List<RunningBean> RBList) {
		List<ShowTimeHistoryBean> sthbList = dao.getshowTimeHistory(RBList);
		return sthbList;
	}
	
	@Transactional
	@Override
	public List<NumberOfSeatsBean> getNumberOfSeats(List<ShowTimeHistoryBean> sthbList) {
		List<NumberOfSeatsBean> nosbList = dao.getNumberOfSeats(sthbList);
		return nosbList;
	}
	
	@Transactional
	@Override
	//getNumberofSeats
	public List<NumberOfSeatsBean> getHallSeats(List<NumberOfSeatsBean> nosbList, String sDate, String eDate) {
		List<NumberOfSeatsBean> nosbLists = dao.getNumberOfSeats(dao.getshowTimeHistory(service.CompareByTime(sDate, eDate)));
		List<NumberOfSeatsBean> nosbListToPage = new ArrayList<>();
		
		LocalDate Sd = LocalDate.parse(sDate);
		LocalDate Ed = LocalDate.parse(eDate);
		
		for(NumberOfSeatsBean nosb : nosbLists) {
			LocalDate Hd = LocalDateTime.parse(nosb.getDate()).toLocalDate();
			long SdHdDays = ChronoUnit.DAYS.between(Sd, Hd);
			long HdEdDays = ChronoUnit.DAYS.between(Hd, Ed);
			
			if(SdHdDays >= 0 && HdEdDays <= 0) {
				//取得資訊
				nosbListToPage.add(nosb);
			}else {
				System.out.println("不符合所需輸入查詢區間與nosb日期比較");
			}
		}
		return nosbListToPage;
	}
	
//	@Override
//	public List<MovieBean> ShowMovieBean(List<RunningBean> RBListToPage) {
//		List<MovieBean> mbToPage = new ArrayList<>();
//		
//		for (RunningBean rb : RBListToPage) {
//			MovieBean mb = rb.getMovie();
////			Integer movieGenre = mb.getGenre();
////			String movieTitle = mb.getTitle();
//			mbToPage.add(mb);
//		}
//		return mbToPage;
//	}
}
