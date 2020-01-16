package com.a.service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.dao.MovieDao;
import com.a.dao.RunningDao;
import com.a.dao.ShowTimeHistoryDao;
import com.a.model.MovieBean;
import com.a.model.RunningBean;
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
	public boolean updateMovieStatus(int movieID, int status) {
		// TODO Auto-generated method stub
		return MDao.updateMovieStatus(movieID, status);
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
				if (rb.getStatus() == 0) {
					shouldRB_list.add(rb);
				} 
		}
		return shouldRB_list;
	}
	@Transactional
	@Override
	public  void sortPT(List<ShowtimeBean>runMovie_list) {
		System.out.println("before sort");
		for(ShowtimeBean sb:runMovie_list) {
			System.out.println(sb.getRb().getRunID());
		}
		// Sort runMovie List order by PT
		Comparator PTcomp = new PTcomparator();
		Collections.sort(runMovie_list, PTcomp);
		
		System.out.println("after======sort");
		for(ShowtimeBean sb:runMovie_list) {
			System.out.println(sb.getRb().getRunID());
		}
		
	}


	
	
	
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
