package com.a.service;

import java.sql.Timestamp;
import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
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
	public RunningBean getComingSoonMovie (Timestamp release);
	//拿電影ID 取出名稱等電影基本資料 (order by expectedProfit)
	public List<MovieBean> getmovie(int movieID);
	//確認status 為未上映
	
	//打包Json傳回前端顯示
	
	//取出正在上映中電影
	//從showtime 拿這個星期電影 可以考慮只拿ID?     
	public List<ShowTimeHistoryBean> getshowMovie (Timestamp playStartTime);
	//拿runID 取出movieID 可以考慮只拿ID?
	public List<RunningBean> getrunning(int runID);
	//拿電影ID 取出名稱等電影基本資料  沿用getmoive
	
	//更改電影狀態
	public boolean updateMovieStatus(int movieID, int status);
	
	
	//排片
	//確定包場 
	//hallOrder table 取這星期 是否有人包場
	//取出where date = 這星期 
	public HallOrderBean getHallOrder(Timestamp date); 	
	//合約確定
	//抓上映日早於排片當天 ,下檔晚於排片當天的run table 所有可以列入排片的片子
	public List<RunningBean> getAllOnMoive(Timestamp release ,Timestamp expectedOffDate);
	//拿電影ID 取出名稱等電影基本資料 getmovie (主要需要movieStatus runningTime)
	// 分成必須排片 與不必排片 runningBean.getstatus
	//跑第一次排片(各自排一場) 排完踢掉存入另一List
    //從第一天開始排
	//判斷上映日
	//預期下檔日
	
	
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
	
	


	
	
	
	
	

}
