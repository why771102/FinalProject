package com.c.dao;

import com.a.model.ShowTimeHistoryBean;
import com.c.model.SeatsBean;

public interface SeatOrderDao {

	public void insertSeatOrder();

	public SeatsBean getSeatsById(String seatID);

	public ShowTimeHistoryBean getShowTimeById(Integer showTimeID);
}
