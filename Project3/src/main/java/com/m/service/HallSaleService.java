package com.m.service;

import java.util.List;

import com.m.model.HallSaleBean;
import com.p.model.HallOrderBean;

public interface HallSaleService {
	
	public List<HallOrderBean> getHallOrder();
	public List<HallOrderBean> getHallHrSubtotal(String sDate, String eDate);
	public List<HallSaleBean> getHSBOutput(List<HallOrderBean> hobList);
//	public List<HallBean> getHallPrice(List<HallOrderBean> hobList);
}
