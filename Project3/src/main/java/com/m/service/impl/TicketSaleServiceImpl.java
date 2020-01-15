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
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.m.dao.TicketSaleDao;
import com.m.model.TicketSaleBean;
import com.m.service.TicketSaleService;
import com.p.model.HallOrderBean;

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
	public List<MOrderBean> getMOrderBean() {
		return dao.getMOrderBean();
	}

	@Transactional
	@Override
	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList) {
		List<TicketSaleBean> tsbListFromMovie = dao.getTicketSaleBean(modList);
		return tsbListFromMovie;
	}

	@Transactional
	@Override
	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList) {
		List<TicketSaleBean> tsbListFromOrder = dao.getMOrderDetailBeanList(tsbList);
		return tsbListFromOrder;
	}

	@Transactional
	@Override
	public List<String> getDistinctTitles() {
		List<String> TitlesList = dao.getDistinctTitles();
		return TitlesList;
	}

	@Transactional
	@Override
	public List<TicketSaleBean> comparedByTime(String sDate, String eDate) {
		List<TicketSaleBean> tsbListFromMovie = dao.getTicketSaleBean(dao.getMOrderBean());
		List<String> TitlesList = dao.getDistinctTitles();
		List<TicketSaleBean> tsbList = new ArrayList<>();

		LocalDate Sd = LocalDate.parse(sDate);
		LocalDate Ed = LocalDate.parse(eDate);

		for (TicketSaleBean tsblfm : tsbListFromMovie) {
			// 比較電影放映日與使用者輸入日期
			LocalDate Pd = LocalDateTime.parse(tsblfm.getPlayStartTime()).toLocalDate();
			long SdPdDays = ChronoUnit.DAYS.between(Sd, Pd);
			long PdEdDays = ChronoUnit.DAYS.between(Pd, Ed);

			if (SdPdDays >= 0 && PdEdDays <= 0) {
				// 特定日期區間去比對電影名稱
				for (String title : TitlesList) {
					if (title.equals(tsblfm.getTitle())) {
						// 取出資訊存到新List中
						tsbList.add(tsblfm);
//Long的Bean
						// 用新的list去取得相對的販售數量與價格
						List<TicketSaleBean> tsbListFromOrder = dao.getMOrderDetailBeanList(tsbList);
						for (TicketSaleBean tsb : tsbListFromOrder) {
							Integer c = tsb.getCategory();
							Long seatSaleTotal = 0L; //售出座位總數
							Long tTotal = 0L; //票卷類加總
							Long fTotal = 0L; //餐點類加總
							// ==================都有的：抓片長=================
							if ( (c == 1) || (c == 2) || (c==3 && tsb.getProductID()==13)) { // c = 1,2 Ticket qty*1
								seatSaleTotal = seatSaleTotal + tsb.getQuantity();//售出座位數
								tTotal = tTotal + (tsb.getUnitPrice() * tsb.getQuantity()); //售出小計加總
								
							} else if ( (c == 3) && (tsb.getProductID()==15) ) { // c=3 Ticket qty*2
								seatSaleTotal = seatSaleTotal + (tsb.getQuantity()*2); //售出座位數
								tTotal = tTotal + (tsb.getUnitPrice() * tsb.getQuantity());//售出小計加總
								
							} else if (c == 4) { // food4
								fTotal = fTotal + (tsb.getUnitPrice() * tsb.getQuantity());//售出小計加總
								
							} else if (c == 5) { // food5: 有discount
								fTotal = fTotal + Math.round(tsb.getUnitPrice() * tsb.getQuantity() * tsb.getDiscount());//售出小計加總
							
							}else {
								System.out.println("比較category發生例外--tssl");
							}
							
							Long ticketSaleSubtotal = tTotal + fTotal; // 票卷與食物消費總額
							
						}

						// 取出資訊存到新List中
						tsbListFromMovie.remove(tsblfm);
					} else {
						System.out.println("比對時,DB電影名稱&tsblfm名稱不同");
					}
				}
			} else {
				// 這邊可以remove不需要的嗎?
				System.out.println("不符合所需輸入查詢區間與playStartTime日期比較");
			}
		}
		return null;
	}

	public List<TicketSaleBean> getTicketSaleBeanOutput(List<TicketSaleBean> tsbListFromOrder,
			List<TicketSaleBean> tsbListFromMovie) {
		return null;
	}

	// =====================================================================
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
	// getNumberofSeats
	public List<NumberOfSeatsBean> getHallSeats(List<NumberOfSeatsBean> nosbList, String sDate, String eDate) {
		List<NumberOfSeatsBean> nosbLists = dao
				.getNumberOfSeats(dao.getshowTimeHistory(service.CompareByTime(sDate, eDate)));
		List<NumberOfSeatsBean> nosbListToPage = new ArrayList<>();

		LocalDate Sd = LocalDate.parse(sDate);
		LocalDate Ed = LocalDate.parse(eDate);

		for (NumberOfSeatsBean nosb : nosbLists) {
			LocalDate Hd = LocalDateTime.parse(nosb.getDate()).toLocalDate();
			long SdHdDays = ChronoUnit.DAYS.between(Sd, Hd);
			long HdEdDays = ChronoUnit.DAYS.between(Hd, Ed);

			if (SdHdDays >= 0 && HdEdDays <= 0) {
				// 取得資訊
				nosbListToPage.add(nosb);
			} else {
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
