package com.m.dao;

import java.util.List;

import com.l.model.MOrderBean;

public interface TicketSaleEarnDao {

	//存入DB方法
	public List<MOrderBean> saveTicketInfoToDB();
//	public List<ShowTimeHistoryBean> getDetail(Integer movieID, LocalDate date);
//	public TicketSaleEarnBean getDetailInfo(Integer movieID, LocalDate date);
}
