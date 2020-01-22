package com.a.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.test.Hallcomparator;
import com.a.test.ShowtimeBean;
import com.c.model.HallBean;
import com.c.service.HallService;
import com.google.gson.Gson;
import com.p.model.HallOrderBean;
import com.p.service.HallOrderService;

@Controller
public class RunMovieController {
	ServletContext context;
	MovieService mService;
	HallService hService;
	HallOrderService hoService;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(MovieService mService, HallService hService, HallOrderService hoService) {
		this.mService = mService;
		this.hService = hService;
		this.hoService = hoService;
	}

	// 新增電影方法

	@GetMapping(value = "/movie/add") // URL
	public String proceessAdd(Model model) {
		MovieBean mb = new MovieBean();

		// 傳空的Bean去前端//如果controller有資料要
		model.addAttribute("Movie", mb);

		return "a/addMovie";
	}

	@PostMapping(value = "/movie/add")
	public String addNewMove(Model model, @ModelAttribute("Movie") MovieBean mb, BindingResult result,
			HttpServletRequest request, @RequestParam("release") String release,
			@RequestParam("expectedOffDate") String expectedOffDate, @RequestParam("MustShowDay") String MustShowDay) {
		String url = request.getContextPath();
		System.out.println(url);
		String[] suppressedFields = result.getSuppressedFields();

		if (suppressedFields.length > 0) {
			throw new RuntimeException("傳入不允許的欄位");
		}
		mb.setStatus(0);


		mService.addmovie(mb);

		// save RunningBean in SQL
		DateTimeFormatter fmtD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(release, fmtD);
		LocalDate endDate2 = LocalDate.parse(expectedOffDate, fmtD);
		long daysDiff = ChronoUnit.DAYS.between(startDate, endDate2);
		int totalDay = (int) (daysDiff);

		RunningBean rb1 = new RunningBean();
//	 		int totalDay = Integer.parseInt(expectedOnDate);
		int mustDay = Integer.parseInt(MustShowDay);
		LocalDate endDate = startDate.plusDays(mustDay - 1);
		LocalDate startDate2 = startDate.plusDays(mustDay);
		if (totalDay - mustDay > 0 && mustDay != 0) {
			RunningBean rb2 = new RunningBean(release, mustDay, 0, endDate.toString(), "2999-01-01", 0, mb);
			mService.addrunning(rb2);
			rb1 = new RunningBean(startDate2.toString(), (totalDay - mustDay), 0, expectedOffDate, "2999-01-01", 1, mb);
		} else if (mustDay == 0) {
			rb1 = new RunningBean(release, totalDay, 0, expectedOffDate, "2999-01-01", 1, mb);

		} else {
			// totalDay=mustDay
			rb1 = new RunningBean(release, totalDay, 0, expectedOffDate, "2999-01-01", 0, mb);
		}

		mService.addrunning(rb1);

//	 		//取出來看看 ok
//	 		MovieBean mbget = mService.getMovieBeanById(1);
//	 		System.out.println("title:"+mbget.getTitle()+"合約:"+mbget.getContractDate()+"預估 :"+mbget.getExpectedProfit()
//            +"拆帳:"+mbget.getProfitRatio()+"狀態:"+mbget.getStatus()+"片長:"+mbget.getRunningTime()
//	);
//	 	

		// 換URL
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url + "/addmovie/suseece");
		// 換URL
		return "index-a";
	}

	@GetMapping(value = "/Allrunning/add")
	public String addAllRunning() {
//		List<MovieBean> Allmovie_list=new ArrayList<>();
		int dataCount = 51;
		LocalDateTime startTime = LocalDateTime.parse("2019/10/01 00:00:00",
				DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		for (int i = 1; i <= dataCount; i++) {

			MovieBean mb = mService.getMovieBeanById(i);
			int random = (int) (Math.random() * 3 + 1);

			LocalDate startDate = startTime.toLocalDate().plusDays(random);
			LocalDate endDate2 = startDate.plusDays(30);
			long daysDiff = ChronoUnit.DAYS.between(startDate, endDate2);
			int totalDay = (int) (daysDiff);

			RunningBean rb1 = new RunningBean();
//		 		int totalDay = Integer.parseInt(expectedOnDate);
			int mustDay = 7;
			LocalDate endDate = startDate.plusDays(mustDay - 1);
			LocalDate startDate2 = startDate.plusDays(mustDay);
			if (totalDay - mustDay > 0 && mustDay != 0) {
				RunningBean rb2 = new RunningBean(startDate.toString(), mustDay, 7, endDate.toString(),
						endDate.toString(), 0, mb);
				mService.addrunning(rb2);
				rb1 = new RunningBean(startDate2.toString(), (totalDay - mustDay), 23, endDate2.toString(),
						endDate2.toString(), 1, mb);
			} else if (mustDay == 0) {
				rb1 = new RunningBean(startDate.toString(), totalDay, 30, endDate2.toString(), endDate2.toString(), 1,
						mb);

			} else {
				// totalDay=mustDay
				rb1 = new RunningBean(startDate.toString(), totalDay, 30, endDate2.toString(), endDate2.toString(), 0,
						mb);
			}

			mService.addrunning(rb1);
			startTime = startDate.atTime(LocalTime.now());

		}

		return "index-a";
	}

	// 一部電影的畫面
	@GetMapping(value = "/movie/show") // URL 跟<a href='movie/show'> 相關
	public String showMovie(Model model) {
		MovieBean mb = new MovieBean();

		// 傳空的Bean去前端//如果controller有資料要
		model.addAttribute("Movie", mb);

		return "a/showMovie";// URL 跟 eclip 擺放位置相關
	}

	@GetMapping(value = "/AllMovie/show") // URL 跟<a href='movie/show'> 相關
	public String showAllMovie(Model model) {
		LocalDate today = (LocalDate.now()).plusDays(1);
		LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		String dateTime = today.toString() + " " + time.toString();

		List<RunningBean> rb_list = mService.getAllOnMoive(today);
		System.out.println("size:" + rb_list.size());
	
		model.addAttribute(rb_list);
	

		// 傳空的Bean去前端//如果controller有資料要
//			model.addAttribute("Movie", rb_list);

		return "a/showAllMovie";// URL 跟 eclip 擺放位置相關

	}

	@GetMapping(value = "/Method/test") // URL 跟<a href='movie/show'> 相關
	public String testMethod(Model model) {
//		LocalDate today = (LocalDate.now()).plusDays(2);
//		List<HallBean> hb_list = hService.getAllHalls(0);
//		List<HallOrderBean> hob_list = hoService.getHallOrder(today);
//		for(HallOrderBean hob:hob_list) {
//		
//			System.out.println(hob.getEndTime());
//			System.out.println(hob.getHb().getHallID());
//			System.out.println(hob.getStartTime());
//			System.out.println(hob.getOrderHours());
//			System.out.println(hb_list.get(1).getHallID());
//			if (hob.getHb().getHallID().equalsIgnoreCase(hb_list.get(1).getHallID())) {
////				HallTime = HallTime - (hob.getOrderHours()) - (restTime.getRunningTime());
//				ShowtimeBean hall = new ShowtimeBean(0, hob.getOrderHours() * 60, hob);
//				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
//				LocalDateTime date2 = LocalDateTime.parse(hob.getStartTime(), fmt);
//				hall.setStartTime(date2);
//				OrderHall_list.add(hall);
		// 創一個統稱包廳的Bean Running

//			} else {
//			}
//		}

		return "index-a";// URL 跟 eclip 擺放位置相關

	}

	@GetMapping(value = "/movie/autoRun") // URL 跟<a href='movie/show'> 相關
	public String RunningMovie(Model model, HttpServletRequest request) {
		List<ShowtimeBean> AllDayShowTime = new ArrayList();
		List<ShowtimeBean> AllShowTime = new ArrayList();

		int day = 2;
		// 跑第一天 //creatOneweekShowTime(LocalDateTime)
		for (int d = 2; d <= day; d++) {
			LocalDateTime runDateTime = LocalDate.now().plusDays(d).atTime(9, 0);
			ShowtimeBean restTime = new ShowtimeBean(2, 10);
			double rate = 0.8;
			creatOneDayShowTime(runDateTime, rate, restTime, d, AllDayShowTime);
		}

		System.out.println("--------------------THE END--------------------------");

		List<HallBean> hb_list2 = hService.getAllHalls(0);

		for (int d2 = 2; d2 <= day; d2++) {
			for (HallBean hb : hb_list2) {
				ShowtimeBean aa = null;
				for (ShowtimeBean stb : AllDayShowTime) {
					if ((stb.getHall().getHallID()).equalsIgnoreCase(hb.getHallID())) {

						if ((stb.getDay().toString()).equalsIgnoreCase(((LocalDate.now().plusDays(d2)).toString()))) {

							AllShowTime.add(stb);
							aa=null;
						}else {
							aa = stb;
						}
						if(aa!=null) {
						AllShowTime.add(aa);
					}
						}
					
				}
				
			}
		}
		Gson gson = new Gson();
		String jsonstring = gson.toJson(AllShowTime);
		request.setAttribute("AllShowTime", AllShowTime);



		return "a/showTimeHistory";// URL 跟 eclip 擺放位置相關

	}
	
	
	
	@PostMapping(value = "/save/showtime")
	public String addNewMove(Model model,
			HttpServletRequest request, @RequestParam("release") String release) {
		String url = request.getContextPath();
		System.out.println(url);
		System.out.print(release);
		Gson gson =new Gson();
		String[] stb =gson.fromJson(release, String[].class);
		for(int i=0;i<stb.length;i++) {
			System.out.print(stb[i]);
		}
		System.out.println(stb);
		
		return "index-a";
		}

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

	public void setAllMoviePT(List<RunningBean> Allrb_list, List<ShowtimeBean> runMovie_list) {
		System.out.println("--------------------------------- 所有可排片size:" + Allrb_list.size());
		for (RunningBean rb : Allrb_list) {
			// setPTValue
			if (rb.getMovie().getMovieStatusBean().getStatusID() == 0) {
				// 新片取預估ＰＴ
				ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
						rb.getMovie().getExpectedProfit(), rb);
				mService.updateMovieStatus(rb.getMovie(), 1);
				runMovie_list.add(movie);

			} else if (rb.getMovie().getMovieStatusBean().getStatusID() == 1) {
				// 舊片取上星期ＰＴ值
				// 先取showtimeHitory
				// 這邊會有問題runningID 一部電影可能有兩個
				List<RunningBean> Movie_rb_list = mService.getnRunningBeanByMovieID(rb.getMovie().getMovieID());
				int AllPrice = 0;
				int AllTime = 0;
				for (RunningBean rb2 : Movie_rb_list) {
					List<ShowTimeHistoryBean> sthb_list = mService.getShowTimeHistoryBean(rb2);
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
		mService.sortPT(runMovie_list);
		// Sort runMovie List order by PT
		System.out.println("after======sort");
		for (ShowtimeBean sb : runMovie_list) {
			System.out.println(sb.getRb().getRunID() + "  " + sb.getPrice_time());
		}

	}

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
				
				
				AllDayShowTime.add(new ShowtimeBean(1, stb.getRunningTime(), stb.getPrice_time(), stb.getRb(),
						stb.getDay(), stb.getTime(), hall));
      			mService.addShowTimeHistory(show);
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
		Allrb_list = mService.getAllOnMoive(runDateTime.toLocalDate());
		System.out.println("今天可以排片的片:" + Allrb_list);

//	 }
		// 取出今天一定要排片
		List<RunningBean> shouldRB_list = mService.checkContract(Allrb_list);
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
						mService.sortPT(runMovie_list);
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

}
