package com.a.controller;

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
import com.p.model.HallOrderBean;
import com.p.service.HallOrderService;

@Controller
public class RunMovieController3 {
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
	public RedirectView addNewMove(Model model, @ModelAttribute("Movie") MovieBean mb, BindingResult result,
			HttpServletRequest request, @RequestParam("release") String release,
			@RequestParam("expectedOffDate") String expectedOffDate, @RequestParam("MustShowDay") String MustShowDay) {
		String url = request.getContextPath();
		System.out.println(url);
		String[] suppressedFields = result.getSuppressedFields();

		if (suppressedFields.length > 0) {
			throw new RuntimeException("傳入不允許的欄位");
		}
		mb.setStatus(0);
//			System.out.println("title:"+mb.getTitle()+"合約:"+mb.getContractDate()+"預估 :"+mb.getExpectedProfit()
//			                   +"拆帳:"+mb.getProfitRatio()+"狀態:"+mb.getStatus()+"片長:"+mb.getRunningTime()
//					);
//			System.out.println("導演:"+mb.getDirector()+"演員:"+mb.getCast()+"預告"+mb.getTrailer()
//			                    +"類型"+mb.getGenre()+"分級:"+mb.getMovieRating()+"內容:"+mb.getPlotSummary()
//					);

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
		LocalDate endDate = startDate.plusDays(mustDay);
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
		return redirectView;
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

//		  try {
//			//找出來後runningBean直接是有帶Bean值得
//			  List<RunningBean> rb_list=mService.getAllOnMoive(today, today.plusDays(7));
//			  for(RunningBean rb :rb_list) {
//			      
//				  System.out.println(rb.getRunID());
//				  System.out.println(rb.getMovie().getTitle());
//			  }
//			  System.out.println("------------");
//		} catch (Exception e) {
//			  System.out.println("erro");
//		}

		List<RunningBean> rb_list = mService.getAllOnMoive(today);
		System.out.println("size:" + rb_list.size());
		for (RunningBean rb : rb_list) {

			System.out.println("runID:" + rb.getRunID());
			System.out.println(rb.getMovie().getTitle());
//				  mService.updateOffDate( rb , LocalDateTime.now());
			System.out.println("======a");
			HallBean a = hService.getHall("A");
			System.out.println("======b");
			ShowTimeHistoryBean show = new ShowTimeHistoryBean();
			show.setHall(a);
			show.setRun(rb);
			show.setPalyStartTime(dateTime);
			mService.addShowTimeHistory(show);
			List<ShowTimeHistoryBean> sthb_list = mService.getshowMovie(today);
			for (ShowTimeHistoryBean sb : sthb_list) {
				System.out.println("======c");
				System.out.println("ShowID:" + sb.getShowTimeId());
				System.out.println("" + sb.getHall().getHallID());
			}
		}

		// 傳空的Bean去前端//如果controller有資料要
//			model.addAttribute("Movie", rb_list);

		return "index-a";// URL 跟 eclip 擺放位置相關

	}

	@GetMapping(value = "/movie/autoRun") // URL 跟<a href='movie/show'> 相關
	public String RunningMovie(Model model) {

		// 跑第一天 //creatOneweekShowTime(LocalDateTime)
//		for (int d = 1; d <= 7; d++) {
//		int startTime =9;
		int HallTime = 1020; // 1020營業時間＊60(分鐘）
		List<ShowtimeBean> Contract_list = new ArrayList<>(); // 存合約
		List<ShowtimeBean> OrderHall_list = new ArrayList<>(); // 存包場
		List<RunningBean> Allrb_list = new ArrayList<>();// 存電影排片 還沒有PT
		List<ShowtimeBean> runMovie_list = new ArrayList<>(); // 存電影排片 有PT值的
		ShowtimeBean restTime = new ShowtimeBean(2, 10);// 清場時間（分鐘）
		List<ShowtimeBean> MovieInsetHall_list = new ArrayList<>(); // 存按照PT值排好的順序
		List<ShowtimeBean> FinalShowMovie_list = new ArrayList<>();// 最後排片(放時間)
		double rate = 0.8;// 遞減函數

		LocalDateTime runDateTime = LocalDate.now().plusDays(1).atTime(9, 0); // 初始時間
		// 確認廳數 //checkUseHall
		// 確認那些影廳可以用 status =0=ok
		List<HallBean> hb_list = hService.getAllHalls(0);

		int Hallcount = hb_list.size();// 有幾個聽
		// Sort Hall orderby 座位數(大到小)
		Comparator Hallcomp = new Hallcomparator();
		Collections.sort(hb_list, Hallcomp);
//
//	if(d>1) {
//         	Allrb_list.clear();
//		  shouldRB_list.clear();
//		 Allrb_list=mService.getReleaseRunnigBean(runDateTime.toLocalDate());
//      //   移除下檔的電影
//          runMovie_list.remove();
//     }esle{

		// 取出今天可以排片的片
		Allrb_list = mService.getAllOnMoive(runDateTime.toLocalDate());
		System.out.println("今天可以排片的片:" + Allrb_list);

//	 }
		// 取出今天一定要排片
		List<RunningBean> shouldRB_list = mService.checkContract(Allrb_list);
		System.out.println("一定要排片:" + shouldRB_list);
		int shouldcount = shouldRB_list.size();
		int InOneHall = (shouldcount / Hallcount);
		int lestHall = (shouldcount % Hallcount);
		System.out.println("InOneHall: " + InOneHall);
		System.out.println("lestHall: " + lestHall);

		// 從第一廳開始排
		for (int i = 0; i < Hallcount ; i++) {
			runDateTime = LocalDate.now().plusDays(1).atTime(9, 0);
			System.out.println("第幾廳: " + (i + 1));
			
			OrderHall_list.clear();
			Contract_list.clear();
			MovieInsetHall_list.clear();
			FinalShowMovie_list.clear();

//			runDateTime = LocalDate.now().plusDays(1).atTime(9, 0);
			HallTime = 960;

			// 確認包場
			// void checkHallOrder(LocalDateTime runDateTime ,int i, List<HallBean> hb_list)
			List<HallOrderBean> hob_list = hoService.getHallOrder(runDateTime.toLocalDate());
			if (hob_list.size() != 0) {
				for (HallOrderBean hob : hob_list) {
					if (hob.getHallID().equalsIgnoreCase(hb_list.get(i).getHallID())) {
						HallTime = HallTime - (hob.getOrderHours()) - (restTime.getRunningTime());
						ShowtimeBean hall = new ShowtimeBean(0, hob.getOrderHours(), hob);
						DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
						LocalDateTime date2 = LocalDateTime.parse(hob.getStartTime(), fmt);
						hall.setStartTime(date2);
						OrderHall_list.add(hall);
						// 創一個統稱包廳的Bean Running

					} else {
					}
				}
			} else {
			}
			System.out.println("合約數量:" + Contract_list.size());
			System.out.println("必須排數量:" + shouldRB_list.size());
			System.out.println("InOneHall:" + InOneHall);

			// 把合約內容排進去 addContract
			System.out.println("contract1----HallTime----:" + HallTime);
			if (shouldRB_list.size() > 0) {

				if (InOneHall < 1) {
					RunningBean rb = shouldRB_list.get(0);
					ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
							rb.getMovie().getExpectedProfit(), rb);
					HallTime = HallTime - (movie.getRunningTime()) - (restTime.getRunningTime());
					Contract_list.add(movie);
					shouldRB_list.remove(rb);
				} else {
					for (int j = 0; j < InOneHall; j++) {

						RunningBean rb = shouldRB_list.get(0);
						ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
								rb.getMovie().getExpectedProfit(), rb);
						HallTime = HallTime - (movie.getRunningTime()) - (restTime.getRunningTime());
						Contract_list.add(movie);
						shouldRB_list.remove(rb);
					}
					System.out.println("第幾個聽:" + i);

					if (i - (Hallcount - lestHall) >= 0) {
						// 這邊加入排片
						RunningBean rb = shouldRB_list.get(0);
						ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
								rb.getMovie().getExpectedProfit(), rb);
						HallTime = HallTime - (movie.getRunningTime()) - (restTime.getRunningTime());
						Contract_list.add(movie);
						shouldRB_list.remove(rb);
						System.out.println("\"必須排數量:\2" + shouldRB_list.size());
					}

				}
			}
			System.out.println("contract1----HallTime----:" + HallTime);

//            if(d>1) {
//            	Allrb_list.clear();
//            }
//			

			// PT排片 public setAllMoviePT(Allrb_list,){ }
			// 分出已上映 未上映 setPTValue
			if (i == 0) { // &&d==1
				System.out.println("i:" + i + "--------------------------------- 所有可排片size:" + Allrb_list.size());
				for (RunningBean rb : Allrb_list) {
					// setPTValue
					if (rb.getMovie().getStatus() == 0) {
						// 新片取預估ＰＴ
						ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
								rb.getMovie().getExpectedProfit(), rb);
						mService.updateMovieStatus(rb.getMovie().getMovieID(), 1);
						runMovie_list.add(movie);

					} else if (rb.getMovie().getStatus() == 1) {
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
			} else {
				System.out.println("clear Allrb_list");
				Allrb_list.clear();

			} // //setPTValue

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
			System.out.println("setPTValue-----------------------------------------------");
			System.out.println("MovieInsetHall_list:" + MovieInsetHall_list.size());
			System.out.println("runMovie Size:" + runMovie_list.size());
			System.out.println("HallTime :" + HallTime);
			int RunCount = 0;
			// public void runMovieByPT(int HallTime,runMovie_list ) {}
			System.out.println("setPTValue-----------------------------------------------");

			while (HallTime > 0) {

				if (HallTime > runMovie_list.get(0).getRunningTime()) {
					HallTime = HallTime - ((runMovie_list.get(0)).getRunningTime()) - (restTime.getRunningTime());
					MovieInsetHall_list.add(runMovie_list.get(0));
					runMovie_list.get(0).setPrice_time(runMovie_list.get(0).getPrice_time() * rate);
					mService.sortPT(runMovie_list);
					System.out.println("1: " + HallTime + "runID: " + runMovie_list.get(0).getRb().getRunID()
							+ " runTime:" + runMovie_list.get(0).getRunningTime());

				} else {

					for (int l = 1; l < (runMovie_list.size() - 1); l++) {

						if (HallTime > runMovie_list.get(l).getRunningTime()) {
							HallTime = HallTime - ((runMovie_list.get(l)).getRunningTime())
									- (restTime.getRunningTime());
							MovieInsetHall_list.add(runMovie_list.get(l));

							runMovie_list.get(l).setPrice_time(runMovie_list.get(l).getPrice_time() * rate);
//											showMovie_list.add(restTime);
							System.out.println("2: " + HallTime);
							mService.sortPT(runMovie_list);

							break;
						} else {

							RunCount++;
							System.out.println("3: " + HallTime + " r:" + RunCount + "  runMovie_list.size() - 1"
									+ (runMovie_list.size() - 1));
						}
					}

				}
				if (RunCount == runMovie_list.size() - 1) {
					System.out.println("6: " + HallTime);
					break;
				}
			}
			System.out.println("MovieInsertHall Size:" + MovieInsetHall_list.size());

			// 把合約跟ＰＴ排片合併 Contract_list MovieInsetHall_list
			for (ShowtimeBean stb : Contract_list) {
				System.out.println("=================================Contract RunID" + stb.getRb().getRunID());
				MovieInsetHall_list.add(stb);
			}
			System.out.println("MovieInsertHall Size:" + MovieInsetHall_list.size());
			// 排時間
//							runDateTime.minusMinutes(chaneTime);
			// 找出需要推移的時間有多少 insertTime 回傳int should changeTime
//						public void setTime() {}

			// 取1-2 （壓在1點分界的）

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
				System.out.println(" s" + s);
				System.out.println(" MovieInsetHall_list" + MovieInsetHall_list.size());
				System.out.println(" runtime1:" + runtimeTotal);
				// 表示電影
				runtimeTotal = runtime + MovieInsetHall_list.get(s).getRunningTime();
				System.out.println(" runtime2:" + runtimeTotal);
				if (runtimeTotal > 720 && runtime <= 720 + 180) {// 720
					FinalShowMovie_list.add(0, MovieInsetHall_list.get(s));
					FinalShowMovie_list.add(restTime);
					System.out.println(" 取9-12 ----------------");

				} else {
					FinalShowMovie_list.add(MovieInsetHall_list.get(s));
					FinalShowMovie_list.add(restTime);
					runtime = runtimeTotal;
				}
			}

			System.out.println(" FinalShowMovie_list size:" + FinalShowMovie_list.size());
			System.out.println(" MovieInsetHall_list size:" + MovieInsetHall_list.size());
			System.out.println("-----------------------------------------------");
			// save showTimeHitory(List<ShowtimeBean> FinalShowMovie_list)
			for (ShowtimeBean stb : FinalShowMovie_list) {
				stb.setStartTime(runDateTime);
				runDateTime = runDateTime.plusMinutes(stb.getRunningTime());
				// 如果(把休息時間排除)
				System.out.println("stb.getStID()" + stb.getStID());
				if (stb.getStID() == 1) {
					HallBean dfa = hb_list.get(i);

					String showtime = (stb.getStartTime().toLocalDate()).toString() + " "
							+ (stb.getStartTime().toLocalTime()).toString();
					System.out.println(showtime);

					ShowTimeHistoryBean show = new ShowTimeHistoryBean(dfa, stb.getRb(), showtime);

					mService.addShowTimeHistory(show);
					System.out.println("stb.RunID()" + stb.getRb().getRunID());
					System.out.println("MovieInsertHallsize:" + MovieInsetHall_list.size());// 85
					System.out.println("----------------------------------------------");
				}

			}
			System.out.println("--------------------THE END--------------------------");
		} // 廳

//		} //七天的迴圈
		return "index-a";// URL 跟 eclip 擺放位置相關
	}

}
