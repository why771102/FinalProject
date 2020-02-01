package com.m.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.MovieBean;
import com.a.model.ShowTimeHistoryBean;
import com.m.dao.TicketEarnDao;
import com.m.model.TicketSaleEarnBean;
import com.m.service.TicketSaleService;

@Repository
public class TicketEarnDaoImpl implements TicketEarnDao {
	SessionFactory factory;
	TicketSaleService service;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Autowired
	public void setService(TicketSaleService service) {
		this.service = service;
	}

	// p1 Earn: all
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
		System.out.println("tsebList.size =>" + tsebList.size());
		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());

		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());

		List<TicketSaleEarnBean> tbList = new ArrayList<>();

		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer ticketCost = 0;
			Integer ticketSaleTotal = 0;
			Integer ticketEarn = 0;

			Integer foodCost = 0;
			Integer foodSaleTotal = 0;
			Integer foodEarn = 0;

			Integer earnSubtotal = 0;
			MovieBean mb = null;
			List<ShowTimeHistoryBean> sthbList = service.getDetail(m, sDate, eDate);
			System.out.println("sthbList.size() =>" + sthbList.size());
			noPlayTimes = sthbList.size();

			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				} else {
				}

				ticketEarn = (int) (tseb.getMovieBean().getProfitRatio() * ticketSaleTotal);
				ticketCost = ticketSaleTotal - ticketEarn;

				foodEarn = foodSaleTotal - foodCost;
				earnSubtotal = ticketEarn + foodEarn;

				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
				System.out.println("foodSaleTotal =>" + foodSaleTotal);
				System.out.println("earnSubtotal =>" + earnSubtotal);

//				avgSeats = (double) ((hallSaleSeats / hallSeats) * 100);
			}

			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, ticketCost, ticketEarn, ticketSaleTotal,
					foodCost, foodEarn, foodSaleTotal, earnSubtotal, mb);

			if (tb.getTicketSaleTotal() != 0) {
				tbList.add(tb);
			} else {
			}
		}
		session.close();
		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 Earn: 0
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo0(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 0 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
		System.out.println("tsebList.size =>" + tsebList.size());
		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());

		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());

		List<TicketSaleEarnBean> tbList = new ArrayList<>();

		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer ticketCost = 0;
			Integer ticketSaleTotal = 0;
			Integer ticketEarn = 0;

			Integer foodCost = 0;
			Integer foodSaleTotal = 0;
			Integer foodEarn = 0;

			Integer earnSubtotal = 0;
			MovieBean mb = null;
			List<ShowTimeHistoryBean> sthbList = service.getDetail(m, sDate, eDate);
			System.out.println("sthbList.size() =>" + sthbList.size());
			noPlayTimes = sthbList.size();

			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				} else {
				}

				ticketEarn = (int) (tseb.getMovieBean().getProfitRatio() * ticketSaleTotal);
				ticketCost = ticketSaleTotal - ticketEarn;

				foodEarn = foodSaleTotal - foodCost;
				earnSubtotal = ticketEarn + foodEarn;

				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
				System.out.println("foodSaleTotal =>" + foodSaleTotal);
				System.out.println("earnSubtotal =>" + earnSubtotal);

//				avgSeats = (double) ((hallSaleSeats / hallSeats) * 100);
			}

			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, ticketCost, ticketEarn, ticketSaleTotal,
					foodCost, foodEarn, foodSaleTotal, earnSubtotal, mb);

			if (tb.getTicketSaleTotal() != 0) {
				tbList.add(tb);
			} else {
			}
		}
		session.close();
		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 Earn: 1
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo1(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 1 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
		System.out.println("tsebList.size =>" + tsebList.size());
		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());

		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());

		List<TicketSaleEarnBean> tbList = new ArrayList<>();

		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer ticketCost = 0;
			Integer ticketSaleTotal = 0;
			Integer ticketEarn = 0;

			Integer foodCost = 0;
			Integer foodSaleTotal = 0;
			Integer foodEarn = 0;

			Integer earnSubtotal = 0;
			MovieBean mb = null;
			List<ShowTimeHistoryBean> sthbList = service.getDetail(m, sDate, eDate);
			System.out.println("sthbList.size() =>" + sthbList.size());
			noPlayTimes = sthbList.size();

			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				} else {
				}

				ticketEarn = (int) (tseb.getMovieBean().getProfitRatio() * ticketSaleTotal);
				ticketCost = ticketSaleTotal - ticketEarn;

				foodEarn = foodSaleTotal - foodCost;
				earnSubtotal = ticketEarn + foodEarn;

				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
				System.out.println("foodSaleTotal =>" + foodSaleTotal);
				System.out.println("earnSubtotal =>" + earnSubtotal);

//				avgSeats = (double) ((hallSaleSeats / hallSeats) * 100);
			}

			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, ticketCost, ticketEarn, ticketSaleTotal,
					foodCost, foodEarn, foodSaleTotal, earnSubtotal, mb);

			if (tb.getTicketSaleTotal() != 0) {
				tbList.add(tb);
			} else {
			}
		}
		session.close();
		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 Earn: 2
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo2(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 2 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
		System.out.println("tsebList.size =>" + tsebList.size());
		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());

		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());

		List<TicketSaleEarnBean> tbList = new ArrayList<>();

		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer ticketCost = 0;
			Integer ticketSaleTotal = 0;
			Integer ticketEarn = 0;

			Integer foodCost = 0;
			Integer foodSaleTotal = 0;
			Integer foodEarn = 0;

			Integer earnSubtotal = 0;
			MovieBean mb = null;
			List<ShowTimeHistoryBean> sthbList = service.getDetail(m, sDate, eDate);
			System.out.println("sthbList.size() =>" + sthbList.size());
			noPlayTimes = sthbList.size();

			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				} else {
				}

				ticketEarn = (int) (tseb.getMovieBean().getProfitRatio() * ticketSaleTotal);
				ticketCost = ticketSaleTotal - ticketEarn;

				foodEarn = foodSaleTotal - foodCost;
				earnSubtotal = ticketEarn + foodEarn;

				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
				System.out.println("foodSaleTotal =>" + foodSaleTotal);
				System.out.println("earnSubtotal =>" + earnSubtotal);

//				avgSeats = (double) ((hallSaleSeats / hallSeats) * 100);
			}

			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, ticketCost, ticketEarn, ticketSaleTotal,
					foodCost, foodEarn, foodSaleTotal, earnSubtotal, mb);

			if (tb.getTicketSaleTotal() != 0) {
				tbList.add(tb);
			} else {
			}
		}
		session.close();
		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 Earn: 3
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo3(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 3 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
		System.out.println("tsebList.size =>" + tsebList.size());
		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());

		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());

		List<TicketSaleEarnBean> tbList = new ArrayList<>();

		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer ticketCost = 0;
			Integer ticketSaleTotal = 0;
			Integer ticketEarn = 0;

			Integer foodCost = 0;
			Integer foodSaleTotal = 0;
			Integer foodEarn = 0;

			Integer earnSubtotal = 0;
			MovieBean mb = null;
			List<ShowTimeHistoryBean> sthbList = service.getDetail(m, sDate, eDate);
			System.out.println("sthbList.size() =>" + sthbList.size());
			noPlayTimes = sthbList.size();

			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				} else {
				}

				ticketEarn = (int) (tseb.getMovieBean().getProfitRatio() * ticketSaleTotal);
				ticketCost = ticketSaleTotal - ticketEarn;

				foodEarn = foodSaleTotal - foodCost;
				earnSubtotal = ticketEarn + foodEarn;

				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
				System.out.println("foodSaleTotal =>" + foodSaleTotal);
				System.out.println("earnSubtotal =>" + earnSubtotal);

//				avgSeats = (double) ((hallSaleSeats / hallSeats) * 100);
			}

			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, ticketCost, ticketEarn, ticketSaleTotal,
					foodCost, foodEarn, foodSaleTotal, earnSubtotal, mb);

			if (tb.getTicketSaleTotal() != 0) {
				tbList.add(tb);
			} else {
			}
		}
		session.close();
		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 Earn: 4
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfo4(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 4 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
		System.out.println("tsebList.size =>" + tsebList.size());
		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());

		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());

		List<TicketSaleEarnBean> tbList = new ArrayList<>();

		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer ticketCost = 0;
			Integer ticketSaleTotal = 0;
			Integer ticketEarn = 0;

			Integer foodCost = 0;
			Integer foodSaleTotal = 0;
			Integer foodEarn = 0;

			Integer earnSubtotal = 0;
			MovieBean mb = null;
			List<ShowTimeHistoryBean> sthbList = service.getDetail(m, sDate, eDate);
			System.out.println("sthbList.size() =>" + sthbList.size());
			noPlayTimes = sthbList.size();

			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				} else {
				}

				ticketEarn = (int) (tseb.getMovieBean().getProfitRatio() * ticketSaleTotal);
				ticketCost = ticketSaleTotal - ticketEarn;

				foodEarn = foodSaleTotal - foodCost;
				earnSubtotal = ticketEarn + foodEarn;

				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
				System.out.println("foodSaleTotal =>" + foodSaleTotal);
				System.out.println("earnSubtotal =>" + earnSubtotal);

//				avgSeats = (double) ((hallSaleSeats / hallSeats) * 100);
			}

			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, ticketCost, ticketEarn, ticketSaleTotal,
					foodCost, foodEarn, foodSaleTotal, earnSubtotal, mb);

			if (tb.getTicketSaleTotal() != 0) {
				tbList.add(tb);
			} else {
			}
		}
		session.close();
		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketEarnInfoByDate(Integer movieID, String sDate, String eDate) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TicketSaleEarnBean WHERE movieID = :movieID";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		System.out.println("tsebList.SIZE() ====> " + tsebList.size());

		List<TicketSaleEarnBean> tbList = new ArrayList<>();

		LocalDate Sd = LocalDate.parse(sDate);
		LocalDate Ed = LocalDate.parse(eDate);

		List<LocalDate> totalDates = new ArrayList<>();

		while (!Sd.isAfter(Ed)) {
			totalDates.add(Sd);
			Sd = Sd.plusDays(1);
		}
		System.out.println("totalDates => " + totalDates);

		for (LocalDate d : totalDates) {
			Integer noPlayTimes = 0;
			List<ShowTimeHistoryBean> sthbList = service.getDetail(movieID, d.toString());
			noPlayTimes = sthbList.size();
			
			String eachDate = null;
			String title = null;
			Integer ticketCost = 0;
			Integer ticketSaleTotal = 0;
			Integer ticketEarn = 0;
			Integer foodCost = 0;
			Integer foodSaleTotal = 0;
			Integer foodEarn = 0;
			Integer earnSubtotal = 0;
			MovieBean mb = null;
			for (TicketSaleEarnBean tseb : tsebList) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDate playMovieDate = LocalDateTime
						.parse(tseb.getShowTimeHistoryBean().getPlayStartTime(), formatter).toLocalDate();
				long EdOdDays = ChronoUnit.DAYS.between(d, playMovieDate);
				if (EdOdDays == 0) {
					System.out.println("這是測試用!!!!!!!!!!!!!!!!!!!");
					eachDate = d.toString();
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				} else {
					System.out.println("這是測試用~~~~~~~~~~~");
				}
				ticketEarn = (int) (tseb.getMovieBean().getProfitRatio() * ticketSaleTotal);
				ticketCost = ticketSaleTotal - ticketEarn;
				foodEarn = foodSaleTotal - foodCost;
				earnSubtotal = ticketEarn + foodEarn;
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(eachDate, title, noPlayTimes, ticketCost, ticketEarn,
					ticketSaleTotal, foodCost, foodEarn, foodSaleTotal, earnSubtotal, mb);
			if (tb.getTicketSaleTotal() != 0) {
				tbList.add(tb);
			} else {
			}
		}
		System.out.println("CHECK HERE !!!" + tbList.size());
		return tbList;
	}

	// p3 method
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getWithinDate(String date, Integer movieID) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE movieID = :movieID";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		List<TicketSaleEarnBean> tbList = new ArrayList<>();
		List<TicketSaleEarnBean> tbListNew = new ArrayList<>();

		for (TicketSaleEarnBean tseb : tsebList) {
			Integer ShowID = tseb.getShowTimeHistoryBean().getShowTimeId();
			String showTime = session.get(ShowTimeHistoryBean.class, ShowID).getPlayStartTime();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate playDate = LocalDateTime.parse(showTime, formatter).toLocalDate();
			LocalDate Sd = LocalDate.parse(date);
			long SdOdDays = ChronoUnit.DAYS.between(Sd, playDate);

			if (SdOdDays == 0) {
				LocalDateTime temp = LocalDateTime.parse(showTime, formatter);
				LocalTime t1 = temp.toLocalTime();
				Integer movieHours = tseb.getMovieBean().getRunningTime(); // 分
				Integer hr = t1.plusMinutes(movieHours).getHour();

				String playTime = null;
				Integer noPlayTimes = 0;
				String title = null;
				Integer ticketCost = 0;
				Integer ticketSaleTotal = 0;
				Integer ticketEarn = 0;
				Integer foodCost = 0;
				Integer foodSaleTotal = 0;
				Integer foodEarn = 0;
				Integer earnSubtotal = 0;
				MovieBean mb = null;

				if (hr >= 9 && hr <= 12) {
					// 上午場
					playTime = "早場";
					noPlayTimes++; // 計算上午場次數
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();

				} else if (hr > 12 && hr <= 18) {
					// 中午場
					playTime = "午場";
					noPlayTimes++; // 計算上午場次數
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				} else {
					// 晚上場
					playTime = "晚場";
					noPlayTimes++; // 計算上午場次數
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				}

				ticketEarn = (int) (tseb.getMovieBean().getProfitRatio() * ticketSaleTotal);
				ticketCost = ticketSaleTotal - ticketEarn;
				foodEarn = foodSaleTotal - foodCost;
				earnSubtotal = ticketEarn + foodEarn;

				TicketSaleEarnBean tb = new TicketSaleEarnBean(playTime, title, noPlayTimes, ticketCost, ticketEarn,
						ticketSaleTotal, foodCost, foodEarn, foodSaleTotal, earnSubtotal, mb);
				tbList.add(tb);
			} else {
			}
		}

		List<String> playTimeList = new ArrayList<>();
		String morn = "早場";
		String noon = "午場";
		String night = "晚場";
		playTimeList.add(morn);
		playTimeList.add(noon);
		playTimeList.add(night);

		for (String pt : playTimeList) {
			String playTime = null;
			Integer noPlayTimes = 0;
			String title = null;
			Integer ticketCost = 0;
			Integer ticketSaleTotal = 0;
			Integer ticketEarn = 0;
			Integer foodCost = 0;
			Integer foodSaleTotal = 0;
			Integer foodEarn = 0;
			Integer earnSubtotal = 0;
			MovieBean mb = null;

			for (TicketSaleEarnBean tseb : tbList) {
				if (tseb.getPlayMovieDate().equals(pt)) {
					noPlayTimes++;
					playTime = pt;
					title = tseb.getMovieBean().getTitle();
					mb = tseb.getMovieBean();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					foodCost = foodCost + tseb.getFoodCost();
				} else {
				}
				ticketEarn = (int) (tseb.getMovieBean().getProfitRatio() * ticketSaleTotal);
				ticketCost = ticketSaleTotal - ticketEarn;
				foodEarn = foodSaleTotal - foodCost;
				earnSubtotal = ticketEarn + foodEarn;
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(playTime, title, noPlayTimes, ticketCost, ticketEarn,
					ticketSaleTotal, foodCost, foodEarn, foodSaleTotal, earnSubtotal, mb);
			if (tb.getFoodCost() != 0) {
				tbListNew.add(tb);
			} else {
			}
		}
		session.close();
		return tbListNew;
	}

}
