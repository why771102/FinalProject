package com.c.dao;

import java.util.List;

import com.c.model.HallBean;

public interface HallDao {
	//取出廳的資訊
	public HallBean getHall(String hallID);

	//取出同樣status的廳
	public List<HallBean> getAllHalls(Integer status);
	
	//更新廳狀態
	public void updateStatus(Integer hallID, Integer status);
	
	//更新廳的colNum, rowNum
	public void updateHallRC(String hallID, Integer colNum, Integer rowNum, Integer noOfSeats);
	
	//新增廳
	public void insertHall(HallBean hb);
	//修改廳資訊
	public void updateHall(HallBean hb);
	
	public String getAllHallTags();
	
	public List<String> getAllHall();
}
