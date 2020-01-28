package com.m.dao;

import java.util.List;

import com.a.model.ShowTimeHistoryBean;
import com.m.model.TicketSaleEarnBean;

public interface TicketSaleDao {
	//下拉式genre
	public String getGenre();
	
	public List<TicketSaleEarnBean> getTicketSaleInfo(String sDate, String eDate);
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String sDate, String eDate);
	
	
	//回傳order, od, product表內的資訊
//	public List<TicketSaleBean> getMOrderDetailBeanList();
//	public List<MOrderBean> getMOrderBean();
//	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList);
//	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList);
//	
//	public List<String> getDistinctTitles();
	//取得票卷銷售相關資訊
//	public List<TicketSaleBean> getTicketSale(List<TicketSaleBean> tsbList);
}
