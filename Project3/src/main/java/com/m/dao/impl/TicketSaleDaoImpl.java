package com.m.dao.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.GenreBean;
import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.HallBean;
import com.c.model.NumberOfSeatsBean;
import com.l.model.MOrderBean;
import com.m.dao.TicketSaleDao;
import com.m.model.TicketSaleBean;
import com.m.model.TicketSaleEarnBean;

@Repository
public class TicketSaleDaoImpl implements TicketSaleDao {

	TicketSaleDao dao;
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Autowired
	public void setDao(TicketSaleDao dao) {
		this.dao = dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getGenre() {
		String hql = "SELECT genre FROM GenreBean";
		Session session = factory.getCurrentSession();
		List<String> genres = new ArrayList<>();
		genres = session.createQuery(hql).getResultList();
		String ans = "";
		ans += "<SELECT id='genres' onclick='sendGen()'>" + "<option value='' selected='' disabled=''>請選擇</option>"
				+ "<option value='all'>全部電影</option>";
		for (String gen : genres) {
			ans += "<option value='" + gen + "'>" + gen + "</option>";
		}
		ans += "</SELECT>";
		return ans;
	}

	// p2 movieTitle
	@Override
	public String getMovieTitle(Integer movieID) {
		Session session = factory.getCurrentSession();
		String title = session.get(MovieBean.class, movieID).getTitle();
		return title;
	}
	// =======================================================================================
	// p1 method
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
//		System.out.println("tsebList.size =>" + tsebList.size());
//		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
//		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());
		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
//		System.out.println("MIDs.size =>" + MIDs.size());
		List<TicketSaleEarnBean> tbList = new ArrayList<>();
		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer hallSeats = 0;
			Integer hallSaleSeats = 0;
			Double avgSeats = 0.00; // 要等場次數與座位數
			Double pricePerSeat = 0.0;
			Integer Subtotal = 0;
			Integer foodSaleTotal = 0;
			Integer ticketSaleTotal = 0;
			MovieBean mb = null;
			List<ShowTimeHistoryBean> sthbList = dao.getDetail(m, sDate, eDate);
//			System.out.println("sthbList.size() =>" + sthbList.size());
			noPlayTimes = sthbList.size();
			for (ShowTimeHistoryBean sthb : sthbList) {
				hallSeats = hallSeats + sthb.getHall().getNoOfSeats();
			}
			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					title = tseb.getMovieBean().getTitle();
//					hallSeats = hallSeats + tseb.getHallSeats();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
				} else {
					continue;
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
//				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
//				System.out.println("foodSaleTotal =>" + foodSaleTotal);
//				System.out.println("Subtotal =>" + Subtotal);
//				System.out.println("hallSaleSeats =>" + hallSaleSeats);
//				System.out.println("hallSeats =>" + hallSeats);
			}
			if (hallSaleSeats != 0 && hallSaleSeats != 0) {
				Double as = (hallSaleSeats * 100.0) / hallSeats;
				BigDecimal b = new BigDecimal(as);
				avgSeats = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
			if (Subtotal != 0 && hallSaleSeats != 0) {
				Double avgTemp = (double) (Subtotal / hallSaleSeats);
				BigDecimal b = new BigDecimal(avgTemp);
				pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, hallSeats, hallSaleSeats, avgSeats,
					pricePerSeat, Subtotal, mb);
			if (tb.getHallSaleSeats() != 0) {
				tbList.add(tb);
			} else {
				continue;
			}
		}
		session.close();
//		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 method: 0
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo0(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 0 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
//		System.out.println("tsebList.size =>" + tsebList.size());
//		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
//		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());
		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
//		System.out.println("MIDs.size =>" + MIDs.size());
		List<TicketSaleEarnBean> tbList = new ArrayList<>();
		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer hallSeats = 0;
			Integer hallSaleSeats = 0;
			Double avgSeats = 0.00; // 要等場次數與座位數
			Double pricePerSeat = 0.0;
			Integer Subtotal = 0;
			Integer foodSaleTotal = 0;
			Integer ticketSaleTotal = 0;
			MovieBean mb = null;
			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					List<ShowTimeHistoryBean> sthbList = dao.getDetail(m, sDate, eDate);
					System.out.println("sthbList.size() =>" + sthbList.size());
					noPlayTimes = sthbList.size();

					title = tseb.getMovieBean().getTitle();
//					hallSeats = hallSeats + tseb.getHallSeats();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					for (ShowTimeHistoryBean sthb : sthbList) {
						hallSeats = hallSeats + sthb.getHall().getNoOfSeats();
					}
				} else {
					continue;
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
//				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
//				System.out.println("foodSaleTotal =>" + foodSaleTotal);
//				System.out.println("Subtotal =>" + Subtotal);
//				System.out.println("hallSaleSeats =>" + hallSaleSeats);
//				System.out.println("hallSeats =>" + hallSeats);
			}
			if (hallSaleSeats != 0 && hallSaleSeats != 0) {
				Double as = (hallSaleSeats * 100.0) / hallSeats;
				BigDecimal b = new BigDecimal(as);
				avgSeats = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
			if (Subtotal != 0 && hallSaleSeats != 0) {
				Double avgTemp = (double) (Subtotal / hallSaleSeats);
				BigDecimal b = new BigDecimal(avgTemp);
				pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, hallSeats, hallSaleSeats, avgSeats,
					pricePerSeat, Subtotal, mb);

			if (tb.getHallSaleSeats() != 0) {
				tbList.add(tb);
			} else {
				continue;
			}
		}
		session.close();
//		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 method: 1
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo1(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 1 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
//		System.out.println("tsebList.size =>" + tsebList.size());
//		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
//		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());
		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());
		List<TicketSaleEarnBean> tbList = new ArrayList<>();
		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer hallSeats = 0;
			Integer hallSaleSeats = 0;
			Double avgSeats = 0.00; // 要等場次數與座位數
			Double pricePerSeat = 0.0;
			Integer Subtotal = 0;
			Integer foodSaleTotal = 0;
			Integer ticketSaleTotal = 0;
			MovieBean mb = null;
			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					List<ShowTimeHistoryBean> sthbList = dao.getDetail(m, sDate, eDate);
					System.out.println("sthbList.size() =>" + sthbList.size());
					noPlayTimes = sthbList.size();

					title = tseb.getMovieBean().getTitle();
//					hallSeats = hallSeats + tseb.getHallSeats();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					for (ShowTimeHistoryBean sthb : sthbList) {
						hallSeats = hallSeats + sthb.getHall().getNoOfSeats();
					}
				} else {
					continue;
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
//				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
//				System.out.println("foodSaleTotal =>" + foodSaleTotal);
//				System.out.println("Subtotal =>" + Subtotal);
//				System.out.println("hallSaleSeats =>" + hallSaleSeats);
//				System.out.println("hallSeats =>" + hallSeats);
			}
			if (hallSaleSeats != 0 && hallSaleSeats != 0) {
				Double as = (hallSaleSeats * 100.0) / hallSeats;
				BigDecimal b = new BigDecimal(as);
				avgSeats = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
			if (Subtotal != 0 && hallSaleSeats != 0) {
				Double avgTemp = (double) (Subtotal / hallSaleSeats);
				BigDecimal b = new BigDecimal(avgTemp);
				pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, hallSeats, hallSaleSeats, avgSeats,
					pricePerSeat, Subtotal, mb);

			if (tb.getHallSaleSeats() != 0) {
				tbList.add(tb);
			} else {
				continue;
			}
		}
		session.close();
//		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 method: 2
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo2(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 2 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
//		System.out.println("tsebList.size =>" + tsebList.size());
//		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
//		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());
		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());
		List<TicketSaleEarnBean> tbList = new ArrayList<>();
		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer hallSeats = 0;
			Integer hallSaleSeats = 0;
			Double avgSeats = 0.00; // 要等場次數與座位數
			Double pricePerSeat = 0.0;
			Integer Subtotal = 0;
			Integer foodSaleTotal = 0;
			Integer ticketSaleTotal = 0;
			MovieBean mb = null;
			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					List<ShowTimeHistoryBean> sthbList = dao.getDetail(m, sDate, eDate);
//					System.out.println("sthbList.size() =>" + sthbList.size());
					noPlayTimes = sthbList.size();

					title = tseb.getMovieBean().getTitle();
//					hallSeats = hallSeats + tseb.getHallSeats();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					for (ShowTimeHistoryBean sthb : sthbList) {
						hallSeats = hallSeats + sthb.getHall().getNoOfSeats();
					}
				} else {
					continue;
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
//				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
//				System.out.println("foodSaleTotal =>" + foodSaleTotal);
//				System.out.println("Subtotal =>" + Subtotal);
//				System.out.println("hallSaleSeats =>" + hallSaleSeats);
//				System.out.println("hallSeats =>" + hallSeats);
			}
			if (hallSaleSeats != 0 && hallSaleSeats != 0) {
				Double as = (hallSaleSeats * 100.0) / hallSeats;
				BigDecimal b = new BigDecimal(as);
				avgSeats = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
			if (Subtotal != 0 && hallSaleSeats != 0) {
				Double avgTemp = (double) (Subtotal / hallSaleSeats);
				BigDecimal b = new BigDecimal(avgTemp);
				pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, hallSeats, hallSaleSeats, avgSeats,
					pricePerSeat, Subtotal, mb);

			if (tb.getHallSaleSeats() != 0) {
				tbList.add(tb);
			} else {
				continue;
			}
		}
		session.close();
//		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 method: 3
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo3(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 3 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
//		System.out.println("tsebList.size =>" + tsebList.size());
//		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
//		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());
		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());
		List<TicketSaleEarnBean> tbList = new ArrayList<>();
		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer hallSeats = 0;
			Integer hallSaleSeats = 0;
			Double avgSeats = 0.00; // 要等場次數與座位數
			Double pricePerSeat = 0.0;
			Integer Subtotal = 0;
			Integer foodSaleTotal = 0;
			Integer ticketSaleTotal = 0;
			MovieBean mb = null;
			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					List<ShowTimeHistoryBean> sthbList = dao.getDetail(m, sDate, eDate);
//					System.out.println("sthbList.size() =>" + sthbList.size());
					noPlayTimes = sthbList.size();

					title = tseb.getMovieBean().getTitle();
//					hallSeats = hallSeats + tseb.getHallSeats();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					for (ShowTimeHistoryBean sthb : sthbList) {
						hallSeats = hallSeats + sthb.getHall().getNoOfSeats();
					}
				} else {
					continue;
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
//				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
//				System.out.println("foodSaleTotal =>" + foodSaleTotal);
//				System.out.println("Subtotal =>" + Subtotal);
//				System.out.println("hallSaleSeats =>" + hallSaleSeats);
//				System.out.println("hallSeats =>" + hallSeats);
			}
			if (hallSaleSeats != 0 && hallSaleSeats != 0) {
				Double as = (hallSaleSeats * 100.0) / hallSeats;
				BigDecimal b = new BigDecimal(as);
				avgSeats = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
			if (Subtotal != 0 && hallSaleSeats != 0) {
				Double avgTemp = (double) (Subtotal / hallSaleSeats);
				BigDecimal b = new BigDecimal(avgTemp);
				pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, hallSeats, hallSaleSeats, avgSeats,
					pricePerSeat, Subtotal, mb);

			if (tb.getHallSaleSeats() != 0) {
				tbList.add(tb);
			} else {
				continue;
			}
		}
		session.close();
//		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	// p1 method: 4
	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo4(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE genre = 4 AND orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
//		System.out.println("tsebList.size =>" + tsebList.size());
//		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
//		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());
		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());
		List<TicketSaleEarnBean> tbList = new ArrayList<>();
		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer hallSeats = 0;
			Integer hallSaleSeats = 0;
			Double avgSeats = 0.00; // 要等場次數與座位數
			Double pricePerSeat = 0.0;
			Integer Subtotal = 0;
			Integer foodSaleTotal = 0;
			Integer ticketSaleTotal = 0;
			MovieBean mb = null;
			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					List<ShowTimeHistoryBean> sthbList = dao.getDetail(m, sDate, eDate);
//					System.out.println("sthbList.size() =>" + sthbList.size());
					noPlayTimes = sthbList.size();

					title = tseb.getMovieBean().getTitle();
//					hallSeats = hallSeats + tseb.getHallSeats();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					for (ShowTimeHistoryBean sthb : sthbList) {
						hallSeats = hallSeats + sthb.getHall().getNoOfSeats();
					}
				} else {
					continue;
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
//				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);
//				System.out.println("foodSaleTotal =>" + foodSaleTotal);
//				System.out.println("Subtotal =>" + Subtotal);
//				System.out.println("hallSaleSeats =>" + hallSaleSeats);
//				System.out.println("hallSeats =>" + hallSeats);
			}
			if (hallSaleSeats != 0 && hallSaleSeats != 0) {
				Double as = (hallSaleSeats * 100.0) / hallSeats;
				BigDecimal b = new BigDecimal(as);
				avgSeats = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
			if (Subtotal != 0 && hallSaleSeats != 0) {
				Double avgTemp = (double) (Subtotal / hallSaleSeats);
				BigDecimal b = new BigDecimal(avgTemp);
				pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
				continue;
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, hallSeats, hallSaleSeats, avgSeats,
					pricePerSeat, Subtotal, mb);
			if (tb.getHallSaleSeats() != 0) {
				tbList.add(tb);
			} else {
				continue;
			}
		}
		session.close();
//		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "SELECT runID FROM RunningBean WHERE movieID = :movieID";
		List<Integer> runIDs = new ArrayList<>();
		runIDs = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		System.out.println("runID.size() => " + runIDs.size());
		List<ShowTimeHistoryBean> sbList = new ArrayList<>();
		for (Integer i : runIDs) {
			String hql1 = "FROM ShowTimeHistoryBean where runID = :runID";
			List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
			sthbList = session.createQuery(hql1).setParameter("runID", i).getResultList();
//			System.out.println("sthbList ----> " + sthbList.size());
			for (ShowTimeHistoryBean sthb : sthbList) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDate playDate = LocalDateTime.parse(sthb.getPlayStartTime(), formatter).toLocalDate();
				LocalDate Sd = LocalDate.parse(sDate);
				LocalDate Ed = LocalDate.parse(eDate);
				long SdOdDays = ChronoUnit.DAYS.between(Sd, playDate);
				long EdOdDays = ChronoUnit.DAYS.between(Ed, playDate);
//				System.out.println("SdOdDays >>>> " + SdOdDays);
//				System.out.println("EdOdDays >>>> " + EdOdDays);
				if (SdOdDays >= 0 && EdOdDays <= 0) {
					sbList.add(sthb);
				} else {
				}
			}
		}
		session.close();
//		System.out.println("sbList ##### " + sbList.size());
		return sbList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String date) {
		Session session = factory.openSession();
		String hql = "SELECT runID FROM RunningBean WHERE movieID = :movieID";
		List<Integer> runIDs = new ArrayList<>();
		runIDs = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
//		System.out.println("runID.size() => " + runIDs.size());
		List<ShowTimeHistoryBean> sbList = new ArrayList<>();
		for (Integer i : runIDs) {
			String hql1 = "FROM ShowTimeHistoryBean where runID = :runID";
			List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
			sthbList = session.createQuery(hql1).setParameter("runID", i).getResultList();
//			System.out.println("sthbList ----> " + sthbList.size());
			for (ShowTimeHistoryBean sthb : sthbList) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDate playDate = LocalDateTime.parse(sthb.getPlayStartTime(), formatter).toLocalDate();
				LocalDate Sd = LocalDate.parse(date);
				long SdOdDays = ChronoUnit.DAYS.between(Sd, playDate);
//				System.out.println("SdOdDays >>>> " + SdOdDays);
				if (SdOdDays == 0) {
					sbList.add(sthb);
				} else {
				}
			}
		}
		session.close();
//		System.out.println("sbList ##### " + sbList.size());
		return sbList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfoByDate(Integer movieID, String sDate, String eDate) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TicketSaleEarnBean WHERE movieID = :movieID";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
//		System.out.println("tsebList.SIZE() ====> " + tsebList.size());
		List<TicketSaleEarnBean> tbList = new ArrayList<>();
		LocalDate Sd = LocalDate.parse(sDate);
		LocalDate Ed = LocalDate.parse(eDate);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!Sd.isAfter(Ed)) {
			totalDates.add(Sd);
			Sd = Sd.plusDays(1);
		}
//		System.out.println("totalDates => " + totalDates);
		for (LocalDate d : totalDates) {
			Integer noPlayTimes = 0;
			Integer hallSeats = 0;
			List<ShowTimeHistoryBean> sthbList = dao.getDetail(movieID, d.toString());
			noPlayTimes = sthbList.size();
			for (ShowTimeHistoryBean sthb : sthbList) {
				hallSeats = hallSeats + sthb.getHall().getNoOfSeats();
			}
			String eachDate = null;
			String title = null;
			Integer hallSaleSeats = 0;
			Double avgSeats = 0.00; // 要等場次數與座位數
			Double pricePerSeat = 0.0;
			Integer Subtotal = 0;
			Integer foodSaleTotal = 0;
			Integer ticketSaleTotal = 0;
			double earnPerHr = 0;
			MovieBean mb = null;
			for (TicketSaleEarnBean tseb : tsebList) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDate playMovieDate = LocalDateTime
						.parse(tseb.getShowTimeHistoryBean().getPlayStartTime(), formatter).toLocalDate();
				long EdOdDays = ChronoUnit.DAYS.between(d, playMovieDate);
				if (EdOdDays == 0) {
//					System.out.println("這是測試用!!!!!!!!!!!!!!!!!!!");
					eachDate = d.toString();
					title = tseb.getMovieBean().getTitle();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
				} else {
//					System.out.println("這是測試用~~~~~~~~~~~");
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
				Double movieHrs = (double) (tseb.getMovieBean().getRunningTime() * noPlayTimes) / 60;
				earnPerHr = Math.round(Subtotal / movieHrs);
//				DecimalFormat df = new DecimalFormat("##.00");
//				if (earnPerHr != 0) {
//					earnPerHr = Double.parseDouble(df.format(earnPerHr));
//				} else {
//				}
//				System.out.println("EEEEE =>" + earnPerHr);
			}
			if (hallSaleSeats != 0 && hallSaleSeats != 0) {
				Double as = (hallSaleSeats * 100.0) / hallSeats;
				BigDecimal b = new BigDecimal(as);
				avgSeats = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
			}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
			if (Subtotal != 0 && hallSaleSeats != 0) {
				Double avgTemp = (double) (Subtotal / hallSaleSeats);
				BigDecimal b = new BigDecimal(avgTemp);
				pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			} else {
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(eachDate, title, noPlayTimes, hallSeats, hallSaleSeats,
					avgSeats, pricePerSeat, ticketSaleTotal, foodSaleTotal, Subtotal, earnPerHr, mb);

			if (tb.getTicketSaleTotal() != 0) {
				tbList.add(tb);
			} else {
			}
		}
//		System.out.println("CHECK HERE !!!" + tbList.size());
		return tbList;
	}

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
				Integer hallSaleSeats = 0;
				Double avgSeats = 0.00; // 要等場次數與座位數
				Double pricePerSeat = 0.0;
				Integer Subtotal = 0;
				Integer foodSaleTotal = 0;
				Integer ticketSaleTotal = 0;
				double earnPerHr = 0;
				MovieBean mb = null;
				Integer hallSeats = 0;
//				List<ShowTimeHistoryBean> sthbList = dao.getDetail(movieID, date);
//				for (ShowTimeHistoryBean sthb : sthbList) {
//					hallSeats = hallSeats + sthb.getHall().getNoOfSeats();
//				}
				if (hr >= 9 && hr <= 12) {
					// 上午場
					playTime = "早場";
					noPlayTimes++; // 計算上午場次數
					title = tseb.getMovieBean().getTitle();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					hallSeats = hallSeats + tseb.getShowTimeHistoryBean().getHall().getNoOfSeats();
				} else if (hr > 12 && hr <= 18) {
					// 中午場
					playTime = "午場";
					noPlayTimes++; // 計算上午場次數
					title = tseb.getMovieBean().getTitle();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					hallSeats = hallSeats + tseb.getShowTimeHistoryBean().getHall().getNoOfSeats();
				} else {
					// 晚上場
					playTime = "晚場";
					noPlayTimes++; // 計算上午場次數
					title = tseb.getMovieBean().getTitle();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					hallSeats = hallSeats + tseb.getShowTimeHistoryBean().getHall().getNoOfSeats();
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
				Double movieHrs = (double) (tseb.getMovieBean().getRunningTime() * noPlayTimes) / 60;
				Math.round(earnPerHr = Subtotal / movieHrs);
//				DecimalFormat df = new DecimalFormat("##.00");
//				if (earnPerHr != 0) {
//					earnPerHr = Double.parseDouble(df.format(earnPerHr));
//				} else {
//				}
//				System.out.println("EEEEE =>" + earnPerHr);
				if (hallSaleSeats != 0 && hallSaleSeats != 0) {
					Double as = (hallSaleSeats * 100.0) / hallSeats;
					BigDecimal b = new BigDecimal(as);
					avgSeats = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				} else {
				}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
				if (Subtotal != 0 && hallSaleSeats != 0) {
					Double avgTemp = (double) (Subtotal / hallSaleSeats);
					BigDecimal b = new BigDecimal(avgTemp);
					pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				} else {
				}
				TicketSaleEarnBean tb = new TicketSaleEarnBean(playTime, title, noPlayTimes, hallSeats, hallSaleSeats,
						avgSeats, pricePerSeat, ticketSaleTotal, foodSaleTotal, Subtotal, earnPerHr, mb);
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
			Integer hallSaleSeats = 0;
			Double avgSeats = 0.00; // 要等場次數與座位數
			Double pricePerSeat = 0.0;
			Integer Subtotal = 0;
			Integer foodSaleTotal = 0;
			Integer ticketSaleTotal = 0;
			double earnPerHr = 0;
			MovieBean mb = null;
			Integer hallSeats = 0;
			for (TicketSaleEarnBean tseb : tbList) {
				if (tseb.getPlayMovieDate().equals(pt)) {
					noPlayTimes++;
					playTime = pt;
					title = tseb.getMovieBean().getTitle();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					hallSeats = hallSeats + tseb.getHallSeats();
				} else {
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
				Double movieHrs = (double) (tseb.getMovieBean().getRunningTime() * noPlayTimes) / 60;
				earnPerHr = Math.round(Subtotal / movieHrs);
//				DecimalFormat df = new DecimalFormat("##.00");
//				if (earnPerHr != 0) {
//					earnPerHr = Double.parseDouble(df.format(earnPerHr));
//				} else {
//				}
//				System.out.println("EEEEE =>" + earnPerHr);
				if (hallSaleSeats != 0 && hallSaleSeats != 0) {
					Double as = (hallSaleSeats * 100.0) / hallSeats;
					BigDecimal b = new BigDecimal(as);
					avgSeats = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				} else {
				}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
				if (Subtotal != 0 && hallSaleSeats != 0) {
					Double avgTemp = (double) (Subtotal / hallSaleSeats);
					BigDecimal b = new BigDecimal(avgTemp);
					pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				} else {
				}
			}
			TicketSaleEarnBean tb = new TicketSaleEarnBean(playTime, title, noPlayTimes, hallSeats, hallSaleSeats,
					avgSeats, pricePerSeat, ticketSaleTotal, foodSaleTotal, Subtotal, earnPerHr, mb);
			if (tb.getEarnPerHr() != 0) {
				tbListNew.add(tb);
			} else {
			}
		}
		session.close();
		return tbListNew;
	}
}
