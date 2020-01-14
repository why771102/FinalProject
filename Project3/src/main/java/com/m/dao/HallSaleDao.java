package com.m.dao;

import java.util.List;
import com.c.model.HallBean;
import com.m.model.HallSaleBean;
import com.p.model.HallOrderBean;

public interface HallSaleDao {
	
	public List<HallOrderBean> getHallOrder();
//	public List<HallBean> getHallBean(List<HallOrderBean> hob);
//	public List<HallSaleBean> getHallSaleBeanOutput();
}
