package com.c.dao;

import java.util.List;

import com.c.model.HallBean;

public interface HallDao {
	//取出廳的資訊
	public HallBean getHall(String hallID);
	
//	//抓取廳的座位數
//	public Integer getNumberOfSeats(Integer hallID);

	//取出同樣status的廳
	public List<HallBean> getAllHalls(Integer status);
	
//	//取得包場價格
//	public Integer getPrice(Integer hallID);
//	
	//更新廳狀態
	public void updateStatus(Integer hallID, Integer status);
	
	public void insertHall(HallBean hb);
}
