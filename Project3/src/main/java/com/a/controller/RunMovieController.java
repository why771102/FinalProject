package com.a.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
import com.a.test.ShowtimeBean;
import com.c.model.HallBean;
import com.c.service.HallService;
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
	public void setService(MovieService mService, HallService hService,HallOrderService hoService) {
		this.mService = mService;
		this.hService = hService;
		this.hoService=hoService;
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
		LocalDate endDate = LocalDate.parse(expectedOffDate, fmtD);
		long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
		int totalDay = (int) (daysDiff);

		RunningBean rb1 = new RunningBean();
//	 		int totalDay = Integer.parseInt(expectedOnDate);
		int mustDay = Integer.parseInt(MustShowDay);
		if (totalDay - mustDay > 0 && mustDay != 0) {
			RunningBean rb2 = new RunningBean(release, mustDay, 0, expectedOffDate, "2999-01-01", 0, mb);
			mService.addrunning(rb2);
			rb1 = new RunningBean(release, (totalDay - mustDay), 0, expectedOffDate, "2999-01-01", 1, mb);
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

	@GetMapping(value = "/movie/running") // URL 跟<a href='movie/show'> 相關
	public String RunningMovie(Model model) {
		// 跑第一天
		for (int d = 1; d <= 7; d++) {
//			LocalDateTime runDate = (LocalDateTime.now().plusDays(d)).truncatedTo(ChronoUnit.SECONDS);
			 LocalDateTime runDateTime=LocalDate.now().plusDays(1).atTime(9, 0);
			// 確認廳數 //checkUseHall
			// 確認那些影廳可以用 status =0=ok
			List<HallBean> hb_list = hService.getAllHalls(0);
			int Hallcount = hb_list.size();
			double rate =0.8;
			// Sort Hall orderby 座位數(大到小)
			//

			// 跑第一廳(跑哪一聽得for)
			for (int i = 0; i < hb_list.size() - 1; i++) {
				int HallTime = 960; // 營業時間＊60(分鐘）
				ShowtimeBean restTime = new ShowtimeBean(2,10);// 清場時間（分鐘）
				List<ShowtimeBean> showMovie_list = null;
				List<ShowtimeBean> runMovie_list = null;
				// 確定包場 checkHallOrder
				// hallOrder table 取這一天 是否有人包場
				List<HallOrderBean> hob_list = hoService.getHallOrder(runDateTime.toLocalDate());
				if (hob_list.size() != 0) {
					for (HallOrderBean rob : hob_list) {
						if (rob.getHallID().equalsIgnoreCase(hb_list.get(i).getHallID())) {
							HallTime = HallTime - (rob.getOrderHours())-(restTime.getRunningTime());
							ShowtimeBean hall = new ShowtimeBean(0, rob.getOrderHours(), rob);
							   DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   
							   LocalDateTime date2 = LocalDateTime.parse(rob.getStartTime(), fmt);		
							hall.setStartTime(date2);
							showMovie_list.add(hall);
							showMovie_list.add(restTime);
							
							// 創一個統稱包廳的Bean Running
						} else {
						}
					}
				} else {
				}
	// 排片開始  
				// 抓上映日早於或等於排片當天 ,下檔晚於或等於排片當天的run table 所有可以列入排片的片子
				List<RunningBean> rb_list0 = null;
				List<RunningBean> rb_list1 = null;
				//取出今天可以排片的片
				List<RunningBean> rb_list = mService.getAllOnMoive(runDateTime.toLocalDate());
				for (RunningBean rb : rb_list) {
      // 合約確定 checkContract
					if (rb.getStatus() == 0) {
						ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
								rb.getMovie().getExpectedProfit(), rb);
						HallTime = HallTime-(movie.getRunningTime())-(restTime.getRunningTime());
						showMovie_list.add(movie);
						showMovie_list.add(restTime);
					} else {
					}
	 // PT排片       runAllMovieByPT
					// 分出已上映 未上映
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
								// getOrderBean (List)
								// AllPrice = AllPrice +(getTickBean(List) .size()*票價 （票的總類？？票價）)
							}
						}					
						//hihi這邊要改 rb.getMovie().getExpectedProfit() 改成 AllPrice/AllTime
						ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
								           rb.getMovie().getExpectedProfit(), rb);
						runMovie_list.add(movie);
					} else {
						System.out.println("下檔");
					}
				}
				System.out.println("before sort");
				for(ShowtimeBean sb:runMovie_list) {
					System.out.println(sb.getRb().getRunID());
				}
				// Sort runMovie List order by PT
				System.out.println("after======sort");
				for(ShowtimeBean sb:runMovie_list) {
					System.out.println(sb.getRb().getRunID());
				}
				List<ShowtimeBean> showMovie_list2 = null;
				while(HallTime >0) {
					int RunCount =0;
					if(HallTime >runMovie_list.get(0).getRunningTime()) {
						HallTime = HallTime -((runMovie_list.get(0)).getRunningTime())-(restTime.getRunningTime());
						showMovie_list2.add(runMovie_list.get(0));
						runMovie_list.get(0).setPrice_time(runMovie_list.get(0).getPrice_time()*rate);
//						showMovie_list.add(restTime);最後再加入休息時間
						//runMovie_list List sort
						
					}else {
						 RunCount =0;
						for(int l=1;l<=runMovie_list.size()-1;l++) {
							if(HallTime >runMovie_list.get(l).getRunningTime()) {
								HallTime = HallTime -((runMovie_list.get(l)).getRunningTime())-(restTime.getRunningTime());
								showMovie_list2.add(runMovie_list.get(l));
								runMovie_list.get(l).setPrice_time(runMovie_list.get(l).getPrice_time()*rate);
//								showMovie_list.add(restTime);最後再加入休息時間
								//runMovie_list sort
								
								break;
							}else {RunCount++;}
						}
					}
					if(RunCount ==runMovie_list.size()-1) {
						break;
					}
					
				}
				for(i=0;i<(showMovie_list.size()-1);i++) {
					showMovie_list2.add(showMovie_list.get(i));
				}
				
				
				//排時間  
//				runDateTime.minusMinutes(chaneTime);
				//找出需要推移的時間有多少 insertTime 回傳int should changeTime
				int runtime=0;
				int runtimeTotal =0;
				int thisTime =900;
				int conut =0;
				
				for(ShowtimeBean stb:showMovie_list2) {
					
					if(stb.getStID()==0) {
						//表示包廳
						stb.getStartTime();
						//
						LocalDateTime endTime =stb.getStartTime().plusMinutes(stb.getRunningTime());
					}else if(stb.getStID()==1) {
						//表示電影
						runtimeTotal=runtime+stb.getRunningTime();
						
						if(runtimeTotal>thisTime) { //900
							//return runtimeTotal-thisTime //要往前推的秒數
							break;
						}else {
							runtime=runtimeTotal;
						}

					}else {
						//表示休息和其他
					}
				}
				
				//把時間放進去
				List<ShowtimeBean> finalRun_list = null;
				runDateTime.minusMinutes(runtimeTotal-thisTime);
				//把時間放進去 //把9-12前移
				
				 runtime=0-(runtimeTotal-thisTime);
				 runtimeTotal =0;
				 thisTime =720;
				 List<Integer> list = new ArrayList<>();
				 
                 for(i =0;i<showMovie_list2.size();i++) {//可能會出問題
					
					if(showMovie_list.get(i).getStID()==0) {
						//表示包廳
//						stb.getStartTime();
//						LocalDateTime endTime =stb.getStartTime().plusMinutes(stb.getRunningTime());
					}else if(showMovie_list.get(i).getStID()==1) {
						//表示電影
						runtimeTotal=runtime+showMovie_list.get(i).getRunningTime();
						
						if(runtimeTotal>thisTime && runtimeTotal<=thisTime+180) {//720-900之間
//							stb.setStartTime(runDateTime.minusMinutes(runtimeTotal-thisTime));
//							finalRun_list.add(0,showMovie_list.get(i));
//							runMovie_list.remove(showMovie_list.get(i));//可能會出問題	
//							runMovie_list.add(0,showMovie_list.get(i));
							//return thisTime  還有i //要往後推的秒數
//							
						}else {
							runtime=runtimeTotal;
						}

					}else {
						//表示休息和其他
					}
				}
				
//				mService.addShowTimeHistory(show);
			} // 跑第一廳

		}
		return "index-a";// URL 跟 eclip 擺放位置相關
	}

}
