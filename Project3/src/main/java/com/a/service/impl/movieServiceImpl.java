package com.a.service.impl;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.dao.MovieDao;
import com.a.dao.RunningDao;
import com.a.dao.ShowTimeHistoryDao;
import com.a.model.MovieBean;
import com.a.model.MovieRatingBean;
import com.a.model.MovieStatusBean;
import com.a.model.RunningBean;
import com.a.model.RunningStatusBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.test.Hallcomparator;
import com.a.test.PTcomparator;
import com.a.test.ShowtimeBean;
import com.c.model.HallBean;
import com.c.service.HallService;
import com.p.model.HallOrderBean;
import com.p.service.HallOrderService;
import com.z.dao.EmpDao;


@Service
public class movieServiceImpl implements MovieService {
	MovieDao MDao;
	RunningDao RDao;
	ShowTimeHistoryDao   SDao;
	HallService hService;
	HallOrderService hoService;
	
	@Autowired
	public void setService( HallService hService, HallOrderService hoService) {
		
		this.hService = hService;
		this.hoService = hoService;
	}
	
	
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
	public boolean updateMovieStatus(MovieBean movie, int status) {
		// TODO Auto-generated method stub
		return MDao.updateMovieStatus(movie, status);
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
	public List<ShowTimeHistoryBean> getshowMovieByDayAndHallID(LocalDate day,String hallID){
		 return SDao.getshowMovie(day,hallID); 
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
	@Transactional
	@Override
	public  List<RunningBean>  checkContract(List<RunningBean> rb_list){
		List<RunningBean> shouldRB_list =new ArrayList<>();
		for (RunningBean rb : rb_list) {
				if (rb.getRunningStatus().getStatusID() == 0) {
					shouldRB_list.add(rb);
				} 
		}
		return shouldRB_list;
	}
	@Transactional
	@Override
	public  void sortPT(List<ShowtimeBean>runMovie_list) {

		// Sort runMovie List order by PT
		Comparator PTcomp = new PTcomparator();
		Collections.sort(runMovie_list, PTcomp);
		
		
	}
	@Transactional
	@Override
	public MovieRatingBean getMovieRatingBeanById(Integer movieRatingID)  {
		return  MDao.getMovieRatingBeanById(movieRatingID);
		}

	@Transactional
	@Override
	public MovieStatusBean getMovieStatusBeanById(Integer movieStatusID) {
		return  MDao.getMovieStatusBeanById(movieStatusID);
	}
	@Transactional
	@Override
	public RunningStatusBean getRunningStatusBeanById(Integer runningStatusID) {
		return  RDao.getRunningStatusBeanById( runningStatusID);
	}
	
	@Transactional
	@Override
	public int  getShowTimeIdByTime(String playStartTime) {
		 return SDao. getShowTimeIdByTime( playStartTime);
	}
	
	@Override
	public Map<Integer, MovieBean> getPageBooks(int pageNo,List<RunningBean> run){
		return  MDao.getPageBooks(pageNo, run);
	}
	@Override
	public int getTotalPages(int count) {
		return  MDao.getTotalPages(count);
	}
	@Transactional
	@Override
	public boolean updateShowTimeHistoryBean(ShowTimeHistoryBean sthb ) {
		return SDao.updateShowTimeHistoryBean(sthb);
	}
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryByTime(String endDay,String startDay){
		return SDao.getShowTimeHistoryByTime(endDay,startDay);
	}
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryByDate(String endDay,String startDay,String hallID){
		return SDao.getShowTimeHistoryByDate(endDay,startDay, hallID);
	}
	@Transactional
	@Override
	public int checkHallOrder(LocalDateTime runDateTime, HallBean hb, int HallTime, List<ShowtimeBean> OrderHall_list) {
		int HallOrderTime = 0;
		List<HallOrderBean> hob_list = hoService.getHallOrder(runDateTime.toLocalDate());
		if (hob_list.size() != 0) {
			for (HallOrderBean hob : hob_list) {
				if (hob.getHb().getHallID().equalsIgnoreCase(hb.getHallID())) {
//					HallTime = HallTime - (hob.getOrderHours()) - (restTime.getRunningTime());
					ShowtimeBean hall = new ShowtimeBean(0, hob.getOrderHours() * 60, hob);
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
					LocalDateTime date2 = LocalDateTime.parse(hob.getStartTime(), fmt);
					hall.setStartTime(date2);
					hall.setDay(date2.toLocalDate());
					hall.setTime(date2.toLocalTime());
					hall.setHall(hob.getHb());
					OrderHall_list.add(hall);
					// 創一個統稱包廳的Bean Running
					HallOrderTime += (hob.getOrderHours() * 60);
				} else {
				}

			}

		} else {
		}
		return HallOrderTime;

	}
	
	
	@Transactional
	@Override
	public void setAllMoviePT(List<RunningBean> Allrb_list, List<ShowtimeBean> runMovie_list) {
		System.out.println("--------------------------------- 所有可排片size:" + Allrb_list.size());
		for (RunningBean rb : Allrb_list) {
			// setPTValue
			if (rb.getMovie().getMovieStatusBean().getStatusID() == 0) {
				// 新片取預估ＰＴ
				ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
						rb.getMovie().getExpectedProfit(), rb);
				updateMovieStatus(rb.getMovie(), 1);
				runMovie_list.add(movie);

			} else if (rb.getMovie().getMovieStatusBean().getStatusID() == 1) {
				// 舊片取上星期ＰＴ值
				// 先取showtimeHitory
				// 這邊會有問題runningID 一部電影可能有兩個
				List<RunningBean> Movie_rb_list = getnRunningBeanByMovieID(rb.getMovie().getMovieID());
				int AllPrice = 0;
				int AllTime = 0;
				for (RunningBean rb2 : Movie_rb_list) {
					List<ShowTimeHistoryBean> sthb_list = getShowTimeHistoryBean(rb2);
					AllTime = AllTime + (sthb_list.size()) * (rb2.getMovie().getRunningTime());

					for (ShowTimeHistoryBean sthb : sthb_list) {
						// showID to seatOrder get seatOrder //seatOrderList.size()*270//P
						// AllPrice= AllPrice +(seatOrderList.size()*270);
						// getOrderBean (List)
						// AllPrice = AllPrice +(getTickBean(List) .size()*票價 （票的總類？？票價）)
					}
				}
				// hihi這邊要改 rb.getMovie().getExpectedProfit() 改成 AllPrice/AllTime
				ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
						rb.getMovie().getExpectedProfit(), rb);
				runMovie_list.add(movie);
			} else {
				System.out.println("下檔");
			}
		}
		System.out.println("=============before sort=============");
		for (ShowtimeBean sb : runMovie_list) {
			System.out.println(sb.getRb().getRunID() + "  " + sb.getPrice_time());
		}
		sortPT(runMovie_list);
		// Sort runMovie List order by PT
		System.out.println("after======sort");
		for (ShowtimeBean sb : runMovie_list) {
			System.out.println(sb.getRb().getRunID() + "  " + sb.getPrice_time());
		}

	}
	@Transactional
	@Override
	public void setHallOrderAndotherMovieInFinalList(LocalDateTime runDateTime, int HallTime,
			List<ShowtimeBean> OrderHall_list, List<ShowtimeBean> changeTimeList_list,
			List<ShowtimeBean> FinalShowMovie_list, ShowtimeBean restTime,String HallName) {
		if(OrderHall_list.size()==0) {
			changeTimeList_list.add(0,restTime);
			for(ShowtimeBean stb:changeTimeList_list) {
				 FinalShowMovie_list.add(stb);
			}
			
		}else {
		for (int oht = 0; oht < OrderHall_list.size(); oht++) {
			OrderHall_list.get(oht).getStartTime();// String to LoalDateTime
            System.out.println("orderHallTimeStart:"+OrderHall_list.get(oht).getStartTime());
			Duration duration = Duration.between(runDateTime,OrderHall_list.get(oht).getStartTime());
			System.out.println("runDateTime:"+runDateTime);
			int minust1 = (int) duration.toMinutes();
			System.out.println("minust1:"+minust1);//60
			System.out.println("duration:"+duration);
			int runtimeTotal = 0;
			int runtime = 0;
			for (int t = 0; t < changeTimeList_list.size(); t++) {
			
				runtimeTotal = runtime + changeTimeList_list.get(t).getRunningTime();//142
				System.out.println(runtimeTotal);
				System.out.println(runtime);
				if (runtime < minust1 && runtimeTotal > minust1) {
					System.out.println("IN IF------------:runtime < minust1 && runtimeTotal > minust1");
					if (minust1 - runtime > HallTime) {
						System.out.println("-----------------Insert orderHall");
						FinalShowMovie_list.add(new ShowtimeBean(0,minust1));
						FinalShowMovie_list.add(OrderHall_list.get(oht));
						runtimeTotal =runtimeTotal+OrderHall_list.get(oht).getRunningTime();
						runtime =runtimeTotal;

					} else {
						System.out.println("-----------------Insert orderHall2");
						FinalShowMovie_list.add(OrderHall_list.get(oht));
						FinalShowMovie_list.add(changeTimeList_list.get(t));
						runtimeTotal =runtimeTotal+OrderHall_list.get(oht).getRunningTime();
						runtime =runtimeTotal;
//		    				 HallTime =HallTime-(OrderHall_list.get(o).getRunningTime());
					}

				} else {
					FinalShowMovie_list.add(changeTimeList_list.get(t));
				}
				runtime = runtimeTotal;
			}
//		    	
		}
		}

	}
	@Transactional
	@Override
	public void saveshowTimeHitory(List<ShowtimeBean> FinalShowMovie_list, LocalDateTime runDateTime, HallBean hall,
			int restTime, List<ShowtimeBean> AllDayShowTime) {
//		if(Halltime>0 ) {
//			int r=((Halltime)/(FinalShowMovie_list.size()));

//		}else {}
		for (ShowtimeBean stb : FinalShowMovie_list) {
			stb.setStartTime(runDateTime);
			stb.setDay(runDateTime.toLocalDate());// .plusMinutes(restTime)
			stb.setTime(runDateTime.toLocalTime());// .plusMinutes(restTime)
			System.out.println("runDateTime1:" + runDateTime);
			runDateTime = runDateTime.plusMinutes(stb.getRunningTime());
			// 如果(把休息時間排除)
			System.out.println("runDateTime2:" + runDateTime);
			System.out.println("stb.getStID()" + stb.getStID());
			if (stb.getStID() == 1) {
//				HallBean dfa = hb_list.get(Hall_i);
				System.out.println("幾廳" + hall.getHallID());
				stb.setHall(hall);
//				 AllDayShowTime.put(hall.getHallID(), stb);
				String showtime = (stb.getStartTime().toLocalDate()).toString() + " "
						+ (stb.getStartTime().toLocalTime()).toString();
				System.out.println(showtime);
				ShowTimeHistoryBean show = new ShowTimeHistoryBean(hall, stb.getRb(), showtime);
				addShowTimeHistory(show);
//				int showTimeId =mService.getShowTimeIdByTime(showtime);
				
				AllDayShowTime.add(new ShowtimeBean(1, stb.getRunningTime(),Math.round(stb.getPrice_time()) , stb.getRb(),
						stb.getDay(), stb.getTime(), hall));
      			
      			System.out.println("AllDayShowTime1:"+AllDayShowTime.size());
				System.out.println("stb.RunID()" + stb.getRb().getRunID());
//				System.out.println("MovieInsertHallsize:" + MovieInsetHall_list.size());
				System.out.println("----------------------------------------------");
			} else if (stb.getStID() == 0) {
				AllDayShowTime.add(
						new ShowtimeBean(0, stb.getRunningTime(), stb.getHob(), stb.getDay(), stb.getTime(), hall));
				stb.setHall(hall);

//			 AllDayShowTime.put(hall.getHallID(), stb);
				System.out.println("----------------------------------------------have HallOrder ");
			}
			
		}

		System.out.println("AllDayShowTime2:" + AllDayShowTime.size());
		System.out.println("FinalShowMovie_list" + FinalShowMovie_list.size());
	}
	
	@Transactional
	@Override
	public void creatOneDayShowTime(LocalDateTime runDateTime, double rate, ShowtimeBean restTime, int d,
			List<ShowtimeBean> AllDayShowTime) {
//		int startTime =9;
//      public void creatOneDayShowTime(LocalDateTime runDateTime) {};
		List<RunningBean> Allrb_list = new ArrayList<>();// 存電影排片 還沒有PT
		List<ShowtimeBean> runMovie_list = new ArrayList<>(); // 存電影排片 有PT值的
//		ShowtimeBean restTime = new ShowtimeBean(2, 10);// 清場時間（分鐘）

//		double rate = 0.8;// 遞減函數

//		LocalDateTime runDateTime = LocalDate.now().plusDays(1).atTime(9, 0); // 初始時間
		// 確認廳數 //checkUseHall
		// 確認那些影廳可以用 status =0=ok
		List<HallBean> hb_list = hService.getAllHalls(0);

		int Hallcount = hb_list.size();// 有幾個聽
		// Sort Hall orderby 座位數(大到小)
		Comparator Hallcomp = new Hallcomparator();
		Collections.sort(hb_list, Hallcomp);
		System.out.println("============= 確認那些影廳可以用  結束:================= ");



		// 取出今天可以排片的片
		Allrb_list = getAllOnMoive(runDateTime.toLocalDate());
		System.out.println("今天可以排片的片:" + Allrb_list);

//	 }
		// 取出今天一定要排片
		List<RunningBean> shouldRB_list = checkContract(Allrb_list);
		System.out.println("一定要排片:" + shouldRB_list);

		// PT排片 public setAllMoviePT(
		// List<RunningBean>Allrb_list,List<ShowtimeBean>runMovie_list){ }
		// 分出已上映 未上映 setPTValue
		//
		setAllMoviePT(Allrb_list, runMovie_list);
		System.out.println("=============setAllMoviePT 結束:================= ");
		// 從第一廳開始排
		for (int Hall_i = 0; Hall_i < Hallcount; Hall_i++) {
			restTime.setRunningTime(10);
			System.out.println("第幾廳: " + (Hall_i + 1) + hb_list.get(Hall_i).getHallID());
			runDateTime = LocalDate.now().plusDays(d).atTime(9, 0);

			List<ShowtimeBean> OrderHall_list = new ArrayList<>(); // 存包場
			List<ShowtimeBean> Contract_list = new ArrayList<>(); // 存合約
			List<ShowtimeBean> MovieInsetHall_list = new ArrayList<>(); // 存按照PT值排好的順序
			List<ShowtimeBean> changeTimeList_list = new ArrayList<>();// 最後排片(放時間)
			List<ShowtimeBean> FinalShowMovie_list = new ArrayList<>();// 最後排片(放時間)
			int HallTime = 1020; // 1020營業時間＊60(分鐘）

//			runDateTime = LocalDate.now().plusDays(1).atTime(9, 0);
			System.out.println("StartTime-------:" + HallTime);
			// 確認包場
			// void checkHallOrder(LocalDateTime runDateTime ,int i, List<HallBean> hb_list)
			HallTime = HallTime - checkHallOrder(runDateTime, hb_list.get(Hall_i), HallTime, OrderHall_list);
			System.out.println("=============包場 結束:================= ");
			System.out.println("合約數量:" + Contract_list.size());
			System.out.println("必須排數量:" + shouldRB_list.size());
//			System.out.println("InOneHall:" + InOneHall);
			System.out.println("checkHallOrder---------------:" + HallTime);
			// 把合約內容排進去 addContract
			int shouldcount = shouldRB_list.size();
			int InOneHall = (shouldcount / Hallcount);
			int lestHall = (shouldcount % Hallcount);
			System.out.println("InOneHall: " + InOneHall);
			System.out.println("lestHall: " + lestHall);
			System.out.println("contract1----HallTime----:" + HallTime);
			if (shouldRB_list.size() > 0) {

				if (Hall_i - (Hallcount - lestHall) >= 0 && !(InOneHall < 1)) {
					InOneHall += 1;
				}

				for (int j = 0; j < InOneHall; j++) {

					RunningBean rb = shouldRB_list.get(0);
					ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
							rb.getMovie().getExpectedProfit(), rb);
					HallTime = HallTime - (movie.getRunningTime()) - (restTime.getRunningTime());
					Contract_list.add(movie);
					shouldRB_list.remove(rb);
				}
				System.out.println("第幾個聽:" + Hall_i);
			}
			System.out.println("contract1----HallTime----:" + HallTime);
			System.out.println("=============合約結束:================= ");
//          if(d>1) {
//          	Allrb_list.clear();
//          }
//			

			System.out.println("runMovie_list in MovieInsetHall_list-----------------------------------------------");
			System.out.println("MovieInsetHall_list:" + MovieInsetHall_list.size());
			System.out.println("runMovie Size:" + runMovie_list.size());
			System.out.println("HallTime :" + HallTime);

			// public void runMovieByPT(int HallTime,runMovie_list ) {}
			System.out.println("runMovie_list in MovieInsetHall_list-----------------------------------------------");

			while (HallTime > 0) {
				boolean runMoviedetect = false;

				for (int l = 0; l < (runMovie_list.size() - 1); l++) {

					if (HallTime > runMovie_list.get(l).getRunningTime()) {
						HallTime = HallTime - ((runMovie_list.get(l)).getRunningTime()) - (restTime.getRunningTime());
						MovieInsetHall_list.add(runMovie_list.get(l));

						runMovie_list.get(l).setPrice_time(runMovie_list.get(l).getPrice_time() * rate);
//											showMovie_list.add(restTime);
						System.out.println("2: " + HallTime);
						sortPT(runMovie_list);
						runMoviedetect = true;
						break;
					} else {
					}
				}

				if (!runMoviedetect) {
					break;
				}
			}
			System.out.println("MovieInsertHall Size:" + MovieInsetHall_list.size());
			System.out.println("決定電影ＰＴ值順序結束" + MovieInsetHall_list.size());

			// 把合約跟ＰＴ排片合併 Contract_list MovieInsetHall_list
			for (ShowtimeBean stb : Contract_list) {
//				stb.setHall(hb_list.get(Hall_i));
				System.out.println(stb.getHall().getHallID());
				System.out.println("=================================Contract RunID" + stb.getRb().getRunID());
				MovieInsetHall_list.add(stb);
			}
			System.out.println("MovieInsertHall Size:" + MovieInsetHall_list.size());
			
			// 調整休息時間長度
			if(OrderHall_list.size()<=0) {
				System.out.println("-----------------------change restTime3");
				int r = ((HallTime) / (MovieInsetHall_list.size()));
				if (HallTime > 0) {
					restTime.setRunningTime(restTime.getRunningTime() + r);
				} else {}
			}else {}
			
			// 排時間
//							runDateTime.minusMinutes(chaneTime);
			// 找出需要推移的時間有多少 insertTime 回傳int should changeTime
//						public void setTime() {}

			// 取1-2 （壓在1點分界的）
			// public int changeTimeAbout1to2clock(int runtimeTotal,int
			// thisTime,List<ShowtimeBean> MovieInsetHall_list)
			// retrun (runtimeTotal - thisTime)
			// int minusTime = minusTime(MovieInsetHall_list);
			int runtimeTotal = 0;
			int thisTime = 900;

			for (ShowtimeBean stb : MovieInsetHall_list) {
				// 表示電影
				runtimeTotal = runtimeTotal + stb.getRunningTime() + restTime.getRunningTime();

				if (runtimeTotal > thisTime) { // 900
					break; // 要往前推的秒數

				} else {
				}

			}
			System.out.println(runtimeTotal);

//							runDateTime=runDateTime.minusMinutes(runtimeTotal-900);
			// 取9-12 （壓在9點分界的）
			// 把時間放進去public sortFinal(int minusTime,MovieInsetHall_list){}
			System.out.println("要往前推多久:" + (runtimeTotal - thisTime));
			System.out.println(" 取9-12 （壓在9點分界的）-----------------------------------------------");
			System.out.println(runDateTime);
			int runtime = 0;
			if (runtimeTotal < 0) {

			} else {
				runtime = 0 - (runtimeTotal - thisTime);
			}

			runtimeTotal = 0;

			for (int s = 0; s < MovieInsetHall_list.size(); s++) {// 可能會出問題
//				System.out.println(" s" + s);
//				System.out.println(" MovieInsetHall_list" + MovieInsetHall_list.size());
//				System.out.println(" runtime1:" + runtimeTotal);
				// 表示電影
				runtimeTotal = runtime + MovieInsetHall_list.get(s).getRunningTime();
				System.out.println(" runtime2:" + runtimeTotal);
				if (runtimeTotal > 780 && runtime <= 780 + 180) {// 720
					changeTimeList_list.add(0, MovieInsetHall_list.get(s));
					changeTimeList_list.add(1,restTime);
					System.out.println(" 取9-12 ----------------");

				} else {
					changeTimeList_list.add(MovieInsetHall_list.get(s));
					changeTimeList_list.add(restTime);
					runtime = runtimeTotal;
				}
			}
			
//			for(ShowtimeBean stb:changeTimeList_list) {
//				System.out.println("C排序-----------------------");
//				System.out.println(stb.getStID());
//			}

			// 處理包場問題

			setHallOrderAndotherMovieInFinalList(runDateTime, HallTime, OrderHall_list, changeTimeList_list,
					FinalShowMovie_list, restTime,hb_list.get(Hall_i).getHallID());

			System.out.println("----解決包場問題-------------------------------------------");
		
			System.out.println("contract1----HallTime----:" + HallTime);
			System.out.println(" changeTimeList_list size:" + changeTimeList_list.size());
			System.out.println(" FinalShowMovie_list size:" + FinalShowMovie_list.size());
			System.out.println(" MovieInsetHall_list size:" + MovieInsetHall_list.size());
			System.out.println("-----------------------------------------------");
			// save showTimeHitory(List<ShowtimeBean> FinalShowMovie_list)

			// 把東西存進去排片
			saveshowTimeHitory(FinalShowMovie_list, runDateTime, hb_list.get(Hall_i), restTime.getRunningTime(),
					AllDayShowTime);
		

			System.out.println("--------------------THE END--------------------------");
		} // 廳
	}
	
	
	
	
	
//	@Transactional
//
//	public void checkHallOrder(List<HallOrderBean> hob_list, int HallTime, ) {
//		if (hob_list.size() != 0) {
//			for (HallOrderBean rob : hob_list) {
//				if (rob.getHallID().equalsIgnoreCase(hb_list.get(i).getHallID())) {
//					HallTime = HallTime - (rob.getOrderHours()) - (restTime.getRunningTime());
//					ShowtimeBean hall = new ShowtimeBean(0, rob.getOrderHours(), rob);
//					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//					LocalDateTime date2 = LocalDateTime.parse(rob.getStartTime(), fmt);
//					hall.setStartTime(date2);
//					OrderHall_list.add(hall);
//					// 創一個統稱包廳的Bean Running
//
//				} else {
//				}
//			}
//		} else {
//		}
//		
//	}

	
	
	
//	
//	public  void creatshowTimeHitory(List<HallBean> hb_list ,int HallTime ) {
//	     
//		 int HallTime = 960; // 營業時間＊60(分鐘）
//		 List<ShowtimeBean> Contract_list = new ArrayList<>(); //存合約和包場
//		 List<ShowtimeBean> OrderHall_list = new ArrayList<>(); //存包場
//		 List<ShowtimeBean> runMovie_list = new ArrayList<>(); //存電影排片
//	 ShowtimeBean restTime = new ShowtimeBean(2,10);// 清場時間（分鐘）
//		 List<ShowtimeBean> MovieInsetHall_list = new ArrayList<>(); //存按照PT值排好的順序
//		 List<ShowtimeBean> FinalShowMovie_list = new ArrayList<>();//最後排片(放時間)
//		 double rate =0.8;
//		 MovieService mService;
//		 HallService hService;
//		 HallOrderService hoService;
//		
//		
//		// 跑第一天 //creatOneweekShowTime(LocalDateTime) 
////		for (int d = 1; d <= 7; d++) {
////			LocalDateTime runDate = (LocalDateTime.now().plusDays(d)).truncatedTo(ChronoUnit.SECONDS);
//			LocalDateTime runDateTime=LocalDate.now().plusDays(1).atTime(9, 0);
//			// 確認廳數 //checkUseHall
//			// 確認那些影廳可以用 status =0=ok
//		
//			
//			int Hallcount = hb_list.size();//有幾個聽
//			
//			// Sort Hall orderby 座位數(大到小)
//			Comparator Hallcomp = new Hallcomparator();
//			Collections.sort(hb_list, Hallcomp);
//
//			//取出今天可以排片的片
//			List<RunningBean> Allrb_list =getAllOnMoive(runDateTime.toLocalDate());
//			//取出一定要排片
//			List<RunningBean>shouldRB_list = checkContract(Allrb_list);
//			int shouldcount = shouldRB_list.size();
//			int InOneHall =(shouldcount/Hallcount );
//			int lestHall =(shouldcount%Hallcount );
//			
//			
//			//從第一廳開始排
//			for(int i=0;i <= (Hallcount-1);i++) {
//				HallTime=960;
//			 // void checkHallOrder(LocalDateTime runDateTime ,int i, List<HallBean> hb_list)
//				List<HallOrderBean> hob_list = hoService.getHallOrder(runDateTime.toLocalDate());
//				if (hob_list.size() != 0) {
//					for (HallOrderBean rob : hob_list) {
//						if (rob.getHallID().equalsIgnoreCase(hb_list.get(i).getHallID())) {
//							HallTime = HallTime - (rob.getOrderHours())-(restTime.getRunningTime());
//							ShowtimeBean hall = new ShowtimeBean(0, rob.getOrderHours(), rob);
//							 DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
//							 LocalDateTime date2 = LocalDateTime.parse(rob.getStartTime(), fmt);		
//							hall.setStartTime(date2);
//							OrderHall_list.add(hall);
//							// 創一個統稱包廳的Bean Running
//							
//						} else {}
//					}
//				} else {}
//				
//				
//				
//				
//				//把合約內容排進去  addContract
//			    for(int j=0;j< InOneHall;j++){
//	
//			    	RunningBean rb= shouldRB_list.get(0);
//			    	ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
//							rb.getMovie().getExpectedProfit(), rb);
//			    	HallTime = HallTime-(movie.getRunningTime())-(restTime.getRunningTime());
//			    	        Contract_list.add(movie);
//			    	        shouldRB_list.remove(rb);  
//			    }
//				System.out.println(i);
//				
//				if(i-(Hallcount-lestHall) >=0){
//					//這邊加入排片
//					RunningBean rb= shouldRB_list.get(0);
//			    	ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
//							rb.getMovie().getExpectedProfit(), rb);
//			    	HallTime = HallTime-(movie.getRunningTime())-(restTime.getRunningTime());
//			    	        Contract_list.add(movie);
//			    	        shouldRB_list.remove(rb);
//					System.out.println("aaaa");
//				}
//			
//				
//			 // PT排片      public  setAllMoviePT(Allrb_list,){ }
//				// 分出已上映 未上映
//				//setPTValue
//				for (RunningBean rb : Allrb_list) {
//					//setPTValue
//					if (rb.getMovie().getStatus() == 0) {
//						// 新片取預估ＰＴ
//						ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
//								rb.getMovie().getExpectedProfit(), rb);
//						mService.updateMovieStatus(rb.getMovie().getMovieID(), 1);
//						runMovie_list.add(movie);
//					} else if (rb.getMovie().getStatus() == 1) {
//						// 舊片取上星期ＰＴ值
//						// 先取showtimeHitory
//						// 這邊會有問題runningID 一部電影可能有兩個
//						List<RunningBean> Movie_rb_list = mService.getnRunningBeanByMovieID(rb.getMovie().getMovieID());
//						int AllPrice = 0;
//						int AllTime = 0;
//						for (RunningBean rb2 : Movie_rb_list) {
//							List<ShowTimeHistoryBean> sthb_list = mService.getShowTimeHistoryBean(rb2);
//							AllTime = AllTime + (sthb_list.size()) * (rb2.getMovie().getRunningTime());
//
//							for (ShowTimeHistoryBean sthb : sthb_list) {
//								// showID to seatOrder get  seatOrder  //seatOrderList.size()*270//P
//								//AllPrice= AllPrice +(seatOrderList.size()*270);
//								// getOrderBean (List)
//								// AllPrice = AllPrice +(getTickBean(List) .size()*票價 （票的總類？？票價）)
//							}
//						}					
//						//hihi這邊要改 rb.getMovie().getExpectedProfit() 改成 AllPrice/AllTime
//						ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
//								           rb.getMovie().getExpectedProfit(), rb);
//						runMovie_list.add(movie);
//					} else {
//						System.out.println("下檔");
//					}	
//				}//	//setPTValue
//			
//				sortPT(runMovie_list);
//				// Sort runMovie List order by PT
//			
//				
//				//public void runMovieByPT(int HallTime,runMovie_list ) {}
//				while(HallTime >0) {
//					int RunCount =0;
//					if(HallTime >runMovie_list.get(0).getRunningTime()) {
//						HallTime = HallTime -((runMovie_list.get(0)).getRunningTime())-(restTime.getRunningTime());
//						MovieInsetHall_list.add(runMovie_list.get(0));
//						runMovie_list.get(0).setPrice_time(runMovie_list.get(0).getPrice_time()*rate);
//						sortPT(runMovie_list);
//						
//					}else {
//						 RunCount =0;
//						for(int l=1;l<=runMovie_list.size()-1;l++) {
//							if(HallTime >runMovie_list.get(l).getRunningTime()) {
//								HallTime = HallTime -((runMovie_list.get(l)).getRunningTime())-(restTime.getRunningTime());
//								MovieInsetHall_list.add(runMovie_list.get(l));
//								runMovie_list.get(l).setPrice_time(runMovie_list.get(l).getPrice_time()*rate);
////								showMovie_list.add(restTime);
//								
//								sortPT(runMovie_list);
//								
//								break;
//							}else {RunCount++;}
//						}
//					}
//					if(RunCount ==runMovie_list.size()-1) {break;}
//				}
//			
//				
//				//把合約跟ＰＴ排片合併  Contract_list  MovieInsetHall_list
//				for(ShowtimeBean stb:Contract_list) {
//					MovieInsetHall_list.add(stb);
//				}
//				
//				
//				//排時間  
////				runDateTime.minusMinutes(chaneTime);
//				//找出需要推移的時間有多少 insertTime 回傳int should changeTime
////			public void setTime() {}
//			//取1-2 （壓在1點分界的）
//		
//				//int minusTime = minusTime(MovieInsetHall_list);
//				int runtimeTotal =0;
//				int thisTime =900;
//				
//				for(ShowtimeBean stb:MovieInsetHall_list) {
//					
//						//表示電影
//						runtimeTotal=runtimeTotal+stb.getRunningTime();
//						
//						if(runtimeTotal>thisTime) { //900
//							break; //要往前推的秒數
//							
//						}else {}
//
//				    }
//				
//				
////				runDateTime=runDateTime.minusMinutes(runtimeTotal-900);
//				//取9-12 （壓在9點分界的）
//				//把時間放進去public sortFinal(int minusTime,MovieInsetHall_list){}
//				
//				 int runtime= 0- (runtimeTotal-thisTime);
//				 runtimeTotal =0;
//
//                 for(int s=0;s<MovieInsetHall_list.size();s++) {//可能會出問題
//					
//						//表示電影
//						runtimeTotal=runtime+MovieInsetHall_list.get(s).getRunningTime();
//						
//						if(runtimeTotal>720 && runtime<=720+180) {//720								
//							FinalShowMovie_list.add(0,MovieInsetHall_list.get(s));
//							FinalShowMovie_list.add(restTime);
//							
//						}else {
//							FinalShowMovie_list.add(MovieInsetHall_list.get(s));
//							FinalShowMovie_list.add(restTime);
//							runtime=runtimeTotal;
//						}
//				}
//               
//                //save showTimeHitory(List<ShowtimeBean> FinalShowMovie_list)
//                 for(ShowtimeBean stb: FinalShowMovie_list) {
//                	 stb.setStartTime(runDateTime);
//                	 runDateTime= runDateTime.plusMinutes(stb.getRunningTime());
//                	 if(stb.getStID()==1) {
//                		HallBean dfa = hb_list.get(i);
//                		 
//                		 ShowTimeHistoryBean show =new ShowTimeHistoryBean(dfa,stb.getRb(),(stb.getStartTime().toString()));
//                		
//                		 mService.addShowTimeHistory(show);
//                	 }
//                 }
//
//			}//廳
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

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
