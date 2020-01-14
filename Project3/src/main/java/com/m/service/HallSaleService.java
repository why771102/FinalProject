package com.m.service;

import java.util.List;

import com.m.model.HallSaleBean;
import com.p.model.HallOrderBean;

public interface HallSaleService {
	
	public List<HallOrderBean> getHallOrder();
	public List<HallOrderBean> getHallHrSubtotal(String sDate, String eDate);
	public List<HallSaleBean> getHallSaleLists(List<HallOrderBean> hobList);
	//根據時間抓出
	public List<HallSaleBean> getHallSaleOutput(List<HallSaleBean> hsbList);
//	public List<HallBean> getHallPrice(List<HallOrderBean> hobList);
}
