package com.c.dao;

import com.c.model.NumberOfSeatsBean;

public interface NumberOfSeatsDao {
	//表只存每個廳的座位數
	
	//將每廳座位數新增
	public void insertNumberofSeats(NumberOfSeatsBean nosb);
	
	//get number of seats for each hall
	public NumberOfSeatsBean getNumberOfSeats(String hallID);
	
}
