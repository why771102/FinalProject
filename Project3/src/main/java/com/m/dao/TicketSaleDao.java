package com.m.dao;

import java.util.List;
import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.m.model.TicketSaleBean;

public interface TicketSaleDao {
	
	//回傳order, od, product表內的資訊
//	public List<TicketSaleBean> getMOrderDetailBeanList();
	public List<MOrderBean> getMOrderBean();
	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList);
	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList);
	
	public List<String> getDistinctTitles();
	//取得票卷銷售相關資訊
//	public List<TicketSaleBean> getTicketSale(List<TicketSaleBean> tsbList);
	
	//在特定時間區內, 根據類別下拉式選項出現相對的電影名稱DBT => movies: genre(0,1,2,3,4,全(全部是上面的方法DEFAULT))
//	public List<String> GetTitlesByGenre();
	
//	//根據輸入的起迄時間, 取得廳院的mID跟RunID, DBT => running
//	public List<RunningBean> getRunningInfo(Date sDate, Date eDate);

//	//ShowTimeID: 取得x電影的場次DBT => (movies & running) & showTimeHistory
//	public Integer getShowTime(Integer movieID);

//	//DBT: movies => movieID, title, runningTime片長, status上映狀態
}
