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
		// 跑第一天 //creatOneweekShowTime(LocalDateTime) 
//		for (int d = 1; d <= 7; d++) {
		 int HallTime = 960; // 營業時間＊60(分鐘）
		 List<ShowtimeBean> Contract_list = new ArrayList<>(); //存合約和包場
		 List<ShowtimeBean> OrderHall_list = new ArrayList<>(); //存包場
		 List<ShowtimeBean> runMovie_list = new ArrayList<>(); //存電影排片
	     ShowtimeBean restTime = new ShowtimeBean(2,10);// 清場時間（分鐘）
		 List<ShowtimeBean> MovieInsetHall_list = new ArrayList<>(); //存按照PT值排好的順序
		 List<ShowtimeBean> FinalShowMovie_list = new ArrayList<>();//最後排片(放時間)
		 double rate =0.8;
		
		 LocalDateTime runDateTime=LocalDate.now().plusDays(1).atTime(9, 0);
			// 確認廳數 //checkUseHall
			// 確認那些影廳可以用 status =0=ok
			List<HallBean> hb_list = hService.getAllHalls(0);
			
			int Hallcount = hb_list.size();//有幾個聽
			
			// Sort Hall orderby 座位數(大到小)
						Comparator Hallcomp = new Hallcomparator();
						Collections.sort(hb_list, Hallcomp);


						//取出今天可以排片的片
						List<RunningBean> Allrb_list =mService.getAllOnMoive(runDateTime.toLocalDate());
						//取出一定要排片
						List<RunningBean>shouldRB_list = mService.checkContract(Allrb_list);
						int shouldcount = shouldRB_list.size();
						int InOneHall =(shouldcount/Hallcount );
						int lestHall =(shouldcount%Hallcount );
						
						
						//從第一廳開始排
						for(int i=0;i <= (Hallcount-1);i++) {
							HallTime=960;
							
						//確認包場
						 // void checkHallOrder(LocalDateTime runDateTime ,int i, List<HallBean> hb_list)
							List<HallOrderBean> hob_list = hoService.getHallOrder(runDateTime.toLocalDate());
							if (hob_list.size() != 0) {
								for (HallOrderBean rob : hob_list) {
									if (rob.getHallID().equalsIgnoreCase(hb_list.get(i).getHallID())) {
										HallTime = HallTime - (rob.getOrderHours())-(restTime.getRunningTime());
										ShowtimeBean hall = new ShowtimeBean(0, rob.getOrderHours(), rob);
										 DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
										 LocalDateTime date2 = LocalDateTime.parse(rob.getStartTime(), fmt);		
										hall.setStartTime(date2);
										OrderHall_list.add(hall);
										// 創一個統稱包廳的Bean Running
										
									} else {}
								}
							} else {}
							
							
							
							
							//把合約內容排進去  addContract
						    for(int j=0;j< InOneHall;j++){
				
						    	RunningBean rb= shouldRB_list.get(0);
						    	ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
										rb.getMovie().getExpectedProfit(), rb);
						    	HallTime = HallTime-(movie.getRunningTime())-(restTime.getRunningTime());
						    	        Contract_list.add(movie);
						    	        shouldRB_list.remove(rb);  
						    }
							System.out.println(i);
							
							if(i-(Hallcount-lestHall) >=0){
								//這邊加入排片
								RunningBean rb= shouldRB_list.get(0);
						    	ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
										rb.getMovie().getExpectedProfit(), rb);
						    	HallTime = HallTime-(movie.getRunningTime())-(restTime.getRunningTime());
						    	        Contract_list.add(movie);
						    	        shouldRB_list.remove(rb);
								System.out.println("aaaa");
							}
						
							
						 // PT排片      public  setAllMoviePT(Allrb_list,){ }
							// 分出已上映 未上映
							//setPTValue
							for (RunningBean rb : Allrb_list) {
								//setPTValue
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
											// showID to seatOrder get  seatOrder  //seatOrderList.size()*270//P
											//AllPrice= AllPrice +(seatOrderList.size()*270);
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
							}//	//setPTValue
						
							mService.sortPT(runMovie_list);
							// Sort runMovie List order by PT
						
							
							//public void runMovieByPT(int HallTime,runMovie_list ) {}
							while(HallTime >0) {
								int RunCount =0;
								if(HallTime >runMovie_list.get(0).getRunningTime()) {
									HallTime = HallTime -((runMovie_list.get(0)).getRunningTime())-(restTime.getRunningTime());
									MovieInsetHall_list.add(runMovie_list.get(0));
									runMovie_list.get(0).setPrice_time(runMovie_list.get(0).getPrice_time()*rate);
									mService.sortPT(runMovie_list);
									
								}else {
									 RunCount =0;
									for(int l=1;l<=runMovie_list.size()-1;l++) {
										if(HallTime >runMovie_list.get(l).getRunningTime()) {
											HallTime = HallTime -((runMovie_list.get(l)).getRunningTime())-(restTime.getRunningTime());
											MovieInsetHall_list.add(runMovie_list.get(l));
											runMovie_list.get(l).setPrice_time(runMovie_list.get(l).getPrice_time()*rate);
//											showMovie_list.add(restTime);
											
											mService.sortPT(runMovie_list);
											
											break;
										}else {RunCount++;}
									}
								}
								if(RunCount ==runMovie_list.size()-1) {break;}
							}
						
							
							//把合約跟ＰＴ排片合併  Contract_list  MovieInsetHall_list
							for(ShowtimeBean stb:Contract_list) {
								MovieInsetHall_list.add(stb);
							}
							
							
							//排時間  
//							runDateTime.minusMinutes(chaneTime);
							//找出需要推移的時間有多少 insertTime 回傳int should changeTime
//						public void setTime() {}
						//取1-2 （壓在1點分界的）
					
							//int minusTime = minusTime(MovieInsetHall_list);
							int runtimeTotal =0;
							int thisTime =900;
							
							for(ShowtimeBean stb:MovieInsetHall_list) {
								
									//表示電影
									runtimeTotal=runtimeTotal+stb.getRunningTime();
									
									if(runtimeTotal>thisTime) { //900
										break; //要往前推的秒數
										
									}else {}

							    }
							
							
//							runDateTime=runDateTime.minusMinutes(runtimeTotal-900);
							//取9-12 （壓在9點分界的）
							//把時間放進去public sortFinal(int minusTime,MovieInsetHall_list){}
							
							 int runtime= 0- (runtimeTotal-thisTime);
							 runtimeTotal =0;

			                 for(int s=0;s<MovieInsetHall_list.size();s++) {//可能會出問題
								
									//表示電影
									runtimeTotal=runtime+MovieInsetHall_list.get(s).getRunningTime();
									
									if(runtimeTotal>720 && runtime<=720+180) {//720								
										FinalShowMovie_list.add(0,MovieInsetHall_list.get(s));
										FinalShowMovie_list.add(restTime);
										
									}else {
										FinalShowMovie_list.add(MovieInsetHall_list.get(s));
										FinalShowMovie_list.add(restTime);
										runtime=runtimeTotal;
									}
							}
			               
			                //save showTimeHitory(List<ShowtimeBean> FinalShowMovie_list)
			                 for(ShowtimeBean stb: FinalShowMovie_list) {
			                	 stb.setStartTime(runDateTime);
			                	 runDateTime= runDateTime.plusMinutes(stb.getRunningTime());
			                	 if(stb.getStID()==1) {
			                		HallBean dfa = hb_list.get(i);
			                		 
			                		 ShowTimeHistoryBean show =new ShowTimeHistoryBean(dfa,stb.getRb(),(stb.getStartTime().toString()));
			                		
			                		 mService.addShowTimeHistory(show);
			                	 }
			                 }

						}//廳

			
			
			

//		} //七天的迴圈
		return "index-a";// URL 跟 eclip 擺放位置相關
	}
	
	
	
	

	
}
