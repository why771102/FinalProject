package com.a.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.a.model.MovieBean;
import com.a.model.MovieRatingBean;
import com.a.model.MovieStatusBean;
import com.a.model.RunningBean;
import com.a.model.RunningStatusBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.test.ShowtimeBean;
import com.c.model.HallBean;
import com.p.model.HallOrderBean;

public interface MovieService {
	
	/*//流程備註//
	先可以匯入電影
	依照合約分成不同的排片電影(不可下檔天數/ 可下檔天數) 存進movie table and running table
	從DB取出符合日期的runningBean
	進入排片流程
	確認包場
	確認合約(都先個排一場在時間最後面)
	新片按照預期票房排優先順序(price/time（每排一次遞減函數） 為基礎)
	舊片按照上週票房排優先順序(price/time（每排一次遞減函數） 為基礎)
	排出順序
	依照每排一次*遞減函數排片
	以每天塞滿為主 每場電影+10分鐘廣告   結束後+10分鐘清場時間
	廳院 如果已經上映電影在大廳滿座率小於(0.25) 小廳滿座率大於(0.5) 就交換 影廳
	排完後 存入showtimehistroy tbale
	*/
	//新增電影table 排片table
	public void addmovie(MovieBean movie);
	public void addrunning(RunningBean run);
	
	//取出哪些電影即將上映
	//從run 取電影ID
	//取出一個月後要上映的電影
	public List<RunningBean> getComingSoonMovie ();
	//拿電影ID 取出名稱等電影基本資料 (order by expectedProfit)
//	public List<MovieBean> getmovie(List<RunningBean> RunList);
	
	//確認status 為未上映(回傳未上映的)跟DB無關在serviceImpl
	List<RunningBean> checkStatusComingSoon(List<RunningBean> RunList);
	
	//打包Json傳回前端顯示(好像可以傳runningBean了)
	/*
	//取出這個星期才上映的電影
	//先取出上映日符合這個星期的
	public List<RunningBean> getOnRunnigBean (Timestamp release);
	//利用 putMovieBeanInRunBean 取出movieStatus
	
	//判斷Status =0 為沒有上映過  // Status =1 上映中 (已經上映的電影)
	//Status =0 可以用 checkStatusComingSoon

	
	//改變上映狀態
	//更改電影狀態
	public boolean updateMovieStatus(int movieID, int status);
	//putMovieBeanInRunBean
	*/
	
//	//Status =1 
//	List<RunningBean> checkStatusIsOn(List<RunningBean> RunList);
	
	
	//從showtime 拿這個星期電影 可以考慮只拿ID?     
//	public List<ShowTimeHistoryBean> getshowMovie (Timestamp playStartTime);
	//拿runID 取出movieID 可以考慮只拿ID?
//	public List<RunningBean> getrunning(int runID);
	//拿電影ID 取出名稱等電影基本資料  沿用getmoive
	
	
	
	
	//排片
	//確定包場 
	//hallOrder table 取這星期 是否有人包場
	//取出where date = 這星期 
	public HallOrderBean getHallOrder(Timestamp date); 	
	//合約確定
	//抓上映日早於或等於排片當天 ,下檔晚於或等於排片當天的run table 所有可以列入排片的片子
	public List<RunningBean> getAllOnMoive(LocalDate day);
	//拿電影ID 取出名稱等電影基本資料 putMovieBeanInRunBean
	// 分成必須排片 與不必排片 runningBean.getstatus
	//分出必須排片 跟DB無關
	List<RunningBean> shouldOnRunningBean(List<RunningBean> rb);
	
	//跑第一次排片(各自排一場srb 跑) 排完踢掉存入另一List
    //從第一天開始排
	//判斷上映日  預期下檔日 取出此天可以排片的
	List<RunningBean> checkMovieDateCanOn(List<RunningBean>rb);
	
	//sort rb by p/t 值
	//先分未上映的電影(上方有取) 取P/t值 (expectedProfit)
	
	//取出這個星期才上映的電影
		//先取出上映日符合這個星期的
		public List<RunningBean> getReleaseRunnigBean(LocalDate release);
		//利用 putMovieBeanInRunBean 取出movieStatus
		
		//判斷Status =0 為沒有上映過  // Status =1 上映中 (已經上映的電影)
		//Status =0 可以用 checkStatusComingSoon
		//改變上映狀態  更改電影狀態
//		public boolean updateMovieStatus(int movieID, int status);
		//putMovieBeanInRunBean
	
	//已上映電影 取P/t值 
	//移出今日上映電影 跟DB無關
	List<RunningBean> removeReleaseMovie(List<RunningBean> AllRunList,List<RunningBean> RRunList);
	//取P/t值
	//先取上星期showtimeHitory
	List <ShowTimeHistoryBean>getShowTimeHistoryBean(RunningBean rb);
	//然後拿showTime ID 取P/T值
	

	
	//合併已經上映 和未上映
	// List sort  by p/t 值  跟DB無關
	List<RunningBean> sortListbyPT(List<RunningBean>Allrb);
	
	//排片方法(one day)跟DB無關
	public List <ShowTimeHistoryBean> createShowTime(List<ShowtimeBean> showtime);
	
	//把排好的檔期存進DB
	public void addShowTimeHistory(ShowTimeHistoryBean show);

	
	
	//根據p/t值排片
	
	//依據movieStatus 分新片舊片
	//新片依據預估金額排
	//舊片依據上星期P/T值排片
	//排完存入新的List (movieBean(movie title) +runningBean +P/T值)
	 //從第一天開始排
		//判斷上映日
		//預期下檔日
	    //判斷P/T值最大就排
	    //跑排片放入廳裡面(從大廳開始)
	    //每完成一次放放入就*遞減函數
	    //直到排完
	
	
	
	
	
//	public int getMovieStatus(int movieID);
//	public int getRunningTime(Timestamp runningTime);
	//把新片和舊片區分出來 
	
	//取出上映中電影(舊片)
//	public List<MovieBean> getOnMoive(int status);
	//取出這星期的上檔電影 (星期三) (未上映但這星期可以上映)(新片)
//	public List<RunningBean> getrunning(Timestamp release);
	//更改新片電影狀態成為上映(沿用updateMovieStatus)
	
	


	
	
	MovieBean getMovieBeanById(int movieID);
	List<RunningBean> getAllOnMoive(LocalDate release, LocalDate expectedOffDate);
	List<RunningBean> getnRunningBeanByMovieID(int movieID);
	boolean updateOnDate(RunningBean rb, int day);
	boolean updateOffDate(RunningBean rb, LocalDateTime OffDate);
	List<ShowTimeHistoryBean> getRunBeanLastSTHB(RunningBean rb, String exOffDay, String release);
	List<ShowTimeHistoryBean> getshowMovie(LocalDate day);
	List<RunningBean> checkContract(List<RunningBean> rb_list);
	void sortPT(List<ShowtimeBean> runMovie_list);
	MovieRatingBean getMovieRatingBeanById(Integer movieRatingID);
	MovieStatusBean getMovieStatusBeanById(Integer movieStatusID);
	RunningStatusBean getRunningStatusBeanById(Integer runningStatusID);
	boolean updateMovieStatus(MovieBean movie, int status);
	Map<Integer, MovieBean> getPageBooks(int pageNo, List<RunningBean> run);
	int getTotalPages(int count);
	
	

}
