package com.c.service;

import java.sql.Date;
import java.util.List;

import com.c.model.HallBean;
import com.c.model.NumberOfSeatsBean;

public interface NumberOfSeatsService {
	//表只存每個廳的座位數
	
		//將每廳座位數新增
		public void insertNumberofSeats(NumberOfSeatsBean nosb);
		
		//get number of seats for each hall
		public List<NumberOfSeatsBean> getNumberOfSeats(Date date);
		
		public HallBean getHallById(String hallID);
		
}
