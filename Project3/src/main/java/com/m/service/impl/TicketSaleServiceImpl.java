package com.m.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.model.ShowTimeHistoryBean;
import com.m.dao.TicketSaleDao;
import com.m.model.TicketSaleEarnBean;
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
	public String getGenre() {
		return dao.getGenre();
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo(String sDate, String eDate) {
		return dao.getTicketSaleInfo(sDate, eDate);
	}
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String sDate, String eDate) {
		return dao.getDetail(movieID, sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo0(String sDate, String eDate) {
		return dao.getTicketSaleInfo0(sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo1(String sDate, String eDate) {
		return dao.getTicketSaleInfo1(sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo2(String sDate, String eDate) {
		return dao.getTicketSaleInfo2(sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo3(String sDate, String eDate) {
		return dao.getTicketSaleInfo3(sDate, eDate);
	}
	@Transactional
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo4(String sDate, String eDate) {
		return dao.getTicketSaleInfo4(sDate, eDate);
	}
	@Transactional
	@Override
	public String getMovieTitle(Integer movieID) {
		return dao.getMovieTitle(movieID);
	}
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String date) {
		return dao.getDetail(movieID, date);
	}
	
	
	
//	@Transactional
//	@Override
//	public List<MOrderBean> getMOrderBean() {
//		return dao.getMOrderBean();
//	}
//
//	@Transactional
//	@Override
//	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList) {
//		List<TicketSaleBean> tsbListFromMovie = dao.getTicketSaleBean(modList);
//		return tsbListFromMovie;
//	}
//
//	@Transactional
//	@Override
//	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList) {
//		List<TicketSaleBean> tsbListFromOrder = dao.getMOrderDetailBeanList(tsbList);
//		return tsbListFromOrder;
//	}
//
//	@Transactional
//	@Override
//	public List<String> getDistinctTitles() {
//		List<String> TitlesList = dao.getDistinctTitles();
//		return TitlesList;
//	}
//
//	@Transactional
//	@Override
//	//input要先有genre => .get新表格bean去獲得相對應的genre
//	public List<TicketSaleBean> comparedByTime(String sDate, String eDate) {
//		List<TicketSaleBean> tsbListFromMovie = dao.getTicketSaleBean(dao.getMOrderBean());
//		List<TicketSaleBean> tsbListFromMovieList = new ArrayList<>();
//
//		LocalDate Sd = LocalDate.parse(sDate);
//		LocalDate Ed = LocalDate.parse(eDate);
////		if() { 比較篩選輸入的genre
//		for (TicketSaleBean tsbl : tsbListFromMovie) {
//			//判斷genre:01234 => db是數字,前端是string
//			// 比較電影放映日與使用者輸入日期
//			LocalDate Pd = LocalDateTime.parse(tsbl.getPlayStartTime()).toLocalDate();
//			long SdPdDays = ChronoUnit.DAYS.between(Sd, Pd);
//			long PdEdDays = ChronoUnit.DAYS.between(Pd, Ed);
//
//			if (SdPdDays >= 0 && PdEdDays <= 0) {
//				tsbListFromMovieList.add(tsbl);
//				tsbListFromMovie.remove(tsbl);
//			} else {
//				System.out.println("不符合所需輸入查詢區間與playStartTime日期比較");
//			}
//		}
////		}
//		return tsbListFromMovieList;
//	}
//
//	@Transactional
//	@Override
//	// p1 => compareByTime() + getTicketSaleOutput()
//	public List<TicketSaleBean> getTicketSaleOutput(List<TicketSaleBean> tsbListFromMovieList) {
//		List<String> TitlesList = dao.getDistinctTitles();
//		List<TicketSaleBean> tsbList1 = new ArrayList<>();
//
//		for (String title : TitlesList) {
//			List<Integer> showTimeLists = new ArrayList<>(); // 存放同一部電影很多個播放ID
//			String movieTitle = null;
//			Integer genre = 0;
//			Integer countShowTime = 0;
//			Integer hallSeats = 0;
//			Integer hallSaleSeats = 0; // 售出座位總數
//			Integer avgHallSaleSeats = 0;
//			Double avgPerOrder = 0.0;
//			Long ticketSaleSubtotal = 0L;
//
//			for (TicketSaleBean tsblfm : tsbListFromMovieList) {
//				List<TicketSaleBean> tsbListFromOrder = dao.getMOrderDetailBeanList(tsbListFromMovieList);
//				if (title.equals(tsblfm.getTitle())) {
//					Integer sID = tsblfm.getShowtimeID();
//					showTimeLists.add(sID);
//					movieTitle = title;
//					genre = tsblfm.getGenre();
//					hallSeats = tsblfm.getHallSeats();
//
//					List<TicketSaleBean> tsbSum = service.getSum(tsbListFromOrder);
//					for (TicketSaleBean tSum : tsbSum) {
//						hallSaleSeats = tSum.getHallSaleSeats();
//						ticketSaleSubtotal = tSum.getTicketSaleSubtotal();
//					}
//				} else {
//					System.out.println("比對時,DB電影名稱&tsblfm名稱不同");
//				}
//				Double avgTemp = (double) (ticketSaleSubtotal / hallSaleSeats);
//				BigDecimal b = new BigDecimal(avgTemp);
//				avgPerOrder = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); // 小數兩位:平均單筆消費/per座位
//			}
//			countShowTime = countRepeatedIntegers(showTimeLists); // 待確認
//			hallSeats = countShowTime * hallSeats;
//			avgHallSaleSeats = (hallSaleSeats / (hallSeats * countShowTime)) * 100;
//
//			TicketSaleBean newTsb = new TicketSaleBean(null, movieTitle, genre, countShowTime, hallSeats, hallSaleSeats,
//					avgHallSaleSeats, avgPerOrder, 0L, 0L, 0.0, ticketSaleSubtotal);
//			tsbList1.add(newTsb);
//		}
//		return tsbList1;
//	}
//
//	// p2: 輸入時間範圍 => 時間陣列, for跑每日, compareByTime(日), 呼叫此方法依該input電影名稱去找相對的資訊
//	@Transactional
//	@Override
//	public List<TicketSaleBean> getTicketSaleOutput2(List<TicketSaleBean> tsbListFromMovieList, String title) {
//		List<TicketSaleBean> tsbList2 = new ArrayList<>();
//		List<Integer> showTimeLists = new ArrayList<>(); // 存放同一部電影很多個播放ID
//		String movieTitle = null;
//		Integer genre = 0;
//		Integer movieHours = 0;
//		Integer countShowTime = 0;
//		Integer hallSeats = 0;
//		Integer hallSaleSeats = 0; // 售出座位總數
//		Integer avgHallSaleSeats = 0;
//		Double avgPerOrder = 0.0;
//		Double avgSalePerHour = 0.0;
//		Long ticketSaleSubtotal = 0L;
//
//		Long ticketSaleTotal = 0L; // 票卷類加總
//		Long foodSaleTotal = 0L; // 餐點類加總
//
//		for (TicketSaleBean tsblfm : tsbListFromMovieList) {
//			List<TicketSaleBean> tsbListFromOrder = dao.getMOrderDetailBeanList(tsbListFromMovieList);
//			if (title.equals(tsblfm.getTitle())) {
//				Integer sID = tsblfm.getShowtimeID();
//				showTimeLists.add(sID);
//				//要存不同時段的播放場次
//				movieTitle = title;
//				genre = tsblfm.getGenre();
//				movieHours = tsblfm.getMovieHours();
//				hallSeats = tsblfm.getHallSeats();
//
//				List<TicketSaleBean> tsbSum = service.getSum(tsbListFromOrder);
//				for (TicketSaleBean tSum : tsbSum) {
//					hallSaleSeats = tSum.getHallSaleSeats();
//					ticketSaleTotal = tSum.getTicketSaleTotal();
//					foodSaleTotal = tSum.getFoodSaleTotal();
//					ticketSaleSubtotal = tSum.getTicketSaleSubtotal();
//				}
//			} else {
//				System.out.println("比對時,DB電影名稱&tsblfm名稱不同");
//			}
//			Double avgTemp = (double) (ticketSaleSubtotal / hallSaleSeats);
//			BigDecimal b = new BigDecimal(avgTemp);
//			avgPerOrder = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); // 小數兩位:平均單筆消費/per座位
//			countShowTime = countRepeatedIntegers(showTimeLists); // 待確認
//			hallSeats = countShowTime * hallSeats;
//			avgHallSaleSeats = (hallSaleSeats / (hallSeats * countShowTime)) * 100;
//			Double mh = (double) (movieHours / 60);
//			avgSalePerHour = ticketSaleSubtotal / (mh * countShowTime);
//			TicketSaleBean newTsb = new TicketSaleBean(showTimeLists, movieTitle, genre, countShowTime, hallSeats,
//					hallSaleSeats, avgHallSaleSeats, avgPerOrder, ticketSaleTotal, foodSaleTotal, avgSalePerHour,
//					ticketSaleSubtotal);
//			tsbList2.add(newTsb);
//		}
//		return tsbList2;
//	}
//
//	@Transactional
//	@Override
//	// p2: output
//	public LinkedHashMap<LocalDate, TicketSaleBean> getInputTimeList(String sDate, String eDate, String title) {
//		List<LocalDate> dtList = pService.showEachDate(sDate, eDate);
//		LinkedHashMap<LocalDate, TicketSaleBean> dateAndTsbMap2 = new LinkedHashMap<LocalDate, TicketSaleBean>();
//
//		for (LocalDate date : dtList) {
//			List<TicketSaleBean> tsbList = service.comparedByTime(date.toString(), date.toString());
//			List<TicketSaleBean> tsbList2 = service.getTicketSaleOutput2(tsbList, title);
//			for (TicketSaleBean tsb : tsbList2) {
//				LocalDate ld = LocalDateTime.parse(tsb.getPlayStartTime()).toLocalDate();
//				if (date == ld) {
//					dateAndTsbMap2.put(date, tsb);
//				}
//			}
//		}
//		return dateAndTsbMap2;
//	}
//
//	// p3
//	// input一天時間compareByTime(),注意PlayStartTime是LocalDateTime, 要在p3方法計算比較~~
//	// 比較所有Orders是否相同(放入LinkedHashMap再取出key, 取出值後看要怎麼輸出畫面變成區間???) //加上movieHours
//	// LinkedHashMap再取出value放一個tsbBean
//	@Transactional
//	@Override
//	public List<TicketSaleBean> getTicketSaleOutput3(List<TicketSaleBean> tsbListFromMovieList, String title) {
//		List<TicketSaleBean> tsbList3 = new ArrayList<>();
////			List<String> playStartTimes = new ArrayList<>(); // 存放同一部電影很多個撥放時間
//		String hallID = null;
//		String playStartTime = null;
//		String movieTitle = null;
//		Integer genre = 0;
//		Integer movieHours = 0;
//		Integer hallSeats = 0;
//		Integer hallSaleSeats = 0; // 售出座位總數
//		Integer avgHallSaleSeats = 0;
//		Double avgPerOrder = 0.0;
//		Double avgSalePerHour = 0.0;
//		Long ticketSaleSubtotal = 0L;
//
//		Long ticketSaleTotal = 0L; // 票卷類加總
//		Long foodSaleTotal = 0L; // 餐點類加總
//
//		for (TicketSaleBean tsblfm : tsbListFromMovieList) {
//			List<TicketSaleBean> tsbListFromOrder = dao.getMOrderDetailBeanList(tsbListFromMovieList);
//			if (title.equals(tsblfm.getTitle())) {
//				hallID = tsblfm.getHallID();
//				playStartTime = tsblfm.getPlayStartTime();
//				movieTitle = title;
//				genre = tsblfm.getGenre();
//				movieHours = tsblfm.getMovieHours();
//				hallSeats = tsblfm.getHallSeats();
//
//				List<TicketSaleBean> tsbSum = service.getSum(tsbListFromOrder);
//				for (TicketSaleBean tSum : tsbSum) {
//					hallSaleSeats = tSum.getHallSaleSeats();
//					ticketSaleTotal = tSum.getTicketSaleTotal();
//					foodSaleTotal = tSum.getFoodSaleTotal();
//					ticketSaleSubtotal = tSum.getTicketSaleSubtotal();
//				}
//			} else {
//				System.out.println("比對時,DB電影名稱&tsblfm名稱不同");
//			}
//			Double avgTemp = (double) (ticketSaleSubtotal / hallSaleSeats);
//			BigDecimal b = new BigDecimal(avgTemp);
//			avgPerOrder = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); // 小數兩位:平均單筆消費/per座位
//			avgHallSaleSeats = (hallSaleSeats / hallSeats) * 100;
//			Double mh = (double) (movieHours / 60); // mh是movieHours小時數
//			avgSalePerHour = ticketSaleSubtotal / mh;
//			TicketSaleBean newTsb = new TicketSaleBean(hallID, playStartTime, movieTitle, movieHours, genre, hallSeats,
//					hallSaleSeats, avgHallSaleSeats, avgPerOrder, ticketSaleTotal, foodSaleTotal, avgSalePerHour,
//					ticketSaleSubtotal);
//			tsbList3.add(newTsb);
//		}
//		return tsbList3;
//	}
//
//	// p3: output
//	@Transactional
//	@Override
//	public LinkedHashMap<String, TicketSaleBean> countRepeatedString(List<TicketSaleBean> tsbList3) {
//		LinkedHashMap<String, TicketSaleBean> dateAndTsbMap3 = new LinkedHashMap<String, TicketSaleBean>();
//		List<LocalTime> pstList = new ArrayList<>();
//
//		for (TicketSaleBean tsb3 : tsbList3) {
//			LocalTime startTime = LocalDateTime.parse(tsb3.getPlayStartTime()).toLocalTime();
//			pstList.add(startTime);
//		}
//
//		for (LocalTime playStartTime : pstList) {
//			for (TicketSaleBean tsb3 : tsbList3) {
//				String hallID = null;
//				LocalTime startTime = null;
//				LocalTime playEndTime = null;
//				String title = null;
//				Integer movieHours = 0;
//				Integer genre = 0;
//				Integer hallSeats = null;
//				Integer hallSaleSeats = 0;
//				Integer avgHallSaleSeats = 0;
//				Double avgPerOrder = 0.0;
//				Long ticketSaleTotal = 0L;
//				Long foodSaleTotal = 0L;
//				Double avgSalePerHour = 0.0;
//				Long ticketSaleSubtotal = 0L;
//
//				LocalTime lt = LocalDateTime.parse(tsb3.getPlayStartTime()).toLocalTime();
//				if (playStartTime == lt) {
//					hallID = tsb3.getHallID();
//					startTime = playStartTime;
//					title = tsb3.getTitle();
//					movieHours = tsb3.getMovieHours();
//					genre = tsb3.getGenre();
//					hallSeats = tsb3.getHallSeats();
//					hallSaleSeats = hallSaleSeats + tsb3.getHallSaleSeats(); // 實際售出座位要相加
//					ticketSaleTotal = ticketSaleTotal + tsb3.getTicketSaleTotal();
//					foodSaleTotal = foodSaleTotal + tsb3.getFoodSaleTotal();
//					ticketSaleSubtotal = ticketSaleSubtotal + tsb3.getTicketSaleSubtotal();
//				} else {
//					System.out.println("比對時,playStartTime & tsb3播放時間不同");
//				}
//				avgHallSaleSeats = hallSaleSeats / hallSeats * 100;
//
//				Double avgTemp = (double) (ticketSaleSubtotal / hallSaleSeats);
//				BigDecimal b = new BigDecimal(avgTemp);
//				avgPerOrder = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); // 小數兩位:平均單筆消費/per座位
//
//				Double mh = (double) (movieHours / 60);
//				avgSalePerHour = ticketSaleSubtotal / mh;
//
//				playEndTime = startTime.plusMinutes(movieHours);
//				String timeRange = Integer.toString(startTime.getHour()) + " - "
//						+ Integer.toString(playEndTime.getHour());
//
//				TicketSaleBean newTsb = new TicketSaleBean(hallID, timeRange, title, movieHours, genre, hallSeats,
//						hallSaleSeats, avgHallSaleSeats, avgPerOrder, ticketSaleTotal, foodSaleTotal, avgSalePerHour,
//						ticketSaleSubtotal);
//
//				if (dateAndTsbMap3.containsKey(timeRange)) {
//					dateAndTsbMap3.put(timeRange, newTsb);
//				} else {
//					dateAndTsbMap3.put(timeRange, newTsb);
//				}
//
//				tsbList3.remove(tsb3);
//			}
//		}
//		return dateAndTsbMap3;
//	}
}
