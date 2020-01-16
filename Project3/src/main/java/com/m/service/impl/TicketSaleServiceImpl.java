package com.m.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.l.model.MOrderBean;
import com.m.dao.TicketSaleDao;
import com.m.model.ProductSaleBean;
import com.m.model.TicketSaleBean;
import com.m.service.ProductSaleService;
import com.m.service.TicketSaleService;

@Service
public class TicketSaleServiceImpl implements TicketSaleService {

	TicketSaleDao dao;
	TicketSaleService service;
	ProductSaleService pService;
	
	@Autowired
	public void setDao(TicketSaleDao dao) {
		this.dao = dao;
	}

	@Autowired
	public void setService(TicketSaleService service) {
		this.service = service;
	}
	
	@Autowired
	public void setService(ProductSaleService pService) {
		this.pService = pService;
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
		List<TicketSaleBean> tsbList = new ArrayList<>();

		LocalDate Sd = LocalDate.parse(sDate);
		LocalDate Ed = LocalDate.parse(eDate);

		for (TicketSaleBean tsbl : tsbListFromMovie) {
			// 比較電影放映日與使用者輸入日期
			LocalDate Pd = LocalDateTime.parse(tsbl.getPlayStartTime()).toLocalDate();
			long SdPdDays = ChronoUnit.DAYS.between(Sd, Pd);
			long PdEdDays = ChronoUnit.DAYS.between(Pd, Ed);

			if (SdPdDays >= 0 && PdEdDays <= 0) {
				tsbList.add(tsbl);
				tsbListFromMovie.remove(tsbl);
			} else {
				System.out.println("不符合所需輸入查詢區間與playStartTime日期比較");
			}
		}
		return tsbList;
	}

	@Transactional
	@Override
	public List<TicketSaleBean> getTicketSaleOutput(List<TicketSaleBean> tsbList) {
		List<String> TitlesList = dao.getDistinctTitles();
		List<TicketSaleBean> tsbList1= new ArrayList<>();
		
		for (String title : TitlesList) {
			List<Integer> showTimeLists = new ArrayList<>();
			Integer showtimeID = null;
			String movieTitle = null;
			Integer genre = 0;
			Integer movieHours = 0;
			Integer countShowTime = 0;
			Integer hallSeats = 0; 
			Integer hallSaleSeats = 0; // 售出座位總數
			Integer avgHallSaleSeats = 0;
			Double avgPerOrder = 0.0;
			Double avgSalePerHour = 0.0;
			Long ticketSaleSubtotal = 0L;
			
			Long ticketSaleTotal = 0L; // 票卷類加總
			Long foodSaleTotal = 0L; // 餐點類加總

			for (TicketSaleBean tsblfm : tsbList) {
				List<TicketSaleBean> tsbListFromOrder = dao.getMOrderDetailBeanList(tsbList);
				if (title.equals(tsblfm.getTitle())) {
					Integer sID = tsblfm.getShowtimeID();
					showTimeLists.add(sID);	
					movieTitle = title;
					genre = tsblfm.getGenre();
					movieHours = tsblfm.getMovieHours();
					hallSeats = tsblfm.getHallSaleSeats();
					// 用新的list去取得相對的販售數量與價格
					for (TicketSaleBean tsb : tsbListFromOrder) {
						Integer c = tsb.getCategory();

						if ((c == 1) || (c == 2) || (c == 3 && tsb.getProductID() == 13)) { // c = 1,2 Ticket qty*1
							hallSaleSeats = hallSaleSeats + tsb.getQuantity();// 售出座位數
							ticketSaleTotal = ticketSaleTotal + (tsb.getUnitPrice() * tsb.getQuantity()); // 售出小計加總

						} else if ((c == 3) && (tsb.getProductID() == 15)) { // c=3 Ticket qty*2
							hallSaleSeats = hallSaleSeats + (tsb.getQuantity() * 2); // 售出座位數
							ticketSaleTotal = ticketSaleTotal + (tsb.getUnitPrice() * tsb.getQuantity());// 售出小計加總

						} else if (c == 4) { // food4
							foodSaleTotal = foodSaleTotal + (tsb.getUnitPrice() * tsb.getQuantity());// 售出小計加總

						} else if (c == 5) { // food5: 有discount
							foodSaleTotal = foodSaleTotal
									+ Math.round(tsb.getUnitPrice() * tsb.getQuantity() * tsb.getDiscount());// 售出小計加總
						} else {
							System.out.println("比較category發生例外--tssl");
						}
						tsbListFromOrder.remove(tsb); // ===檢查===
					}

				} else {
					System.out.println("比對時,DB電影名稱&tsblfm名稱不同");
				}
				ticketSaleSubtotal = ticketSaleTotal + foodSaleTotal; // 票卷與食物消費總額
				Double avgTemp = (double) (ticketSaleSubtotal / hallSaleSeats);
				BigDecimal b = new BigDecimal(avgTemp);
				avgPerOrder = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); // 小數兩位:平均單筆消費/per座位
			}
			countShowTime = countRepeatedIntegers(showTimeLists); //待確認
			hallSeats = countShowTime * hallSeats;
			avgHallSaleSeats = (hallSaleSeats / (hallSeats*countShowTime) * 100);
			Double mh = (double) (movieHours / 60);
			avgSalePerHour = ticketSaleSubtotal / (mh * countShowTime);
			TicketSaleBean newTsb = new TicketSaleBean(showtimeID, movieTitle, genre, countShowTime, hallSeats,
					hallSaleSeats, avgHallSaleSeats, avgPerOrder,avgSalePerHour, ticketSaleSubtotal);
			tsbList1.add(newTsb);
		}
		return tsbList1;
	}

	@Transactional
	@Override
	public Integer countRepeatedIntegers(List<Integer> ints) {
		HashMap<Integer, String> repetitions = new HashMap<Integer, String>();
		for (Integer i : ints) {
			int item = i;
			if (repetitions.containsKey(item)) {
				repetitions.put(item, repetitions.get(item) + 1);
			} else {
				repetitions.put(item, "else");
			}
		}
		return repetitions.size();
	}
	
	//補上第一頁的genre selection
	
	@Transactional
	@Override
	public List<TicketSaleBean> getTicketSaleByTitle(List<TicketSaleBean> tsbList, String title){
		List<TicketSaleBean> tsbList1 = new ArrayList<>();
		
		for (TicketSaleBean tsb : tsbList) {
			if(title.equals(tsb.getTitle())) {
				tsbList1.add(tsb);
			}
		}
		return tsbList1;
	}
	
	@Transactional
	@Override
	//getTicketSaleByDate
	public List<TicketSaleBean> getTicketSaleByDateOutput(String sDate, String eDate) {
		List<LocalDate>datesList = pService.showEachDate(sDate, eDate);
		List<TicketSaleBean> TSBList = new ArrayList<>();
		
		for (LocalDate date : datesList) {
			TSBList = service.getTicketSaleOutput(service.comparedByTime(date.toString(), date.toString()));
		}
		return TSBList;
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
}
